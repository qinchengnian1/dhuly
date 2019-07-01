package com.ecms.cums.airportvo;

import java.util.List;

public class SearchFirstResVo {

	private Integer status;
	private String msg;
	private List<SearchFlightFirstVo> result;

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
	public List<SearchFlightFirstVo> getResult() {
		return result;
	}
	public void setResult(List<SearchFlightFirstVo> result) {
		this.result = result;
	}

}
