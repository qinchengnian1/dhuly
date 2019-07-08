package com.ecms.cums.utils.weixin;

import com.ecms.cums.logutils.FunOrderLog;
import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.utils.HttpUtils;
import com.ecms.cums.utils.ResultUtil;
import com.ecms.cums.utils.account.AppKeyProperties;
import com.ecms.cums.web.vo.BaseOrderInfo;
import com.ecms.cums.web.vo.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 微信支付
 */
public class WXPayService {

    public static Result<Object> unifiedorder(BaseOrderInfo order, String xmlParam) {
        try {
            String prepayResult = HttpUtils.sendHttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder", xmlParam);
            Map<String, String> params = XmlUtils.xmlToStringMap(prepayResult);
            String retuen_code = params.get("return_code");
            if (retuen_code != null && "SUCCESS".equals(retuen_code)) {
                String result_code = params.get("result_code");
                if (result_code != null && "SUCCESS".equals(result_code)) {
                    return new ResultUtil<>().setData(buildAppPrepayInfoMap(params.get("prepay_id")));
                } else {
                    FunOrderLog.logger.error("预支付交易失败, 错误码=" + (String)params.get("err_code") + ", 错误描述=" + (String)params.get("err_code_des") + ", 订单=" + order);
                    return new ResultUtil<>().setErrorMsg(String.format("错误码=%s, 错误描述=%s", params.get("err_code"), params.get("err_code_des")));
                }
            } else {
                FunOrderLog.logger.error("预支付通信失败, 返回状态码: " + new String(((String)params.get("return_msg")).getBytes("ISO-8859-1"), "UTF-8") + ", 订单 = " + order);
                return new ResultUtil<>().setErrorMsg("预支付通信失败");
            }
        } catch (Exception var8) {
            FunOrderLog.logger.error("统一订单请求出错,订单=" + order, var8);
            return new ResultUtil<>().setErrorMsg("出现异常");
        }
    }

    private static Map<String, Object> buildAppPrepayInfoMap(String prepayid) {
        Map<String, Object> keyValues = new HashMap();
        keyValues.put("appid", AppKeyProperties.get("weixin.pay.appid"));
        keyValues.put("partnerid", AppKeyProperties.get("weixin.pay.mchid"));
        keyValues.put("prepayid", prepayid);
        keyValues.put("package", "Sign=WXPay");
        keyValues.put("noncestr", generateRandomStr());
        keyValues.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
        keyValues.put("sign", getSign(keyValues, AppKeyProperties.get("weixin.pay.appkey")));
        return keyValues;
    }

    public static Map<String, Object> buildAppAuthInfoMap(BaseOrderInfo order, String remoteIp) throws UnsupportedEncodingException {
        Map<String, Object> keyValues = new HashMap();
        keyValues.put("appid", order.getPayAppId());
        keyValues.put("mch_id", order.getPayMchId());
        keyValues.put("nonce_str", generateRandomStr());
        keyValues.put("body", order.getGoodsName());
        keyValues.put("out_trade_no", order.getOrderNoLocal());
        keyValues.put("total_fee", order.getOnlinePrice());
        keyValues.put("spbill_create_ip", remoteIp);
        keyValues.put("notify_url", order.getCallBackUrl());
        keyValues.put("trade_type", "MWEB");
        keyValues.put("attach", order.getCallBackParam());
        keyValues.put("sign", getSign(keyValues, order.getPayAppKey()));
        return keyValues;
    }

    private static String generateRandomStr() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }

    public static String getSign(Map<String, Object> map, String signKey) {
        map.remove("sign");
        List<String> keys = new ArrayList(map.keySet());
        Collections.sort(keys);
        StringBuilder authInfo = new StringBuilder();

        for(int i = 0; i < keys.size(); ++i) {
            String key = keys.get(i);
            String value = String.valueOf(map.get(key));
            authInfo.append(buildKeyValue(key, value, false));
            authInfo.append("&");
        }

        authInfo.append(buildKeyValue("key", signKey, false));
        return MD5.encode(authInfo.toString()).toUpperCase();
    }

    private static String buildKeyValue(String key, String value, boolean isEncode) {
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append("=");
        if (isEncode) {
            try {
                sb.append(URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException var6) {
                sb.append(value);
            }
        } else {
            sb.append(value);
        }

        return sb.toString();
    }

    public static String mapToXml(Map<String, Object> params) {
        List<String> keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        Iterator var4 = keys.iterator();

        while(var4.hasNext()) {
            String key = (String)var4.next();
            sb.append("<" + key + ">");
            sb.append("<![CDATA[" + params.get(key) + "]]>");
            sb.append("</" + key + ">");
        }

        sb.append("</xml>");
        return sb.toString().trim();
    }

}
