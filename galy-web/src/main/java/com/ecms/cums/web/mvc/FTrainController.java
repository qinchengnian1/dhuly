package com.ecms.cums.web.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecms.cums.core.util.HttpCommandProvider;
import com.ecms.cums.cores.Constants;
import com.ecms.cums.horsevo.TrainListVo;
import com.ecms.cums.logutils.FAirportLog;
import com.ecms.cums.logutils.FTrainLog;
import com.ecms.cums.utils.StringReaderUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Controller
@RequestMapping("/sTrainController")
public class FTrainController extends IndexController{

	/**
	 * @Title: getTrainList
	 * @Description: 查询余票接口
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/queryCitySANCode",method=RequestMethod.POST,consumes="application/json")
	public void getTrainList(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FTrainLog.logger.info("报案请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			TrainListVo train =  gson.fromJson(body.toString(),TrainListVo.class);
			train.setCid(Constants.airportCId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonParams = mapper.writeValueAsString(train);
			FAirportLog.logger.info("调用查询火车票余票请求参数" + jsonParams);
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/booking.htm", jsonParams);
			this.getSuccessResponse(response, httpResult);
		} catch (IOException e) {
			FTrainLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FTrainLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FTrainLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * @Title: getSubwayStation
	 * @Description: 查询经停车站
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/getSubwayStation",method=RequestMethod.POST,consumes="application/json")
	public void getSubwayStation(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FTrainLog.logger.info("报案请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			JSONObject json = new JSONObject();
			json.put("cid", Constants.airportCId);
			json.put("trainCode", body.getString("trainCode"));
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"train/getSubwayStation", json.toString());
			this.getSuccessResponse(response, httpResult);
		} catch (IOException e) {
			FTrainLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FTrainLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FTrainLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * @Title: CheckTicket
	 * @Description: 验证余票接口
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/CheckTicket",method=RequestMethod.POST,consumes="application/json")
	public void CheckTicket(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FTrainLog.logger.info("报案请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			TrainListVo train =  gson.fromJson(body.toString(),TrainListVo.class);
			train.setCid(Constants.airportCId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonParams = mapper.writeValueAsString(train);
			FAirportLog.logger.info("调用验证余票接口请求参数" + jsonParams);
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"train/checkTicket", jsonParams);
			this.getSuccessResponse(response, httpResult);
		} catch (IOException e) {
			FTrainLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FTrainLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FTrainLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * @Title: createTrainOrder
	 * @Description: 创建订单
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/createTrainOrder",method=RequestMethod.POST,consumes="application/json")
	public void createTrainOrder(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FTrainLog.logger.info("报案请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			TrainListVo train =  gson.fromJson(body.toString(),TrainListVo.class);
			train.setCid(Constants.airportCId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonParams = mapper.writeValueAsString(train);
			FAirportLog.logger.info("调用查询火车票余票请求参数" + jsonParams);
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/booking.htm", jsonParams);
			this.getSuccessResponse(response, httpResult);
		} catch (IOException e) {
			FTrainLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FTrainLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FTrainLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}


}
