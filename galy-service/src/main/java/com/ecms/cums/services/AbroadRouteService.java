package com.ecms.cums.services;

import java.util.Map;

public interface AbroadRouteService {
	/**
	 * 接口：获取出境参团热门目的地接口
	 * 接口描述：获取国内参团热门目的地，来源为B2C后台推荐的全文检索热门目的地，此目的地数据只显示推荐部分的目的地数据.
	 * 接口apiId:getOutboundGroupHotDest
	 * 参数示例{"rowNum":"100"}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundGroupHotDest(String param);
	/**
	 * 接口： 查询出境参团所属区域列表接口
	 * 接口描述：取得出境参团推荐线路列表。
	 * 接口apiId:getOutboundGroupDestArea
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundGroupDestArea(String param);
	/**
	 * 接口： 查询出境参团可用出发地列表接口
	 * 接口描述：取得出境参团线路所有有效的出发地列表。
	 * 接口apiId:getOutboundGroupStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundGroupStartPlace(String param);
	/**
	 * 接口： 查询出境参团推荐线路列表接口
	 * 接口描述：取得出境参团推荐线路列表。
	 * 接口apiId:getOutboundGroupRecommendRoute
	 * 参数示例{ " rowNum ": "10","terminal": "ap"}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundGroupRecommendRoute(String param);
	/**
	 * 接口： 查询出境参团线路列表接口
	 * 接口描述：根据条件查询出境参团线路列表信息。
	 * 接口apiId:getOutboundGroupRoutes
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundGroupRoutes(String param);
	/**
	 * 接口： 查询聚合页二次过滤的出境跟团游出发地
	 * 接口描述：根据条件查询聚合页二次过滤的出境跟团游出发地信息。
	 * 接口apiId:getOutboundGroupFilterStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundGroupFilterStartPlace(String param);
	/**
	 * 接口： 查询聚合页二次过滤的出境跟团游目的地
	 * 接口描述：根据条件查询聚合页二次过滤的出境跟团游目的地信息。
	 * 接口apiId:getOutboundGroupFilterDestination
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundGroupFilterDestination(String param);
	/**
	 * 接口： 获取出境参团线路详细接口
	 * 接口描述：取得出境参团线路详细信息。
	 * 接口apiId:getOutboundRouteDetail
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundRouteDetail(String param);
	/**
	 * 接口： 获取出境自由行热门目的地接口
	 * 接口描述：获取出境自由行的热门目的地数据
	 * 接口apiId:getOutboundFreeHotDest
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundFreeHotDest(String param);
	
	/**
	 * 接口： 获取出境自由行所属市场/区域接口
	 * 接口描述：获取自由行线路的所有所属市场或区域信息，以方便拉取大量的数据信息。
	 * 接口apiId:getOutboundFreeAreaInfo
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundFreeAreaInfo(String param);
	/**
	 * 接口：取得聚合页二次过滤的出境自由行出发地
	 * 接口描述：通过这个接口可以获得符合条件的出境自由行出发地信息。
	 * 接口apiId:getOutboundFreeFilterStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundFreeFilterStartPlace(String param);
	/**
	 * 接口： 取得聚合页二次过滤的出境自由行目的地
	 * 接口描述：去的符合条件的目的地信息。
	 * 接口apiId:getOutboundFreeFilterDest
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundFreeFilterDest(String param);
	/**
	 * 接口：获取出境自由行热门线路接口
	 * 接口描述：使用此接口获取出境自由行的热门推荐线路列表。
	 * 接口apiId:getOutboundFreeFilterDest
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getOutboundFreeHotRoute(String param);
	Map<String, Object> getFreeBaseInfo(String param);

}
