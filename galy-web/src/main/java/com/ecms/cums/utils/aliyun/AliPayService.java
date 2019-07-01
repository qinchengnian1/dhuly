package com.ecms.cums.utils.aliyun;

import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.utils.account.AppKeyProperties;
import com.ecms.cums.utils.ResultUtil;
import com.ecms.cums.web.vo.BaseOrderInfo;
import com.ecms.cums.web.vo.Result;

import javax.servlet.http.HttpServletRequest;
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
        AlipayTradeAppPayResponse response;
        try {
            response =  getAliClient(order).sdkExecute(getAliOrder(order, order.getCallBackUrl()));
            if (response == null) {
                return new ResultUtil<String>().setErrorMsg("订单生成失败异常");
            }
        } catch (Exception var5) {
            return new ResultUtil<String>().setErrorMsg("订单生成失败异常");
        }
        return new ResultUtil<String>().setSuccessMsg(response.getBody());
    }

    private static AlipayTradeAppPayRequest getAliOrder(BaseOrderInfo order, String aliCallBackUrl) {
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(order.getGoodsName());
        model.setSubject(order.getGoodsName());
        model.setOutTradeNo(order.getOrderNoLocal());
        model.setTotalAmount(String.valueOf(Float.parseFloat(order.getOnlinePrice()) / 100.0F));
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        model.setPassbackParams(String.valueOf(order.getCallBackParam()));
        request.setNotifyUrl(aliCallBackUrl);
        return request;
    }

    private static DefaultAlipayClient getAliClient(BaseOrderInfo order) {
        if (!aliClientContainer.containsKey(order.getPayAppId())) {
            DefaultAlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",order.getPayAppId(),
                    order.getPayAppKey(), "json", "UTF-8", order.getPayAppAliKey(), "RSA2");
            return aliClientContainer.putIfAbsent(order.getPayAppId(), alipayClient);
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
