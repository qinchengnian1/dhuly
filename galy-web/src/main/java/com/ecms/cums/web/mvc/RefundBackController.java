package com.ecms.cums.web.mvc;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.cums.airportvo.AirportChargeAgentVo;
import com.ecms.cums.airportvo.AirportRefundBackVo;
import com.ecms.cums.airportvo.Passengers;
import com.ecms.cums.core.util.HttpCommandProvider;
import com.ecms.cums.core.util.IdGenerator;
import com.ecms.cums.logutils.FAirportLog;
import com.ecms.cums.utils.DateUtil;
import com.ecms.cums.utils.PayUtil;
import com.ecms.cums.utils.ResourceUtils;
import com.ecms.cums.utils.StringReaderUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


/**
 * @ClassName: RefundBackController
 * @Description: 申请退票回调Controller
 * @author: zJin
 * @date: 2018年7月18日 下午2:47:16
 */
@Controller
public class RefundBackController {


    @ResponseBody
    @RequestMapping(value = "/refundBackNotice", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String payBackNotice(HttpServletRequest request, HttpServletResponse response) {
        String reqJSON = null;
        try {
            reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
            Gson gson = new Gson();
            AirportRefundBackVo back = gson.fromJson(reqJSON, AirportRefundBackVo.class);
            if (null != back) {
                List<Passengers> list = back.getData();
                if (null != list && list.size() > 0) {

                }
            }


        } catch (IOException e) {
            FAirportLog.logger.error("请求流解析异常", e);
        } catch (JsonSyntaxException e) {
            FAirportLog.logger.error("解析json转化异常", e);
        } catch (Exception e) {
            FAirportLog.logger.error("解析json转化异常", e);
        }
        return "";
    }

    public static void main(String[] args) {
        AirportChargeAgentVo vo = new AirportChargeAgentVo();
        vo.setService("cae_charge_agent");
        vo.setPartner("2088701948662641");
        vo.set_input_char_set("utf-8");
        vo.setSign("");
        vo.setSign_type("MD5");
        vo.setNotify_url("");
        vo.setOut_order_no(IdGenerator.INSTANCE.nextId());
        vo.setAmount("0.1");
        vo.setSubject("代扣");
        vo.setTrans_account_out("liang-xg@163.com");
        vo.setTrans_account_in("20887019486626410156");
        vo.setCharge_type("trade");
        vo.setType_code("20887019486626411000310004");
        vo.setGmt_out_order_create(DateUtil.getDetailedTime());
        vo.setRoyalty_type("10");
        vo.setRoyalty_parameters("");
        /* 支付宝sign */
        Map<String, String> zhifuInfo = PayUtil.bean2Map(vo);
        // 生成签名
        String zfbSign = PayUtil.getSign4ZFB(ResourceUtils.getProperty("key"), zhifuInfo);
        vo.setSign(zfbSign);
        Map<String, String> zfbCtx = PayUtil.bean2MapWithSing(vo);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Entry<String, String> entry : zfbCtx.entrySet()) {
            if (entry.getValue() != null && !"".equals(entry.getValue())) {
                if (i == 0) {
                    sb.append(entry.getKey() + "=" + URLEncoder.encode(entry.getValue()));
                } else {
                    sb.append("&" + entry.getKey() + "=" + URLEncoder.encode(entry.getValue()));
                }
                i++;
            }
        }
        //拼接支付宝链接URL
        FAirportLog.logger.info("支付宝请求分润参数" + sb.toString());
        String paramUrl = "https://mapi.alipay.com/gateway.do?" + sb.toString();
        HttpCommandProvider sp = new HttpCommandProvider();
        String returnXml = sp.setGetMethod().setUrl(paramUrl).send();
        FAirportLog.logger.info("调取支付宝分润接口返回参数" + returnXml);


    }


}
