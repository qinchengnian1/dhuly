package com.ecms.cums.web.vo;

public class ZfbOrderVo {
	//交易类型
	private String trade_type;
	//appid
	private String app_id;
	//商品描述
	private String goods_body;
	//商品详情
	private String goods_detail;
	//商家数据包
	private String goods_attach;
	//商户订单号
	private String out_trade_no;
	//商品金额
	private int goods_amount;
	//时间
	private String pay_time;
	//支付通知地址
	private String notify_url;
	//支付跳转地址
	private String redirect_url;
	//ip地址
	private String create_ip;
	//用户标识
	private String open_id;
	//授权码
	private String auth_code;
	//支付签名
	private String sign;
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getGoods_body() {
		return goods_body;
	}
	public void setGoods_body(String goods_body) {
		this.goods_body = goods_body;
	}
	public String getGoods_detail() {
		return goods_detail;
	}
	public void setGoods_detail(String goods_detail) {
		this.goods_detail = goods_detail;
	}
	public String getGoods_attach() {
		return goods_attach;
	}
	public void setGoods_attach(String goods_attach) {
		this.goods_attach = goods_attach;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public int getGoods_amount() {
		return goods_amount;
	}
	public void setGoods_amount(int goods_amount) {
		this.goods_amount = goods_amount;
	}
	public String getPay_time() {
		return pay_time;
	}
	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getRedirect_url() {
		return redirect_url;
	}
	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}
	public String getCreate_ip() {
		return create_ip;
	}
	public void setCreate_ip(String create_ip) {
		this.create_ip = create_ip;
	}
	public String getOpen_id() {
		return open_id;
	}
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}


}
