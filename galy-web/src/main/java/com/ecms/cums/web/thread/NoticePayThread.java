package com.ecms.cums.web.thread;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import net.sf.json.JSONObject;
import com.ecms.cums.airportvo.PayNotifyVo;
import com.ecms.cums.core.util.HttpCommandProvider;
import com.ecms.cums.cores.Constants;
import com.ecms.cums.logutils.FAirportLog;
import com.ecms.cums.model.FAirportOrders;
import com.ecms.cums.services.FAriportService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NoticePayThread implements Runnable {

	private FAirportOrders p;

	@Autowired
	private FAriportService fAriportService;

	public NoticePayThread() {
		super();
	}

	public NoticePayThread(FAirportOrders p,FAriportService fAriportService) {
		super();
		this.p = p;
		this.fAriportService = fAriportService;
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<3;i++){
				PayNotifyVo rule =  new PayNotifyVo();
				rule.setCid(Constants.airportCId);
				rule.setOrderNo(p.getLdyOrderNo());
				rule.setPayId(p.getTransactionId());
				rule.setPrice(p.getTotalPrice());
				ObjectMapper mapper = new ObjectMapper();
				String jsonParams = mapper.writeValueAsString(rule);
				FAirportLog.logger.info("分润请求参数接口" + jsonParams);
				HttpCommandProvider sp = new HttpCommandProvider();
				String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/payNotify.htm", jsonParams);
				FAirportLog.logger.info("请求来单云分润接口返回接口" + httpResult);
				JSONObject param = JSONObject.fromObject(httpResult);
				Integer status = param.getInt("status");
				if(0==status){
					FAirportLog.logger.info("请求来单云分润接口成功，保存订单信息到本地");
					p.setStatus("1");
					p.setStatusName("支付成功等待出票");
					p.setUpdateTime(new Date());
					fAriportService.saveAirportOrderEntiy(p);
					break;
				}
				if(i==3){
					FAirportLog.logger.info("请求来单云分润接口失败，出票失败，保存订单信息到本地,并插入日志信息,执行退款");
					p.setStatus("0-3");//分润成功第三方分润失败
					p.setStatusName("未出票申请退款");
					p.setUpdateTime(new Date());
					fAriportService.saveAirportOrderEntiy(p);
					break;
				}
				FAirportLog.logger.info("请求来单云分润接口返回异常"+i+"分钟后开始重新调用");
				Thread.sleep(i*60*1000);
			}

		} catch (Exception e) {
			FAirportLog.logger.info("分润接口系统异常" , e);
			p.setStatus("52");
			p.setStatusName("系统异常");
			p.setUpdateTime(new Date());
			fAriportService.saveAirportOrderEntiy(p);
		}

	}

}
