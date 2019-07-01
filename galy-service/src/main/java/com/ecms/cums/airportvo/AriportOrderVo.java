package com.ecms.cums.airportvo;

public class AriportOrderVo {

	private String storeId;
	private String productCode;
	private String storeName;
	private String storeType;
	private String token;
	private String userId;
	private String cityNo;
	private String fromCity;
	private String toCity;
	private String airportName;
	private String aircraftName;
	private String airportType; //国内 1 国际2
	private String clientSite;
	private FAirportCouponVo fAirportCouponVo;
	private CreateOrderAriportVo createOrderAriportVo;


	public String getClientSite() {
		return clientSite;
	}
	public void setClientSite(String clientSite) {
		this.clientSite = clientSite;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAircraftName() {
		return aircraftName;
	}
	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}
	public String getAirportType() {
		return airportType;
	}
	public void setAirportType(String airportType) {
		this.airportType = airportType;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public FAirportCouponVo getfAirportCouponVo() {
		return fAirportCouponVo;
	}
	public void setfAirportCouponVo(FAirportCouponVo fAirportCouponVo) {
		this.fAirportCouponVo = fAirportCouponVo;
	}
	public CreateOrderAriportVo getCreateOrderAriportVo() {
		return createOrderAriportVo;
	}
	public void setCreateOrderAriportVo(CreateOrderAriportVo createOrderAriportVo) {
		this.createOrderAriportVo = createOrderAriportVo;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCityNo() {
		return cityNo;
	}
	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
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

}
