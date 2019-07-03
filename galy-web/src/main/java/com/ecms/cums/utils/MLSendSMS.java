package com.ecms.cums.utils;

import com.alipay.api.DefaultAlipayClient;
import com.ecms.cums.utils.account.AppKeyProperties;
import com.ecms.cums.utils.weixin.MD5;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author QinChengNian
 * 美lian发送短信
 */
public class MLSendSMS {

    private static ConcurrentHashMap<String, String> sendMap = new ConcurrentHashMap();
    public static void main(String[] args) {
        //连接超时及读取超时设置
        System.setProperty("sun.net.client.defaultConnectTimeout", "30000"); //连接超时：30秒
        System.setProperty("sun.net.client.defaultReadTimeout", "30000");    //读取超时：30秒
        //新建一个StringBuffer链接
        StringBuffer buffer = new StringBuffer();
        //String encode = "GBK"; //页面编码和短信内容编码为GBK。重要说明：如提交短信后收到乱码，请将GBK改为UTF-8测试。如本程序页面为编码格式为：ASCII/GB2312/GBK则该处为GBK。如本页面编码为UTF-8或需要支持繁体，阿拉伯文等Unicode，请将此处写为：UTF-8
        String code = "12312";
        String encode = "UTF-8";
        String username = "lccs";  //用户名
        String password_md5 = MD5.encode("meilian1234");  //密码
        String mobile = "15810814521";  //手机号,只发一个号码：13800000001。发多个号码：13800000001,13800000002,...N 。使用半角逗号分隔。
        String apikey = "422585bff47038529128d5d42cb9aa0a";  //apikey秘钥（请登录 http://m.5c.com.cn 短信平台-->账号管理-->我的信息 中复制apikey）
        String content = "【豆会玩】您的验证码是：" + code + "，2分钟内有效！如非本人操作，请忽略本短信";  //要发送的短信内容，特别注意：签名必须设置，网页验证码应用需要加添加【图形识别码】。
        try {
            String contentUrlEncode = URLEncoder.encode(content, encode);  //对短信内容做Urlencode编码操作。注意：如
            //把发送链接存入buffer中，如连接超时，可能是您服务器不支持域名解析，请将下面连接中的：【m.5c.com.cn】修改为IP：【115.28.23.78】
            buffer.append("http://m.5c.com.cn/api/send/index.php?username=" + username + "&password_md5=" + password_md5 + "&mobile=" + mobile + "&apikey=" + apikey + "&content=" + contentUrlEncode + "&encode=" + encode);
            //System.out.println(buffer); //调试功能，输入完整的请求URL地址
            //把buffer链接存入新建的URL中
            URL url = new URL(buffer.toString());
            //打开URL链接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //使用POST方式发送
            connection.setRequestMethod("POST");
            //使用长链接方式
            connection.setRequestProperty("Connection", "Keep-Alive");
            //发送短信内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            //获取返回值
            String result = reader.readLine();

            //输出result内容，查看返回值，成功为success，错误为error，详见该文档起始注释
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean sendSMS(String phone, String code){
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(code)){
            return false;
        }
        try {
            // 构造短信发送
            if (!sendMap.containsKey("username")){
                sendMap.put("username", AppKeyProperties.get("meilian.username"));
                sendMap.put("password_md5", MD5.encode(AppKeyProperties.get("meilian.password")));
                sendMap.put("apikey", AppKeyProperties.get("meilian.apikey"));
                sendMap.put("encode","UTF-8");
            }
            sendMap.put("mobile", phone);
            String content = "【豆会玩】您的验证码是：" + code + "，2分钟内有效！如非本人操作，请忽略本短信";  //要发送的短信内容，特别注意：签名必须设置，网页验证码应用需要加添加【图形识别码】。
            String contentUrlEncode = URLEncoder.encode(content, "UTF-8");  //对短信内容做Urlencode编码操作。注意：如
            sendMap.put("content", contentUrlEncode);
            HttpUtils.sendHttpPost(AppKeyProperties.get("meilian.url"), sendMap);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
