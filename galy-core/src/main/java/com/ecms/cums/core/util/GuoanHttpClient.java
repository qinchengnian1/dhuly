package com.ecms.cums.core.util;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.ecms.cums.core.util.Base64;
import com.ecms.cums.core.util.MD5;
import com.ecms.cums.cores.Constants;

/**
 * 国安HTTP请求客户端
 *
 * @author sea
 *
 */
/*public class GuoanHttpClient {

	private static final String CHARSET = "UTF-8";
	private static Logger logger = Logger.getLogger(GuoanHttpClient.class);
	private static String className = GuoanHttpClient.class.getName();

	*//**
	 * 发送数据到国安
	 *
	 * @param url
	 *            请求的URL
	 * @param datas
	 *            请求的数据
	 * @param isNeedToken
	 *            是否需要Token
	 * @param token
	 *            令牌
	 * @param appId
	 *            平台提供的appId
	 * @param secretKey
	 *            平台提供的秘钥
	 * @return 返回的JSON数据
	 *//*
	public static String postData(String url, String params,String token,String shoreId) {
		HttpPost httpPost = new HttpPost(url);
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				  .setSocketTimeout(5000)
				  .setConnectTimeout(5000)
				  .setConnectionRequestTimeout(5000)
				  .build();
		CloseableHttpClient client = HttpClients.custom()
			    .setDefaultRequestConfig(defaultRequestConfig).build();
		CloseableHttpResponse response = null;
		try {
			String bodyData = Base64.encode(params);
			String md5Content = MD5.crypt(bodyData + Constants.pt_secret_key);
			logger.info(className + "---->>postDataNew发送请求, dataJson=" + params
					+ ", base64Encoder=" + bodyData + ", md5Content=" + md5Content + ", url=" + url);
			createHeader(httpPost, md5Content,token,shoreId);
			HttpEntity sendEntity = new StringEntity(bodyData, CHARSET);
			httpPost.setEntity(sendEntity);
			response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return EntityUtils.toString(entity, CHARSET);
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					response = null;
				}
			}
		}
		return null;
	}

	*//**
	 * 创建报文头
	 *
	 * @param httpPost
	 * @param sendBody
	 * @param isNeedToken
	 * @param token
	 *//*
	private static void createHeader(HttpPost httpPost, String md5Content,String token,String shoreId) {
		try {
			if(!StringUtils.isBlank(token)){
				httpPost.setHeader("token", token);
			}
			httpPost.setHeader("Content-Type", "text/plain; charset=UTF-8");
			httpPost.setHeader("md5", md5Content);
			httpPost.setHeader("appId", Constants.pt_appId);
			httpPost.setHeader("appTypePlatform","customer_travel");
			if(!StringUtils.isBlank(shoreId)){
				httpPost.setHeader("storeId",shoreId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	public static void main(String[] args) {
		String pTResult = postData("https://gasq-web-employee.guoanshequ.com/gasq-web-employee/employee/listbystore","","customer_app_635b5da5541283e658903038b6889957","00000000000000000000000000000034");
		System.out.println(pTResult);
	}
}*/
