package com.ecms.cums.web.vo;

import com.ecms.cums.utils.account.AppKeyProperties;
import com.ecms.cums.utils.aliyun.AlipayConfig;

import java.io.Serializable;

/**
 * 订单基类
 */
public class BaseOrderInfo implements Serializable{

    public BaseOrderInfo(String callBackUrl, String callBackParam, String orderNoLocal, String onlinePrice, Integer type, String goodsName){
        this.callBackUrl = callBackUrl;
        this.callBackParam = callBackParam;
        this.orderNoLocal = orderNoLocal;
        this.onlinePrice = onlinePrice;
        // 1微信支付
        if (type == 1){
            this.payAppId = AppKeyProperties.get("weixin.pay.appid");
            this.payAppKey = AppKeyProperties.get("weixin.pay.appkey");
            this.payMchId = AppKeyProperties.get("weixin.pay.mchid");
        } else {
            this.payAppId = AlipayConfig.app_id;
            this.payAppKey = AlipayConfig.merchant_private_key;
            this.payAppAliKey = AlipayConfig.alipay_public_key;
        }
        this.goodsName = goodsName;
    }

    public BaseOrderInfo() {
    }

    private String goodsName;

    private String orderNoLocal;

    private String callBackUrl;

    private String callBackParam;

    private String onlinePrice;

    private String payAppId;

    private String payAppKey;

    private String payMchId;

    private String payAppAliKey;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getOrderNoLocal() {
        return orderNoLocal;
    }

    public void setOrderNoLocal(String orderNoLocal) {
        this.orderNoLocal = orderNoLocal;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public String getCallBackParam() {
        return callBackParam;
    }

    public void setCallBackParam(String callBackParam) {
        this.callBackParam = callBackParam;
    }

    public String getOnlinePrice() {
        return onlinePrice;
    }

    public void setOnlinePrice(String onlinePrice) {
        this.onlinePrice = onlinePrice;
    }

    public String getPayAppId() {
        return payAppId;
    }

    public void setPayAppId(String payAppId) {
        this.payAppId = payAppId;
    }

    public String getPayAppKey() {
        return payAppKey;
    }

    public void setPayAppKey(String payAppKey) {
        this.payAppKey = payAppKey;
    }

    public String getPayMchId() {
        return payMchId;
    }

    public void setPayMchId(String payMchId) {
        this.payMchId = payMchId;
    }

    public String getPayAppAliKey() {
        return payAppAliKey;
    }

    public void setPayAppAliKey(String payAppAliKey) {
        this.payAppAliKey = payAppAliKey;
    }
}
