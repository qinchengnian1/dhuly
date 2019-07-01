package com.ecms.cums.services;

import java.util.Map;


public interface DomesticRouteService {

	/**
	 * 接口：获取国内参团热门目的地接口
	 * 接口描述：获取国内参团热门目的地，来源为B2C后台推荐的全文检索热门目的地，此目的地数据只显示推荐部分的目的地数据.
	 * 参数示例{"rowNum":"100"}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticGroupHotDest(String params);

	Map<String, Object> getDomesticTeamHotDest(String params);
	/**
	 * 接口：查询国内参团所属区域列表接口
	 * 接口描述：取得国内参团推荐线路列表。
	 * 接口apiId:getDomesticGroupDestArea
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticGroupDestArea(String params);
	/**
	 * 接口：查询国内参团可用出发地列表接口
	 * 接口描述：取得出境参团线路所有有效的出发地列表。
	 * 接口apiId:getDomesticGroupStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticGroupStartPlace(String params);
	/**
	 * 接口：查询国内参团推荐线路列表接口
	 * 接口描述：取得出境参团推荐线路列表。
	 * 接口apiId:getDomesticGroupRecommendRoute
	 * 参数示例{"rowNum":"100","terminal": "ap"}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticGroupRecommendRoute(String params);
	/**
	 * 接口：查询国内参团线路列表接口
	 * 接口描述：根据条件查询国内参团线路列表信息。
	 * 接口apiId:getDomesticGroupRoutes
	 * 参数示例{{"dayNumBegin": "1","dayNumEnd": "20","destArea": "1",
     * "destId": "14001002277","destIdFilter": "14001002277",
     * "endDate": "2015-12-01","fromCity": "北京","orderBy": "2",
     * " rowNum ": "1"," page ": "3","priceAreaBegin": "1","priceAreaEnd": "1000000",
     * "routeName": "游","startDate": "2014-12-01"}}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticGroupRoutes(String params);
	/**
	 * 接口：查询聚合页二次过滤的国内参团游出发地
	 * 接口描述：根据条件查询聚合页二次过滤的国内参团游出发地信息。
	 * 接口apiId:getDomesticGroupFilterStartPlace
	 * 参数示例 同线路列表查询
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticGroupFilterStartPlace(String params);
	/**
	 * 接口：查询聚合页二次过滤的国内参团游目的地
	 * 接口描述：根据条件查询聚合页二次过滤的国内参团游目的地信息。
	 * 接口apiId:getDomesticGroupFilterDestination
	 * 参数示例  同线路列表查询
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticGroupFilterDestination(String params);
	/**
	 * 接口：获取国内参团线路详细接口
	 * 接口描述：取得出境参团线路详细信息。
	 * 接口apiId:getDomesticRouteDetail
	 * 参数示例{"routeId": "07001595620"}
	 * @param body	
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticRouteDetail(String params);

	/**
	 * 接口：获取国内自由行热门目的地接口
	 * 接口描述：获取国内自由行的热门目的地数据
	 * 接口apiId:getDomesticFreeHotDest
	 * 参数示例{"rowNum": "10"}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticFreeHotDest(String params);
	/**
	 * 接口：获取国内自由行所属市场/区域接口
	 * 接口描述：获取自由行线路的所有所属市场或区域信息，以方便拉取大量的数据信息。
	 * 接口apiId:getDomesticFreeAreaInfo
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticFreeAreaInfo(String params);
	
	/**
	 * 接口:取得聚合页二次过滤的国内自由行出发地
	 * 接口描述：通过这个接口可以获得符合条件的国内自由行出发地信息。
	 * 接口apiId:getDomesticFreeFilterStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticFreeFilterStartPlace(String params);

	/**
	 * 接口:取得聚合页二次过滤的国内自由行目的地
	 * 接口描述：去的符合条件的目的地信息。
	 * 接口apiId:getDomesticFreeFilterStartPlace
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticFreeFilterDest(String params);
	/**
	 * 接口:获取国内自由行热门线路接口
	 * 接口描述：使用此接口获取国内自由行的热门推荐线路列表。
	 * 接口apiId:getDomesticFreeHotRoute
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getDomesticFreeHotRoute(String params);
	/**
	 * 接口:查询-自由行线路详细接口-线路基本信息
	 * 接口描述：取得自由行线路详细信息。不含酒店交通价格等信息。
	 * 接口apiId:getFreeBaseInfo
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getFreeBaseInfo(String params);
	/**
	 * 接口:十九、	查询-自由行线路出发日期接口
	 * 接口描述：取得自由行线路出发日期信息。与自由行产品出发日期表 相对应
	 * 接口apiId:getFreeDateInfo
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getFreeDateInfo(String params);
	/**
	 * 接口:查询-自由行线路行程接口
	 * 接口描述：取得自由行具体产品的行程信息。与TravelInfoVo相对应
	 * 接口apiId:getFreeDateInfo
	 * 参数示例{}
	 * @param body
	 * @param request
	 * @param response
	 */
	Map<String, Object> getFreeTripInfo(String params);

	
	


}
