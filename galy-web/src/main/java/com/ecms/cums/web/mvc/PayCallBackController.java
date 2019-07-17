package com.ecms.cums.web.mvc;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.AlipaySignature;
import com.ecms.cums.logutils.FunOrderLog;
import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.model.Tourist;
import com.ecms.cums.services.OrderService;
import com.ecms.cums.services.PortService;
import com.ecms.cums.utils.account.AppKeyProperties;
import com.ecms.cums.utils.aliyun.AliPayService;
import com.ecms.cums.utils.aliyun.AlipayConfig;
import com.ecms.cums.utils.weixin.HttpProtocolUtils;
import com.ecms.cums.utils.weixin.WXPayService;
import com.ecms.cums.utils.weixin.WeixinConfig;
import com.ecms.cums.utils.weixin.XmlUtils;
import com.ecms.cums.web.vo.OrderStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付回调
 */
@RestController
@RequestMapping("/paycallback")
public class PayCallBackController {

    @Autowired
    private PortService portService;

    @RequestMapping("/webAppNotice")
    public void webAppNotice(@RequestParam Map<String, Object> map){
        String outTradeNo = map.get("out_trade_no") == null?"":map.get("out_trade_no").toString();
        if (StringUtils.isBlank(outTradeNo)){
            return;
        }
        OrderInfo orderInfo = portService.getOrderInfoByOrderNo(outTradeNo);
        if (orderInfo == null){
            return;
        }
        paySuccess(orderInfo);
    }



    @RequestMapping("/alipay")
    public String aliPayCallBack(HttpServletRequest request){
        Map requestMap = null;
        try {
            requestMap = AliPayService.reqIOToMap(request);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "FALL";
        }
        try {
            String orderId = (String) requestMap.get("passback_params");
            boolean flag = AlipaySignature.rsaCheckV1(requestMap, AlipayConfig.alipay_public_key, "UTF-8", "RSA2");
            if (flag) {
                OrderStatus status = "TRADE_SUCCESS".equals(requestMap.get("trade_status")) ? OrderStatus.PAY_SUCCESS : OrderStatus.PAY_FAILTURE;
                OrderInfo orderInfo = portService.selectOrderInfoByPrimaryKey(orderId);
                if (status == OrderStatus.PAY_SUCCESS) {
                    paySuccess(orderInfo);
                }
                return "SUCCESS";
            } else {
                return "FALL";
            }
        } catch (Exception var8) {
            FunOrderLog.logger.error("", var8);
            return "FALL";
        }
    }

    @RequestMapping("/weixinpay")
    public String weiXinPayCallBack(HttpServletRequest request) {
        HashMap rtnParams = new HashMap(2);
        try {
            String notifyParam = HttpProtocolUtils.parseInputStream(request);
            JSONObject params = new JSONObject(XmlUtils.xmlToObjMap(notifyParam));
            String orderId = params.getString("attach");
            if (StringUtils.isEmpty(orderId)) {
                rtnParams.put("return_code", "FALL");
                return WXPayService.mapToXml(rtnParams);
            } else {
                OrderInfo orderInfo = portService.selectOrderInfoByPrimaryKey(orderId);
                if (orderInfo == null) {
                    rtnParams.put("return_code", "FALL");
                    return WXPayService.mapToXml(rtnParams);
                } else {
                    String sign = params.getString("sign");
                    String oldSign = WXPayService.getSign(params, WeixinConfig.pay_app_key);
                    if (!StringUtils.isEmpty(sign) && !StringUtils.isEmpty(oldSign) && sign.equals(oldSign)) {
                        OrderStatus status = "SUCCESS".equals(params.getString("result_code")) ? OrderStatus.PAY_SUCCESS : OrderStatus.PAY_FAILTURE;
                        if (orderInfo == null) {
                            rtnParams.put("return_code", "FALL");
                            return WXPayService.mapToXml(rtnParams);
                        } else {
                            if (status == OrderStatus.PAY_SUCCESS) {
                                paySuccess(orderInfo);
                            }
                            rtnParams.put("return_code", "SUCCESS");
                            return WXPayService.mapToXml(rtnParams);
                        }
                    } else {
                        rtnParams.put("return_code", "FALL");
                        return WXPayService.mapToXml(rtnParams);
                    }
                }
            }
        } catch (Exception var11) {
            FunOrderLog.logger.error("接收微信支付异步通知失败", var11);
            rtnParams.put("return_code", "FALL");
            return WXPayService.mapToXml(rtnParams);
        }
    }

    // 订单成功修改状态
    private void paySuccess(OrderInfo orderInfo) {
        orderInfo.setStateLocal("3");
        orderInfo.setUpdateTime(new Date());
        portService.updateOrderInfo(orderInfo);
        //如果是本地订单并且支付成功 那么减去库存
        String teamId = orderInfo.getTeamId();
        if (!StringUtils.isBlank(teamId)) {
            List<Tourist> list = portService.selectOrderTouristInfoByOrderId(orderInfo.getOrderId());
            if (null != list && list.size() > 0) {
                Integer num = list.size();
                portService.updateTreamDetailLeftNumByPrimaryId(Integer.parseInt(teamId), num);
            }

        }
    }

}
