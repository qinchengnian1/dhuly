package com.ecms.cums.airportvo;

import java.util.List;

public class RoutingVo {

	private List<FromSegmentsVo> fromSegments;
	private List<RetSegmentsVo> retSegments;

	public List<FromSegmentsVo> getFromSegments() {
		return fromSegments;
	}
	public void setFromSegments(List<FromSegmentsVo> fromSegments) {
		this.fromSegments = fromSegments;
	}
	public List<RetSegmentsVo> getRetSegments() {
		return retSegments;
	}
	public void setRetSegments(List<RetSegmentsVo> retSegments) {
		this.retSegments = retSegments;
	}



}
