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
import com.ecms.cums.services.AbroadRouteService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("sys/abroad")
public class AbroadRouteController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(AbroadRouteController.class);

	@Autowired
	private AbroadRouteService abroadRouteService;

	@Resource
	private ICached cached;
	
	/**
	 * 接口：获取出境参团热门目的地接口
	 * 接口描述：获取国内参团热门目的地，来源为B2C后台推荐的全文检索热门目的地，此目的地数据只显示推荐部分的目的地数据.
	 * 接口apiId:getOutboundGroupHotDest
	 * 参数示例{"rowNum":"100"}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundGroupHotDest",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String  getDomesticGroupHotDest(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			logger.info("请求redis--获取出境参团热门目的地接口，获取目的地列表");
			String result = (String) cached.getCached(SerializeUtil.serialize(Constants.OutboundGroupHotDest));
			if(result==null){
				try {
					logger.info("获取出境参团热门目的地>>>>>>");
					Map<String,Object> reMap = abroadRouteService.getOutboundGroupHotDest(jsonbody.toString());
					logger.info("获取到数据，存到redis中>>>>>>>>>",result);
					cached.updateCached(SerializeUtil.serialize(Constants.OutboundGroupHotDest),SerializeUtil.serialize(reMap.get("responseBody")),60*10l);
					logger.info("获取到数据，直接返回前台",result);
					return (String) reMap.get("responseBody");
				} catch (Exception e){
					logger.error("请求流解析异常",e);
					this.getErrorResponse(response, "系统异常");
					e.printStackTrace();
				}
			}else{
				return result;
			}
		} catch (Exception el){
			logger.error("请求流解析异常",el);
			this.getSuccessResponse(response, "发送失败");
			el.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 接口： 查询出境参团所属区域列表接口
	 * 接口描述：取得出境参团推荐线路列表。
	 * 接口apiId:getOutboundGroupDestArea
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundGroupDestArea",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String  getOutboundGroupDestArea(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		logger.info("报案请求参数>>>" + jsonbody);
		try {
			logger.info("请求redis--查询出境参团所属区域列表");
			String result = (String) cached.getCached(SerializeUtil.serialize(Constants.OutboundGroupDestArea));
			if(result==null ){
				try {
					logger.info("查询出境参团所属区域列表>>>>>>");
					Map<String,Object> reMap = abroadRouteService.getOutboundGroupDestArea(jsonbody.toString());
					logger.info("查询出境参团所属区域列表，存入redis中",reMap);
					cached.updateCached(SerializeUtil.serialize(Constants.OutboundGroupDestArea),SerializeUtil.serialize(reMap.get("responseBody")),60*60l);
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
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 接口： 查询出境参团可用出发地列表接口
	 * 接口描述：取得出境参团线路所有有效的出发地列表。
	 * 接口apiId:getOutboundGroupStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundGroupStartPlace",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void  getOutboundGroupStartPlace(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getOutboundGroupStartPlace(jsonbody.toString());
			this.getSuccessResponse(response, "发送成功", reMap);
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
	}
	/**
	 * 接口： 查询出境参团推荐线路列表接口
	 * 接口描述：取得出境参团推荐线路列表。
	 * 接口apiId:getOutboundGroupRecommendRoute
	 * 参数示例{ " rowNum ": "10","terminal": "ap"}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundGroupRecommendRoute",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String  getOutboundGroupRecommendRoute(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			logger.info("请求redis-- 查询出境参团推荐线路列表");
			String result = (String) cached.getCached(SerializeUtil.serialize(Constants.OutboundGroupRecommendRoute));
			if(result==null ){
				try {
					logger.info(" 查询出境参团推荐线路列表>>>>>>");
					Map<String,Object> reMap = abroadRouteService.getOutboundGroupRecommendRoute(jsonbody.toString());
					logger.info(" 查询出境参团推荐线路列表，存入redis中",reMap);
					cached.updateCached(SerializeUtil.serialize(Constants.OutboundGroupRecommendRoute),SerializeUtil.serialize(reMap.get("responseBody")),60*60l);
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
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 接口： 查询出境参团线路列表接口
	 * 接口描述：根据条件查询出境参团线路列表信息。
	 * 接口apiId:getOutboundGroupRoutes
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundGroupRoutes",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void  getOutboundGroupRoutes(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getOutboundGroupRoutes(jsonbody.toString());
			this.getSuccessResponse(response, "发送成功", reMap);
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
	}
	/**
	 * 接口： 查询聚合页二次过滤的出境跟团游出发地
	 * 接口描述：根据条件查询聚合页二次过滤的出境跟团游出发地信息。
	 * 接口apiId:getOutboundGroupFilterStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundGroupFilterStartPlace",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void  getOutboundGroupFilterStartPlace(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getOutboundGroupFilterStartPlace(jsonbody.toString());
			this.getSuccessResponse(response, "发送成功", reMap);
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 接口： 查询聚合页二次过滤的出境跟团游目的地
	 * 接口描述：根据条件查询聚合页二次过滤的出境跟团游目的地信息。
	 * 接口apiId:getOutboundGroupFilterDestination
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundGroupFilterDestination",method=RequestMethod.POST,consumes="application/json")
	public void  getOutboundGroupFilterDestination(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getOutboundGroupFilterDestination(jsonbody.toString());
			this.getSuccessResponse(response, "发送成功", reMap);
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
	}
	/**
	 * 接口： 获取出境参团线路详细接口
	 * 接口描述：取得出境参团线路详细信息。
	 * 接口apiId:getOutboundRouteDetail
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundRouteDetail",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String  getOutboundRouteDetail(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getOutboundRouteDetail(jsonbody.toString());
			//this.getSuccessResponse(response, "发送成功", reMap);
			return (String) reMap.get("responseBody");
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
		return body;
	}
	
	
	//***************************************************************************//
	/**
	 * 接口： 获取出境自由行热门目的地接口
	 * 接口描述：获取出境自由行的热门目的地数据
	 * 接口apiId:getOutboundFreeHotDest
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundFreeHotDest",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void  getOutboundFreeHotDest(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getOutboundFreeHotDest(jsonbody.toString());
			this.getSuccessResponse(response, "发送成功", reMap);
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 接口： 获取出境自由行所属市场/区域接口
	 * 接口描述：获取自由行线路的所有所属市场或区域信息，以方便拉取大量的数据信息。
	 * 接口apiId:getOutboundFreeAreaInfo
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundFreeAreaInfo",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void  getOutboundFreeAreaInfo(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getOutboundFreeAreaInfo(jsonbody.toString());
			this.getSuccessResponse(response, "发送成功", reMap);
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 接口：取得聚合页二次过滤的出境自由行出发地
	 * 接口描述：通过这个接口可以获得符合条件的出境自由行出发地信息。
	 * 接口apiId:getOutboundFreeFilterStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundFreeFilterStartPlace",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void  getOutboundFreeFilterStartPlace(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getOutboundFreeFilterStartPlace(jsonbody.toString());
			this.getSuccessResponse(response, "发送成功", reMap);
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
	}
	/**
	 * 接口： 取得聚合页二次过滤的出境自由行目的地
	 * 接口描述：去的符合条件的目的地信息。
	 * 接口apiId:getOutboundFreeFilterDest
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundFreeFilterDest",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void  getOutboundFreeFilterDest(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getOutboundFreeFilterDest(jsonbody.toString());
			this.getSuccessResponse(response, "发送成功", reMap);
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 接口：获取出境自由行热门线路接口
	 * 接口描述：使用此接口获取出境自由行的热门推荐线路列表。
	 * 接口apiId:getOutboundFreeFilterDest
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getOutboundFreeHotRoute",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void  getOutboundFreeHotRoute(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getOutboundFreeHotRoute(jsonbody.toString());
			this.getSuccessResponse(response, "发送成功", reMap);
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 接口：查询-自由行线路详细接口-线路基本信息
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
	public void  getFreeBaseInfo(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String,Object> reMap = abroadRouteService.getFreeBaseInfo(jsonbody.toString());
			this.getSuccessResponse(response, "发送成功", reMap);
		} catch (Exception e) {
			this.getSuccessResponse(response, "发送失败");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
