package com.ecms.cums.web.mvc;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.cums.core.cached.ICached;
import com.ecms.cums.core.cached.SerializeUtil;
import com.ecms.cums.cores.Constants;
import com.ecms.cums.services.DomesticRouteService;

import net.sf.json.JSONObject;
/**
 * 国内旅游接口
 * @author 王莹磊
 */
@Controller
@RequestMapping("sys/domestic")
public class DomesticRouteController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(DomesticRouteController.class);

	@Autowired
	private DomesticRouteService domesticRoute;
	
	
	@Resource
	private ICached cached;
	
	/**
	 * 接口：获取国内参团热门目的地接口
	 * 接口描述：获取国内参团热门目的地，来源为B2C后台推荐的全文检索热门目的地，此目的地数据只显示推荐部分的目的地数据.
	 * 接口apiId:getDomesticGroupHotDest
	 * 参数示例{"rowNum":"100"}
	 * @param body
	 * @param request
	 * @param response
	 * @return 
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticGroupHotDest",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticGroupHotDest(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			logger.info("请求redis--获取国内参团热门目的地接口，获取目的地列表");
			String result = (String) cached.getCached(SerializeUtil.serialize(Constants.DomesticGroupHotDest_key));
			if(result==null){
				try {
					logger.info("获取国内参团热门目的地>>>>>>");
					Map<String,Object> reMap = domesticRoute.getDomesticGroupHotDest(jsonbody.toString());
					logger.info("获取到数据，存到redis中>>>>>>>>>",result);
					cached.updateCached(SerializeUtil.serialize(Constants.DomesticGroupHotDest_key),SerializeUtil.serialize(reMap.get("responseBody")),60*60l);
					logger.info("获取到数据，直接返回前台",result);
					return (String) reMap.get("responseBody");
				} catch (Exception e){
					logger.error("请求流解析异常",e);
					this.getErrorResponse(response, "系统异常");
					e.printStackTrace();
				}
			}else{
				logger.info("从redis中获取到数据，直接返回前台",result);
				return result;
			}
		} catch (Exception e1) {
			logger.error("请求流解析异常",e1);
			e1.printStackTrace();
		}
		return body;
	}
	
	/**
	 * 接口：查询国内参团所属区域列表接口
	 * 接口描述：取得国内参团推荐线路列表。
	 * 接口apiId:getDomesticGroupDestArea
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 * @return 
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticGroupDestArea",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticGroupDestArea(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			logger.info("请求redis--获取国内参团热门目的地接口，获取目的地列表");
			String result = (String) cached.getCached(SerializeUtil.serialize(Constants.DomesticGroupDestArea_key));
			if(result==null ){
				try {
					logger.info("获取国内参团热门目的地>>>>>>");
					Map<String,Object> reMap = domesticRoute.getDomesticGroupDestArea(jsonbody.toString());
					logger.info("获取国内参团热门目的地，存入redis中",reMap);
					cached.updateCached(SerializeUtil.serialize(Constants.DomesticGroupDestArea_key),SerializeUtil.serialize(reMap.get("responseBody")),60*60l);
					logger.info("获取到数据，直接返回前台");
					return (String) reMap.get("responseBody");
				} catch (Exception e){
					logger.error("请求流解析异常",e);
					this.getErrorResponse(response, "系统异常");
					e.printStackTrace();
				}
			}else{
				logger.info("从redis中获取到数据，直接返回前台",result);
				return result;
			}
		} catch (Exception e1) {
			logger.error("请求流解析异常",e1);
			this.getErrorResponse(response, "系统异常");
			e1.printStackTrace();
		}
		return body;
	}
	
	/**
	 * 接口：查询国内参团可用出发地列表接口
	 * 接口描述：取得出境参团线路所有有效的出发地列表。
	 * 接口apiId:getDomesticGroupStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticGroupStartPlace",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticGroupStartPlace(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			logger.info("请求redis--查询国内参团可用出发地列表");
			String result = (String) cached.getCached(SerializeUtil.serialize(Constants.DomesticGroupStartPlace_key));
			if(result==null ){
				try {
					logger.info("查询国内参团可用出发地列表>>>>>>");
					Map<String,Object> reMap = domesticRoute.getDomesticGroupStartPlace(jsonbody.toString());
					logger.info("查询国内参团可用出发地列表，存入redis中",reMap);
					cached.updateCached(SerializeUtil.serialize(Constants.DomesticGroupStartPlace_key),SerializeUtil.serialize(reMap.get("responseBody")),60*60l);
					logger.info("获取到数据，直接返回前台",reMap);
					return (String) reMap.get("responseBody");
				} catch (Exception e){
					logger.error("请求流解析异常",e);
					this.getErrorResponse(response, "系统异常");
					e.printStackTrace();
				}
			}else{
				logger.info("从redis中获取到数据，直接返回前台",result);
				return result;
			}
		} catch (Exception e1) {
			logger.error("请求流解析异常",e1);
			this.getErrorResponse(response, "系统异常");
			e1.printStackTrace();
		}
		return body;
	}
	
	/**
	 * 接口：查询国内参团推荐线路列表接口
	 * 接口描述：取得出境参团推荐线路列表。
	 * 接口apiId:getDomesticGroupRecommendRoute
	 * 参数示例{"rowNum":"100","terminal": "ap"}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticGroupRecommendRoute",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticGroupRecommendRoute(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			logger.info("请求redis--查询国内参团推荐线路列表");
			String result = (String) cached.getCached(SerializeUtil.serialize(Constants.DomesticGroupRecommendRoute_key));
			if(result==null){
				try {
					logger.info("查询国内参团推荐线路列表>>>>>>");
					Map<String,Object> reMap = domesticRoute.getDomesticGroupRecommendRoute(jsonbody.toString());
					logger.info("查询国内参团推荐线路列表，存入redis中",reMap);
					cached.updateCached(SerializeUtil.serialize(Constants.DomesticGroupRecommendRoute_key),SerializeUtil.serialize(reMap.get("responseBody")),60*60l);
					logger.info("获取到数据，直接返回前台",reMap);
					return (String) reMap.get("responseBody");
				} catch (Exception e) {
					logger.error("请求流解析异常",e);
					this.getErrorResponse(response, "系统异常");
					e.printStackTrace();
				}
			}else{
				logger.info("从redis中获取数据，返回给前台",result);
				return result;
			}
		} catch (Exception e1) {
			logger.error("请求流解析异常",e1);
			this.getErrorResponse(response, "系统异常");
			e1.printStackTrace();
		}
		return body;

	}
	/**
	 * 接口：查询国内参团线路列表接口
	 * 接口描述：根据条件查询国内参团线路列表信息。
	 * 接口apiId:getDomesticGroupRoutes
	 * 参数示例{"destArea":"HB"}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticGroupRoutes",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticGroupRoutes(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			logger.info("查询国内参团线路列表");
			Map<String,Object> reMap = domesticRoute.getDomesticGroupRoutes(jsonbody.toString());
			logger.info("获取到数据，直接返回前台",reMap);
			return (String) reMap.get("responseBody");
		} catch (Exception e) {
			logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "系统异常");
			e.printStackTrace();
		}
		return body;
	}
	/**
	 * 接口：查询聚合页二次过滤的国内参团游出发地
	 * 接口描述：根据条件查询聚合页二次过滤的国内参团游出发地信息。
	 * 接口apiId:getDomesticGroupFilterStartPlace
	 * 参数示例 同线路列表查询
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticGroupFilterStartPlace",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticGroupFilterStartPlace(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			logger.info("查询聚合页二次过滤的国内参团游出发地");
			Map<String,Object> reMap = domesticRoute.getDomesticGroupFilterStartPlace(jsonbody.toString());
			logger.info("获取到数据，直接返回前台",reMap);
			return (String) reMap.get("responseBody");
		} catch (Exception e) {
			logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "系统异常");
			e.printStackTrace();
		}
		return body;
	}
	
	/**
	 * 接口：查询聚合页二次过滤的国内参团游目的地
	 * 接口描述：根据条件查询聚合页二次过滤的国内参团游目的地信息。
	 * 接口apiId:getDomesticGroupFilterDestination
	 * 参数示例  同线路列表查询
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticGroupFilterDestination",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticGroupFilterDestination(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			logger.info("查询聚合页二次过滤的国内参团游目的地");
			Map<String,Object> reMap = domesticRoute.getDomesticGroupFilterDestination(jsonbody.toString());
			logger.info("获取到数据，直接返回前台",reMap);
			return (String) reMap.get("responseBody");
		} catch (Exception e) {
			logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "系统异常");
			e.printStackTrace();
		}
		return body;
	}
	/**
	 * 接口：获取国内参团线路详细接口
	 * 接口描述：取得出境参团线路详细信息。
	 * 接口apiId:getDomesticRouteDetail
	 * 参数示例{"routeId": "07001595620"}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticRouteDetail",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticRouteDetail(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			 	logger.info("获取国内参团线路详细信息");
				Map<String,Object> reMap = domesticRoute.getDomesticRouteDetail(jsonbody.toString());
				logger.info("获取到数据，直接返回前台",reMap);
				return (String) reMap.get("responseBody");
			} catch (Exception e) {
				logger.error("请求流解析异常",e);
				this.getErrorResponse(response, "系统异常");
				e.printStackTrace();
			}
		return body;
	} 
	
	/**
	 * 接口：获取国内自由行热门目的地接口
	 * 接口描述：获取国内自由行的热门目的地数据
	 * 接口apiId:getDomesticFreeHotDest
	 * 参数示例{"rowNum": "10"}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticFreeHotDest",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticFreeHotDest(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			logger.info("请求redis--获取国内自由行热门目的地接口，获取目的地列表");
			String result = (String) cached.getCached(SerializeUtil.serialize(Constants.DomesticFreeHotDest_key));
			if(result==null){
				try {
					logger.info("获取国内自由行热门目的地>>>>>>");
					Map<String,Object> reMap = domesticRoute.getDomesticFreeHotDest(jsonbody.toString());
					logger.info("获取到数据，存到redis中>>>>>>>>>",result);
					cached.updateCached(SerializeUtil.serialize(Constants.DomesticFreeHotDest_key),SerializeUtil.serialize(reMap.get("responseBody")),60*60l);
					logger.info("获取到数据，直接返回前台",result);
					return (String) reMap.get("responseBody");
				} catch (Exception e){
					logger.error("请求流解析异常",e);
					this.getErrorResponse(response, "系统异常");
					e.printStackTrace();
				}
			}else{
				logger.info("从redis中获取到数据，直接返回前台",result);
				return result;
			}
		} catch (Exception e1) {
			logger.error("请求流解析异常",e1);
			e1.printStackTrace();
		}
		return body;
	}
	
	/**
	 * 接口：获取国内自由行所属市场/区域接口
	 * 接口描述：获取自由行线路的所有所属市场或区域信息，以方便拉取大量的数据信息。
	 * 接口apiId:getDomesticFreeAreaInfo
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticFreeAreaInfo",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticFreeAreaInfo(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			 	logger.info("获取国内自由行所属市场/区域");
				Map<String,Object> reMap = domesticRoute.getDomesticFreeAreaInfo(jsonbody.toString());
				logger.info("获取到数据，直接返回前台",reMap);
				return (String) reMap.get("responseBody");
			} catch (Exception e) {
				logger.error("请求流解析异常",e);
				this.getErrorResponse(response, "系统异常");
				e.printStackTrace();
			}
		return body;
	} 
	
	
	/**
	 * 接口:取得聚合页二次过滤的国内自由行出发地
	 * 接口描述：通过这个接口可以获得符合条件的国内自由行出发地信息。
	 * 接口apiId:getDomesticFreeFilterStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticFreeFilterStartPlace",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticFreeFilterStartPlace(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			 	logger.info("取得聚合页二次过滤的国内自由行出发地");
				Map<String,Object> reMap = domesticRoute.getDomesticFreeFilterStartPlace(jsonbody.toString());
				logger.info("获取到数据，直接返回前台",reMap);
				return (String) reMap.get("responseBody");
			} catch (Exception e) {
				logger.error("请求流解析异常",e);
				this.getErrorResponse(response, "系统异常");
				e.printStackTrace();
			}
		return body;
	} 
	
	/**
	 * 接口:取得聚合页二次过滤的国内自由行目的地
	 * 接口描述：去的符合条件的目的地信息。
	 * 接口apiId:getDomesticFreeFilterStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticFreeFilterDest",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticFreeFilterDest(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			 	logger.info("取得聚合页二次过滤的国内自由行出发地");
				Map<String,Object> reMap = domesticRoute.getDomesticFreeFilterDest(jsonbody.toString());
				logger.info("获取到数据，直接返回前台",reMap);
				return (String) reMap.get("responseBody");
			} catch (Exception e) {
				logger.error("请求流解析异常",e);
				this.getErrorResponse(response, "系统异常");
				e.printStackTrace();
			}
		return body;
	} 
	/**
	 * 接口:获取国内自由行热门线路接口
	 * 接口描述：使用此接口获取国内自由行的热门推荐线路列表。
	 * 接口apiId:getDomesticFreeHotRoute
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getDomesticFreeHotRoute",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getDomesticFreeHotRoute(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			 	logger.info("获取国内自由行热门线路");
				Map<String,Object> reMap = domesticRoute.getDomesticFreeHotRoute(jsonbody.toString());
				logger.info("获取到数据，直接返回前台",reMap);
				return (String) reMap.get("responseBody");
			} catch (Exception e) {
				logger.error("请求流解析异常",e);
				this.getErrorResponse(response, "系统异常");
				e.printStackTrace();
			}
		return body;
	} 
	
	/**
	 * 接口:查询-自由行线路详细接口-线路基本信息
	 * 接口描述：取得自由行线路详细信息。不含酒店交通价格等信息。
	 * 接口apiId:getFreeBaseInfo
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getFreeBaseInfo",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getFreeBaseInfo(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			 	logger.info("获取国内参团线路详细信息");
				Map<String,Object> reMap = domesticRoute.getFreeBaseInfo(jsonbody.toString());
				logger.info("获取到数据，直接返回前台",reMap);
				return (String) reMap.get("responseBody");
			} catch (Exception e) {
				logger.error("请求流解析异常",e);
				this.getErrorResponse(response, "系统异常");
				e.printStackTrace();
			}
		return body;
	} 
	/**
	 * 接口:查询-自由行线路出发日期接口
	 * 接口描述：取得自由行线路出发日期信息。与自由行产品出发日期表 相对应
	 * 接口apiId:getFreeDateInfo
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getFreeDateInfo",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getFreeDateInfo(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			 	logger.info("获取国内参团线路详细信息");
				Map<String,Object> reMap = domesticRoute.getFreeDateInfo(jsonbody.toString());
				logger.info("获取到数据，直接返回前台",reMap);
				return (String) reMap.get("responseBody");
			} catch (Exception e) {
				logger.error("请求流解析异常",e);
				this.getErrorResponse(response, "系统异常");
				e.printStackTrace();
			}
		return body;
	} 
	/**
	 * 接口:查询-自由行线路行程接口
	 * 接口描述：取得自由行具体产品的行程信息。与TravelInfoVo相对应
	 * 接口apiId:getFreeDateInfo
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getFreeTripInfo",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getFreeTripInfo(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			 	logger.info("获取国内参团线路详细信息");
				Map<String,Object> reMap = domesticRoute.getFreeTripInfo(jsonbody.toString());
				logger.info("获取到数据，直接返回前台",reMap);
				return (String) reMap.get("responseBody");
			} catch (Exception e) {
				logger.error("请求流解析异常",e);
				this.getErrorResponse(response, "系统异常");
				e.printStackTrace();
			}
		return body;
	}
	
	
	
	
	
	
}  

	
	

