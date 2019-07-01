package com.ecms.cums.web.vo;

import com.ecms.cums.utils.ResourceUtils;


public class ZfbDistributeRoyaltyVo {
	/*接口名称*/
	private String service = ResourceUtils.getProperty("servicezfb");
	/*合作身份者ID*/
	private String partner = ResourceUtils.getProperty("partner");
	/*参数编码字符集*/
	private String _input_charset = ResourceUtils.getProperty("_input_charset");
	/*签名方式*/
	private String sign_type = ResourceUtils.getProperty("sign_type");
	/*签名*/
	private String sign;
	/*分润号*/
	private String out_bill_no;
	/*分润类型*/
	private String royalty_type = ResourceUtils.getProperty("royalty_type");
	/*分润参数明细*/
	private String royalty_parameters;
	/*支付宝交易号    可空*/
	private String trade_no;
	/*商户网站唯一订单号  可空*/
	private String out_trade_no;


	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String get_input_charset() {
		return _input_charset;
	}
	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getOut_bill_no() {
		return out_bill_no;
	}
	public void setOut_bill_no(String out_bill_no) {
		this.out_bill_no = out_bill_no;
	}
	public String getRoyalty_type() {
		return royalty_type;
	}
	public void setRoyalty_type(String royalty_type) {
		this.royalty_type = royalty_type;
	}
	public String getRoyalty_parameters() {
		return royalty_parameters;
	}
	public void setRoyalty_parameters(String royalty_parameters) {
		this.royalty_parameters = royalty_parameters;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}


}
