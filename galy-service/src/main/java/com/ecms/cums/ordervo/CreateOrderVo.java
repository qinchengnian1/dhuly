package com.ecms.cums.ordervo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value=JsonInclude.Include.NON_EMPTY )
public class CreateOrderVo {

	private String channelSource;

	private String contactEmail;

	private String contactName;

	private String contactNotes;

	private String contactTel;

	private String loginId;

	private String productUrl;

	private String recommendCode;

	private String serverName;

	private String teamId;

	private String thirdOrderId;

	private String urgencyName;

	private String urgencyRel;

	private String urgencyTel;

	private String userAccount;

	private String vdianAccount;

	private List<String> coupons;

	private List<TouristsVo> tourists;

	public String getChannelSource() {
		return channelSource;
	}
	public void setChannelSource(String channelSource) {
		this.channelSource = channelSource;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getContactNotes() {
		return contactNotes;
	}
	public void setContactNotes(String contactNotes) {
		this.contactNotes = contactNotes;
	}
	public String getRecommendCode() {
		return recommendCode;
	}
	public void setRecommendCode(String recommendCode) {
		this.recommendCode = recommendCode;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getThirdOrderId() {
		return thirdOrderId;
	}
	public void setThirdOrderId(String thirdOrderId) {
		this.thirdOrderId = thirdOrderId;
	}
	public String getUrgencyName() {
		return urgencyName;
	}
	public void setUrgencyName(String urgencyName) {
		this.urgencyName = urgencyName;
	}
	public String getUrgencyRel() {
		return urgencyRel;
	}
	public void setUrgencyRel(String urgencyRel) {
		this.urgencyRel = urgencyRel;
	}
	public String getUrgencyTel() {
		return urgencyTel;
	}
	public void setUrgencyTel(String urgencyTel) {
		this.urgencyTel = urgencyTel;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getVdianAccount() {
		return vdianAccount;
	}
	public void setVdianAccount(String vdianAccount) {
		this.vdianAccount = vdianAccount;
	}
	public List<String> getCoupons() {
		return coupons;
	}
	public void setCoupons(List<String> coupons) {
		this.coupons = coupons;
	}
	public List<TouristsVo> getTourists() {
		return tourists;
	}
	public void setTourists(List<TouristsVo> tourists) {
		this.tourists = tourists;
	}

}
