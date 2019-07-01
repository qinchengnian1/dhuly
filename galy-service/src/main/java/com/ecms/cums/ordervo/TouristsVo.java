package com.ecms.cums.ordervo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value=JsonInclude.Include.NON_EMPTY )
public class TouristsVo {

	@JsonIgnore
	private String touristId;

	private String touristName;
	@JsonIgnore
	private String touristNamePY;
	@JsonIgnore
	private String touristSex;
	@JsonIgnore
	private String touristNationId;
	@JsonIgnore
	private String touristCredType;
	@JsonIgnore
	private String touristCredId;
	@JsonIgnore
	private String roommateRelation;
	@JsonIgnore
	private String roommateName;
	@JsonIgnore
	private String roommateMobile;
	@JsonIgnore
	private String touristBirthDate;
	@JsonIgnore
	private String touristRegPlace;
	@JsonIgnore
	private String touristMobile;
	@JsonIgnore
	private String touristEmail;
	@JsonIgnore
	private String touristMemo;
	@JsonIgnore
	private String pasgType;

	private String priceId;

	private String price;

	public String getTouristName() {
		return touristName;
	}
	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}
	public String getTouristNamePY() {
		return touristNamePY;
	}
	public void setTouristNamePY(String touristNamePY) {
		this.touristNamePY = touristNamePY;
	}
	public String getTouristSex() {
		return touristSex;
	}
	public void setTouristSex(String touristSex) {
		this.touristSex = touristSex;
	}
	public String getTouristNationId() {
		return touristNationId;
	}
	public void setTouristNationId(String touristNationId) {
		this.touristNationId = touristNationId;
	}
	public String getTouristCredType() {
		return touristCredType;
	}
	public void setTouristCredType(String touristCredType) {
		this.touristCredType = touristCredType;
	}
	public String getTouristCredId() {
		return touristCredId;
	}
	public void setTouristCredId(String touristCredId) {
		this.touristCredId = touristCredId;
	}
	public String getRoommateRelation() {
		return roommateRelation;
	}
	public void setRoommateRelation(String roommateRelation) {
		this.roommateRelation = roommateRelation;
	}
	public String getRoommateName() {
		return roommateName;
	}
	public void setRoommateName(String roommateName) {
		this.roommateName = roommateName;
	}
	public String getRoommateMobile() {
		return roommateMobile;
	}
	public void setRoommateMobile(String roommateMobile) {
		this.roommateMobile = roommateMobile;
	}
	public String getTouristBirthDate() {
		return touristBirthDate;
	}
	public void setTouristBirthDate(String touristBirthDate) {
		this.touristBirthDate = touristBirthDate;
	}
	public String getTouristRegPlace() {
		return touristRegPlace;
	}
	public void setTouristRegPlace(String touristRegPlace) {
		this.touristRegPlace = touristRegPlace;
	}
	public String getTouristMobile() {
		return touristMobile;
	}
	public void setTouristMobile(String touristMobile) {
		this.touristMobile = touristMobile;
	}
	public String getTouristEmail() {
		return touristEmail;
	}
	public void setTouristEmail(String touristEmail) {
		this.touristEmail = touristEmail;
	}
	public String getTouristMemo() {
		return touristMemo;
	}
	public void setTouristMemo(String touristMemo) {
		this.touristMemo = touristMemo;
	}
	public String getPasgType() {
		return pasgType;
	}
	public void setPasgType(String pasgType) {
		this.pasgType = pasgType;
	}
	public String getPriceId() {
		return priceId;
	}
	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTouristId() {
		return touristId;
	}
	public void setTouristId(String touristId) {
		this.touristId = touristId;
	}

}
