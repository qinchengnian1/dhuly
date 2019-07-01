package com.ecms.cums.web.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.cums.core.util.HttpCommandProvider;
import com.ecms.cums.cores.Constants;
import com.ecms.cums.logutils.FAirportLog;
import com.ecms.cums.trainvo.TrainCheckInfoVo;
import com.ecms.cums.utils.StringReaderUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * @ClassName: TrainController
 * @Description: 火车票Controller
 * @author: zJin
 * @date: 2018年7月20日 上午10:41:26
 */
@Controller
@RequestMapping("/train")
public class TrainController extends IndexController{

	/**
	 * @Title: getTrainList
	 * @Description: 查询火车票余票
	 * @param request
	 * @param response
	 * @return
	 * @return: String
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/getTrainList",method=RequestMethod.POST,consumes="application/json")
	public String getTrainList(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("查询火车票搜索余票>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String travel_time = body.getString("travel_time");
			String from_station = body.getString("from_station");
			String arrive_station = body.getString("arrive_station");
			JSONObject object = new JSONObject();
			object.put("cid", Constants.airportCId);
			object.put("travel_time", travel_time);
			object.put("from_station", from_station);
			object.put("arrive_station", arrive_station);
			HttpCommandProvider sp = new HttpCommandProvider();
			FAirportLog.logger.info("请求来单与火车票余票请求接口入参>>>" + object.toString());
			String httpResult = sp.httpAirport(Constants.airportUrl+"train/getTrainList.htm", object.toString());
			FAirportLog.logger.info("请求来单与火车票余票请求接口出参>>>" + httpResult);
			return "{\"body\":{\"status\":\"0\",\"mes\":\"请求成功\",\"result\":"+httpResult+"}}";
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			return "{\"body\":{\"status\":\"-1\",\"mes\":\"请求流解析异常\"}}";
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			return "{\"body\":{\"status\":\"-1\",\"mes\":\"解析json转化异常\"}}";
		} catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			return "{\"body\":{\"status\":\"-1\",\"mes\":\"系统异常\"}}";
		}
	}


	/**
	 * @Title: getSubwayStation
	 * @Description: 查询途径站信息接口
	 * @param request
	 * @param response
	 * @return
	 * @return: String
	 */
	@CrossOrigin
	@RequestMapping(value="/getSubwayStation",method=RequestMethod.POST,consumes="application/json")
	public String getSubwayStation(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("查询途径站信息接口>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String train_code = body.getString("train_code");
			JSONObject object = new JSONObject();
			object.put("cid", Constants.airportCId);
			object.put("train_code", train_code);
			HttpCommandProvider sp = new HttpCommandProvider();
			FAirportLog.logger.info("请求来单云途径站信息接口请求接口入参>>>" + object.toString());
			String httpResult = sp.httpAirport(Constants.airportUrl+"train/getSubwayStation.htm", object.toString());
			FAirportLog.logger.info("请求来单云途径站信息接口请求接口出参>>>" + httpResult);
			return "{\"body\":{\"status\":\"0\",\"mes\":\"请求成功\",\"result\":"+httpResult+"}}";
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			return "{\"body\":{\"status\":\"-1\",\"mes\":\"请求流解析异常\"}}";
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			return "{\"body\":{\"status\":\"-1\",\"mes\":\"解析json转化异常\"}}";
		} catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			return "{\"body\":{\"status\":\"-1\",\"mes\":\"系统异常\"}}";
		}
	}


	/**
	 * @Title: getSubwayStation
	 * @Description: 验证用户信息接口
	 * @param request
	 * @param response
	 * @return
	 * @return: String
	 */
	@CrossOrigin
	@RequestMapping(value="/checkInfo",method=RequestMethod.POST,consumes="application/json")
	public String checkInfo(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("查询验证用户信息接口接口>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			TrainCheckInfoVo checkInfo =  gson.fromJson(body.toString(),TrainCheckInfoVo.class);
			checkInfo.setCid(Constants.airportCId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonParams = mapper.writeValueAsString(checkInfo);
			HttpCommandProvider sp = new HttpCommandProvider();
			FAirportLog.logger.info("请求来单云验证用户信息接口请求接口入参>>>" + jsonParams);
			String httpResult = sp.httpAirport(Constants.airportUrl+"train/checkInfo.htm", jsonParams);
			FAirportLog.logger.info("请求来单云验证用户信息接口请求接口出参>>>" + httpResult);
			return "{\"body\":{\"status\":\"0\",\"mes\":\"请求成功\",\"result\":"+httpResult+"}}";
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			return "{\"body\":{\"status\":\"-1\",\"mes\":\"请求流解析异常\"}}";
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			return "{\"body\":{\"status\":\"-1\",\"mes\":\"解析json转化异常\"}}";
		} catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			return "{\"body\":{\"status\":\"-1\",\"mes\":\"系统异常\"}}";
		}
	}


}
