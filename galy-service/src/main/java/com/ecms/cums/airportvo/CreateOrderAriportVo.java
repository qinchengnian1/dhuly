package com.ecms.cums.airportvo;

import java.util.List;

public class CreateOrderAriportVo {

	private String cid;
	private String tripType;
	private SearchResRoutingsVo routing;
	private List<CreateOrderPassengersVo> passengers;
	private CreateOrderContantVo contact;
	private QunarExtVo qunarExt;

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
	public SearchResRoutingsVo getRouting() {
		return routing;
	}
	public void setRouting(SearchResRoutingsVo routing) {
		this.routing = routing;
	}
	public List<CreateOrderPassengersVo> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<CreateOrderPassengersVo> passengers) {
		this.passengers = passengers;
	}
	public CreateOrderContantVo getContact() {
		return contact;
	}
	public void setContact(CreateOrderContantVo contact) {
		this.contact = contact;
	}
	public QunarExtVo getQunarExt() {
		return qunarExt;
	}
	public void setQunarExt(QunarExtVo qunarExt) {
		this.qunarExt = qunarExt;
	}

}
