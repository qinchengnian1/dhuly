package com.ecms.cums.core.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import com.ecms.cums.core.util.GuolvDESUtil;
import com.ecms.cums.core.util.HttpCommandProvider;
import com.ecms.cums.core.util.MD5;
import com.ecms.cums.cores.Constants;

public class GuoLvUtils {

//	private static final Logger logger = LoggerFactory.getLogger(GuoLvUtils.class);
//
//	/**
//	 * @Title: getResultApiByParams
//	 * @Description: 通过appId，以及参数获取国旅返回结果
//	 * @param appId
//	 * @param paramStr
//	 * @return
//	 * @return: String
//	 */
//	public static Map<String,Object> getResultApiByParams(String appId,String paramStr){
//		Map<String,Object> result = new HashMap<String, Object>();
//		logger.info("获取国旅api接口【{}】",appId);
//		if(StringUtils.isBlank(paramStr)){
//			paramStr = Constants.noParam;
//		}else{
//			paramStr = GuolvDESUtil.encrypt(paramStr, Constants.guolv_secret_key);
//		}
//		logger.info("获取编码后参数结果【{}】",paramStr);
//		//组装用户请求头信息
//		JSONObject map = new JSONObject();
//		//Map<String,String> map = new HashMap<String,String>();
//		map.put("user", Constants.guolv_username);//用户名
//		map.put("apiId", appId);//接口名称
//		map.put("site", Constants.server_name);//站点名
//		map.put("deviceId", "");//设备ID
//		{
//			StringBuffer sb = new StringBuffer();
//			sb.append(Constants.guolv_secret_key);
//			sb.append(paramStr);
//			sb.append(Constants.guolv_username);
//			sb.append(Constants.server_name);
//			sb.append(appId);
//			sb.append("");
//			String md5 = MD5.crypt(sb.toString());
//			map.put("token", md5);
//		}
//
//		Map<String,String> params = new HashMap<String, String>();
//		params.put("requestHeader", map.toJSONString());
//		params.put("requestBody",paramStr);
//		HttpCommandProvider sp = new HttpCommandProvider();
//		String re = sp.httpSubmit(Constants.guolv_url, params);
//
//		JSONObject reJosnObj = JSONObject.parseObject(re);
//		String reBody = "";
//		if(reJosnObj.get("responseBody") != null){
//			reBody = GuolvDESUtil.decrypt((String) reJosnObj.get("responseBody"), Constants.guolv_secret_key);
//		}
//		String reHead = reJosnObj.get("responseHeader").toString();
//		result.put("responseHeader", reHead);
//		result.put("responseBody", reBody);
//		return result;
//	}
//
//	public static void main(String[] args) {
//		//无参
//		System.out.println(getResultApiByParams("getDomesticGroupDestArea",""));
//		//有参
//		JSONObject params = new JSONObject();
//		params.put("rowNum", "100");
//		System.out.println(params.toJSONString());
//		System.out.println(getResultApiByParams("getDomesticGroupHotDest",params.toJSONString()));
//	}
}
