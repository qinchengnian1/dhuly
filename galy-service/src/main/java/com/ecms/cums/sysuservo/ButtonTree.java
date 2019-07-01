package com.ecms.cums.sysuservo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ButtonTree {
	@JsonProperty(value = "id")
	private String id;
	@JsonProperty(value = "buttonCode")
	private String buttonCode;
	@JsonProperty(value = "text")
	private String text;
	@JsonProperty(value = "state")
	private StatesTree state;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getButtonCode() {
		return buttonCode;
	}
	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public StatesTree getState() {
		return state;
	}
	public void setState(StatesTree state) {
		this.state = state;
	}
	
	
	
}
