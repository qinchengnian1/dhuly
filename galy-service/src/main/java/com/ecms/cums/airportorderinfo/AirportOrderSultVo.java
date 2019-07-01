package com.ecms.cums.airportorderinfo;

import java.util.List;

public class AirportOrderSultVo {

	private String message;
	private OrderDetailVo detail;
	private AirportXcdVo xcd;
	private AirportOtherVo other;
	private AirportContacterInfoVo contacterInfo;
	private List<AirportPassengersVo> passengers;
	private List<AirportFlightInfoVo> flightInfo;
	private List<AirportPassengerTypes> passengerTypes;

	public AirportContacterInfoVo getContacterInfo() {
		return contacterInfo;
	}
	public void setContacterInfo(AirportContacterInfoVo contacterInfo) {
		this.contacterInfo = contacterInfo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public OrderDetailVo getDetail() {
		return detail;
	}
	public void setDetail(OrderDetailVo detail) {
		this.detail = detail;
	}
	public AirportXcdVo getXcd() {
		return xcd;
	}
	public void setXcd(AirportXcdVo xcd) {
		this.xcd = xcd;
	}
	public AirportOtherVo getOther() {
		return other;
	}
	public void setOther(AirportOtherVo other) {
		this.other = other;
	}
	public List<AirportPassengersVo> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<AirportPassengersVo> passengers) {
		this.passengers = passengers;
	}
	public List<AirportFlightInfoVo> getFlightInfo() {
		return flightInfo;
	}
	public void setFlightInfo(List<AirportFlightInfoVo> flightInfo) {
		this.flightInfo = flightInfo;
	}
	public List<AirportPassengerTypes> getPassengerTypes() {
		return passengerTypes;
	}
	public void setPassengerTypes(List<AirportPassengerTypes> passengerTypes) {
		this.passengerTypes = passengerTypes;
	}

}
