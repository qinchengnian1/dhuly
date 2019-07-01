package com.ecms.cums.airportvo;

public class SearchAirportReqVo {

	private String cid; //渠道唯一标识
	private String tripType;  //行程类型 1：单程 2：往返
	private String fromCarrier;  //航司二字码
	private String retCarrier; //航司二字码
	private String fromCity; //出发地城市三字码
	private String toCity;  //目的地城市三字码
	private String fromDate; //出发日期
	private String retDate; //返回日期
	private Integer adultNumber; //成人人数
	private Integer childNumber; //儿童人数

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
	public String getFromCarrier() {
		return fromCarrier;
	}
	public void setFromCarrier(String fromCarrier) {
		this.fromCarrier = fromCarrier;
	}
	public String getRetCarrier() {
		return retCarrier;
	}
	public void setRetCarrier(String retCarrier) {
		this.retCarrier = retCarrier;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getRetDate() {
		return retDate;
	}
	public void setRetDate(String retDate) {
		this.retDate = retDate;
	}
	public Integer getAdultNumber() {
		return adultNumber;
	}
	public void setAdultNumber(Integer adultNumber) {
		this.adultNumber = adultNumber;
	}
	public Integer getChildNumber() {
		return childNumber;
	}
	public void setChildNumber(Integer childNumber) {
		this.childNumber = childNumber;
	}

}
