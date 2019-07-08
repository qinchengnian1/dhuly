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
    //public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCb9B0ZdW42JKlCHrj1hP8X7ouI9sDHbRYs6wWQSPyUJjo23knOhDPVaFWx7LW0V37D95ATn/zXjC7yrGIg8nD5WwRDtW+vXcls0BnV9RrHNjLXzeq/tpwRMoZiqSjZrSJYPzCtaPZqfTEHuNOOtgH5RP6XLwJxCKBjRPj4KVVwyKR281bHxFrLRU9XMzCvV2kkkAqa8+e8IeBhRplKWQHgXrOEIqGf8FWhYbAvi0T/g8fSRr8i2tVZzRQGjFld4AHdg3qKLtRYPuQWFOqEd9fsfqKHhVwr6dhutGgyzT/nuiOWnWwLeQoNfd2jxmcTSd+vK7MlmYnIJMAM/Kbs0sYTAgMBAAECggEAAi/XJJ8/72RuNy4lG9REm3pN3JrRMzq1X+Xfyxkq6Yzrrg9J66pw66It6XPPTHsZnPfgvlW0/vTJR7/hFGMx8F01XxmxOj1PcMYuRpDMUlTRO7N4gj22TItv1PxYRU0nOSORtCzPn8inolsWJF8rAerUwxv2pc0gKqQx9ZDm0NEJxOVQHi4EdYy5OLzAco8WRrc+2u6gJ1TTG1zGa1PyZy0yU7xGRxTI+UGpJAzM+sMKAICmo/h/Yl3JafkGnRj/xKaHGwo0Jm89bkJ6cw0cwBOLblTjKOzQCdVLW35TVXlm2UZYevKTiL6zirryVc45lhs4NikcRIRmfd7FbA53WQKBgQDt5qh1Gl7sI7zvAKla85AfZXLchhkxZrx7aqWA5RgZUd00KLXn3QLuw8j0MJP2chg4CGUjPBvjOVlcJC9UuZKUf2fwlb0ycsHQy+U6Orfhp5VlhIfWd588HLfKAPKPx4L+dA4sesnkXFZLNPlqV7utnrmTVEEdkZqIXwLzq+9tjQKBgQCn0XQa7Jesnbtqy4rlzbx4UlQtMj+HRLA0uEOPCPJtrPsW6ikH8FDVcZ2jSM08SgCotV1AW/uS5VlQ4fZX5d9ulFhVbUEcAhJsSn19KdZNaDTdxwKtl1QXi0c4TK9HuGKC0o7CaI4kfP9hAb8Kc4et7sstFTmpUn0fXoLzXwEKHwKBgC7ASFSS9Rp0v3k8aQudl7IDzrm1hJfnt5yNTa7x1nWLV+wbH/xLu3rOcNxD+5/PtiC0zaNJ+bUCnSP1XHPK8BpMm1F1K7QRRzNQDmEODvrCYyKLE+K6qUk334pL+17z9zMn/W0SSECfQLoQ0/7o9NHewltIkG9OIM8x1LOsEyY1AoGBAJI6BtIjD7JgKltPCjNdRnkNO726B/ME3gjB+lQa9qqsTIlV9fSt6LFjc3lAyVxcGyDmD2AyBg6ke2Pn0LAcY8jFyAZ/0XjnMUhcy+WQ2+PNBius6d96edKeEKu03hI/Ts8xSyWI1zpiFGBhliY0LqhW54Db+sdYUiBQSQho4s3/AoGBAJmr6QlwGmH6PfGxFqTMV4gqnLku1+FnjotptRfB3BNtntO581um6rNUCU8ANuyZ4kmwMGz0aAsj1d07iA9FtFvjeAVA522DG7eRT6uIyS6SoCw23G1uxBP5+fslkCXFQoJlJyVUn/pKoiGMRrB5Jv8qzQG4OvB62Mx9s+jfCoGv";
    // 正式
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCoUXRR/qJnmjDmoHA+DfMRNQX5HaE1nFnnLH2Ib+aPPMn4S4C0vk0PC7tIrpRMpueWeQkpfR3fBdQnmdZpLGfS6WZUV2CCIGE6nPBeP6repeg6LqlQ7kqS03OUO2oicD7lRy4KoOrlknjpxZpQKYMv1dYanzbfLiev2edGUu/M+l48MKvYNhA4G27q7S9mZwnGMQrirJ3ChNzkANkoTjFqIMDpUroj0Q+oeWB2jp+iwVrdOdlIjQEEakm8LmanzSL+8raNu2QIb9nj8ps5Y2SA/DOt67M/bNVrp2gjI+ISyHhW2oGnAWnCMuMmYDwb16K6j4DhuT2FlKIKzyYSA9RjAgMBAAECggEAEWHYEV+qheh2hFqtPLtUDsLbCw70RwUOg8EkdaKYvNIaSXoCoKfGbXdYr/jXd9MEt5VoTNCO9Sk076IDcnkTf8R6vNsJLGcLo3HxoMoSa0vW36tR8Pmq2d7cYMKCA2x0Ell3d8GGgI7PzdSKSxz+X0JGChnHIOUzVAW8zJZkDVbi3RnTTXNkJcNUWu7/be2rtnwc+BEpBhJmfTYBi+2GXC5MjoP8/5wSmkl6DYX8FaRQI5P06/DN9tA6Evg3G5cKsUlfddpLc2b6TzrFwDjzGCvTdQmTdolOUgtDDsO9ZyG7pPEu/ceFYG33nY9hQawXQKUjdXBzRBbwUuaZ8oNEAQKBgQDXbfyhX6Q4sT2kLCE+pI9IuIEnTN+n1bvisjFxp5hFdNxEPTMvQF94lF4XlR95bpvMMaTElWUW/WKGbv/67XqrvO/Id+UCCem6enhmg4cOjrpeN/bOjKABXCiLN7wf1kBjEUsa5g1ZN6BOrDocwyP/M61bGKPjjkOQ4wCZVeFlwwKBgQDIBDD/6EdXe7Cf13updbJ44JsueNJdvvZ/Wn2/yfmeIA+BB3zpxNcuI2KIxGITm5776cNcHg9U3CEl1A32x7TgP2/WgwKDXg3GNnLBTmuklH3qAUPaZ+CdxLGBwpmHuddCaMgkOIluC/WHVPeRFZ/vTOus80yzXTWqgR1YV8bM4QKBgH/9AFJ/l/l2k8Ct1zJ4Ygg6VcEbkuULvox4gZeckoLxYsvH8FjqTc49l4k7N2/Vnwo5lEKW33BBKf/kgoB6Bp9xqKPZV11Wtl3r1QxSqDKl6WOArEkakxU7w3qyqjnf+HDjHVPlyZhvy/XxrLTZ2tELyrqMcRIIu2ug8gInW7oxAoGBAIm2sRIRmMU4KZT0ZXV4zwgBBXeKwrS/HbLz2C7r3o0r3+DkCfJekBV5UYd/R1PeyykBe3v6Sm4QHlaQWYj3WacoplUY4OsYH/3AUWSdHOo1PziV5GUFLpcR7XG9Tb4wi3By+pJNxvnZDBVAwC/JptO5r27mGYJJhADAYzcHQJ6hAoGARgCZoqY0uD+mb7SAYCWQzgzvGyFrHeMe8DLAZoAUwElt2L3IgZF7+LqVWv66lWSgosCGZnVA0SUMbhgPQprIBi8BXMkjwd+7a1sVriF+y0SvEawWI/479RrV65qQMfOAVwaXtaj4C9IGSFocMzfHLaAXkB5v4993PJozUt2HNm4=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    //public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2oT6APQwW2rzUgxcVLyJMZj2//EsXM3k+Y9mfr2QuFPW1xx1WIMjUEQKdy5jlRShc/xCN7C6BILuEBkXqJLCmfoqPCigwbj8soqCmiq4LSRlIn4I0Jaq0aG7UIT7gVlN7jWl8Zb3EZUErj6SDPMhkn1nM0Y8bFZLuR6KF9pVYjRpFwDNGK5v8+6XDcCPhmCZL7K3F8v/gEw9xQM4Y5wT6z25fimRo2gLCLX7zFMWN6AulU0bQJ5pspMRYG3hasnHUPX0vLvScnCiigkUq4Xbk15mMxaOan6uz3KH9QY6R9CV4uU9VPDM9cKTsScoBirTN+TurTC2a7mMXo+uOrgwLQIDAQAB";
    // 正式
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiy9IAfL2jhpUSzQF0s8JrJcDUT7HHuxJCWbPLyAzspjXb74inTAFMP8LBrojPf/lr+RWJuHV122xPQxc682oXqjNNqeQeie+v7Ocl/UvEdjY5xYygtc5YUP01EaVow8+yQX1tsVfSMJC2ZfrlestLh5Nygqc+oEImKtN2Xt+VoLslWEbx2bgIT4WBWy6cRraVw8FuINjfCc/yQ4nF9NfpzhP6pducuUTybZkJJhhiJ9PVXnFze9OAhpunsOSZGTMTmPbvqe1rVJZhtaCVWunxlGd0olVsGP8di4TionZqezDiMEPNe2lncGnFCKPWmxAKDFSzC9xVjEQtHaEX2RvWwIDAQAB ";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访
   // public static String notify_url = "http://54sbgr.natappfree.cc/web/paycallback/alipay";
    public static String notify_url = "http://ly.5138fun.com/galy-web/paycallback/alipay";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://39.97.196.174/redlotus-api/alipay/returnCallback";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
    //支付宝网关-沙盒环境
    //public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关

}

