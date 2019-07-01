package com.ecms.cums.ordervo;

import java.util.HashMap;
import java.util.Map;

public class Message {

	private Map<String ,Object> header = new HashMap<String,Object>();

	public Map<String, Object> getHeader() {
		return header;
	}

	public void setHeader(Map<String, Object> header) {
		this.header = header;
	}

}
