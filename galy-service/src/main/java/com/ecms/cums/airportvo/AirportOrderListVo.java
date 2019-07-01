package com.ecms.cums.airportvo;

import java.util.Date;

public class AirportOrderListVo {

	private String fromToCity;
	private String airportName;
	private String aircraftName;
	private Date createTime;
	private String totalPrice;
	private String couponPrice;
	private String orderNo;
	private String ldyOrderNo;
	private String id;
	private String status;
	private String orderId;
	private String clientSite;
	private String statusName;
	private String orderGroupIds;


	public String getLdyOrderNo() {
		return ldyOrderNo;
	}
	public void setLdyOrderNo(String ldyOrderNo) {
		this.ldyOrderNo = ldyOrderNo;
	}
	public String getOrderGroupIds() {
		return orderGroupIds;
	}
	public void setOrderGroupIds(String orderGroupIds) {
		this.orderGroupIds = orderGroupIds;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClientSite() {
		return clientSite;
	}
	public void setClientSite(String clientSite) {
		this.clientSite = clientSite;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getFromToCity() {
		return fromToCity;
	}
	public void setFromToCity(String fromToCity) {
		this.fromToCity = fromToCity;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAircraftName() {
		return aircraftName;
	}
	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(String couponPrice) {
		this.couponPrice = couponPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
