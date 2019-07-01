package com.ecms.cums.services;

import java.util.List;

import com.ecms.cums.airportvo.AirportOrderListVo;
import com.ecms.cums.airportvo.AriportOrderVo;
import com.ecms.cums.airportvo.CreateOrderResultVo;
import com.ecms.cums.model.FAirportCity;
import com.ecms.cums.model.FAirportOrders;
import com.ecms.cums.model.FAirportTourist;
import com.ecms.cums.model.FAirportTouristOrder;

public interface FAriportService {
	/**
	 * @Title: queryCityListByStatus
	 * @Description: 根据状态查询城市列表
	 * @param status
	 * @return
	 * @return: List<FAirportCity>
	 */
	List<FAirportCity> queryCityListByStatus(String status);

	/**
	 * @Title: queryHotCityListByStatus
	 * @Description: 根据状态获取热门城市列表
	 * @param status
	 * @return
	 * @return: List<FAirportCity>
	 */
	List<FAirportCity> queryHotCityListByStatus(String status);

	/**
	 * @Title: saveOrderInfo
	 * @Description: 保存机票订单信息到本地
	 * @param ariportOrder
	 * @param resp
	 * @param walletPayDiscountAmount
	 * @return: void
	 */
	void saveOrderInfo(AriportOrderVo ariportOrder, CreateOrderResultVo resp,
			String walletPayDiscountAmount,String orderGroupId,String orderSns,String fenrun);

	/**
	 * @Title: getOrderByOrderGroupid
	 * @Description: 根据平台订单编号查询订单实体
	 * @param orderGroupIds
	 * @return
	 * @return: FAirportOrders
	 */
	FAirportOrders getOrderByOrderGroupid(String orderGroupIds);

	/**
	 * @Title: saveAirportOrderEntiy
	 * @Description: 保存订单实体到本地
	 * @param order
	 * @return: void
	 */
	void saveAirportOrderEntiy(FAirportOrders order);

	/**
	 * @param orderStatus
	 * @param userId
	 * @Title: getAriportOrderList
	 * @Description:
	 * @return
	 * @return: List<AirportOrderListVo>
	 */
	List<AirportOrderListVo> getAriportOrderList(String userId);

	/**
	 * @Title: queryFAirportOrdersByPrimaryKey
	 * @Description: TODO
	 * @param orderId
	 * @return
	 * @return: FAirportOrders
	 */
	FAirportOrders queryFAirportOrderByPrimaryKey(String orderId);
	/**
	 * @Title: updateFAirportStatus
	 * @Description: 修改订单状态
	 * @param order
	 * @return: void
	 */
	void updateFAirportStatus(FAirportOrders order);

	/**
	 * @Title: getAirportTourist
	 * @Description: 获取机票信息接口
	 * @param userId
	 * @return
	 * @return: List<FAirportTourist>
	 */
	List<FAirportTourist> getAirportTourist(String userId);

	/**
	 * @Title: saveOrUpdateTourist
	 * @Description: 保存或者修改旅客信息
	 * @param entity
	 * @return: void
	 */
	void saveOrUpdateTourist(FAirportTourist entity);

	/**
	 * @Title: deleteTourist
	 * @Description: 删除旅客信息
	 * @param touristId
	 * @return: void
	 */
	void deleteTourist(String touristId);

	/**
	 * @Title: queryTourist
	 * @Description: 查询旅客信息
	 * @param touristId
	 * @return: void
	 */
	FAirportTourist queryTourist(String touristId);

	/**
	 * @Title: getPassengerInfoByNameAndCardNo
	 * @Description: 通过订单id 和旅客姓名身份证号码匹配 乘客和订单关联表
	 * @param orderId
	 * @param name
	 * @param cardNum
	 * @return
	 * @return: FAirportTouristOrder
	 */
	FAirportTouristOrder getPassengerInfoByNameAndCardNo(String orderId,String name, String cardNum);

	/**
	 * @Title: updateAirportTouristOrder
	 * @Description: 修改乘客和订单关联表内容
	 * @param tOrder
	 * @return: void
	 */
	void updateAirportTouristOrder(FAirportTouristOrder tOrder);

}
