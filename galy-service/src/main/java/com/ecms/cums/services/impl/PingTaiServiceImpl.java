package com.ecms.cums.services.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ecms.cums.core.util.HttpCommandProvider;
import com.ecms.cums.cores.Constants;
import com.ecms.cums.ordervo.CreatePTOrderVo;
import com.ecms.cums.services.PingTaiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

@Service
public class PingTaiServiceImpl implements PingTaiService{

	@Override
	public String getSignByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createOrder(CreatePTOrderVo pOrder) {
		// TODO Auto-generated method stub
		JSONObject params = new JSONObject();
		JSONObject header = new JSONObject();
		JSONObject body = new JSONObject();
		header.put("appId", "");
		header.put("md5", "");
		header.put("token", "");
		header.put("appTypePlatform", "");
		try {
			String value = new ObjectMapper().writeValueAsString(pOrder);
			body.put("customerAddress", value);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		params.put("header", header);
		params.put("body", body);
		HttpCommandProvider sp = new HttpCommandProvider();
		String result = sp.setUrl(Constants.pt_create_order_url).setPostMethod().setRequestBody(params.toString()).send();
		return result;
	}


}
