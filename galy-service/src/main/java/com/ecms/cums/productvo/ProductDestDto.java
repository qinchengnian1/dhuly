package com.ecms.cums.productvo;

import java.util.List;

import com.ecms.cums.model.ProductDest;

public class ProductDestDto {
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
	
	private List<ProductDest> productDestVoJson;
	
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
	public List<ProductDest> getProductDestVoJson() {
		return productDestVoJson;
	}
	public void setProductDestVoJson(List<ProductDest> productDestVoJson) {
		this.productDestVoJson = productDestVoJson;
	}
	
	
	
}
