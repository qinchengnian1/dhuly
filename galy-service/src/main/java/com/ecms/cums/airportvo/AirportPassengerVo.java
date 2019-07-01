package com.ecms.cums.airportvo;

public class AirportPassengerVo {

	private Long id;
	private String name;
	private String cardType;
	private String cardNum;
	private String ticketNum;
	private String birthday;
	private Integer gender;
	private Boolean success;
	private String reason;
	private Boolean volunteer;
	private Boolean noTicket;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Boolean getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(Boolean volunteer) {
		this.volunteer = volunteer;
	}
	public Boolean getNoTicket() {
		return noTicket;
	}
	public void setNoTicket(Boolean noTicket) {
		this.noTicket = noTicket;
	}

}
