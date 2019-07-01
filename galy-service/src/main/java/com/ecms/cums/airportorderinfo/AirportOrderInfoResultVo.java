package com.ecms.cums.airportorderinfo;

public class AirportOrderInfoResultVo {

	private Integer status;
	private String msg;
	private AirportOrderSultVo result;
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
	public AirportOrderSultVo getResult() {
		return result;
	}
	public void setResult(AirportOrderSultVo result) {
		this.result = result;
	}

}
