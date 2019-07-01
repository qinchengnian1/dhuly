package com.ecms.cums.utils.aliyun;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ecms.cums.utils.account.AppKeyProperties;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 阿里云短信服务
 * @author QinChengNian
 */
public class AliyunDysmsUtils {
    public static final String product = "Dysmsapi";
    public static final String domain = "dysmsapi.aliyuncs.com";
    public static final String DEFAULT = "";
    public static String accessKeyId= AppKeyProperties.get("aliyun.accessKeyId");
    public static String accessKeySecret=AppKeyProperties.get("aliyun.accessKeySecret");
    public static String signName = AppKeyProperties.get("aliyun.signName");
    public static String Login_TemplateCode = AppKeyProperties.get("aliyun.templatecode");

    public static boolean send(String phone, String code) {
        String host = "https://cxcdx.market.alicloudapi.com";
        String path = "/cdcxlongsms/dxjk";
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE afaebe5544bc41ccb3bc86aa6debd216");
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("content", "【豆会玩】您的验证码是："+code+"，2分钟内有效！如非本人操作，请忽略本短信");
        querys.put("mobile", phone);
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public AliyunDysmsUtils() {
    }


    public static String generalCode(int length) {
        return RandomStringUtils.random(length, "0123456789");
    }

    public static String generalCode() {
        return generalCode(6);
    }

    public static String sendSms(long phone, String templateCode, String templateParam, String appId) {
        try {
            System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
            IAcsClient acsClient = new DefaultAcsClient(profile);
            SendSmsRequest request = new SendSmsRequest();
            request.setPhoneNumbers(String.valueOf(phone));
            request.setTemplateCode(templateCode);
            request.setSignName(signName);
            // 根据来源发送短信
//            if (DEFAULT.equals(appId)) {
//                request.setSignName(current.signName);
//            } else if (DEFAULT.equals(appId)) {
//                request.setSignName(current.signName);
//            }
            request.setTemplateParam(templateParam);
            SendSmsResponse resp = acsClient.getAcsResponse(request);
            return resp.getCode();
        } catch (ClientException var9) {
            return "";
        }
    }

}
