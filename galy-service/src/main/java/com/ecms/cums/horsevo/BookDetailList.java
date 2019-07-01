package com.ecms.cums.horsevo;

public class BookDetailList {
	private String bx;  //是否购买保险 0-否，1-是
	private String idsType; //0-成人，1-儿童
	private String ticketType;//1一代身份证，2-二代身份证，3-港澳通行，4-台湾通行，5-护照
	private String userIds;//证件号码
	private String userName;//姓名
	public String getBx() {
		return bx;
	}
	public void setBx(String bx) {
		this.bx = bx;
	}
	public String getIdsType() {
		return idsType;
	}
	public void setIdsType(String idsType) {
		this.idsType = idsType;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


}
