package com.ecms.cums.ordervo;

public class OrderVo {

	private String userId;

	private String productImgUrl;

	private String routeName;

	private String startPlace;

	private String startDate;

	private String jnyDays;

	private String glOrderId;

	private String orderStatus;

	private String orderStatusName;

	private String onlinePrice;

	private String routeId;

	private CreateOrderVo createOrderVo;


	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getJnyDays() {
		return jnyDays;
	}

	public void setJnyDays(String jnyDays) {
		this.jnyDays = jnyDays;
	}

	public String getGlOrderId() {
		return glOrderId;
	}

	public void setGlOrderId(String glOrderId) {
		this.glOrderId = glOrderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public String getOnlinePrice() {
		return onlinePrice;
	}

	public void setOnlinePrice(String onlinePrice) {
		this.onlinePrice = onlinePrice;
	}

	public CreateOrderVo getCreateOrderVo() {
		return createOrderVo;
	}

	public void setCreateOrderVo(CreateOrderVo createOrderVo) {
		this.createOrderVo = createOrderVo;
	}


}
