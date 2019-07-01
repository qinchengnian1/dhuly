package com.ecms.cums.airportvo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResRoutingsVo {

	private String data;
	private List<SearchResGoFlightInfos> goFlightInfos;
	@JsonProperty("channels")
	private SearchResChannelsVo channels;


	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<SearchResGoFlightInfos> getGoFlightInfos() {
		return goFlightInfos;
	}
	public void setGoFlightInfos(List<SearchResGoFlightInfos> goFlightInfos) {
		this.goFlightInfos = goFlightInfos;
	}
	public SearchResChannelsVo getChannels() {
		return channels;
	}
	public void setChannels(SearchResChannelsVo channels) {
		this.channels = channels;
	}

}
