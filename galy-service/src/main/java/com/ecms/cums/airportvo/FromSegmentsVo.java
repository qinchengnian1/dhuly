package com.ecms.cums.airportvo;
/**
 * @ClassName: FromSegmentsVo
 * @Description: 去程航段集合
 * @author: zJin
 * @date: 2018年4月25日 下午1:57:09
 */
public class FromSegmentsVo {

	private String data;
	/*渠道代码*/
	private String code;
	/*航司二字码*/
	private String carrier;
	/*出发机场*/
	private String depAirport;
	/*到达机场*/
	private String arrAirport;
	/*航班日期*/
	private String flightDate;
	/*航班代码*/
	private String cabin;
	/*航班号*/
	private String flightNumber;
	/*出发时间*/
	private String dptTime;
	/*票面价*/
	private String ticketPrice;
	/*裸票价*/
	private String barePrice;
	/*包装价*/
	private String price;
	/*政策价*/
	private String basePrice;
	/*政策类型*/
	private String policyType;
	/*wrapperId*/
	private String wrapperId;
	/*代理商域名*/
	private String client;
	/*政策Id*/
	private String policyId;
	/*产品tag*/
	private String prtag;

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
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
	public String getDptTime() {
		return dptTime;
	}
	public void setDptTime(String dptTime) {
		this.dptTime = dptTime;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getBarePrice() {
		return barePrice;
	}
	public void setBarePrice(String barePrice) {
		this.barePrice = barePrice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getWrapperId() {
		return wrapperId;
	}
	public void setWrapperId(String wrapperId) {
		this.wrapperId = wrapperId;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getPrtag() {
		return prtag;
	}
	public void setPrtag(String prtag) {
		this.prtag = prtag;
	}

}
