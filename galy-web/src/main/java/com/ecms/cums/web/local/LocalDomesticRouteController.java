package com.ecms.cums.web.local;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductDestLocal;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.ordervo.Message;
import com.ecms.cums.productvo.ProductDestLocalDto;
import com.ecms.cums.productvo.ProductVo;
import com.ecms.cums.productvo.ProductVoJson;
import com.ecms.cums.services.LocalDomesticRouteService;
import com.ecms.cums.web.mvc.BaseController;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("local/sys/domestic")
public class LocalDomesticRouteController extends BaseController{
	
	/*<<<<<<<<<<<<<<后期优化到同一个类 合并方法修改传参>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	
	@Autowired
	private LocalDomesticRouteService localDomesticRouteService;
	/**
	 * 获取推荐国内目的地列表
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findLocalDomesticOriginList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findLocalDomesticOriginList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
	try {
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		//验证参数是否正确
		Message mes = localDomesticRouteService.DomesticIsBlack(jsonbody);
		if(!"1".equals(mes.getHeader().get("resCode"))){
			this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
			return ;
		}
		//获取所有国内推荐数据放入list中
		List<ProductDestLocal> productDest = localDomesticRouteService.findLocalDomesticOriginList(jsonbody);
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
	 *  获取国内所有目的地列表
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findLocalDomesticOriginAllList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findLocalDomesticOriginAllList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
	try {
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		//验证参数是否正确
		Message mes = localDomesticRouteService.DomesticAllIsBlack(jsonbody);
		if(!"1".equals(mes.getHeader().get("resCode"))){
			this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
			return ;
		}
		//获取所有国内推荐数据放入list中
		List<ProductDestLocal> list = this.localDomesticRouteService.findLocalDomesticOriginAllList(jsonbody);
		//判断是否为空
			if(null != list){
				List<ProductDestLocalDto> CategoryJson = new ArrayList<ProductDestLocalDto>();
				for(ProductDestLocal category:list){
					ProductDestLocalDto pjson = new ProductDestLocalDto();
					pjson.setDestId(category.getDestId());
					pjson.setDestPid(category.getDestPId());
					pjson.setDestName(category.getDestName());
					pjson.setPinyin(category.getPinyin());
					pjson.setProductDestVoJson(localDomesticRouteService.findDestPidList(category.getDestId()));
					CategoryJson.add(pjson);
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("CategoryJson", CategoryJson);
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
	 * 根据目的地id（dest_id）进行查询得到所有包含这个目的地的产品列表
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findLocalDomesticRouteDetailList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findLocalDomesticRouteDetailList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
	try {
		//获取请求过来的参数
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		//验证参数是否正确
		Message mes = localDomesticRouteService.DomesticByIDIsBlack(jsonbody);
		if(!"1".equals(mes.getHeader().get("resCode"))){
			this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
			return ;
		}
		//获取所有包含这个目的地的数据
		List<Product> product = localDomesticRouteService.findLocalDomesticRouteDetailList(jsonbody);
		List<ProductVo> list= new ArrayList<ProductVo>();
		if(product!=null){
			//循环list 得到数据放进一个对象里面
			for(int i=0;i<product.size();i++){
					ProductVo ul = new ProductVo();
					//获取线路类型
					TravelType travelType=	localDomesticRouteService.findTravelTypeByid(product.get(i).gettId());
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
	 * 获取国内首页推荐列表
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findLocalDomesticList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findLocalDomesticList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
		try {
			JSONObject param= JSONObject.fromObject(body);
			JSONObject jsonbody = param.getJSONObject("body");
			//验证参数是否正确
			Message mes = localDomesticRouteService.DomesticByHostIsBlack(jsonbody);
			if(!"1".equals(mes.getHeader().get("resCode"))){
				this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
				return ;
			}
			List<Product> product = this.localDomesticRouteService.findLocalDomesticList(jsonbody);
			List<ProductVo> list= new ArrayList<ProductVo>();
			if(product!=null){
				//循环list 得到数据放进一个对象里面
				for(int i=0;i<product.size();i++){
						ProductVo ul = new ProductVo();
						//获取线路类型
						TravelType travelType=	localDomesticRouteService.findTravelTypeByid(product.get(i).gettId());
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
				this.getSuccessResponseJson(response, map);
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
		Message mes = localDomesticRouteService.DomesticByPidIsBlack(jsonbody);
		if(!"1".equals(mes.getHeader().get("resCode"))){
 			this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
			return ;
		}
		//根据id进行查询信息
		List<Product> list=localDomesticRouteService.findRouteById(jsonbody.getInt("pId"));
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
							if(product.getSystemFlag()=="1"){
								
							} 
							TravelType travelType=	localDomesticRouteService.findTravelTypeByid(product.gettId());
							//线路名称
							pJson.settId(travelType.getTypeName());
							List<ProductInfoWithBLOBs> productInfo= localDomesticRouteService.findProductInfoByPid(product.getpId());
		 					pJson.setProductInfoWithBLOBs(productInfo);
							List<TreamDetail> treamDetail=localDomesticRouteService.findTreamDetailList(productInfo.get(0).getiId());
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
	 * 获取国内所有的数据列表
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findLocalDomesticAllList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findLocalDomesticAllList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response) {
		try {
			JSONObject param= JSONObject.fromObject(body);
			JSONObject jsonbody = param.getJSONObject("body");
			//验证参数是否正确
			Message mes = localDomesticRouteService.DomesticByHostIsBlack(jsonbody);
			if(!"1".equals(mes.getHeader().get("resCode"))){
				this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
				return ;
			}
			List<Product> product = this.localDomesticRouteService.findLocalDomesticAllList(jsonbody);
			List<ProductVo> list= new ArrayList<ProductVo>();
			if(product!=null){
				//循环list 得到数据放进一个对象里面
				for(int i=0;i<product.size();i++){
						ProductVo ul = new ProductVo();
						//获取线路类型
						TravelType travelType=	localDomesticRouteService.findTravelTypeByid(product.get(i).gettId());
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
				this.getSuccessResponseJson(response, map);
			}else{
				this.getSuccessResponse(response,"数据为空");
			}
		} catch (Exception e){
			this.getErrorResponse(response,"系统错误");
			e.printStackTrace();
		}
	}
	
	

}
