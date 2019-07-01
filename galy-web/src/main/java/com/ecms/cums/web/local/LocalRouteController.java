package com.ecms.cums.web.local;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ecms.cums.logutils.FunOrderLog;
import com.ecms.cums.model.EShop;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductGuolv;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.ordervo.Message;
import com.ecms.cums.productvo.ProductDestDto;
import com.ecms.cums.productvo.ProductVo;
import com.ecms.cums.productvo.ProductVoJson;
import com.ecms.cums.services.LocalDomesticRouteService;
import com.ecms.cums.services.LocalRouteService;
import com.ecms.cums.utils.StringReaderUtils;
import com.ecms.cums.web.mvc.BaseController;
import com.google.gson.JsonSyntaxException;
import net.sf.json.JSONObject;
@Controller
@RequestMapping("/sys/local/")
public class LocalRouteController extends BaseController{
	@Resource
	private LocalRouteService localRouteService;
	@Resource
	private LocalDomesticRouteService localDomesticRouteService;
	/***
	 * 获取不同分类下的数据列表
	 *
	 * */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getLocalBySystemflag",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void getLocalBySystemflag(@RequestBody String parameter,HttpServletRequest request,HttpServletResponse response){
		try {
			JSONObject param= JSONObject.fromObject(parameter);
			JSONObject jsonbody = param.getJSONObject("body");
			//验证参数是否正确
			Message message = localRouteService.LocalByHostIsBlack(jsonbody);
			if(!"1".equals(message.getHeader().get("resCode"))){
				this.getErrorResponse(response, message.getHeader().get("resMsg").toString());
					return ;
			}
			List<Product> product = this.localRouteService.findAllLocalList(jsonbody);
			List<ProductVo> list= new ArrayList<ProductVo>();
				if(product!=null){
					//循环list 得到数据放进一个对象里面
					for(int i=0;i<product.size();i++){
						ProductVo ul = new ProductVo();
						//获取线路类型name
						TravelType travelType=	localRouteService.findTravelTypeByid(product.get(i).gettId());
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
	@RequestMapping(value="findRouteDetailById",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findRouteDetailById(@RequestBody String parameter,HttpServletRequest request,HttpServletResponse response) {
		try {
		//获取请求过来的参数
		JSONObject param= JSONObject.fromObject(parameter);
		JSONObject jsonbody = param.getJSONObject("body");
		//验证参数是否正确
		Message mes = localRouteService.localByPidIsBlack(jsonbody);
		if(!"1".equals(mes.getHeader().get("resCode"))){
 			this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
			return ;
		}
		//根据id进行查询信息
			List<Product> list=localRouteService.findLocalRouteByPid(jsonbody.getInt("pId"));
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
							pJson.setStatus(product.getStatus());
							TravelType travelType=	localRouteService.findTravelTypeByid(product.gettId());
							//线路名称
							pJson.settId(travelType.getTypeName());
							//根据路线pid进行查询线路的详细信息
							List<ProductInfoWithBLOBs> productInfo= localRouteService.findProductInfoByPid(product.getpId());
							pJson.setProductInfoWithBLOBs(productInfo);
							//根据线路详细信息查询此线路的价格日历
							List<TreamDetail> teamDetailList=localRouteService.findTreamDetailList(productInfo.get(0).getiId());
							pJson.setTreamDetailList(teamDetailList);
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
	 * @Title: queryEshopList
	 * @Description: 获取店铺信息
	 * @param
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="queryEshopList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void queryEshopList(HttpServletRequest request,HttpServletResponse response) {
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("报案请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String compId = body.getString("compId");
			String systemFlag = body.getString("systemFlag");
			if(StringUtils.isBlank(compId) || StringUtils.isBlank(systemFlag)){
				this.getErrorResponse(response, "店铺id或者类型为空");
				return;
			}
			List<ProductVo> list= new ArrayList<ProductVo>();
			Map<String, Object> map = new HashMap<String, Object>();
			if("0".equals(compId)){
				List<ProductGuolv> productGuolv = localRouteService.queryProductGuoLvListByParams(systemFlag);
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
				if("0".equals(systemFlag)){
					map.put("eShopName", "中国国际旅行社总社");
					map.put("ePic", "images/abroad/yuenanyazhuang.jpeg");
				}
			}else{
				List<Product> product = this.localRouteService.queryEshopList(compId,systemFlag);
				for(int i=0;i<product.size();i++){
					ProductVo ul = new ProductVo();
					//获取线路类型name
					TravelType travelType=	localRouteService.findTravelTypeByid(product.get(i).gettId());
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
				if("0".equals(systemFlag)){
					EShop shop = localRouteService.selectEshopByPrimaryId(compId);
					map.put("eShopName", shop.geteName());
					map.put("ePic", shop.getRemark());
				}
			}
			map.put("list", list);
			this.getSuccessResponse(response,map);
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}
	/**
	 * 根据t_id(自由行，跟团游)分类进行查询
	 * @param parameter
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="findRouteByTid",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findRouteByTid(@RequestBody String parameter,HttpServletRequest request,HttpServletResponse response){
		try {
			//获取请求过来的参数
			JSONObject param= JSONObject.fromObject(parameter);
			JSONObject jsonbody = param.getJSONObject("body");
			//验证参数是否正确
			Message mes = localRouteService.findRouteAllByTidIsBlack(jsonbody);
			if(!"1".equals(mes.getHeader().get("resCode"))){
			 	this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
				return ;
			}
			List<Product> product = this.localRouteService.findRouteByTid(jsonbody);
			List<ProductVo> list= new ArrayList<ProductVo>();
				if(product!=null){
					//循环list 得到数据放进一个对象里面
					for(int i=0;i<product.size();i++){
						ProductVo ul = new ProductVo();
						//获取线路类型name
						TravelType travelType=	localRouteService.findTravelTypeByid(product.get(i).gettId());
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
		} catch (Exception e) {
			this.getErrorResponse(response,"系统错误");
			e.printStackTrace();
		}
	}

	/**
	 * 根据商品分类进行展示目的地
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="findDestBySystemFlag",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void findDestBySystemFlag(@RequestBody String parameter,HttpServletRequest request,HttpServletResponse response){
			//获取请求过来的参数
			JSONObject param= JSONObject.fromObject(parameter);
			JSONObject jsonbody = param.getJSONObject("body");
			//验证参数是否正确
			Message mes = localRouteService.findDestBySystemFlagIsBlack(jsonbody);
			if(!"1".equals(mes.getHeader().get("resCode"))){
			 	this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
				return ;
			}
			List<ProductDest> list=this.localRouteService.findDestBySystemFlag(jsonbody);
			if(null != list){
				List<ProductDestDto> CategoryJson = new ArrayList<ProductDestDto>();
				for(ProductDest category:list){
					ProductDestDto pjson = new ProductDestDto();
					pjson.setDestId(category.getDestId());
					pjson.setDestPid(category.getDestPId());
					pjson.setDestName(category.getDestName());
					pjson.setPinyin(category.getPinyin());
					pjson.setSystemFlag(category.getSystemFlag());
					//pjson.setProductDestVoJson(localDomesticRouteService.findDestPidList(category.getDestId()));
					pjson.setProductDestVoJson(localRouteService.findDestPidList(category.getDestId(),jsonbody));
					CategoryJson.add(pjson);
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("CategoryJson", CategoryJson);
				this.getSuccessResponseJson(response, map);
			}
		}
	/**
	 *根据目的地id查询列表国内跟团游
	 *参数：国旅 destId
	 *	     国安： destid  system_flag（1-国内，2-境外，3-周边，4-游轮，5-门票，6-签证） status（1--打开，0--禁用）
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getAllRouteTravelAndLocalList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public  void  getAllRouteTravelAndLocalList(@RequestBody String parameter,HttpServletRequest request,HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(parameter);
		JSONObject jsonbody = param.getJSONObject("body");
		Message mes = localRouteService.getAllRouteTravelAndLocalListIsBlack(jsonbody);
		if(!"1".equals(mes.getHeader().get("resCode"))){
		 	this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
			return ;
		}
//		//根据static的传值判断国旅的接口
//		Map<String,Object> reMap = new HashMap<String, Object>();
//		if(jsonbody.getString("static").equals("1")){
//			//获取国旅国内跟团游接口数据
//			reMap = localRouteService.getDomesticGroupRoutes(jsonbody.toString());
//		}else if(jsonbody.getString("static").equals("2")){
//			//获取国旅国内自由行接口数据
//			reMap = localRouteService.seachDomesticFree(jsonbody.toString());
//		}else if(jsonbody.getString("static").equals("3")){
//			//获取国旅国外跟团游接口数据
//			reMap = localRouteService.getOutboundGroupRoutes(jsonbody.toString());
//		}else if(jsonbody.getString("static").equals("4")){
//			//获取国旅国外自由行接口数据
//			reMap = localRouteService.seachOutboundFree(jsonbody.toString());
//		}
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
					//目的地城市
					ul.setDestPlaceId(product.get(i).getDestPlaceId());
					//供应商
					list.add(ul);
				 }
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
//			map.put("guolvResult",reMap.get("responseBody"));
			this.getSuccessResponse(response, map);
		}
	}


}

