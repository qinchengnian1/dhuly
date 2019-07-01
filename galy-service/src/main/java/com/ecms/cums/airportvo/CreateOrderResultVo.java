package com.ecms.cums.airportvo;

import java.math.BigDecimal;

public class CreateOrderResultVo {

	private Integer status;
	private String msg;
	private String orderId;
	private String orderNo;
	private String pnr;
	private BigDecimal adultPrice;
	private BigDecimal adultTax;
	private BigDecimal childPrice;
	private BigDecimal childTax;
	private BigDecimal orderPrice;

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public BigDecimal getAdultPrice() {
		return adultPrice;
	}
	public void setAdultPrice(BigDecimal adultPrice) {
		this.adultPrice = adultPrice;
	}
	public BigDecimal getAdultTax() {
		return adultTax;
	}
	public void setAdultTax(BigDecimal adultTax) {
		this.adultTax = adultTax;
	}
	public BigDecimal getChildPrice() {
		return childPrice;
	}
	public void setChildPrice(BigDecimal childPrice) {
		this.childPrice = childPrice;
	}
	public BigDecimal getChildTax() {
		return childTax;
	}
	public void setChildTax(BigDecimal childTax) {
		this.childTax = childTax;
	}
	public BigDecimal getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

}
