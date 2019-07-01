package com.ecms.cums.airportvo;
/**
 * @ClassName: RetSegmentsVo
 * @Description: 返程航段集合
 * @author: zJin
 * @date: 2018年4月25日 下午1:56:48
 */
public class RetSegmentsVo {
	//渠道代码
	private String code;
	//航司二字码
	private String carrier;
	//出发机场
	private String depAirport;
	//到达机场
	private String arrAirport;
	//航班日期
	private String flightDate;
	//舱位代码
	private String cabin;
	//航班号
	private String flightNumber;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getDepAirport() {
		return depAirport;
	}
	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}
	public String getArrAirport() {
		return arrAirport;
	}
	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


}
