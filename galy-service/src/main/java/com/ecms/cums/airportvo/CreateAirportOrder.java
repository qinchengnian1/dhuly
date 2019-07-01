package com.ecms.cums.airportvo;

import java.util.List;

public class CreateAirportOrder {

	private String cid;
	private String tripType;
	private String sessionId;
	private RoutingVo routing;
	private List<PassengersVo> passengers;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public RoutingVo getRouting() {
		return routing;
	}
	public void setRouting(RoutingVo routing) {
		this.routing = routing;
	}
	public List<PassengersVo> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<PassengersVo> passengers) {
		this.passengers = passengers;
	}


}
