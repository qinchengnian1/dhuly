package com.ecms.cums.airportvo;


public class FAirportCouponVo {

	private String fCardCouponId;   //优惠卷id
	private String fStartDate;      //启用时间
	private String fExpirationDate; //过期时间
	private String fAmount;         //优惠金额
	private String fCouponName;     //优惠名称

	public String getfCardCouponId() {
		return fCardCouponId;
	}
	public void setfCardCouponId(String fCardCouponId) {
		this.fCardCouponId = fCardCouponId;
	}
	public String getfStartDate() {
		return fStartDate;
	}
	public void setfStartDate(String fStartDate) {
		this.fStartDate = fStartDate;
	}
	public String getfExpirationDate() {
		return fExpirationDate;
	}
	public void setfExpirationDate(String fExpirationDate) {
		this.fExpirationDate = fExpirationDate;
	}
	public String getfAmount() {
		return fAmount;
	}
	public void setfAmount(String fAmount) {
		this.fAmount = fAmount;
	}
	public String getfCouponName() {
		return fCouponName;
	}
	public void setfCouponName(String fCouponName) {
		this.fCouponName = fCouponName;
	}
}
