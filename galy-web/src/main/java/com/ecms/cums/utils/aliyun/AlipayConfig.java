package com.ecms.cums.utils.aliyun;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 类名：AlipayConfig
 * 功能：基础配置类
 * 详细：设置帐户有关信息及返回路径
 * 修改日期：2017-04-05
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016093000629455";


    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYJhtG4/w9WGtA35+aFHYDomOBZfc4SFE3Rspkzy9+aG7FQ2a7A3A4uz1N8AlkrFMnJTmeZzlp1lwE8ksXaMTnWvh4lXOzJn34pBYOucrC10l2WOMxl73lYLUconmqQ2jgeBgcgzuvPChZI8/31s6h6C9wRCozqCZyZiYnpY9Ijo/hFEK4E6sHzxVG88AKZ0LPFgJnkybK0hiX8JHT3fnTW/ezMUCBVUn1r5DLmAzDJYSMrz+slfb5DJHZFDhSJ8/qPix4yXCOSsiLN8eF5eePGVS1/Mi2hhXsiDNSi+D8513tMBpG0iPSaME5IPs5NjG+bowyM0e8WDEdTf0ZLaaFAgMBAAECggEAYmLJ4raMpvKlMGcq4sz2X3VD2SohimChPBhnynZ7pMdNUfw60xXvHJBfnSVqPZJ9luOodbkUVE9MY9p2GmYiZeTapccm8SMj9IPOy6jy57mlhIUILUqNfmVh2GlsOWCr0fN2zAFEuBUzlijlU8OxDNuCyZsamxrR+cn6REr385dUq988KdLHpyjFVYC8NC2ElFecBBbiTcxl6khw1ZOUIMWsEpoS+t8K9p0MP/r+7m15N5kFRyMFzlsLkb0MltHCjPBEBIhDwZUwQyxBMs2x+B6x55zkTJcWdufHIZy8ajoioe1QF9mbyeE62UF6e8i4I/wkoh3YyyRGx3E6nwTqBQKBgQDTx72lL4z4rmN2tB6/OuYTTvTCWOhoRShAACzt83DepOlkqMP1IkbpXv8mC6qOt/tM4U9HbiUGjGX9ub1ypFViT5+47EktshapFKDLrenmqoWpPkWniXOnDH1mnfdrF9gK02ZwFtwzQe1rkIAUO5woewm40l1hK1VmjS3daXYNXwKBgQC36uXVsxuLGmIBclB7w5mcE8/8+hGV0lWMqCHnrX0ASTcZKtpIpCfplp9jldKFYvblx+jrd4GQRyUMOCy4f7kb9ZZef4SN7FUqp48P55N+heP0+z9UlfX7H26fV9yRixwvqM7wL7JbtLCV05BlAr27NnogqfVa8npFc4KwoEkymwKBgBmeeBqbffo3XmDluTJ49YwwaPt5teOnOg9D9ity35yPZox+vfXRh7KDg2oezyskponOV8DUWjZIla3z4i8UIiAacb/1FYUpngQmMq1xBHKa/kBTACocPplesWzQfzW9VK06lZHJsimhOA9jE5te+q0K9UoeaJ1wmIwnV/0I3PcRAoGBALXuQi6zvzJKBdrCdwUGx2QSYTMxN8YJy6CZDPj9r+JhioR11Hn5EJZL7h13rklOTUeeCjUrAVp0VhyRUQOtLLKQrI+L+tbdip3oJGeqP0fwMEA9bTdCJJKmVCqBomnCvz4R8aq8s+VthySepH6XSJHx4LuBBHlT1Unwar5HwECzAoGAA96sSbqCbaFVVOPu58+/wbFwKVzqn8hl8Z12D0TyOSFIxkU5xOho4Y9HFA2w0oKEmjc3oWG+Kv1OlA5seash3E64UCbwkbB+02w2npGZBsWWJ9ga2DX/0PQn8POYKbL0leTTnzIyypN0jCHA+NFc87iyCkYsR0Q9WsZmlhGgXYI=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2oT6APQwW2rzUgxcVLyJMZj2//EsXM3k+Y9mfr2QuFPW1xx1WIMjUEQKdy5jlRShc/xCN7C6BILuEBkXqJLCmfoqPCigwbj8soqCmiq4LSRlIn4I0Jaq0aG7UIT7gVlN7jWl8Zb3EZUErj6SDPMhkn1nM0Y8bFZLuR6KF9pVYjRpFwDNGK5v8+6XDcCPhmCZL7K3F8v/gEw9xQM4Y5wT6z25fimRo2gLCLX7zFMWN6AulU0bQJ5pspMRYG3hasnHUPX0vLvScnCiigkUq4Xbk15mMxaOan6uz3KH9QY6R9CV4uU9VPDM9cKTsScoBirTN+TurTC2a7mMXo+uOrgwLQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访
    public static String notify_url = "http://wztvhj.natappfree.cc/web/paycallback/alipay";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://39.97.196.174/redlotus-api/alipay/returnCallback";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
   // public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
    //支付宝网关-沙盒环境
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

