package com.ecms.cums.web.vo;

import java.util.HashMap;
import java.util.Map;


public class Response {

	private Map<String ,Object> header = new HashMap<String,Object>();

	private Map<String ,Object> body = new HashMap<String,Object>();

	public Map<String, Object> getHeader() {
		return header;
	}

	public void setHeader(Map<String, Object> header) {
		this.header = header;
	}

	public Map<String, Object> getBody() {
		return body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}



}
