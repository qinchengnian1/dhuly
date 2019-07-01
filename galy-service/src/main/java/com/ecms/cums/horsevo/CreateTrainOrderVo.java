package com.ecms.cums.horsevo;

import java.util.List;

public class CreateTrainOrderVo {

	private String cid;
	private String merchantOrderId;//商户订单id
	private String arriveStation;//到达车站
	private String arriveTime;//到达时间
	private List<BookDetailList> bookDetailList;
	private String bxInvoice;//保险发票是否需要 0-否，1-是
	private String bxInvoiceAddress;//保险发票地址
	private String bxInvoicePhone;//发票电话
	private String bxInvoiceReceiver;//收件人
	private String bxInvoiceZipCode;//邮政编号
	private String fromStation;//出发车站
	private String fromTime;//出发日期
	private String linkAddress;//联系人地址
	private String linkMail;//联系人邮箱
	private String linkName;//联系人姓名
	private String linkPhone;//手机号
	private String orderPro1;//保险格式 10元保险：BX_10  20元保险：BX_20 或者空
	private String orderPro2; //空
	private String seatType; //座位类型 0-商务，1-特等，2-一等，3-二等，4高级软卧，5软卧，6硬卧，7软座，8硬座，9无座，10其他
	private String smsNotify;//预订车票完成并付款成功是否短信通知 0-否，1-是
	private String sumAmount;//总计金额  = 车票价格+总保险金额
	private String ticketPrice;//车票单价 保留两位小数
	private String trainCode;//车次
	private String travelTime;//乘车日期
	private String wzExt;//备选无座   0-否，1-是 默认0 如果没有座位 就预订无座的票
	private String accountName; //12306账户
	private String accountPwd;//12306密码
	private Boolean isChooseSeates;//是否选座 true 选 ，false-非选
	private String chooseSeats; //选座信息
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getMerchantOrderId() {
		return merchantOrderId;
	}
	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}
	public String getArriveStation() {
		return arriveStation;
	}
	public void setArriveStation(String arriveStation) {
		this.arriveStation = arriveStation;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public List<BookDetailList> getBookDetailList() {
		return bookDetailList;
	}
	public void setBookDetailList(List<BookDetailList> bookDetailList) {
		this.bookDetailList = bookDetailList;
	}
	public String getBxInvoice() {
		return bxInvoice;
	}
	public void setBxInvoice(String bxInvoice) {
		this.bxInvoice = bxInvoice;
	}
	public String getBxInvoiceAddress() {
		return bxInvoiceAddress;
	}
	public void setBxInvoiceAddress(String bxInvoiceAddress) {
		this.bxInvoiceAddress = bxInvoiceAddress;
	}
	public String getBxInvoicePhone() {
		return bxInvoicePhone;
	}
	public void setBxInvoicePhone(String bxInvoicePhone) {
		this.bxInvoicePhone = bxInvoicePhone;
	}
	public String getBxInvoiceReceiver() {
		return bxInvoiceReceiver;
	}
	public void setBxInvoiceReceiver(String bxInvoiceReceiver) {
		this.bxInvoiceReceiver = bxInvoiceReceiver;
	}
	public String getBxInvoiceZipCode() {
		return bxInvoiceZipCode;
	}
	public void setBxInvoiceZipCode(String bxInvoiceZipCode) {
		this.bxInvoiceZipCode = bxInvoiceZipCode;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public String getLinkMail() {
		return linkMail;
	}
	public void setLinkMail(String linkMail) {
		this.linkMail = linkMail;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getOrderPro1() {
		return orderPro1;
	}
	public void setOrderPro1(String orderPro1) {
		this.orderPro1 = orderPro1;
	}
	public String getOrderPro2() {
		return orderPro2;
	}
	public void setOrderPro2(String orderPro2) {
		this.orderPro2 = orderPro2;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public String getSmsNotify() {
		return smsNotify;
	}
	public void setSmsNotify(String smsNotify) {
		this.smsNotify = smsNotify;
	}
	public String getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(String sumAmount) {
		this.sumAmount = sumAmount;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getTrainCode() {
		return trainCode;
	}
	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public String getWzExt() {
		return wzExt;
	}
	public void setWzExt(String wzExt) {
		this.wzExt = wzExt;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountPwd() {
		return accountPwd;
	}
	public void setAccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}
	public Boolean getIsChooseSeates() {
		return isChooseSeates;
	}
	public void setIsChooseSeates(Boolean isChooseSeates) {
		this.isChooseSeates = isChooseSeates;
	}
	public String getChooseSeats() {
		return chooseSeats;
	}
	public void setChooseSeats(String chooseSeats) {
		this.chooseSeats = chooseSeats;
	}


}
