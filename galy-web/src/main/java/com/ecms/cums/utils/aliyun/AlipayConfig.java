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
    //public static String app_id = "2016091600527415";
    // 正式
    public static String app_id = "2019062465629939";
    // 商户私钥，您的PKCS8格式RSA2私钥
    //public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCb9B0ZdW42JKlCHrj1hP8X7ouI9sDHbRYs6wWQSPyUJjo23knOhDPVaFWx7LW0V37D95ATn/zXjC7yrGIg8nD5WwRDtW+vXcls0BnV9RrHNjLXzeq/tpwRMoZiqSjZrSJYPzCtaPZqfTEHuNOOtgH5RP6XLwJxCKBjRPj4KVVwyKR281bHxFrLRU9XMzCvV2kkkAqa8+e8IeBhRplKWQHgXrOEIqGf8FWhYbAvi0T/g8fSRr8i2tVZzRQGjFld4AHdg3qKLtRYPuQWFOqEd9fsfqKHhVwr6dhutGgyzT/nuiOWnWwLeQoNfd2jxmcTSd+vK7MlmYnIJMAM/Kbs0sYTAgMBAAECggEAAi/XJJ8/72RuNy4lG9REm3pN3JrRMzq1X+Xfyxkq6Yzrrg9J66pw66It6XPPTHsZnPfgvlW0/vTJR7/hFGMx8F01XxmxOj1PcMYuRpDMUlTRO7N4gj22TItv1PxYRU0nOSORtCzPn8inolsWJF8rAerUwxv2pc0gKqQx9ZDm0NEJxOVQHi4EdYy5OLzAco8WRrc+2u6gJ1TTG1zGa1PyZy0yU7xGRxTI+UGpJAzM+sMKAICmo/h/Yl3JafkGnRj/xKaHGwo0Jm89bkJ6cw0cwBOLblTjKOzQCdVLW35TVXlm2UZYevKTiL6zirryVc45lhs4NikcRIRmfd7FbA53WQKBgQDt5qh1Gl7sI7zvAKla85AfZXLchhkxZrx7aqWA5RgZUd00KLXn3QLuw8j0MJP2chg4CGUjPBvjOVlcJC9UuZKUf2fwlb0ycsHQy+U6Orfhp5VlhIfWd588HLfKAPKPx4L+dA4sesnkXFZLNPlqV7utnrmTVEEdkZqIXwLzq+9tjQKBgQCn0XQa7Jesnbtqy4rlzbx4UlQtMj+HRLA0uEOPCPJtrPsW6ikH8FDVcZ2jSM08SgCotV1AW/uS5VlQ4fZX5d9ulFhVbUEcAhJsSn19KdZNaDTdxwKtl1QXi0c4TK9HuGKC0o7CaI4kfP9hAb8Kc4et7sstFTmpUn0fXoLzXwEKHwKBgC7ASFSS9Rp0v3k8aQudl7IDzrm1hJfnt5yNTa7x1nWLV+wbH/xLu3rOcNxD+5/PtiC0zaNJ+bUCnSP1XHPK8BpMm1F1K7QRRzNQDmEODvrCYyKLE+K6qUk334pL+17z9zMn/W0SSECfQLoQ0/7o9NHewltIkG9OIM8x1LOsEyY1AoGBAJI6BtIjD7JgKltPCjNdRnkNO726B/ME3gjB+lQa9qqsTIlV9fSt6LFjc3lAyVxcGyDmD2AyBg6ke2Pn0LAcY8jFyAZ/0XjnMUhcy+WQ2+PNBius6d96edKeEKu03hI/Ts8xSyWI1zpiFGBhliY0LqhW54Db+sdYUiBQSQho4s3/AoGBAJmr6QlwGmH6PfGxFqTMV4gqnLku1+FnjotptRfB3BNtntO581um6rNUCU8ANuyZ4kmwMGz0aAsj1d07iA9FtFvjeAVA522DG7eRT6uIyS6SoCw23G1uxBP5+fslkCXFQoJlJyVUn/pKoiGMRrB5Jv8qzQG4OvB62Mx9s+jfCoGv";    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    // 正式
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCx4MSh4taAdZqxZRKVHR9zuJDphjFhEZN1JVGPS4hIzLTopHa0yAz1lBiZ1xu45RX2F/Ghk5/iftcM9j2zZ/EpKHz3VLqYKqg083WChfoYTFpL50K4VwIVab3Ck/mi4pxXGA83Pr0Qanr7umfsmEnlElYyIB2881R7Gcupul8dJG5Xq7ZlAOadqb5qyUzA/TUf133GBUsaByB6NppYeQOHxP1hGYeWoVVQfhSFf+sRlBYlpMGAI9fOuQXBI0cWA9turKdGeyNgWWv1JfAhosymPCt3lixVNAZk8gY43OpjB9xewKGHxQvGkbq3tN7rV5sGMsgkMwz1mxyANTJGyMeDAgMBAAECggEAXodgd9egvqvBBbz83xmW+VyARln2K+u3PW4Tpd8yEd4X1fpwyyn1GR0W5cqXBO9ZeGrJEmDteuSFTHIf4BPA6WqG3rm8X9lrgphPPooMmpUY93Vy05wJk2+aVKlm5NUg2HgEvgstVmf/637oc6eKvZ29CO5gX2XA45qVzSEqIsWxJWWPqm7ypg1kzIMstiSyvpKHD3t86sreYWldS9M2dRrJW4L3613FTc/xq/a3RjrtTKztFAKomCjesV+rs/IzqIZGH27SzaHdUf5vfEN8UMUp4oJ2yprbVKlG5UQ4Zhlutur6TIENttopNfOYW+VwWVRfXUXtx39U+PJlyeBJYQKBgQDwSqW3UYU/0pPQWVO/eHBbq+turz18yZ9iVJ8vYFbpZCSws1sNC45ZzdYUtytsi9q+IPJai3+exue3rg2WztKyzrFyhHIcMjcvjFOCAQ90SAEzIHxgq+BoqVvbSocOgplMN5VjFWM3Vgopcu6f+0KRqn119juxbIRl/3y/GzUb3QKBgQC9gZxCpB6s9dXXxItydZzO2B0POKHnfpjGq9dYs73EV8aIb3CKBVBPMMN20w+VGIog1ZvHiHmOevkYBJKFHouDR45uFB4fOjaAW5BLh/WSYCj07prUak6LelcEKTQ2EFfUZEDJUIQnlov6LD9dFAbzjSCLLV5jSXwdnL6xPCxq3wKBgD1c0rTdvIlv3Q93wEtFFmxSmuzJE4qqcmlJ8tzGXWt8h2IYa0gJi3Cjf+gKXqx5ioLDJyC4Pv7tDH97kzzP1D6VSftUl09cA3vA+hJY8vle6e+EfD6zpbsUhMCbZ6Hs9/jeuOd0rsGS10V+dDGmmHlacG+PUe8dJzJk7BZhfE6BAoGAHXrTJx7G0tsvV/BwTO705MyDwMFrlkqAU6+ZwWe8ppWNAd5sIFxxQNByJ8Lvkp8Npcv0/tZBKqQAqfbUIDc/Nr3j70Xb5bm1jsQvr0BIOGwTEv8nQNIEw/fVH4WVZK+oKhcqaObImCv4PIOzm7Qo3KxgmqYFH+bnkue2VnXo5vsCgYAoIqqo4RSpiGHdCF0vnF+OH9BWTl6nZUIEvgdxZIVqgZ1AwLblot7UMSU8h4ejD5NqakEOY7aZvt0Rqi1+foq0tgGyF9gv0SOft/3LjYjmCXMlgUrdHGgHsq99ko4GIF3klYay7yCVF+8IS73iEtCyOLhcIOV9rqilF8u4wJYsTQ==";
    //public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2oT6APQwW2rzUgxcVLyJMZj2//EsXM3k+Y9mfr2QuFPW1xx1WIMjUEQKdy5jlRShc/xCN7C6BILuEBkXqJLCmfoqPCigwbj8soqCmiq4LSRlIn4I0Jaq0aG7UIT7gVlN7jWl8Zb3EZUErj6SDPMhkn1nM0Y8bFZLuR6KF9pVYjRpFwDNGK5v8+6XDcCPhmCZL7K3F8v/gEw9xQM4Y5wT6z25fimRo2gLCLX7zFMWN6AulU0bQJ5pspMRYG3hasnHUPX0vLvScnCiigkUq4Xbk15mMxaOan6uz3KH9QY6R9CV4uU9VPDM9cKTsScoBirTN+TurTC2a7mMXo+uOrgwLQIDAQAB";
    // 正式
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiy9IAfL2jhpUSzQF0s8JrJcDUT7HHuxJCWbPLyAzspjXb74inTAFMP8LBrojPf/lr+RWJuHV122xPQxc682oXqjNNqeQeie+v7Ocl/UvEdjY5xYygtc5YUP01EaVow8+yQX1tsVfSMJC2ZfrlestLh5Nygqc+oEImKtN2Xt+VoLslWEbx2bgIT4WBWy6cRraVw8FuINjfCc/yQ4nF9NfpzhP6pducuUTybZkJJhhiJ9PVXnFze9OAhpunsOSZGTMTmPbvqe1rVJZhtaCVWunxlGd0olVsGP8di4TionZqezDiMEPNe2lncGnFCKPWmxAKDFSzC9xVjEQtHaEX2RvWwIDAQAB ";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访
    public static String notify_url = "http://wztvhj.natappfree.cc/web/paycallback/alipay";
//    public static String notify_url = "http://ly.5138fun.com/galy-web/paycallback/alipay";

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

}

