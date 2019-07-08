package com.ecms.cums.utils.aliyun;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.utils.account.AppKeyProperties;
import com.ecms.cums.utils.ResultUtil;
import com.ecms.cums.web.vo.BaseOrderInfo;
import com.ecms.cums.web.vo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 阿里支付
 */
public class AliPayService {
    private static ConcurrentHashMap<String, DefaultAlipayClient> aliClientContainer = new ConcurrentHashMap();

    public static Result<String> aliOrderReq(BaseOrderInfo order) {
        AlipayTradeWapPayResponse response;
        try {
            response =  getAliClient(order).sdkExecute(getAliOrder(order, order.getCallBackUrl()));
            if (response == null) {
                return new ResultUtil<String>().setErrorMsg("订单生成失败异常");
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return new ResultUtil<String>().setErrorMsg("订单生成失败异常");
        }
        return new ResultUtil<String>().setSuccessMsg(response.getBody());
    }

    private static AlipayTradeWapPayRequest getAliOrder(BaseOrderInfo order, String aliCallBackUrl) {
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        model.setSubject(order.getGoodsName());
        model.setOutTradeNo(order.getOrderNoLocal());
        model.setTotalAmount(String.valueOf(Float.parseFloat(order.getOnlinePrice()) / 100.0F));
        model.setProductCode("QUICK_MSECURITY_PAY");
        model.setPassbackParams(String.valueOf(order.getCallBackParam()));
        request.setBizModel(model);
        request.setNotifyUrl(aliCallBackUrl);
        return request;
    }

    public static void alipay(BaseOrderInfo order, HttpServletResponse response) throws AlipayApiException, IOException {
        //获得初始化的AlipayClie1nt
        AlipayClient alipayClient = getAliClient(order);
        //设置请求参数
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        // 设置异步通知地址
        alipayRequest.setNotifyUrl(order.getCallBackUrl());
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + order.getOrderNoLocal() + "\","
                + "\"total_amount\":\"" + (Float.parseFloat(order.getOnlinePrice()) / 100.0F) + "\","
                + "\"subject\":\"" + order.getGoodsName() + "\","
                + "\"passback_params\":\"" + order.getCallBackParam() + "\","
                + "\"product_code\":\"QUICK_WAP_PAY\"}");
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        response.setContentType("text/html;charset=" + AlipayConfig.charset);
        response.getWriter().write(result);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }

    private static DefaultAlipayClient getAliClient(BaseOrderInfo order) {
        if (!aliClientContainer.containsKey(order.getPayAppId())) {
            DefaultAlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,order.getPayAppId(),
                    order.getPayAppKey(), "json", AlipayConfig.charset, order.getPayAppAliKey(), "RSA2");
             aliClientContainer.putIfAbsent(order.getPayAppId(), alipayClient);
             return alipayClient;
        } else {
            return  aliClientContainer.get(order.getPayAppId());
        }
    }

    public static Map<String, String> reqIOToMap(HttpServletRequest request) throws UnsupportedEncodingException {
        Map<String, String> requestMap = new HashMap();
        Map requestParams = request.getParameterMap();
        Iterator iter = requestParams.keySet().iterator();

        while(iter.hasNext()) {
            String name = (String)iter.next();
            String[] values = ((String[])requestParams.get(name));
            String valueStr = "";

            for(int i = 0; i < values.length; ++i) {
                valueStr = i == values.length - 1 ? valueStr + values[i] : valueStr + values[i] + ",";
            }

            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
            requestMap.put(name, valueStr);
        }

        return requestMap;
    }

}
