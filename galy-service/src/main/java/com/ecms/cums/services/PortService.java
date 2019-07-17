package com.ecms.cums.services;

import java.util.List;

import com.ecms.cums.core.util.StringUtil;
import com.ecms.cums.model.EShop;
import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.Tourist;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.ordervo.CreateOrderVo;
import com.ecms.cums.ordervo.CreatePTOrderInfoVo;
import com.ecms.cums.ordervo.Message;
import com.ecms.cums.ordervo.local.CreateOrderVoLocal;


public interface PortService {

	/**
	 * @Title: CheckOrderIsBlack
	 * @Description: 验证前台接受信息参数是否必传
	 * @param cOrder
	 * @return
	 * @return: Boolean
	 */
	Message CheckOrderIsBlack(CreateOrderVoLocal cOrder);

	/**
	 * @Title: saveOrderInfoByParams
	 * @Description: 保存订单信息到本地
	 * @param
	 * @return
	 * @return: Integer
	 */
	Integer saveOrderInfoByParams(OrderInfo orderInfo,CreateOrderVoLocal cOrder);

	/**
	 * @Title: getGuoLvJsonByParams
	 * @Description: 拼装组成国旅订单接口json参数
	 * @param cOrder
	 * @return
	 * @return: String
	 */
	CreateOrderVo getGuoLvJsonByParams(CreateOrderVoLocal cOrder);

	/**
	 * @Title: createPTOrderInfoVo
	 * @Description:  拼装组成请求平台接口参数
	 * @param pOrder
	 * @return
	 * @return: CreatePTOrderInfoVo
	 */
	CreatePTOrderInfoVo createPTOrderInfoVo(CreateOrderVoLocal pOrder);

	/**
	 * @Title: checkOrderInfo
	 * @Description: 根据订单id查询订单信息
	 * @param orderId
	 * @return
	 * @return: OrderInfo
	 */
	OrderInfo selectOrderInfoByPrimaryKey(String orderId);

	/**
	 * @Title: checkOrderStatus
	 * @Description: 根据用户id,订单列表状态,查询订单列表
	 * @param userId
	 * @return
	 * @return: List<OrderInfo>
	 */
	List<OrderInfo> checkOrderStatusByuserId(String userId, String orderStatus);

	void updateOrderInfo(OrderInfo oInfo);

	List<Tourist> selectOrderTouristInfoByOrderId(Integer orderId);

	/**
	 * @Title: insertOrderLogByParams
	 * @Description: 订单失败日志
	 * @param orderId
	 * @param type
	 * @param reqJson
	 * @param resasonText
	 * @return: void
	 */
	void insertOrderLogByParams(Integer orderId, String type, String reqJson,String resasonText);
	/**
	 * @Title: getTouristInfoByOrderId
	 * @Description: 根据订单id查询旅客信息
	 * @param orderId
	 * @return
	 * @return: List<Tourist>
	 */
	List<Tourist> getTouristInfoByOrderId(Integer orderId);

	/**
	 * @Title: selectEshopCodeByPrimaryIdAndCityId
	 * @Description: 根据产品id和城市id查询E店编码
	 * @return
	 * @return: String
	 */
	String selectEshopCodeByPrimaryIdAndCityId(Integer productId, Integer eShopCode);
	/**
	 * 查询statelocal为4（已取消订单）的订单信息列表
	 * @param statelocal
	 * @return
	 */
	List<OrderInfo> getorderList(String statelocal);

	/**
	 * 删除OrderTourist表中关联的信息
	 * @return
	 */
	int delectOrderTouristByOrderId(Integer orderId);
	/**
	 * 删除OrderTourist表中关联的信息
	 * @return
	 */
	int delectorderInfoByOrderId(Integer orderId);
	/**
	 * 查询所有的订单信息列表
	 * @return
	 */
	List<OrderInfo> getorderAllList();

	void updateOrderTourist();

	Product selectProductByPrimarykey(Integer productId);

	EShop selectEshopByPrimarykey(Integer compId);

	List<OrderInfo> checkOrderInfoByUserId(String userId);

	void updateTreamDetailLeftNumByPrimaryId(Integer tId, Integer num);

	TreamDetail SelectTreamDetailByPrimaryId(Integer parseInt);

	/**
	 * 根据订单号查询
	 */
	OrderInfo getOrderInfoByOrderNo(String orderNo);
}
