package com.ecms.cums.services;

import java.util.List;
import java.util.Map;

import com.ecms.cums.model.EShop;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductGuolv;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.ordervo.Message;

import net.sf.json.JSONObject;

public interface LocalRouteService {
	/**
	 * 验证参数是否正确
	 * @param jsonbody
	 * @return
	 */
	Message LocalByHostIsBlack(JSONObject jsonbody);
	/**
	 * 获取全部数据--list
	 * @param jsonbody
	 * @return
	 */
	List<Product> findAllLocalList(JSONObject jsonbody);
	/**
	 * 获取线路类型name
	 * @param gettId
	 * @return
	 */
	TravelType findTravelTypeByid(Integer gettId);
	/**
	 * 判断详情页参数是否正确
	 * @param jsonbody
	 * @return
	 */

	Message localByPidIsBlack(JSONObject jsonbody);

	/**
	 * 获取详情页数据
	 * @param int1
	 * @return
	 */

	List<Product> findLocalRouteByPid(int pid);
	/**
	 * 根据路线pid进行查询线路的详细信息
	 * @param getpId
	 * @return
	 */

	List<ProductInfoWithBLOBs> findProductInfoByPid(Integer getpId);

	/**
	 * 根据线路详细信息查询此线路的价格日历
	 * @param getiId
	 * @return
	 */
	List<TreamDetail> findTreamDetailList(Integer getiId);

	/**
	 * @Title: queryEshopList
	 * @Description: 获取店铺数据信息
	 * @param compId
	 * @param systemFlag
	 * @return
	 * @return: List<Product>
	 */
	List<Product> queryEshopList(String compId, String systemFlag);
	/**
	 * @Title: selectEshopByPrimaryId
	 * @Description: 获取门店实体
	 * @param compId
	 * @return
	 * @return: EShop
	 */
	EShop selectEshopByPrimaryId(String compId);
	/**
	 * 验证查询根据t_id进行分类的参数是否正确
	 * @param jsonbody
	 * @return
	 */
	Message findRouteAllByTidIsBlack(JSONObject jsonbody);
	/**
	 * 查询根据t_id进行分类的列表
	 * @param jsonbody
	 * @return
	 */
	List<Product> findRouteByTid(JSONObject jsonbody);
	/**
	 * 查询ProductDestLocal列表
	 * @param jsonbody
	 * @return
	 */
	List<ProductDest> findDestBySystemFlag(JSONObject jsonbody);
	/**
	 *验证参数是否存在
	 * @param jsonbody
	 * @return
	 */
	Message findDestBySystemFlagIsBlack(JSONObject jsonbody);
	/**
	 * 验证参数是否存在
	 * @param jsonbody
	 * @return
	 */
	Message getAllRouteTravelAndLocalListIsBlack(JSONObject jsonbody);

	/**
	 * 获取国旅国内跟团游的数据
	 * @param string
	 * @return
	 */
	Map<String, Object> getDomesticGroupRoutes(String string);
	/**
	 * 获取国旅国外跟团游的数据
	 * @param string
	 * @return
	 */
	Map<String, Object> getOutboundGroupRoutes(String string);

	Map<String, Object> seachOutboundFree(String string);
	Map<String, Object> seachDomesticFree(String string);

	List<ProductDest> findDestPidList(String destId,JSONObject jsonbody);

	List<ProductGuolv> queryProductGuoLvListByParams(String systemFlag);

}
