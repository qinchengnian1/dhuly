package com.ecms.cums.airportvo;

public class AirportPayBeforeVo {

	private String orderGroupIds;
	private String payPlatform;
	private PayValidateVo payValidateVo;

	public String getOrderGroupIds() {
		return orderGroupIds;
	}
	public void setOrderGroupIds(String orderGroupIds) {
		this.orderGroupIds = orderGroupIds;
	}
	public String getPayPlatform() {
		return payPlatform;
	}
	public void setPayPlatform(String payPlatform) {
		this.payPlatform = payPlatform;
	}
	public PayValidateVo getPayValidateVo() {
		return payValidateVo;
	}
	public void setPayValidateVo(PayValidateVo payValidateVo) {
		this.payValidateVo = payValidateVo;
	}


}
