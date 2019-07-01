package com.ecms.cums.airportvo;

import java.math.BigDecimal;
import java.util.List;

public class SearchResponseVo {

	private Integer status;
	private String msg;
	private List<SearchResRoutingsVo> routings;
	private BigDecimal lowRoutingsPrice;

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
	public List<SearchResRoutingsVo> getRoutings() {
		return routings;
	}
	public void setRoutings(List<SearchResRoutingsVo> routings) {
		this.routings = routings;
	}
	public BigDecimal getLowRoutingsPrice() {
		return lowRoutingsPrice;
	}
	public void setLowRoutingsPrice(BigDecimal lowRoutingsPrice) {
		this.lowRoutingsPrice = lowRoutingsPrice;
	}

}
