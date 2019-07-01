package com.ecms.cums.sysuservo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuTree {
	
	@JsonProperty(value = "id")
	private String id;
	@JsonProperty(value = "menuCode")
	private String menuCode;
	@JsonProperty(value = "text")
	private String text;
	@JsonProperty(value = "state")
	private StatesTree state;
	@JsonProperty(value = "nodes")
	private List<ChildTree> nodes;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public StatesTree getState() {
		return state;
	}
	public void setState(StatesTree state) {
		this.state = state;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<ChildTree> getNodes() {
		return nodes;
	}
	public void setNodes(List<ChildTree> nodes) {
		this.nodes = nodes;
	}
	
}
