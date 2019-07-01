package com.ecms.cums.ordervo.local;

import java.util.List;

import com.ecms.cums.ordervo.TouristsVo;

public class CreateOrderVoLocal {
	private String userId; /*用户id*/

	private String productImgUrl; /*产品图片*/

	private String routeName;/*线路名称*/

	private String startPlace;/*出发地*/

	private String startDate;/*出团日期*/

	private String jnyDays;/*行程天数*/

	private String onlinePrice;/*总价*/

	private String routeId;/*线路id*/

	private String glOrderType;/*国内游--1，出境游--2，*/

	private String ifLocal;/*1--本地，2--国旅接口*/

	private String contactEmail;/*联系人邮箱*/

	private String contactName;/*联系人姓名*/

	private String contactNotes;/*备注*/

	private String contactTel;/*联系人电话*/

	private String productUrl;/*产品url*/

	private String productId;/*产品id*/

	private String cityId;/*城市id*/

	private String teamId;/*团id*/
	private String couponId; //优惠券id
	private String storeId;
	private String storeName;
	private String storeType;
	private String token;
	private String adName;
	private String cityName;
	private String longitude;
	private String provinceCode;
	private String latitude;
	private String cityCode;
	private String detailAddress;
	private String placename;
	private String provinceName;
	private String adCode;

	private String deliveryType;
	private String employeeId;

	private List<TouristsVo> tourists;/*旅客信息*/


	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getPlacename() {
		return placename;
	}
	public void setPlacename(String placename) {
		this.placename = placename;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getAdCode() {
		return adCode;
	}
	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getStoreId() {
		return storeId;
	}
	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
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

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getJnyDays() {
		return jnyDays;
	}

	public void setJnyDays(String jnyDays) {
		this.jnyDays = jnyDays;
	}

	public String getOnlinePrice() {
		return onlinePrice;
	}

	public void setOnlinePrice(String onlinePrice) {
		this.onlinePrice = onlinePrice;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getGlOrderType() {
		return glOrderType;
	}

	public void setGlOrderType(String glOrderType) {
		this.glOrderType = glOrderType;
	}

	public String getIfLocal() {
		return ifLocal;
	}

	public void setIfLocal(String ifLocal) {
		this.ifLocal = ifLocal;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNotes() {
		return contactNotes;
	}

	public void setContactNotes(String contactNotes) {
		this.contactNotes = contactNotes;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public List<TouristsVo> getTourists() {
		return tourists;
	}

	public void setTourists(List<TouristsVo> tourists) {
		this.tourists = tourists;
	}

}
