package com.ecms.cums.ordervo;


public class CreatePTOrderInfoVo {

	private String eshopCode;

	private String productCode;

	private String quantity;

	private String unitPrice;

	private String storeId;

	private String storeName;

	private String storeType;

	private String deliveryType;

	private String buyerRemark;

	private String cardCouponId;

	private String employeeId;

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCardCouponId() {
		return cardCouponId;
	}
	public void setCardCouponId(String cardCouponId) {
		this.cardCouponId = cardCouponId;
	}
	public String getEshopCode() {
		return eshopCode;
	}
	public void setEshopCode(String eshopCode) {
		this.eshopCode = eshopCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getStoreId() {
		return storeId;
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
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getBuyerRemark() {
		return buyerRemark;
	}
	public void setBuyerRemark(String buyerRemark) {
		this.buyerRemark = buyerRemark;
	}

}
