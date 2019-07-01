package com.ecms.cums.core.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpCommandProvider {

    private static final Logger logger = LoggerFactory.getLogger(HttpCommandProvider.class);

	private String methodType = "GET";

	private String encoding = "UTF-8";

	private Map<String, String> headParams = new HashMap<String, String>();

	private Map<String, String> params = new HashMap<String, String>();

	private String requestBody;

	private String url;

	private Boolean https;

	private int responseCode = -1;

	private String responseContent;




	public String send() {
		if ("POST".equalsIgnoreCase(this.methodType)) {
			responseContent = post();
		} else if ("GET".equalsIgnoreCase(this.methodType)) {
			responseContent = get();
		}
		return responseContent;
	}

	/**
	 *  post 请求
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private String post() {
		logger.info("used request url : " + url);
		PostMethod method = new PostMethod(this.url);
		method.addRequestHeader("Connection", "close");
		addHeadParams(method);

		if (null != params && params.size() > 1) {
			Iterator<String> paramsIT = params.keySet().iterator();
			NameValuePair[] nameValuePairs= new NameValuePair[params.size()];
			int i = 0;
			while (paramsIT.hasNext()) {
				String key = paramsIT.next();
				String value = params.get(key);
				/*logger.info("request param [ key : " + key + " ;value : "
						+ value + " ;]");*/
				method.addRequestHeader(key, value);

				NameValuePair nameValuePair = new NameValuePair();
				nameValuePair.setName(key);
				nameValuePair.setValue(value);
				nameValuePairs[i++] = nameValuePair;
			}
			method.addParameters(nameValuePairs);
		}

		if (null != requestBody && !"".equals(requestBody.trim())) {
			//logger.info("request body : " + requestBody);
			method.setRequestBody(requestBody);
			method.setRequestContentLength(requestBody.length());
		}
        method.getParams().setContentCharset(this.encoding);

		try {
			return executeMethod(method);
		} catch (Exception e) {
			logger.error("POST request error : ",e);
			return null;
		}
	}

	/**
	 *get 方式
	 * @return
	 */
	private String get() {
		//logger.info("used request url : " + url);
		GetMethod method = new GetMethod(this.url);
		method.addRequestHeader("Connection", "close");
		addHeadParams(method);
		try {
			return executeMethod(method);
		} catch (Exception e) {
			logger.error("GET request error : ",e);
			return null;
		}
	}


	private String executeMethod(HttpMethod method) throws HttpException,
			IOException {
		try {
			HttpClient httpClient = new HttpClient();
			httpClient.executeMethod(method);
			this.responseCode = method.getStatusCode();
			//logger.info("response code : " + responseCode);
			//logger.info("response encoding : "+encoding);
			String result =new String( IOUtils.toString(method.getResponseBodyAsStream(),this.encoding));
			//logger.info("response content : "+result);
			return result;
		} catch (HttpException he) {
			throw he;
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			method.releaseConnection();
		}
	}


	private void addHeadParams(HttpMethod method) {
		if (null != headParams && headParams.size() > 1) {
			Iterator<String> headParamIT = headParams.keySet().iterator();
			while (headParamIT.hasNext()) {
				String key = headParamIT.next();
				String value = headParams.get(key);
				//logger.info("request head param [ key : " + key + " ;value : "
				//		+ value + " ;]");
				method.addRequestHeader(key, value);
			}
		}
	}


	public HttpCommandProvider setPostMethod() {
		this.methodType = "POST";
		return this;
	}


	public HttpCommandProvider setGetMethod() {
		this.methodType = "GET";
		return this;
	}

	public HttpCommandProvider setHeadParams(Map<String, String> headParams) {
		this.headParams = headParams;
		return this;
	}


	public HttpCommandProvider setParams(Map<String, String> params) {
		this.params = params;
		return this;
	}


	public HttpCommandProvider addParam(String key, String value) {
		if (null == this.params)
			params = new HashMap<String, String>();
		params.put(key, value);
		return this;
	}


	public HttpCommandProvider addHeadParam(String key, String value) {
		if (null == this.headParams)
			this.headParams = new HashMap<String, String>();
		this.headParams.put(key, value);
		return this;
	}


	public HttpCommandProvider setEncoding(String encoding) {
		this.encoding = encoding;
		return this;
	}


	public HttpCommandProvider setRequestBody(String requestBody) {
		this.requestBody = requestBody;
		return this;
	}


	public HttpCommandProvider setUrl(String url) {
		this.url = url;
		return this;
	}

	public HttpCommandProvider setHttps(boolean b){
		if(b){
			Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);
			Protocol.registerProtocol("https", myhttps);
		}
		this.https = b;
		return this;
	}
	// =====================================//
	public String getMethodType() {
		return methodType;
	}

	public String getEncoding() {
		return encoding;
	}

	public String getUrl() {
		return url;
	}

	public String httpAirport(String url,String jsonParams){
		HttpPost httpPost = new HttpPost(url);
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				  .setSocketTimeout(50000)
				  .setConnectTimeout(50000)
				  .setConnectionRequestTimeout(50000)
				  .build();
		CloseableHttpClient client = HttpClients.custom()
			    .setDefaultRequestConfig(defaultRequestConfig).build();
		CloseableHttpResponse response = null;
		try {
			HttpEntity sendEntity = new StringEntity(jsonParams, "UTF-8");
			httpPost.setEntity(sendEntity);

			response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return EntityUtils.toString(entity, "UTF-8");
			}
		} catch (IOException e) {
			e.printStackTrace();
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

	public String httpSubmit(String url,Map<String,String> map){
		 String result = "";
		 HttpClient httpClient = new HttpClient();
		 PostMethod postMethod = new PostMethod(url);
		 NameValuePair[] data = {
		    new NameValuePair("requestBody", map.get("requestBody")),
		    new NameValuePair("requestHeader", map.get("requestHeader")),
		 };
		 postMethod.setRequestBody(data);
		 try {
			 httpClient.executeMethod(postMethod);
			 result = postMethod.getResponseBodyAsString();
			 postMethod.releaseConnection();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("发送请求国旅接口异常");
		}

		return result;
	}


}

