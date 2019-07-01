package com.ecms.cums.airportvo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CreateOrderPassengersVo {
	@JsonInclude(value=JsonInclude.Include.NON_DEFAULT )
	private String touristId;
	private String name;
	private String ageType;
	private String birthday;
	private String cardNum;
	private String cardType;
	private String phoneNum;


	public String getTouristId() {
		return touristId;
	}
	public void setTouristId(String touristId) {
		this.touristId = touristId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAgeType() {
		return ageType;
	}
	public void setAgeType(String ageType) {
		this.ageType = ageType;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
