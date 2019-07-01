package com.ecms.cums.web.local;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.cums.logutils.FunOrderLog;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductDestLocal;
import com.ecms.cums.model.ProductGuolv;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.ordervo.Message;
import com.ecms.cums.productvo.ProductDestLocalDto;
import com.ecms.cums.productvo.ProductVo;
import com.ecms.cums.productvo.ProductVoJson;
import com.ecms.cums.services.LocalAbroadRouteService;
import com.ecms.cums.utils.StringReaderUtils;
import com.ecms.cums.web.mvc.BaseController;
import com.google.gson.JsonSyntaxException;

@Controller
@RequestMapping("local/sys/abroad")
public class LocalAbroadRouteController extends BaseController{

	/*<<<<<<<<<<<<<<后期优化到同一个类 合并方法修改传参>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	//private static final Logger logger = (Logger) LoggerFactory.getLogger(LocalAbroadRouteController.class);

	@Autowired
	private LocalAbroadRouteService localAbroadRouteService;
	/**
	 * 获取推荐国外目的地列表
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findLocalAbroadOriginList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findLocalAbroadOriginList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
	try {
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		//验证参数是否正确
		Message mes = localAbroadRouteService.AbroadIsBlack(jsonbody);
		if(!"1".equals(mes.getHeader().get("resCode"))){
			this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
			return ;
		}
		//获取所有国内推荐数据放入list中
		List<ProductDestLocal> productDest = localAbroadRouteService.findLocalAbroadOriginList(jsonbody);
		//判断是否为空
		if(productDest!=null){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productDest", productDest);
			this.getSuccessResponseJson(response, map);
		}else{
			this.getSuccessResponse(response,"数据为空");
		}
		} catch (Exception e) {
			this.getErrorResponse(response,"系统错误");
			e.printStackTrace();
		}
	}
	/**
	 *  获取国外所有目的地列表
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findLocalAbroadOriginAllList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findLocalAbroadOriginAllList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
	try {
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		//验证参数是否正确
		Message mes = localAbroadRouteService.AbroadAllIsBlack(jsonbody);
		if(!"1".equals(mes.getHeader().get("resCode"))){
			this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
			return ;
		}
		//获取所有国内推荐数据放入list中
		List<ProductDestLocal> list = this.localAbroadRouteService.findLocalAbroadOriginAllList(jsonbody);
		System.out.println("输出list>>>>>"+list);
		//判断是否为空
			if(null != list){
				System.out.println("输出list不为空"+list);
				List<ProductDestLocalDto> CategoryJson = new ArrayList<ProductDestLocalDto>();
				for(ProductDestLocal category:list){
					ProductDestLocalDto pjson = new ProductDestLocalDto();
					pjson.setDestId(category.getDestId());
					pjson.setDestPid(category.getDestPId());
					pjson.setDestName(category.getDestName());
					pjson.setPinyin(category.getPinyin());
					//pjson.setProductDestVoJson(localAbroadRouteService.findDestPidList(category.getDestId()));
					pjson.setProductDestVoJson(localAbroadRouteService.findDestPidList(category.getDestId()));
					CategoryJson.add(pjson);
				}
				Map<String, Object> map = new HashMap<String, Object>();
				System.out.println("结果准备返回给前台"+list);
				map.put("CategoryJson", CategoryJson);
				this.getSuccessResponseJson(response, map);
			}else{
				this.getSuccessResponse(response,"数据为空");
				System.out.println("结果准备返回给前台"+list);
			}
		} catch (Exception e) {
			this.getErrorResponse(response,"系统错误");
			e.printStackTrace();
		}
	}
	/**
	 * 根据目的地id（dest_id）进行查询得到所有包含这个目的地的产品列表
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findLocalAbroadRouteDetailList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findLocalAbroadRouteDetailList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
	try {
		//获取请求过来的参数
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		//验证参数是否正确
		Message mes = localAbroadRouteService.AbroadByIDIsBlack(jsonbody);
		if(!"1".equals(mes.getHeader().get("resCode"))){
			this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
			return ;
		}
		//获取所有包含这个目的地的数据
		List<Product> product = localAbroadRouteService.findLocalAbroadRouteDetailList(jsonbody);
		List<ProductVo> list= new ArrayList<ProductVo>();
		if(product!=null){
			//循环list 得到数据放进一个对象里面
			for(int i=0;i<product.size();i++){
					ProductVo ul = new ProductVo();
					//获取线路类型
					TravelType travelType=	localAbroadRouteService.findTravelTypeByid(product.get(i).gettId());
					//线路名称
					ul.settId(travelType.getTypeName());
					//图片路径
					ul.setPicPath(product.get(i).getPicPath());
					//产品id
					ul.setpId(product.get(i).getpId());
					//价格
					ul.setPrice(product.get(i).getPrice());
					//主标题名称
					ul.setRouteMain(product.get(i).getRouteMain());
					//副标题名称
					ul.setRouteSub(product.get(i).getRouteSub());
					//出发城市
					ul.setStartPlaceId(product.get(i).getStartPlaceId());
					//出发城市
					ul.setDestPlaceId(product.get(i).getDestPlaceId());
					//供应商
					list.add(ul);
				 }
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			this.getSuccessResponseJson(response, map);
		}else{
				this.getSuccessResponse(response,"数据为空");
			}
		} catch (Exception e)   {
			this.getErrorResponse(response,"系统错误");
			e.printStackTrace();
		}
	}

	/**
	 * @Title: searchProductByParams
	 * @Description: 根据产品名称（线路主标题搜索产品信息）
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/searchProductByParams",method=RequestMethod.POST,consumes="application/json")
	public void searchProductByParams(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("报案请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String routeMain = body.getString("routeMain");
			List<Product> product = localAbroadRouteService.searchProductListByParams(routeMain);
			List<ProductVo> list= new ArrayList<ProductVo>();
			List<ProductGuolv> productGuolv = localAbroadRouteService.searchProductGuoLvListByParams(routeMain);
			if(null!=productGuolv && productGuolv.size()>0){
				for(ProductGuolv guolv:productGuolv){
					ProductVo gl = new ProductVo();
					gl.settId(guolv.getpRouteType());
					gl.setPicPath(guolv.getpImageUrl());
					gl.setpId(guolv.getpGId());
					gl.setPrice(guolv.getpPrice());
					gl.setRouteMain(guolv.getpRouteMain());
					gl.setStartPlaceId(guolv.getpStartDest());
					gl.setSystemFlag(guolv.getpSystemFlag());
					gl.setpRouteId(guolv.getpRouteId());
					gl.setIfLocal("0");
					list.add(gl);
				}
			}

			if(null != product && product.size()>0){
				for(int i=0;i<product.size();i++){
					ProductVo ul = new ProductVo();
					TravelType travelType=	localAbroadRouteService.findTravelTypeByid(product.get(i).gettId());
					ul.settId(travelType.getTypeName());
					ul.setPicPath(product.get(i).getPicPath());
					ul.setpId(product.get(i).getpId());
					ul.setPrice(product.get(i).getPrice());
					ul.setRouteMain(product.get(i).getRouteMain());
					ul.setRouteSub(product.get(i).getRouteSub());
					ul.setStartPlaceId(product.get(i).getStartPlaceId());
					ul.setDestPlaceId(product.get(i).getDestPlaceId());
					ul.setSystemFlag(product.get(i).getSystemFlag());
					ul.setIfLocal("1");
					list.add(ul);
				 }
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			this.getSuccessResponseJson(response, map);
		} catch (IOException e) {
			FunOrderLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}
	/**
	 * 获取国外首页推荐列表
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findLocalAbroadList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findLocalAbroadList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
		try {
			JSONObject param= JSONObject.fromObject(body);
			JSONObject jsonbody = param.getJSONObject("body");
			//验证参数是否正确
			Message mes = localAbroadRouteService.AbroadByHostIsBlack(jsonbody);
			if(!"1".equals(mes.getHeader().get("resCode"))){
				this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
				return ;
			}
			List<Product> product = this.localAbroadRouteService.findLocalAbroadList(jsonbody);
			List<ProductVo> list= new ArrayList<ProductVo>();
			if(product!=null){
				//循环list 得到数据放进一个对象里面
				for(int i=0;i<product.size();i++){
						ProductVo ul = new ProductVo();
						//获取线路类型
						TravelType travelType=	localAbroadRouteService.findTravelTypeByid(product.get(i).gettId());
						//线路名称
						ul.settId(travelType.getTypeName());
						//图片路径
						ul.setPicPath(product.get(i).getPicPath());
						//产品id
						ul.setpId(product.get(i).getpId());
						//价格
						ul.setPrice(product.get(i).getPrice());
						//主标题名称
						ul.setRouteMain(product.get(i).getRouteMain());
						//副标题名称
						ul.setRouteSub(product.get(i).getRouteSub());
						//出发日期
						ul.setStartDateStr(product.get(i).getStartDateStr());
						//出发城市
						ul.setStartPlaceId(product.get(i).getStartPlaceId());
						//出发城市
						ul.setDestPlaceId(product.get(i).getDestPlaceId());
						//供应商
						list.add(ul);
					 }
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("list", list);
				this.getSuccessResponse(response,map);
			}else{
				this.getSuccessResponse(response,"数据为空");
			}
		} catch (Exception e){
			this.getErrorResponse(response,"系统错误");
			e.printStackTrace();
		}
	}
	/**
	 * 根据产品列表的id进行查询得到线路的详细信息
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findRouteDetail",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findRouteDetail(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
		try {
		//获取请求过来的参数
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		//验证参数是否正确
		Message mes = localAbroadRouteService.AbroadByPidIsBlack(jsonbody);
		if(!"1".equals(mes.getHeader().get("resCode"))){
 			this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
			return ;
		}
		//根据id进行查询信息
		List<Product> list=localAbroadRouteService.findRouteById(jsonbody.getInt("pId"));
		if(null !=list){
				List<ProductVoJson> productVoJson= new ArrayList<ProductVoJson>();
				for(Product product:list){
					ProductVoJson pJson = new ProductVoJson();
					pJson.setAgentType(product.getAgentType());
					pJson.setCityIds(product.getCityIds());
					pJson.setCompId(product.getCompId());
					pJson.setDestPlaceId(product.getDestPlaceId());
					pJson.setPicPath(product.getPicPath());
					pJson.setpId(product.getpId());
					pJson.setPrice(product.getPrice());
					pJson.setRouteMain(product.getRouteMain());
					pJson.setRouteSub(product.getRouteSub());
					pJson.setStartDateStr(product.getStartDateStr());
					pJson.setStartPlaceId(product.getStartPlaceId());
					pJson.setSystemFlag(product.getSystemFlag());
					TravelType travelType=	localAbroadRouteService.findTravelTypeByid(product.gettId());
					//线路名称
					pJson.settId(travelType.getTypeName());
					List<ProductInfoWithBLOBs> productInfo= localAbroadRouteService.findProductInfoByPid(product.getpId());
 					pJson.setProductInfoWithBLOBs(productInfo);
					List<TreamDetail> treamDetail=localAbroadRouteService.findTreamDetailList(productInfo.get(0).getiId());
					pJson.setTreamDetailList(treamDetail);
					productVoJson.add(pJson);
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("productVoJson", productVoJson);
				this.getSuccessResponseJson(response, map);
		}
		} catch (Exception e)   {
			this.getErrorResponse(response,"系统错误");
			e.printStackTrace();
		}
	}

	/**
	 * 获取国外所有列表
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findLocalAbroadAllList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findLocalAbroadAllList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
		try {
			JSONObject param= JSONObject.fromObject(body);
			JSONObject jsonbody = param.getJSONObject("body");
			//验证参数是否正确
			Message mes = localAbroadRouteService.AbroadByHostIsBlack(jsonbody);
			if(!"1".equals(mes.getHeader().get("resCode"))){
				this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
				return ;
			}
			List<Product> product = this.localAbroadRouteService.findLocalAbroadAllList(jsonbody);
			List<ProductVo> list= new ArrayList<ProductVo>();
			if(product!=null){
				//循环list 得到数据放进一个对象里面
				for(int i=0;i<product.size();i++){
						ProductVo ul = new ProductVo();
						//获取线路类型
						TravelType travelType=	localAbroadRouteService.findTravelTypeByid(product.get(i).gettId());
						//线路名称
						ul.settId(travelType.getTypeName());
						//图片路径
						ul.setPicPath(product.get(i).getPicPath());
						//产品id
						ul.setpId(product.get(i).getpId());
						//价格
						ul.setPrice(product.get(i).getPrice());
						//主标题名称
						ul.setRouteMain(product.get(i).getRouteMain());
						//副标题名称
						ul.setRouteSub(product.get(i).getRouteSub());
						//出发日期
						ul.setStartDateStr(product.get(i).getStartDateStr());
						//出发城市
						ul.setStartPlaceId(product.get(i).getStartPlaceId());
						//出发城市
						ul.setDestPlaceId(product.get(i).getDestPlaceId());
						//供应商
						list.add(ul);
					 }
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("list", list);
				this.getSuccessResponse(response,map);
			}else{
				this.getSuccessResponse(response,"数据为空");
			}
		} catch (Exception e){
			this.getErrorResponse(response,"系统错误");
			e.printStackTrace();
		}
	}
}
