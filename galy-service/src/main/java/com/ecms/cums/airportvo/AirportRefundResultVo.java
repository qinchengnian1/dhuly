package com.ecms.cums.airportvo;

import java.util.List;

public class AirportRefundResultVo {

	private Integer status;
	private String msg;
	private Long createTime;
	private List<AirportPassengerVo> result;

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
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public List<AirportPassengerVo> getResult() {
		return result;
	}
	public void setResult(List<AirportPassengerVo> result) {
		this.result = result;
	}

}
