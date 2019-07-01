package com.ecms.cums.utils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * httpClient
 */
public final class HttpUtils {
    public HttpUtils() {
    }

    public static String sendHttpGet(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            String var6 = entity != null ? EntityUtils.toString(entity) : null;
            return var6;
        } catch (Exception var14) {
        } finally {
            try {
                httpclient.close();
            } catch (IOException var13) {
            }

        }

        return null;
    }

    public static String sendHttpGet(String url, Map<String, String> headers) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpGet httpget = new HttpGet(url);
            setHeader(httpget, headers);
            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            String var7 = entity != null ? EntityUtils.toString(entity) : null;
            return var7;
        } catch (Exception var15) {
        } finally {
            try {
                httpclient.close();
            } catch (IOException var14) {
            }

        }

        return null;
    }

    public static String sendHttpPost(String url, Map<String, String> headers, Map<String, String> params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpPost httppost = new HttpPost(url);
            setHeader(httppost, headers);
            List<NameValuePair> bodys = new ArrayList();
            if (params != null) {
                Iterator var7 = params.entrySet().iterator();

                while(var7.hasNext()) {
                    Entry<String, String> entry = (Entry)var7.next();
                    bodys.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
                }
            }

            httppost.setEntity(new UrlEncodedFormEntity(bodys, Charset.forName("UTF-8")));
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            String var9 = entity != null ? EntityUtils.toString(entity) : null;
            return var9;
        } catch (Exception var17) {
        } finally {
            try {
                httpclient.close();
            } catch (IOException var16) {
            }

        }

        return null;
    }

    public static String sendHttpPost(String url, Map<String, String> params) {
        return sendHttpPost(url, (Map)null, (Map)params);
    }

    public static String sendHttpPost(String url, String params) {
        return sendHttpPost(url, params.getBytes(Charset.forName("UTF-8")));
    }

    public static String sendHttpPost(String url, byte[] params) {
        return sendHttpPost(url, (Map)null, (byte[])params);
    }

    public static String sendHttpPost(String url, Map<String, String> headers, byte[] params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpPost httppost = new HttpPost(url);
            httppost.setEntity(new ByteArrayEntity(params));
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            String var8 = entity != null ? EntityUtils.toString(entity) : null;
            return var8;
        } catch (Exception var16) {
        } finally {
            try {
                httpclient.close();
            } catch (IOException var15) {
            }

        }

        return null;
    }

    //
    public static void setHeader(AbstractHttpMessage httpMessage, Map<String, String> headers){
        if (headers != null) {
            Iterator var6 = headers.entrySet().iterator();
            while(var6.hasNext()) {
                Entry<String, String> entry = (Entry)var6.next();
                httpMessage.setHeader((String)entry.getKey(), (String)entry.getValue());
            }
        }
    }

}