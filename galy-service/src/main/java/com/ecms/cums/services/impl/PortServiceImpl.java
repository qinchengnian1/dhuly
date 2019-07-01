package com.ecms.cums.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.cores.Constants;
import com.ecms.cums.dao.CityCompMapper;
import com.ecms.cums.dao.EShopMapper;
import com.ecms.cums.dao.OrderInfoMapper;
import com.ecms.cums.dao.OrderLogMapper;
import com.ecms.cums.dao.OrderTouristMapper;
import com.ecms.cums.dao.ProductInfoMapper;
import com.ecms.cums.dao.ProductMapper;
import com.ecms.cums.dao.TouristMapper;
import com.ecms.cums.dao.TreamDetailMapper;
import com.ecms.cums.model.CityComp;
import com.ecms.cums.model.CityCompCriteria;
import com.ecms.cums.model.EShop;
import com.ecms.cums.model.EShopCriteria;
import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.model.OrderInfoCriteria;
import com.ecms.cums.model.OrderLogWithBLOBs;
import com.ecms.cums.model.OrderTourist;
import com.ecms.cums.model.OrderTouristCriteria;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.Tourist;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.ordervo.CreateOrderVo;
import com.ecms.cums.ordervo.CreatePTOrderInfoVo;
import com.ecms.cums.ordervo.Message;
import com.ecms.cums.ordervo.TouristsVo;
import com.ecms.cums.ordervo.local.CreateOrderVoLocal;
import com.ecms.cums.services.PortService;

@Service
public class PortServiceImpl implements PortService{

	private static final Logger logger = LoggerFactory.getLogger(PortServiceImpl.class);

	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Autowired
	private TouristMapper touristMapper;

	@Autowired
	private OrderTouristMapper orderTouristMapper;

	@Autowired
	private OrderLogMapper orderLogMapper;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private ProductInfoMapper productInfoMapper;

	@Autowired
	private EShopMapper eShopMapper;

	@Autowired
	private CityCompMapper cityCompMapper;

	@Autowired
	private TreamDetailMapper treamDetailMapper;

	@Override
	public Message CheckOrderIsBlack(CreateOrderVoLocal order) {
		// TODO Auto-generated method stub
		Message ms = new Message();
		ms.getHeader().put("resCode", "0");
		if(StringUtils.isBlank(order.getUserId())){
			ms.getHeader().put("resMsg", "用户id不能为空");
			return ms;
		}

		if(StringUtils.isBlank(order.getContactName())){
			ms.getHeader().put("resMsg", "紧急联系人姓名不能为空");
			return ms;
		}
		if(StringUtils.isBlank(order.getContactTel())){
			ms.getHeader().put("resMsg", "紧急联系人电话不能为空");
			return ms;
		}
		if(StringUtils.isBlank(order.getProductUrl())){
			ms.getHeader().put("resMsg", "产品链接不能为空");
			return ms;
		}

		if(null==order.getTourists()){
			ms.getHeader().put("resMsg", "游客信息不能为空");
			return ms;
		}
		ms.getHeader().put("resCode", "1");
		ms.getHeader().put("resMsg", "请求成功");
		return ms;
	}


	@Override
	public Integer saveOrderInfoByParams(OrderInfo order,CreateOrderVoLocal cOrder) {

		CityCompCriteria city = new CityCompCriteria();
		CityCompCriteria.Criteria c = city.createCriteria();
		c.andRemarkEqualTo(cOrder.getCityId());
		List<CityComp> listc = cityCompMapper.selectByExample(city);
		Integer cityId = 1;
		if(null!=listc){
			cityId = listc.get(0).getCityId();
		}
		order.setCityId(cityId);
		if(!StringUtils.isBlank(cOrder.getProductId())){
			order.setProductId(Integer.parseInt(cOrder.getProductId()));
		}
		order.setUserId(Integer.parseInt(cOrder.getUserId()));
		order.setStoreId(cOrder.getStoreId());
		order.setOrderNoLocal("");//本地订单编号
		order.setPerName(cOrder.getContactName());
		order.setPerEmail(cOrder.getContactEmail());
		order.setPerTel(cOrder.getContactTel());
		order.setRemark(cOrder.getContactNotes());
		order.setProductImgUrl(cOrder.getProductImgUrl());
		order.setRouteName(cOrder.getRouteName());
		order.setStartPlace(cOrder.getStartPlace());
		order.setStartDate(cOrder.getStartDate());
		order.setJnyDays(cOrder.getJnyDays());
		if (order.getStateLocal() == null || "0".equals(order.getStateLocal())){
			order.setStateLocal("0");//待支付
		} else {
			order.setStateLocal("1");
		}
		order.setOnlinePrice(cOrder.getOnlinePrice());
		order.setProductUrl(cOrder.getProductUrl());
		order.setIfLocal(cOrder.getIfLocal());
		order.setTeamId(cOrder.getTeamId());
		order.setRouteId(cOrder.getRouteId());
		order.setOnlinePrice(cOrder.getOnlinePrice());
		order.setGlOrderType(cOrder.getGlOrderType());
		order.setCreateTime(new Date());
		order.setEmployeeId(cOrder.getEmployeeId());
		order.setDeliveryType("self".equals(cOrder.getDeliveryType())?"0":"1");
		List<TouristsVo> list = cOrder.getTourists();
		order.setSystemFlag(String.valueOf(list.size()));
	    orderInfoMapper.insert(order);
		for(TouristsVo vo:list){
			OrderTourist os = new OrderTourist();
			os.setOrderId(order.getOrderId());
			os.setTouristId(Integer.parseInt(vo.getTouristId()));
			os.setPriceid(vo.getPriceId());
			os.setPrice(vo.getPrice());
			os.setCreateTime(new Date());
			orderTouristMapper.insert(os);
		}
		return order.getOrderId();
	}

	@Override
	public CreateOrderVo getGuoLvJsonByParams(CreateOrderVoLocal order) {
		// TODO Auto-generated method stub
		CreateOrderVo cOrder = new CreateOrderVo();
		cOrder.setChannelSource(Constants.channelsource);  //渠道
		cOrder.setContactEmail(order.getContactEmail());
		cOrder.setContactName(order.getContactName());
		cOrder.setContactTel(order.getContactTel());
		cOrder.setProductUrl(order.getProductUrl());
		cOrder.setServerName(Constants.server_name);       //服务器域名
		cOrder.setTeamId(order.getTeamId());
		cOrder.setUserAccount(Constants.guolv_username);   //api账户
		List<TouristsVo> list = order.getTourists();
		for(TouristsVo vo:list){
			//通过旅客id查询旅客信息
			Tourist t = touristMapper.selectByPrimaryKey(Integer.parseInt(vo.getTouristId()));
			if(null==t){
				logger.info("旅客信息为空");
			}
			vo.setTouristName(t.getTouristName());
			vo.setTouristNamePY(t.getTouristNamePy());
			vo.setTouristSex(t.getSex());
			vo.setTouristNationId(t.getTouristNationId());
			vo.setTouristCredType(t.getCardType());
			vo.setTouristCredId(t.getCardNo());
			vo.setTouristMobile(t.getTelephone());
			vo.setTouristRegPlace(t.getRouristRegPlace());
			vo.setTouristBirthDate(t.getRouristBirthday());
			vo.setPasgType(t.getPasgType());
		}
		cOrder.setTourists(list);
		return cOrder;
	}

	@Override
	public CreatePTOrderInfoVo createPTOrderInfoVo(CreateOrderVoLocal order) {
		CreatePTOrderInfoVo vo = new CreatePTOrderInfoVo();
		if("1".equals(order.getIfLocal())){
			//根据产品id查询产品信息
			Product product = productMapper.selectByPrimaryKey(Integer.parseInt(order.getProductId()));
			//根据城市编码获取城市id
			CityCompCriteria cityCrieria = new CityCompCriteria();
			CityCompCriteria.Criteria cityC = cityCrieria.createCriteria();
			cityC.andRemarkEqualTo(order.getCityId());
			List<CityComp> cityList = cityCompMapper.selectByExample(cityCrieria);
			//根据供应商id 和城市id 查询E店信息
			EShopCriteria criteria = new EShopCriteria();
			EShopCriteria.Criteria c = criteria.createCriteria();
			c.andCityIdEqualTo(cityList.get(0).getCityId());
			c.andCompIdEqualTo(product.getCompId());
			List<EShop> list = eShopMapper.selectByExample(criteria);
			vo.setEshopCode(list.get(0).geteKey());
			vo.setProductCode(product.getPtNo());
		}else{
			vo.setEshopCode(Constants.guolv_e_shop);
			vo.setProductCode(order.getRouteId());
		}

		vo.setStoreId(order.getStoreId());
		vo.setUnitPrice(order.getOnlinePrice());
		vo.setQuantity("1");
		vo.setStoreName(order.getStoreName());
		vo.setStoreType(order.getStoreType());
		vo.setDeliveryType(order.getDeliveryType()); /*self：自提，delivery：配送*/
		if("delivery".equals(order.getDeliveryType())){
			vo.setEmployeeId(order.getEmployeeId());
		}
		vo.setBuyerRemark(order.getContactNotes());
		return vo;
	}

	@Override
	public OrderInfo selectOrderInfoByPrimaryKey(String orderId) {
		// TODO Auto-generated method stub
		return orderInfoMapper.selectByPrimaryKey(Integer.parseInt(orderId));
	}

	@Override
	public List<OrderInfo> checkOrderStatusByuserId(String userId,
			String orderStatus) {
		// TODO Auto-generated method stub
		OrderInfoCriteria criteria = new OrderInfoCriteria();
		OrderInfoCriteria.Criteria c = criteria.createCriteria();
		c.andUserIdEqualTo(Integer.parseInt(userId));

		if(!"2".equals(orderStatus)){
			List<String> params = new ArrayList<String>();
			if("0".equals(orderStatus)){
				params.add("0");//待支付
				params.add("1");//支付中
			}
			if("1".equals(orderStatus)){
				params.add("3");//已完成
			}
			c.andStateLocalIn(params);
		}
		criteria.setOrderByClause("create_time DESC");
		return orderInfoMapper.selectByExample(criteria);
	}

	@Override
	public void updateOrderInfo(OrderInfo oInfo) {
		// TODO Auto-generated method stub
		orderInfoMapper.updateByPrimaryKey(oInfo);
	}

	@Override
	public List<Tourist> selectOrderTouristInfoByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		OrderTouristCriteria criteria = new OrderTouristCriteria();
		OrderTouristCriteria.Criteria c = criteria.createCriteria();
		c.andOrderIdEqualTo(orderId);
		List<OrderTourist> list = orderTouristMapper.selectByExample(criteria);
		List<Tourist> tourist = new ArrayList<Tourist>();
		for(OrderTourist o :list){
			Tourist sr = touristMapper.selectByPrimaryKey(o.getTouristId());
			tourist.add(sr);
		}
		return tourist;
	}

	@Override
	public void insertOrderLogByParams(Integer orderId, String type,
			String reqJson, String resasonText) {
		// TODO Auto-generated method stub
		OrderLogWithBLOBs orderLog = new OrderLogWithBLOBs();
		orderLog.setOrderId(orderId);
		orderLog.setLogType(type);
		orderLog.setReasonText(resasonText);
		orderLog.setReqJson(reqJson);
		orderLog.setCreateTime(new Date());
		orderLogMapper.insert(orderLog);
	}

	@Override
	public List<Tourist> getTouristInfoByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		return touristMapper.getTouristInfoByOrderId(orderId);
	}

	@Override
	public String selectEshopCodeByPrimaryIdAndCityId(Integer productId,
			Integer cityId) {
		//根据产品id查询产品信息
		Product product = productMapper.selectByPrimaryKey(productId);
		//根据供应商id 和城市id 查询E店信息
		EShopCriteria criteria = new EShopCriteria();
		EShopCriteria.Criteria c = criteria.createCriteria();
		c.andCityIdEqualTo(cityId);
		c.andCompIdEqualTo(product.getCompId());
		List<EShop> list = eShopMapper.selectByExample(criteria);
		if(null!=list){
			return list.get(0).getRemark();
		}
		return null;
	}

	@Override
	public List<OrderInfo> getorderList(String statelocal) {
		OrderInfoCriteria criteria = new OrderInfoCriteria();
		OrderInfoCriteria.Criteria c = criteria.createCriteria();
		c.andStateLocalEqualTo(statelocal);
		return orderInfoMapper.selectByExample(criteria);
	}

	@Override
	public int delectOrderTouristByOrderId(Integer orderId) {
		OrderTouristCriteria criteria = new OrderTouristCriteria();
		OrderTouristCriteria.Criteria c= criteria.createCriteria();
		c.andOrderIdEqualTo(orderId);
		return orderTouristMapper.deleteByExample(criteria);
	}

	@Override
	public int delectorderInfoByOrderId(Integer orderId) {
		return orderInfoMapper.deleteByPrimaryKey(orderId);
	}
	@Override
	public List<OrderInfo> getorderAllList() {
		OrderInfoCriteria criteria = new OrderInfoCriteria();
		//OrderInfoCriteria.Criteria c = criteria.createCriteria();
		return orderInfoMapper.selectByExample(criteria);
	}
	@Override
	public void updateOrderTourist() {
		orderInfoMapper.updateOrderInfoStatusByTime();
	}


	@Override
	public Product selectProductByPrimarykey(Integer productId) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(productId);
	}


	@Override
	public EShop selectEshopByPrimarykey(Integer compId) {
		// TODO Auto-generated method stub
		return eShopMapper.selectByPrimaryKey(compId);
	}


	@Override
	public List<OrderInfo> checkOrderInfoByUserId(String userId) {
		// TODO Auto-generated method stub
		return orderInfoMapper.checkOrderInfoByUserId(Integer.parseInt(userId));
	}


	@Override
	public void updateTreamDetailLeftNumByPrimaryId(Integer tId, Integer num) {
		// TODO Auto-generated method stub
		TreamDetail treamDetail = treamDetailMapper.selectByPrimaryKey(tId);
		if(null!=treamDetail && !StringUtils.isBlank(treamDetail.getLeftNum())){
			Integer sum = Integer.parseInt(treamDetail.getLeftNum())-num;
			if(sum > 0){
				treamDetail.setLeftNum(sum.toString());
				treamDetailMapper.updateByPrimaryKey(treamDetail);
			}else{
				treamDetailMapper.deleteByPrimaryKey(tId);
			}
		}

	}


	@Override
	public TreamDetail SelectTreamDetailByPrimaryId(Integer tId) {
		// TODO Auto-generated method stub
		return treamDetailMapper.selectByPrimaryKey(tId);
	}


}
