package com.ecms.cums.services.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.airportvo.AirportOrderListVo;
import com.ecms.cums.airportvo.AriportOrderVo;
import com.ecms.cums.airportvo.CreateOrderAriportVo;
import com.ecms.cums.airportvo.CreateOrderContantVo;
import com.ecms.cums.airportvo.CreateOrderPassengersVo;
import com.ecms.cums.airportvo.CreateOrderResultVo;
import com.ecms.cums.airportvo.FAirportCouponVo;
import com.ecms.cums.airportvo.SearchResGoFlightInfos;
import com.ecms.cums.airportvo.SearchResRoutingsVo;
import com.ecms.cums.dao.FAirportCityMapper;
import com.ecms.cums.dao.FAirportOrderInfoMapper;
import com.ecms.cums.dao.FAirportOrdersMapper;
import com.ecms.cums.dao.FAirportTouristMapper;
import com.ecms.cums.dao.FAirportTouristOrderMapper;
import com.ecms.cums.dao.fAirportCouponMapper;
import com.ecms.cums.model.FAirportCity;
import com.ecms.cums.model.FAirportOrderInfo;
import com.ecms.cums.model.FAirportOrders;
import com.ecms.cums.model.FAirportOrdersCriteria;
import com.ecms.cums.model.FAirportTourist;
import com.ecms.cums.model.FAirportTouristCriteria;
import com.ecms.cums.model.FAirportTouristOrder;
import com.ecms.cums.model.FAirportTouristOrderCriteria;
import com.ecms.cums.model.fAirportCoupon;
import com.ecms.cums.services.FAriportService;

@Service
public class FAriportServiceImpl implements FAriportService{

	@Autowired
	private FAirportCityMapper fAirportCityMapper;
	@Autowired
	private FAirportOrderInfoMapper FAirportOrdersInfoMapper;
	@Autowired
	private FAirportOrdersMapper FAirportOrdersMapper;
	@Autowired
	private FAirportTouristMapper fAirportTouristMapper;
	@Autowired
	private fAirportCouponMapper fAirportCouponMapper;
	@Autowired
	private FAirportTouristOrderMapper fAirportTouristOrderMapper;


	@Override
	public List<FAirportCity> queryCityListByStatus(String status) {
		// TODO Auto-generated method stub
		return fAirportCityMapper.queryCityListByStatus(status);
	}


	@Override
	public List<FAirportCity> queryHotCityListByStatus(String status) {
		// TODO Auto-generated method stub
		return fAirportCityMapper.queryHotCityListByStatus(status);
	}


	@Override
	public void saveOrderInfo(AriportOrderVo order,
		CreateOrderResultVo resp, String walletPayDiscountAmount,String orderGroupId,String orderSns,String fenrun) {
		//保存优惠卷信息
//		FAirportCouponVo couponVo = order.getfAirportCouponVo();
//		String couponId = "";
//		if(null!=couponVo && !StringUtils.isBlank(couponVo.getfAmount())){
//			fAirportCoupon coupon = new fAirportCoupon();
//			coupon.setfCardCouponId(couponVo.getfCardCouponId());
//			coupon.setfCouponName(couponVo.getfCouponName());
//			coupon.setfExpirationDate(couponVo.getfExpirationDate());
//			coupon.setfStartDate(couponVo.getfStartDate());
//			coupon.setfAmount(couponVo.getfAmount());
//			coupon.setCreateDate(new Date());
//			fAirportCouponMapper.insert(coupon);
//			couponId = coupon.getfCardId().toString();
//		}
		//保存订单信息
		FAirportOrders fOrder = new FAirportOrders();
		fOrder.setfCityNo(order.getCityNo());
		fOrder.setfUserId(Integer.parseInt(order.getUserId()));
//		fOrder.setfOrderNoPt(orderSns);
//		fOrder.setfOrderGroupId(orderGroupId);
		fOrder.setTotalPrice(resp.getOrderPrice().toString());
//		fOrder.setCouponPrice(walletPayDiscountAmount);
//		fOrder.setCardCouponId(couponId);
		fOrder.setLdyOrderNo(resp.getOrderNo());
		fOrder.setLdyPnr(resp.getPnr());
		fOrder.setLdyOrderId(resp.getOrderId());
		fOrder.setStatus("0");
		fOrder.setStatusName("待支付");
		fOrder.setCreateTime(new Date());
		fOrder.setFenrunTotalPrice(fenrun);
   		fOrder.setRemark(order.getClientSite());//来单云代理商域名

		//保存订单详情信息
		CreateOrderAriportVo ariport = order.getCreateOrderAriportVo(); //机票
		CreateOrderContantVo contant = ariport.getContact(); //联系人
		SearchResRoutingsVo routing = ariport.getRouting();//航线
		List<SearchResGoFlightInfos> goFlightInfos = routing.getGoFlightInfos();//航班
		List<CreateOrderPassengersVo> passengerList = ariport.getPassengers();//保存乘机人信息

		FAirportOrderInfo orderInfo = new FAirportOrderInfo();

		if(null!=contant){
			orderInfo.setfPerName(contant.getName());
			orderInfo.setfPerTel(contant.getMobile());
		}
		String fromToCity = order.getFromCity()+",";
		if(!StringUtils.isBlank(goFlightInfos.get(0).getStopCityName())){
			fromToCity += goFlightInfos.get(0).getStopCityName()+",";
		}
		fromToCity += order.getToCity();
		orderInfo.setFromToCity(fromToCity);//经过城市
		orderInfo.setFromToTime(goFlightInfos.get(0).getDepTime()+","+goFlightInfos.get(0).getArrTime());
		orderInfo.setAirportTime(goFlightInfos.get(0).getDuration());
		orderInfo.setfStoreId(order.getStoreId());
		orderInfo.setStoreName(order.getStoreName());
		orderInfo.setStoreType(order.getStoreType());
		orderInfo.setCouponId("");
		orderInfo.setProductCode(order.getProductCode());
		orderInfo.setAirportName(order.getAirportName());
		orderInfo.setAircraftName(order.getAircraftName());

		orderInfo.setAdultPrice((null==resp.getAdultPrice())?"":resp.getAdultPrice().toString());
		orderInfo.setAdultTax((null==resp.getAdultTax())?"":resp.getAdultPrice().toString());
		orderInfo.setChildPrice((null==resp.getAdultTax())?"":resp.getChildPrice().toString());
		orderInfo.setChildTax((null==resp.getAdultTax())?"":resp.getChildTax().toString());
		orderInfo.setCreateTime(new Date());

		FAirportOrdersMapper.insert(fOrder);
		orderInfo.setfOrderId(fOrder.getfOrderId());
		FAirportOrdersInfoMapper.insert(orderInfo);
		//保存旅客信息
		for(CreateOrderPassengersVo passenger:passengerList){
			FAirportTouristOrder tOrder = new FAirportTouristOrder();
			tOrder.setfOrderId(fOrder.getfOrderId());
			tOrder.setfTouristId(Integer.parseInt(passenger.getTouristId()));
			tOrder.setfTouristName(passenger.getName());
			tOrder.setCardNum(passenger.getCardNum());
			tOrder.setCreateTime(new Date());
			fAirportTouristOrderMapper.insert(tOrder);
		}
	}


	@Override
	public FAirportOrders getOrderByOrderGroupid(String orderGroupIds) {
		// TODO Auto-generated method stub
		FAirportOrdersCriteria criteria = new FAirportOrdersCriteria();
		FAirportOrdersCriteria.Criteria c = criteria.createCriteria();
		c.andFOrderGroupIdEqualTo(orderGroupIds);
		List<FAirportOrders> list = FAirportOrdersMapper.selectByExample(criteria);
		if(null!=list && list.size()>0){
			return list.get(0);
		}
		return null;
	}


	@Override
	public void saveAirportOrderEntiy(FAirportOrders order) {
		// TODO Auto-generated method stub
		FAirportOrdersMapper.insert(order);
	}


	@Override
	public List<AirportOrderListVo> getAriportOrderList(String userId){
		// TODO Auto-generated method stub
		return FAirportOrdersMapper.getAriportOrderList(Integer.parseInt(userId));
	}


	@Override
	public FAirportOrders queryFAirportOrderByPrimaryKey(String orderId) {
		return FAirportOrdersMapper.selectByPrimaryKey(Integer.parseInt(orderId));
	}


	@Override
	public void updateFAirportStatus(FAirportOrders order) {
		// TODO Auto-generated method stub
		FAirportOrdersMapper.updateByPrimaryKeySelective(order);
	}


	@Override
	public List<FAirportTourist> getAirportTourist(String userId) {
		// TODO Auto-generated method stub
		FAirportTouristCriteria tourist = new FAirportTouristCriteria();
		FAirportTouristCriteria.Criteria c = tourist.createCriteria();
		c.andUserIdEqualTo(Integer.parseInt(userId));
		return fAirportTouristMapper.selectByExample(tourist);
	}


	@Override
	public void saveOrUpdateTourist(FAirportTourist entity) {
		// TODO Auto-generated method stub
		if(null!= entity.getfTouristId()){
			fAirportTouristMapper.updateByPrimaryKey(entity);
		}else{
			fAirportTouristMapper.insert(entity);
		}
	}


	@Override
	public void deleteTourist(String touristId) {
		// TODO Auto-generated method stub
		fAirportTouristMapper.deleteByPrimaryKey(Integer.parseInt(touristId));
	}


	@Override
	public FAirportTourist queryTourist(String touristId) {
		// TODO Auto-generated method stub
		return fAirportTouristMapper.selectByPrimaryKey(Integer.parseInt(touristId));
	}


	@Override
	public FAirportTouristOrder getPassengerInfoByNameAndCardNo(String orderId,String name, String cardNum) {
		// TODO Auto-generated method stub
		FAirportTouristOrderCriteria criteria = new FAirportTouristOrderCriteria();
		FAirportTouristOrderCriteria.Criteria c = criteria.createCriteria();
		c.andCardNumEqualTo(cardNum);
		c.andFTouristNameEqualTo(name);
		c.andFOrderIdEqualTo(Integer.parseInt(orderId));
		List<FAirportTouristOrder> list = fAirportTouristOrderMapper.selectByExample(criteria);
		if(null!=list && list.size()>0){
			return list.get(0);
		}
		return null;
	}


	@Override
	public void updateAirportTouristOrder(FAirportTouristOrder tOrder) {
		// TODO Auto-generated method stub
		fAirportTouristOrderMapper.updateByPrimaryKey(tOrder);
	}

}
