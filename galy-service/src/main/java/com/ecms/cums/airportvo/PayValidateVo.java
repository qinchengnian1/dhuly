package com.ecms.cums.airportvo;

public class PayValidateVo {
	private String cid;
	private String orderId;
	private String clientSite;
	private String pmCode;
	private String bankCode;

	public String getPmCode() {
		return pmCode;
	}
	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getClientSite() {
		return clientSite;
	}
	public void setClientSite(String clientSite) {
		this.clientSite = clientSite;
	}

}
