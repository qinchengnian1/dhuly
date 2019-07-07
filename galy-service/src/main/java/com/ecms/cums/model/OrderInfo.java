package com.ecms.cums.model;

import java.io.Serializable;
import java.util.Date;

public class OrderInfo implements Serializable {

	private Integer orderId;

	private Integer cityId;

	private Integer productId;

	private Integer userId;

	private String storeId;

	private String orderNoPt;

	private String orderNoLocal;

	private String perName;

	private String perEmail;

	private String perTel;

	private String productImgUrl;

	private String routeName;

	private String startPlace;

	private String startDate;

	private String jnyDays;

	private String stateLocal;

	private String onlinePrice;

	private String productUrl;

	private String teamId;

	private String ifLocal;

	private Date createTime;

	private Date updateTime;

	private String createName;

	private String updateName;

	private String remark;

	private String routeId;

	private String systemFlag;

	private String glOrderType;

	private String deliveryType;

	private String employeeId;

	private String ptResult;

	private String goodsName;

	private String orderNoGl;

	public String getOrderNoGl() {
		return orderNoGl;
	}

	public void setOrderNoGl(String orderNoGl) {
		this.orderNoGl = orderNoGl;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	private static final long serialVersionUID = 1L;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId == null ? null : storeId.trim();
	}

	public String getOrderNoPt() {
		return orderNoPt;
	}

	public void setOrderNoPt(String orderNoPt) {
		this.orderNoPt = orderNoPt == null ? null : orderNoPt.trim();
	}

	public String getOrderNoLocal() {
		return orderNoLocal;
	}

	public void setOrderNoLocal(String orderNoLocal) {
		this.orderNoLocal = orderNoLocal == null ? null : orderNoLocal.trim();
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName == null ? null : perName.trim();
	}

	public String getPerEmail() {
		return perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail == null ? null : perEmail.trim();
	}

	public String getPerTel() {
		return perTel;
	}

	public void setPerTel(String perTel) {
		this.perTel = perTel == null ? null : perTel.trim();
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl == null ? null : productImgUrl
				.trim();
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName == null ? null : routeName.trim();
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace == null ? null : startPlace.trim();
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate == null ? null : startDate.trim();
	}

	public String getJnyDays() {
		return jnyDays;
	}

	public void setJnyDays(String jnyDays) {
		this.jnyDays = jnyDays == null ? null : jnyDays.trim();
	}

	public String getStateLocal() {
		return stateLocal;
	}

	public void setStateLocal(String stateLocal) {
		this.stateLocal = stateLocal == null ? null : stateLocal.trim();
	}

	public String getOnlinePrice() {
		return onlinePrice;
	}

	public void setOnlinePrice(String onlinePrice) {
		this.onlinePrice = onlinePrice == null ? null : onlinePrice.trim();
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl == null ? null : productUrl.trim();
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId == null ? null : teamId.trim();
	}

	public String getIfLocal() {
		return ifLocal;
	}

	public void setIfLocal(String ifLocal) {
		this.ifLocal = ifLocal == null ? null : ifLocal.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName == null ? null : createName.trim();
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName == null ? null : updateName.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId == null ? null : routeId.trim();
	}

	public String getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag == null ? null : systemFlag.trim();
	}

	public String getGlOrderType() {
		return glOrderType;
	}

	public void setGlOrderType(String glOrderType) {
		this.glOrderType = glOrderType == null ? null : glOrderType.trim();
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType == null ? null : deliveryType.trim();
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId == null ? null : employeeId.trim();
	}

	public String getPtResult() {
		return ptResult;
	}

	public void setPtResult(String ptResult) {
		this.ptResult = ptResult == null ? null : ptResult.trim();
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		OrderInfo other = (OrderInfo) that;
		return (this.getOrderId() == null ? other.getOrderId() == null : this
				.getOrderId().equals(other.getOrderId()))
				&& (this.getCityId() == null ? other.getCityId() == null : this
						.getCityId().equals(other.getCityId()))
				&& (this.getProductId() == null ? other.getProductId() == null
						: this.getProductId().equals(other.getProductId()))
				&& (this.getUserId() == null ? other.getUserId() == null : this
						.getUserId().equals(other.getUserId()))
				&& (this.getStoreId() == null ? other.getStoreId() == null
						: this.getStoreId().equals(other.getStoreId()))
				&& (this.getOrderNoPt() == null ? other.getOrderNoPt() == null
						: this.getOrderNoPt().equals(other.getOrderNoPt()))
				&& (this.getOrderNoLocal() == null ? other.getOrderNoLocal() == null
						: this.getOrderNoLocal()
								.equals(other.getOrderNoLocal()))
				&& (this.getPerName() == null ? other.getPerName() == null
						: this.getPerName().equals(other.getPerName()))
				&& (this.getPerEmail() == null ? other.getPerEmail() == null
						: this.getPerEmail().equals(other.getPerEmail()))
				&& (this.getPerTel() == null ? other.getPerTel() == null : this
						.getPerTel().equals(other.getPerTel()))
				&& (this.getProductImgUrl() == null ? other.getProductImgUrl() == null
						: this.getProductImgUrl().equals(
								other.getProductImgUrl()))
				&& (this.getRouteName() == null ? other.getRouteName() == null
						: this.getRouteName().equals(other.getRouteName()))
				&& (this.getStartPlace() == null ? other.getStartPlace() == null
						: this.getStartPlace().equals(other.getStartPlace()))
				&& (this.getStartDate() == null ? other.getStartDate() == null
						: this.getStartDate().equals(other.getStartDate()))
				&& (this.getJnyDays() == null ? other.getJnyDays() == null
						: this.getJnyDays().equals(other.getJnyDays()))
				&& (this.getStateLocal() == null ? other.getStateLocal() == null
						: this.getStateLocal().equals(other.getStateLocal()))
				&& (this.getOnlinePrice() == null ? other.getOnlinePrice() == null
						: this.getOnlinePrice().equals(other.getOnlinePrice()))
				&& (this.getProductUrl() == null ? other.getProductUrl() == null
						: this.getProductUrl().equals(other.getProductUrl()))
				&& (this.getTeamId() == null ? other.getTeamId() == null : this
						.getTeamId().equals(other.getTeamId()))
				&& (this.getIfLocal() == null ? other.getIfLocal() == null
						: this.getIfLocal().equals(other.getIfLocal()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null
						: this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getUpdateTime() == null ? other.getUpdateTime() == null
						: this.getUpdateTime().equals(other.getUpdateTime()))
				&& (this.getCreateName() == null ? other.getCreateName() == null
						: this.getCreateName().equals(other.getCreateName()))
				&& (this.getUpdateName() == null ? other.getUpdateName() == null
						: this.getUpdateName().equals(other.getUpdateName()))
				&& (this.getRemark() == null ? other.getRemark() == null : this
						.getRemark().equals(other.getRemark()))
				&& (this.getRouteId() == null ? other.getRouteId() == null
						: this.getRouteId().equals(other.getRouteId()))
				&& (this.getSystemFlag() == null ? other.getSystemFlag() == null
						: this.getSystemFlag().equals(other.getSystemFlag()))
				&& (this.getGlOrderType() == null ? other.getGlOrderType() == null
						: this.getGlOrderType().equals(other.getGlOrderType()))
				&& (this.getDeliveryType() == null ? other.getDeliveryType() == null
						: this.getDeliveryType()
								.equals(other.getDeliveryType()))
				&& (this.getEmployeeId() == null ? other.getEmployeeId() == null
						: this.getEmployeeId().equals(other.getEmployeeId()))
				&& (this.getPtResult() == null ? other.getPtResult() == null
						: this.getPtResult().equals(other.getPtResult()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getOrderId() == null) ? 0 : getOrderId().hashCode());
		result = prime * result
				+ ((getCityId() == null) ? 0 : getCityId().hashCode());
		result = prime * result
				+ ((getProductId() == null) ? 0 : getProductId().hashCode());
		result = prime * result
				+ ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result
				+ ((getStoreId() == null) ? 0 : getStoreId().hashCode());
		result = prime * result
				+ ((getOrderNoPt() == null) ? 0 : getOrderNoPt().hashCode());
		result = prime
				* result
				+ ((getOrderNoLocal() == null) ? 0 : getOrderNoLocal()
						.hashCode());
		result = prime * result
				+ ((getPerName() == null) ? 0 : getPerName().hashCode());
		result = prime * result
				+ ((getPerEmail() == null) ? 0 : getPerEmail().hashCode());
		result = prime * result
				+ ((getPerTel() == null) ? 0 : getPerTel().hashCode());
		result = prime
				* result
				+ ((getProductImgUrl() == null) ? 0 : getProductImgUrl()
						.hashCode());
		result = prime * result
				+ ((getRouteName() == null) ? 0 : getRouteName().hashCode());
		result = prime * result
				+ ((getStartPlace() == null) ? 0 : getStartPlace().hashCode());
		result = prime * result
				+ ((getStartDate() == null) ? 0 : getStartDate().hashCode());
		result = prime * result
				+ ((getJnyDays() == null) ? 0 : getJnyDays().hashCode());
		result = prime * result
				+ ((getStateLocal() == null) ? 0 : getStateLocal().hashCode());
		result = prime
				* result
				+ ((getOnlinePrice() == null) ? 0 : getOnlinePrice().hashCode());
		result = prime * result
				+ ((getProductUrl() == null) ? 0 : getProductUrl().hashCode());
		result = prime * result
				+ ((getTeamId() == null) ? 0 : getTeamId().hashCode());
		result = prime * result
				+ ((getIfLocal() == null) ? 0 : getIfLocal().hashCode());
		result = prime * result
				+ ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result
				+ ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
		result = prime * result
				+ ((getCreateName() == null) ? 0 : getCreateName().hashCode());
		result = prime * result
				+ ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
		result = prime * result
				+ ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result
				+ ((getRouteId() == null) ? 0 : getRouteId().hashCode());
		result = prime * result
				+ ((getSystemFlag() == null) ? 0 : getSystemFlag().hashCode());
		result = prime
				* result
				+ ((getGlOrderType() == null) ? 0 : getGlOrderType().hashCode());
		result = prime
				* result
				+ ((getDeliveryType() == null) ? 0 : getDeliveryType()
						.hashCode());
		result = prime * result
				+ ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
		result = prime * result
				+ ((getPtResult() == null) ? 0 : getPtResult().hashCode());
		return result;
	}

}