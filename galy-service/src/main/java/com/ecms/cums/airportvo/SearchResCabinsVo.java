package com.ecms.cums.airportvo;

import java.math.BigDecimal;

public class SearchResCabinsVo {

	private String cabin;
	//成人公布价
	private BigDecimal publishPrice;
	//成人单价
	private BigDecimal adultPrice;
	//成人税费
	private BigDecimal adultTax;
	//成人舱位数
	private Integer adultCabinNum;
	//儿童公布价
	private BigDecimal childPublishPrice;
	//儿童单价
	private BigDecimal childPrice;
	//儿童税费
	private BigDecimal childTax;
	//儿童舱位数
	private Integer childCabinNum;
	//舱位数
	private Integer cabinNum;
	//是否支持儿童
	private Boolean isChd;
	//预订需求参数
	private String data;
	//裸票价
	private String barePrice;
	//包装价
	private String price;
	//政策价
	private String basePrice;
	//政策类型
	private String policyType;

	private String wrapperId;
	//代理商域名
	private String client;
	//政策id
	private String policyId;
	//产品tag
	private String prtag;
	//中文舱位类型
	private String policyCode;
	//折扣率
	private String discountRate;

	private SearchResRuleVo rule;

	public SearchResRuleVo getRule() {
		return rule;
	}
	public void setRule(SearchResRuleVo rule) {
		this.rule = rule;
	}
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	public BigDecimal getPublishPrice() {
		return publishPrice;
	}
	public void setPublishPrice(BigDecimal publishPrice) {
		this.publishPrice = publishPrice;
	}
	public BigDecimal getAdultPrice() {
		return adultPrice;
	}
	public void setAdultPrice(BigDecimal adultPrice) {
		this.adultPrice = adultPrice;
	}
	public BigDecimal getAdultTax() {
		return adultTax;
	}
	public void setAdultTax(BigDecimal adultTax) {
		this.adultTax = adultTax;
	}
	public Integer getAdultCabinNum() {
		return adultCabinNum;
	}
	public void setAdultCabinNum(Integer adultCabinNum) {
		this.adultCabinNum = adultCabinNum;
	}
	public BigDecimal getChildPublishPrice() {
		return childPublishPrice;
	}
	public void setChildPublishPrice(BigDecimal childPublishPrice) {
		this.childPublishPrice = childPublishPrice;
	}
	public BigDecimal getChildPrice() {
		return childPrice;
	}
	public void setChildPrice(BigDecimal childPrice) {
		this.childPrice = childPrice;
	}
	public BigDecimal getChildTax() {
		return childTax;
	}
	public void setChildTax(BigDecimal childTax) {
		this.childTax = childTax;
	}
	public Integer getChildCabinNum() {
		return childCabinNum;
	}
	public void setChildCabinNum(Integer childCabinNum) {
		this.childCabinNum = childCabinNum;
	}
	public Integer getCabinNum() {
		return cabinNum;
	}
	public void setCabinNum(Integer cabinNum) {
		this.cabinNum = cabinNum;
	}
	public Boolean getIsChd() {
		return isChd;
	}
	public void setIsChd(Boolean isChd) {
		this.isChd = isChd;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
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
	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	public String getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}

}
