package com.ecms.cums.core.util;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.ecms.cums.core.util.MD5;





public class WeixinUtil {


	public static String signData(Map<String, Object> contentData,String weixin_key) {

		Set<String> set = contentData.keySet();

		ArrayList<String> list = new ArrayList<String>(set);

		java.util.Collections.sort(list);

		StringBuffer sb = new StringBuffer();

		for(String key:list){
			if(contentData.get(key) != null && !"".equals(contentData.get(key))){
				sb.append(key).append("=").append(contentData.get(key)).append("&");
			}
		}
		sb.append("key=").append(weixin_key);

		String sign = MD5.crypt(sb.toString()).toUpperCase();

		return sign;
	}

	public static String chanageMapToXml(Map<String ,Object> map){
		if(map == null || map.size() == 0){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>") ;

		Set<String> keySet = map.keySet();

		for(String key: keySet){
			if(map.get(key) != null && !"".equals(map.get(key))){
				sb.append("<")
				.append(key)
				.append(">")
				.append(map.get(key))
				.append("</")
				.append(key)
				.append(">");
			}
		}
		sb.append("</xml>") ;
		return sb.toString();
	}

}
