package com.ecms.cums.productvo;

import java.util.List;

import com.ecms.cums.model.ProductDestLocal;

public class ProductDestLocalVo {
	//目的地ID
	private String destId;
	//目的地名称
	private String destName;
	//拼音
	private String pinyin;
	//1--国内，2--境外
	private String systemFlag;
	//父级id
	private String destPid;
	
	private List<ProductDestLocal> productDestVoJson;
	
	public String getDestId() {
		return destId;
	}
	public void setDestId(String destId) {
		this.destId = destId;
	}
	public String getDestName() {
		return destName;
	}
	public void setDestName(String destName) {
		this.destName = destName;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getSystemFlag() {
		return systemFlag;
	}
	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}
	public String getDestPid() {
		return destPid;
	}
	public void setDestPid(String destPid) {
		this.destPid = destPid;
	}
	public List<ProductDestLocal> getProductDestVoJson() {
		return productDestVoJson;
	}
	public void setProductDestVoJson(List<ProductDestLocal> productDestVoJson) {
		this.productDestVoJson = productDestVoJson;
	}
	

	
	
	
}
