package com.ecms.cums.airportvo;

import java.math.BigDecimal;

public class SearchResGoFlightInfos {
	//航司二字码
	private String carrier;
	//航班号码
	private String flightNumber;
	//出发城市代码
	private String depCityport;
	//出发机场三字码
	private String depAirport;
	//出发航站楼
	private String depTerminal;
	//起飞日期时间
	private String depTime;
	//到达城市代码
	private String arrCityport;
	//到达机场三字码
	private String arrAirport;
	//抵达航站楼
	private String arrTerminal;
	//起飞日期
	private String arrTime;
	//代码共享标识
	private Boolean codeShare;
	//实际承运航司
	private String operatingCarrier;
	//实际承运航班号
	private String operatingFlightNo;
	//机型
	private String aircraftCode;
	//飞行时长
	private String duration;
	//机建
	private BigDecimal airportTax;
	//燃油
	private BigDecimal fuelTax;
	//是否经停
	private Boolean pass;
	//经停城市三字码
	private String stopCityCode;
	//经停城市名
	private String stopCityName;
	//经停机场三字码
	private String stopAirportCode;
	//经停机场名
	private String stopAirportName;
	//经停机场全名
	private String stopAirportFullName;

	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepCityport() {
		return depCityport;
	}
	public void setDepCityport(String depCityport) {
		this.depCityport = depCityport;
	}
	public String getDepAirport() {
		return depAirport;
	}
	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}
	public String getDepTerminal() {
		return depTerminal;
	}
	public void setDepTerminal(String depTerminal) {
		this.depTerminal = depTerminal;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getArrCityport() {
		return arrCityport;
	}
	public void setArrCityport(String arrCityport) {
		this.arrCityport = arrCityport;
	}
	public String getArrAirport() {
		return arrAirport;
	}
	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}
	public String getArrTerminal() {
		return arrTerminal;
	}
	public void setArrTerminal(String arrTerminal) {
		this.arrTerminal = arrTerminal;
	}
	public String getArrTime() {
		return arrTime;
	}
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	public Boolean getCodeShare() {
		return codeShare;
	}
	public void setCodeShare(Boolean codeShare) {
		this.codeShare = codeShare;
	}
	public String getOperatingCarrier() {
		return operatingCarrier;
	}
	public void setOperatingCarrier(String operatingCarrier) {
		this.operatingCarrier = operatingCarrier;
	}
	public String getOperatingFlightNo() {
		return operatingFlightNo;
	}
	public void setOperatingFlightNo(String operatingFlightNo) {
		this.operatingFlightNo = operatingFlightNo;
	}
	public String getAircraftCode() {
		return aircraftCode;
	}
	public void setAircraftCode(String aircraftCode) {
		this.aircraftCode = aircraftCode;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public BigDecimal getAirportTax() {
		return airportTax;
	}
	public void setAirportTax(BigDecimal airportTax) {
		this.airportTax = airportTax;
	}
	public BigDecimal getFuelTax() {
		return fuelTax;
	}
	public void setFuelTax(BigDecimal fuelTax) {
		this.fuelTax = fuelTax;
	}
	public Boolean getPass() {
		return pass;
	}
	public void setPass(Boolean pass) {
		this.pass = pass;
	}
	public String getStopCityCode() {
		return stopCityCode;
	}
	public void setStopCityCode(String stopCityCode) {
		this.stopCityCode = stopCityCode;
	}
	public String getStopCityName() {
		return stopCityName;
	}
	public void setStopCityName(String stopCityName) {
		this.stopCityName = stopCityName;
	}
	public String getStopAirportCode() {
		return stopAirportCode;
	}
	public void setStopAirportCode(String stopAirportCode) {
		this.stopAirportCode = stopAirportCode;
	}
	public String getStopAirportName() {
		return stopAirportName;
	}
	public void setStopAirportName(String stopAirportName) {
		this.stopAirportName = stopAirportName;
	}
	public String getStopAirportFullName() {
		return stopAirportFullName;
	}
	public void setStopAirportFullName(String stopAirportFullName) {
		this.stopAirportFullName = stopAirportFullName;
	}

}
