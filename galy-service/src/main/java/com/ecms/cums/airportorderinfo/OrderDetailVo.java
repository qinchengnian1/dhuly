package com.ecms.cums.airportorderinfo;

public class OrderDetailVo {

	private String orderNo;
	private String status;
	private String pnr;
	private String siblingOrderNo;
	private String siblingOrderStatus;
	private String orderSelfStatus;
	private String parentOrderStatus;
	private String parentOrderNo;
	private AirportCashBackVo cashBack;

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getSiblingOrderNo() {
		return siblingOrderNo;
	}
	public void setSiblingOrderNo(String siblingOrderNo) {
		this.siblingOrderNo = siblingOrderNo;
	}
	public String getSiblingOrderStatus() {
		return siblingOrderStatus;
	}
	public void setSiblingOrderStatus(String siblingOrderStatus) {
		this.siblingOrderStatus = siblingOrderStatus;
	}
	public String getOrderSelfStatus() {
		return orderSelfStatus;
	}
	public void setOrderSelfStatus(String orderSelfStatus) {
		this.orderSelfStatus = orderSelfStatus;
	}
	public String getParentOrderStatus() {
		return parentOrderStatus;
	}
	public void setParentOrderStatus(String parentOrderStatus) {
		this.parentOrderStatus = parentOrderStatus;
	}
	public String getParentOrderNo() {
		return parentOrderNo;
	}
	public void setParentOrderNo(String parentOrderNo) {
		this.parentOrderNo = parentOrderNo;
	}
	public AirportCashBackVo getCashBack() {
		return cashBack;
	}
	public void setCashBack(AirportCashBackVo cashBack) {
		this.cashBack = cashBack;
	}

}
