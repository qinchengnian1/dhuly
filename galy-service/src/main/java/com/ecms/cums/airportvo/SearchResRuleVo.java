package com.ecms.cums.airportvo;

public class SearchResRuleVo {
	//退票规定
	private String refund;
	//改签规定
	private String endorse;
	//行李规定
	private String baggage;
	//其他说明
	private String other;

	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public String getEndorse() {
		return endorse;
	}
	public void setEndorse(String endorse) {
		this.endorse = endorse;
	}
	public String getBaggage() {
		return baggage;
	}
	public void setBaggage(String baggage) {
		this.baggage = baggage;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}

}
