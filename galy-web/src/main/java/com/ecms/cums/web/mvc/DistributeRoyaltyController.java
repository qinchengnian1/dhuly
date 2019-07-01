package com.ecms.cums.web.mvc;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.ecms.cums.core.util.HttpCommandProvider;
import com.ecms.cums.core.util.IdGenerator;
import com.ecms.cums.core.util.SignUtils;
import com.ecms.cums.logutils.FAirportLog;
import com.ecms.cums.model.FAirportOrders;
import com.ecms.cums.services.FAriportService;
import com.ecms.cums.utils.DateUtil;
import com.ecms.cums.utils.PayUtil;
import com.ecms.cums.utils.ResourceUtils;
import com.ecms.cums.web.thread.NoticePayThread;
import com.ecms.cums.web.vo.PayBackNoticeVo;
import com.ecms.cums.web.vo.ZfbDistributeRoyaltyVo;

/**
 * @ClassName: DistributeRoyaltyController
 * @Description: 分润Controller
 * @author: zJin
 * @date: 2018年6月15日 下午3:25:00
 */
@Controller
public class DistributeRoyaltyController {


	@Autowired
	private FAriportService fAriportService;

	/**
	 * @Title: payBackNotice
	 * @Description: TODO
	 * @param request
	 * @param response
	 * @param payBack
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping(value="/payBackNotice",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String payBackNotice(HttpServletRequest request, HttpServletResponse response,PayBackNoticeVo payBack){
		try {
			FAirportLog.logger.info("支付宝回调入参》》》"+net.sf.json.JSONObject.fromObject(payBack).toString());
			if(null==payBack){
				FAirportLog.logger.error("支付宝回调参数为空");
				return "{\"return_code\":\"2\",\"return_msg\":\"支付回调参数为空\"}";
			}
			String sign =SignUtils.getSign(payBack, ResourceUtils.getProperty("jh_key"));
			if(!payBack.getSign().equals(sign)){
				FAirportLog.logger.error("支付宝回调签名解析错误");
				return "{\"return_code\":\"2\",\"return_msg\":\"支付回调签名解析错误\"}";
			}
			String groupIds = "";
			if(payBack.getGroupIds().contains("_")){
				groupIds = payBack.getGroupIds().split("_")[0];
			}else{
				groupIds = payBack.getGroupIds();
			}
			FAirportOrders order = fAriportService.getOrderByOrderGroupid(groupIds);

			if(null==order){
				FAirportLog.logger.error("订单回调失败，没有订单信息");
				return "{\"return_code\":\"2\",\"return_msg\":\"支付回调失败，没有订单信息\"}";
			}
			if("3".equals(order.getStatus()) || "4".equals(order.getStatus())){
				FAirportLog.logger.error("订单回调失败，该订单已取消，请重新下单"+order.getStatus());
				return "{\"return_code\":\"2\",\"return_msg\":\"支付回调失败，该订单已支付\"}";
			}
			order.setPayplatform(payBack.getPayPlatform());
			order.setOutTradeNo(payBack.getOut_trade_no());
			order.setTransactionId(payBack.getTransaction_id());
			order.setTradeState(payBack.getTrade_state());
			order.setPayTime(DateUtil.parseStringToDate(payBack.getPay_time()));
			order.setNotifyTime(DateUtil.parseStringToDate(payBack.getNotify_time()));
			order.setUpdateTime(new Date());
			fAriportService.updateFAirportStatus(order);

			//进行转账（目前只有支付成功回调）

			AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
					"app_id",
					"your private_key",
					"json",
					"utf-8",
					"alipay_public_key",
					"RSA2");
			AlipayFundTransToaccountTransferRequest requests = new AlipayFundTransToaccountTransferRequest();
			requests.setBizContent("{" +
			"\"out_biz_no\":"+IdGenerator.INSTANCE.nextId()+"," +
			"\"payee_type\":\"ALIPAY_LOGONID\"," +
			"\"payee_account\":\"abc@sina.com\"," +
			"\"amount\":\"12.23\"," +
			"\"payer_show_name\":\"上海交通卡退款\"," +
			"\"payee_real_name\":\"张三\"," +
			"\"remark\":\"转账备注\"" +
			"}");
			AlipayFundTransToaccountTransferResponse responses = alipayClient.execute(requests);
			if(responses.isSuccess()){
			System.out.println("调用成功");
			} else {
			System.out.println("调用失败");
			}
			IdGenerator.INSTANCE.nextId();
			ZfbDistributeRoyaltyVo vo = new ZfbDistributeRoyaltyVo();
			String fenrunOutBillNo = String.valueOf(IdGenerator.getPK());
			vo.setOut_bill_no(fenrunOutBillNo); //商户请求分润的唯一标示 16位纯数字

			String resavezfbusername = ResourceUtils.getProperty("payee");//收款方支付宝账号
			String fenrun_price = order.getFenrunTotalPrice();

			Double totalPrice = Double.parseDouble(order.getTotalPrice())-Double.parseDouble(fenrun_price);
			String RoyaltyParameters = resavezfbusername+"^"+totalPrice+"^机票分润"+fenrun_price+"元";
			vo.setRoyalty_parameters(RoyaltyParameters);//分润明细参数说明
			vo.setTrade_no(payBack.getTransaction_id()); //支付宝交易号
			/* 支付宝sign */
			Map<String, String> zhifuInfo = PayUtil.bean2Map(vo);
			// 生成签名
			String zfbSign = PayUtil.getSign4ZFB(ResourceUtils.getProperty("key"),zhifuInfo);
			vo.setSign(zfbSign);
			Map<String,String> zfbCtx = PayUtil.bean2MapWithSing(vo);
			StringBuilder sb = new StringBuilder();
			int i = 0;
			for (Entry<String, String> entry : zfbCtx.entrySet()) {
				if(entry.getValue() != null && !"".equals(entry.getValue())){
					if(i==0){
						sb.append(entry.getKey()+"="+entry.getValue());
					}else{
						sb.append("&"+entry.getKey()+"="+entry.getValue());
					}
					i++;
				}
	        }
			//拼接支付宝链接URL
			FAirportLog.logger.info("支付宝请求分润参数"+sb.toString());
			String paramUrl = ResourceUtils.getProperty("target")+"?"+sb.toString();
			HttpCommandProvider sp = new HttpCommandProvider();
			String returnXml = sp.setGetMethod().setUrl(paramUrl).send();
			FAirportLog.logger.info("调取支付宝分润接口返回参数"+returnXml);
			Document doc = DocumentHelper.parseText(returnXml); // 将字符串转为XML
			Element ele=doc.getRootElement();
			String is_success = ele.element("is_success").getText();
			if(!"T".equals(is_success)){
				order.setStatus("0-1");//支付成功 分润失败
				order.setStatusName("未出票申请退款");
				order.setUpdateTime(new Date());
				fAriportService.updateFAirportStatus(order);
				return "{\"return_code\":\"2\",\"return_msg\":"+ele.element("error").getText()+"}";
			}
			order.setFenrunOutTradeNo(fenrunOutBillNo);
			order.setUpdateTime(new Date());
			fAriportService.updateFAirportStatus(order);
			FAirportLog.logger.info("调取支付宝分润成功异步通知分润接口-------------------");
			//异步通知合作商分润接口  如失败则每隔段时间通知 ，共通知三次   保存本地信息数据，
			NoticePayThread t = new NoticePayThread(order,fAriportService);
			new Thread(t).start();

			return "{\"return_code\":\"1\",\"return_msg\":\"success\"}";
		} catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			return "{\"return_code\":\"2\",\"return_msg\":\"系统错误\"}";
		}
	}

	public static void main(String[] args) throws AlipayApiException {
		System.out.println("2222222222222");
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
				"2015121100957479",
				"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALo7FVO0ePXDUqeB+5IuOFOr/ppoDVL6tColg7GsEyvfcm4waCLcgs8eUZWUhVKagshkp+L5OePxcn5T4pqU16Er62KHadHhqOdnC6wpDBpP9x0BrVGs2vx32u86v7Ocu2sa66G/sRTG7DkBlzFWQh54LvpjsrBpANTKt7uW+ur9AgMBAAECgYADkmiJT3fWduWZ8uNJXXuVF0Jt4bsHsWlNOaT5/mvrtoByXplQudwEbvdvoAaim/YQM+YIc3FJzvK8O42oG1y7YTNZeTDqOcuoiyzgxLB+t28Yi7c4gt8Tyd88WBBeIonf0OCTbzMo9G6l9JLkvptc7671AGadFpnkL2FCE2SunQJBAPhBjwDnz9maHQ86IYonzfDWX2yjfm0MCt6pXubmij+VcvWSDDAQl87hviLLMKQKymC/aa81wjYqcVj+6lgBCK8CQQDACjk+vZhkIq4ReFmgd6pF6Y2OkZ6vs4TaxFu47A+4yxCiuXHDPEGVWM9YAUvywRho69yY3mI9orPVoOV6spoTAkEAhignd33OPPGjso7fgSFxkSzH9JWFxLg1R46P0ofTPfktXrfGDlNpNkuXzIWxi3SpWQ8Xta9/fHYDOuzHBzfH0QJAKcePoLi62L46xI48YY7nOoKPS38e2PbjZnzlv5uL6BY1rlFOEL2hPw6tPWY60bt0xg7aVV+8W9Bz83wnsMP+hQJBAMsm23kj4MBgUySTbh0U9thjXEctXOlNDcEvzqxUpg3IXiv/8Dxbv+Y+WB2PCg/gir2V/iI9Uk26vJvh9rFk2dE=",
				"json",
				"utf-8",
				"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB",
				"RSA");
		AlipayFundTransToaccountTransferRequest requests = new AlipayFundTransToaccountTransferRequest();
		JSONObject obj = new JSONObject();
		obj.put("out_biz_no", IdGenerator.INSTANCE.nextId());
		obj.put("payee_type", "ALIPAY_LOGONID");
		obj.put("payee_account", "liang-xg@163.com");
		obj.put("amount", "0.1");
		obj.put("remark", "机票测试分润转账");
		System.out.println(obj.toString());
		requests.setBizContent(obj.toString());
		AlipayFundTransToaccountTransferResponse responses = alipayClient.execute(requests);
		if(responses.isSuccess()){
		System.out.println("调用成功");
		} else {
		System.out.println("调用失败"+responses.getBody());

		}
	}

	/**
	 * @Title: payBackNotice
	 * @Description: 支付回调接口
	 * @param request
	 * @param response
	 * @param payBack
	 * @return  0-订座成功等待支付，1-支付成功等待出票，1-1-支付成功等待分润，1-2-支付成功分润失败,1-3-支付失败,1-4-分润成功第三方分润成功,1-5-分润成功第三方分润失败,2-出票完成，5-出票中,12-订单取消,20-等待座位确认,30-退款待确认,31-待退款,40-改签申请中,42-改签完成,50-未出票申请退款,51-订座成功等待价格确认
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping(value="/payBackNoticeOld",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String payBackNoticeOld(HttpServletRequest request, HttpServletResponse response,PayBackNoticeVo payBack){
		try {
			FAirportLog.logger.info("支付宝回调入参》》》"+net.sf.json.JSONObject.fromObject(payBack).toString());
			if(null==payBack){
				FAirportLog.logger.error("支付宝回调参数为空");
				return "{\"return_code\":\"2\",\"return_msg\":\"支付回调参数为空\"}";
			}
			String sign =SignUtils.getSign(payBack, ResourceUtils.getProperty("jh_key"));
			if(!payBack.getSign().equals(sign)){
				FAirportLog.logger.error("支付宝回调签名解析错误");
				return "{\"return_code\":\"2\",\"return_msg\":\"支付回调签名解析错误\"}";
			}
			String groupIds = "";
			if(payBack.getGroupIds().contains("_")){
				groupIds = payBack.getGroupIds().split("_")[0];
			}else{
				groupIds = payBack.getGroupIds();
			}
			FAirportOrders order = fAriportService.getOrderByOrderGroupid(groupIds);

			if(null==order){
				FAirportLog.logger.error("订单回调失败，没有订单信息");
				return "{\"return_code\":\"2\",\"return_msg\":\"支付回调失败，没有订单信息\"}";
			}
			if("3".equals(order.getStatus()) || "4".equals(order.getStatus())){
				FAirportLog.logger.error("订单回调失败，该订单已取消，请重新下单"+order.getStatus());
				return "{\"return_code\":\"2\",\"return_msg\":\"支付回调失败，该订单已支付\"}";
			}
			order.setPayplatform(payBack.getPayPlatform());
			order.setOutTradeNo(payBack.getOut_trade_no());
			order.setTransactionId(payBack.getTransaction_id());
			order.setTradeState(payBack.getTrade_state());
			order.setPayTime(DateUtil.parseStringToDate(payBack.getPay_time()));
			order.setNotifyTime(DateUtil.parseStringToDate(payBack.getNotify_time()));
			order.setUpdateTime(new Date());
			fAriportService.updateFAirportStatus(order);

			//进行分润 （目前只有支付成功回调）
			ZfbDistributeRoyaltyVo vo = new ZfbDistributeRoyaltyVo();
			String fenrunOutBillNo = String.valueOf(IdGenerator.getPK());
			vo.setOut_bill_no(fenrunOutBillNo); //商户请求分润的唯一标示 16位纯数字

			String resavezfbusername = ResourceUtils.getProperty("payee");//收款方支付宝账号
			String fenrun_price = order.getFenrunTotalPrice();

			Double totalPrice = Double.parseDouble(order.getTotalPrice())-Double.parseDouble(fenrun_price);
			totalPrice = 0.1;
			String RoyaltyParameters = resavezfbusername+"^"+totalPrice+"^机票分润"+fenrun_price+"元";
			vo.setRoyalty_parameters(RoyaltyParameters);//分润明细参数说明
			vo.setTrade_no(payBack.getTransaction_id()); //支付宝交易号
			/* 支付宝sign */
			Map<String, String> zhifuInfo = PayUtil.bean2Map(vo);
			// 生成签名
			String zfbSign = PayUtil.getSign4ZFB(ResourceUtils.getProperty("key"),zhifuInfo);
			vo.setSign(zfbSign);
			Map<String,String> zfbCtx = PayUtil.bean2MapWithSing(vo);
			StringBuilder sb = new StringBuilder();
			int i = 0;
			for (Entry<String, String> entry : zfbCtx.entrySet()) {
				if(entry.getValue() != null && !"".equals(entry.getValue())){
					if(i==0){
						sb.append(entry.getKey()+"="+entry.getValue());
					}else{
						sb.append("&"+entry.getKey()+"="+entry.getValue());
					}
					i++;
				}
	        }
			//拼接支付宝链接URL
			FAirportLog.logger.info("支付宝请求分润参数"+sb.toString());
			String paramUrl = ResourceUtils.getProperty("target")+"?"+sb.toString();
			HttpCommandProvider sp = new HttpCommandProvider();
			String returnXml = sp.setGetMethod().setUrl(paramUrl).send();
			FAirportLog.logger.info("调取支付宝分润接口返回参数"+returnXml);
			Document doc = DocumentHelper.parseText(returnXml); // 将字符串转为XML
			Element ele=doc.getRootElement();
			String is_success = ele.element("is_success").getText();
			if(!"T".equals(is_success)){
				order.setStatus("0-1");//支付成功 分润失败
				order.setStatusName("未出票申请退款");
				order.setUpdateTime(new Date());
				fAriportService.updateFAirportStatus(order);
				return "{\"return_code\":\"2\",\"return_msg\":"+ele.element("error").getText()+"}";
			}
			order.setFenrunOutTradeNo(fenrunOutBillNo);
			order.setUpdateTime(new Date());
			fAriportService.updateFAirportStatus(order);
			FAirportLog.logger.info("调取支付宝分润成功异步通知分润接口-------------------");
			//异步通知合作商分润接口  如失败则每隔段时间通知 ，共通知三次   保存本地信息数据，
			NoticePayThread t = new NoticePayThread(order,fAriportService);
			new Thread(t).start();

			return "{\"return_code\":\"1\",\"return_msg\":\"success\"}";
		} catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			return "{\"return_code\":\"2\",\"return_msg\":\"系统错误\"}";
		}
	}

}
