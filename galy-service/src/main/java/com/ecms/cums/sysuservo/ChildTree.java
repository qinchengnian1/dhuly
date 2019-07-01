package com.ecms.cums.sysuservo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChildTree {
	@JsonProperty(value = "id")
	private String id;
	@JsonProperty(value = "ChildCode")
	private String ChildCode;
	@JsonProperty(value = "text")
	private String text;
	@JsonProperty(value = "state")
	private StatesTree state;
	@JsonProperty(value = "nodes")
	private List<ButtonTree> nodes;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChildCode() {
		return ChildCode;
	}
	public void setChildCode(String childCode) {
		ChildCode = childCode;
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
	public List<ButtonTree> getNodes() {
		return nodes;
	}
	public void setNodes(List<ButtonTree> nodes) {
		this.nodes = nodes;
	}
	
}
