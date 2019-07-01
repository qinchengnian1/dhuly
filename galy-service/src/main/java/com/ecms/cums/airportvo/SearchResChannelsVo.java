package com.ecms.cums.airportvo;

import java.util.List;


public class SearchResChannelsVo {
	private String code;
	private List<SearchResCabinsVo> cabins;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<SearchResCabinsVo> getCabins() {
		return cabins;
	}
	public void setCabins(List<SearchResCabinsVo> cabins) {
		this.cabins = cabins;
	}



}
