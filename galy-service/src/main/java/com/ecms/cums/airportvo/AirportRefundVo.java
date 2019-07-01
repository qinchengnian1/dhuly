package com.ecms.cums.airportvo;



public class AirportRefundVo {

	private String id;
	private String cid;
	private String ldyOrderNo;
	private Integer refundCauseId;
	private String passengerIds;
	private String refundCause;
	private String returnRefundFee; //当前应该退的票款
	private String refundFee;       //当前应该退票扣费金额
	private String onePriceAll;     //一张机票总和    机票+燃油+机建

	public String getOnePriceAll() {
		return onePriceAll;
	}
	public void setOnePriceAll(String onePriceAll) {
		this.onePriceAll = onePriceAll;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getLdyOrderNo() {
		return ldyOrderNo;
	}
	public void setLdyOrderNo(String ldyOrderNo) {
		this.ldyOrderNo = ldyOrderNo;
	}
	public Integer getRefundCauseId() {
		return refundCauseId;
	}
	public void setRefundCauseId(Integer refundCauseId) {
		this.refundCauseId = refundCauseId;
	}
	public String getPassengerIds() {
		return passengerIds;
	}
	public void setPassengerIds(String passengerIds) {
		this.passengerIds = passengerIds;
	}
	public String getRefundCause() {
		return refundCause;
	}
	public void setRefundCause(String refundCause) {
		this.refundCause = refundCause;
	}
	public String getReturnRefundFee() {
		return returnRefundFee;
	}
	public void setReturnRefundFee(String returnRefundFee) {
		this.returnRefundFee = returnRefundFee;
	}
	public String getRefundFee() {
		return refundFee;
	}
	public void setRefundFee(String refundFee) {
		this.refundFee = refundFee;
	}

}
