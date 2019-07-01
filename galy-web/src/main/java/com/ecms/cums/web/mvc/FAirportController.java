package com.ecms.cums.web.mvc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecms.cums.core.util.*;
import com.ecms.cums.model.*;
import com.ecms.cums.ordervo.Message;
import com.ecms.cums.ordervo.local.CreateOrderVoLocal;
import com.ecms.cums.utils.ResultUtil;
import com.ecms.cums.utils.account.AppKeyProperties;
import com.ecms.cums.utils.weixin.HttpProtocolUtils;
import com.ecms.cums.utils.weixin.WXPayService;
import com.ecms.cums.web.vo.BaseOrderInfo;
import com.ecms.cums.web.vo.Result;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ecms.cums.airportorderinfo.AirportOrderInfoResultVo;
import com.ecms.cums.airportorderinfo.AirportOrderSultVo;
import com.ecms.cums.airportorderinfo.OrderDetailVo;
import com.ecms.cums.airportvo.AirportOrderListVo;
import com.ecms.cums.airportvo.AirportPassengerVo;
import com.ecms.cums.airportvo.AirportPayBeforeVo;
import com.ecms.cums.airportvo.AirportPriceVo;
import com.ecms.cums.airportvo.AirportRefundResultVo;
import com.ecms.cums.airportvo.AirportRefundVo;
import com.ecms.cums.airportvo.AriportOrderVo;
import com.ecms.cums.airportvo.BaggageruleVo;
import com.ecms.cums.airportvo.BookingAirportVo;
import com.ecms.cums.airportvo.ChangeInfoVo;
import com.ecms.cums.airportvo.CreateOrderAriportVo;
import com.ecms.cums.airportvo.CreateOrderPassengersVo;
import com.ecms.cums.airportvo.CreateOrderResultVo;
import com.ecms.cums.airportvo.FAirportCouponVo;
import com.ecms.cums.airportvo.ParentBookingVo;
import com.ecms.cums.airportvo.PayValidateVo;
import com.ecms.cums.airportvo.SearchAirportReqVo;
import com.ecms.cums.airportvo.SearchFirstResVo;
import com.ecms.cums.airportvo.SearchFlightFirstVo;
import com.ecms.cums.core.cached.ICached;
import com.ecms.cums.core.cached.SerializeUtil;
import com.ecms.cums.cores.Constants;
import com.ecms.cums.logutils.FAirportLog;
import com.ecms.cums.logutils.FunOrderLog;
import com.ecms.cums.ordervo.CreatePTOrderInfoVo;
import com.ecms.cums.productvo.AttachmentsInfo;
import com.ecms.cums.productvo.ProductJson;
import com.ecms.cums.productvo.ProductJsonVo;
import com.ecms.cums.services.FAriportService;
import com.ecms.cums.utils.DateUtil;
import com.ecms.cums.utils.ResourceUtils;
import com.ecms.cums.utils.StringReaderUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * @ClassName: FAirportController
 * @Description: 来单云机票Controller
 * @author: zJin
 * @date: 2018年7月13日 下午4:30:25
 */
@Controller
@RequestMapping("/fAriport")
public class FAirportController extends IndexController{

	@Autowired
	private FAriportService fAriportService;

	@Resource
	private ICached cached;

	/**
	 * @Title: searchCitySANCode
	 * @Description: 查询城市三字码
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/queryCitySANCode",method=RequestMethod.POST,consumes="application/json")
	public void queryCitySANCode(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("查询城市三字码请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String status = body.getString("status");
			//根据状态查询城市列表
			Map<String,Object> map = new HashMap<String, Object>();
			List<FAirportCity> city = fAriportService.queryCityListByStatus(status);
			List<FAirportCity> hotCity = fAriportService.queryHotCityListByStatus(status);
			map.put("city", city);
			map.put("hotCity", hotCity);
			this.getSuccessResponse(response, map);
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * @Title: serachFirportList
	 * @Description: 根据城市三字码查询机票信息
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/serachFirportList",method=RequestMethod.POST,consumes="application/json")
	public void serachFirportList(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("根据城市三字码查询机票信息请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			Map<String, Object> map = new HashMap<String, Object>();
			SearchAirportReqVo ariport =  gson.fromJson(body.toString(),SearchAirportReqVo.class);
			// 搜索机票路线 key
			String firportListkey = ariport.getFromCity()+ariport.getToCity()+ariport.getFromDate();
			// 缓存机票路线结果
			String firportResult = (String) cached.getCached(SerializeUtil.serialize(firportListkey));
			// 价格日历 key
			String airportKey = ariport.getFromCity()+"-"+ariport.getToCity();
			if(StringUtils.isBlank(firportResult)){
				String sanzima = ariport.getFromCity()+"_"+ariport.getToCity();
				/*一线机场     PEK-北京，CAN-广州，SZX-深圳，SHA-PVG上海，TSN-天津*/
				Long cachTime = 60L;
				if(sanzima.contains("PEK") || sanzima.contains("CAN") || sanzima.contains("SZX") || sanzima.contains("PVG") || sanzima.contains("TSN") ){
					cachTime = cachTime * 2;
				}else
				/*二线机场   HGH-杭州，NKG-南京，TNA-济南，CKG-重庆，TAO-青岛，DLC-大连，NGB-宁波，XMN-厦门 */
				if(sanzima.contains("HGH") || sanzima.contains("CAN") || sanzima.contains("SZX") || sanzima.contains("PVG") || sanzima.contains("TSN") ){
					cachTime = cachTime * 4;
				} else {
					cachTime = cachTime * 10;
				}
				ariport.setCid(Constants.airportCId);
				ariport.setTripType("1");
				ObjectMapper mapper = new ObjectMapper();
				String jsonParams = mapper.writeValueAsString(ariport);
				FAirportLog.logger.info("调用搜索查询接口请求参数" + jsonParams);
				HttpCommandProvider sp = new HttpCommandProvider();
				String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/search.htm", jsonParams);
				SearchFirstResVo resp =  gson.fromJson(httpResult,SearchFirstResVo.class);
				if(null!=resp){
					if(0==resp.getStatus() && null!=resp.getResult() && resp.getResult().size()>0){
						Collections.sort(resp.getResult(), new Comparator<SearchFlightFirstVo>() {
							@Override
							public int compare(SearchFlightFirstVo arg0, SearchFlightFirstVo arg1) {
								// 对航司价格进行降序排序
								return (int)(Double.parseDouble(arg0.getBarePrice())-Double.parseDouble(arg1.getBarePrice()));
							}
				        });
					    long time = DateUtil.nowDateSub(ariport.getFromDate()+" 23:59:59");

					    if(time>0){
						   cached.updateHashCached(SerializeUtil.serialize(airportKey), SerializeUtil.serialize(ariport.getFromDate()), SerializeUtil.serialize(resp.getResult().get(0).getBarePrice()), time);
					    }
					    Map<byte[],byte[]> cachMap =cached.getAllHashCached(SerializeUtil.serialize(airportKey));
					    Map<String,String> resultMap = getMapType(cachMap);
					    map.put("riliSult", resultMap);
					    map.put("result", resp.getResult());
					    map.put("status", 0);
					    map.put("msg", "请求成功");
					    cached.updateCached(SerializeUtil.serialize(firportListkey),SerializeUtil.serialize((new Gson()).toJson(resp.getResult())), cachTime);
					}else{
						map.put("status", resp.getStatus());
						map.put("msg", resp.getMsg());
					}
				}
				this.getSuccessResponse(response,map);
			}else{
				 Map<byte[],byte[]> cachMap =cached.getAllHashCached(SerializeUtil.serialize(airportKey));
			     Map<String,String> resultMap = getMapType(cachMap);
			     JSONObject header = new JSONObject();
			     header.put("resCode", "0");
			     header.put("successRes", "请求成功");
			     JSONObject bodys = new JSONObject();
			     bodys.put("riliSult", resultMap);
			     bodys.put("result", firportResult);
			     bodys.put("status", 0);
			     bodys.put("msg", "请求成功");
			     JSONObject resp = new JSONObject();
			     resp.put("header", header);
			     resp.put("body", bodys);
			     this.writeJsonResponseJson(response,resp.toString());
			}
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * @Title: price
	 * @Description: 报价请求接口
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/airportPrice",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String airportPrice(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("报价请求接口参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			AirportPriceVo ariport =  gson.fromJson(body.toString(),AirportPriceVo.class);
			ariport.setCid(Constants.airportCId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonParams = mapper.writeValueAsString(ariport);
			FAirportLog.logger.info("调用报价请求参数" + jsonParams);
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/searchprice.htm", jsonParams);
			FAirportLog.logger.info("调用报价返回参数" + httpResult);
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
	 * @Title: checkAirportBefore
	 * @Description: 下单前验证
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/checkAirportBefore",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String checkAirportBefore(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("下单前校验请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			ParentBookingVo parent =  gson.fromJson(body.toString(),ParentBookingVo.class);
			BookingAirportVo ariport = parent.getBookingAirportVo();
			ariport.setCid(Constants.airportCId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonParams = mapper.writeValueAsString(ariport);
			FAirportLog.logger.info("调用校验下单接口《前》请求参数" + jsonParams);
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/booking.htm", jsonParams);
			JSONObject result = JSONObject.fromObject(httpResult);
			Integer status = result.getInt("status");
			if(0!=status){
				String firportResult = (String) cached.getCached(SerializeUtil.serialize(parent.getFirportListkey()));
				if(!StringUtils.isBlank(firportResult)){
					cached.deleteCached(SerializeUtil.serialize(parent.getFirportListkey()));
				}
			}
			FAirportLog.logger.info("调用校验下单接口《前》请求返回参数" + httpResult);
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
	 * @Title: baggagerule
	 * @Description: 行李额接口
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/baggagerule",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String baggagerule(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("调用行李额接口参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			BaggageruleVo rule =  gson.fromJson(body.toString(),BaggageruleVo.class);
			rule.setCid(Constants.airportCId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonParams = mapper.writeValueAsString(rule);
			FAirportLog.logger.info("调用行李额接口" + jsonParams);
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/baggagerule.htm", jsonParams);
			FAirportLog.logger.info("调用行李额请求返回参数" + httpResult);
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
	 * @Title: changeInfo
	 * @Description: 退改签说明查询接口
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/changeInfo",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String changeInfo(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("退改签说明查询接口参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			ChangeInfoVo rule =  gson.fromJson(body.toString(),ChangeInfoVo.class);
			rule.setCid(Constants.airportCId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonParams = mapper.writeValueAsString(rule);
			FAirportLog.logger.info("退改签说明查询接口" + jsonParams);
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/changeInfo.htm", jsonParams);
			FAirportLog.logger.info("退改签说明返回接口" + httpResult);
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
	 * @Title: updatePtShop
	 * @Description: 上传商品到E店
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/updatePtShop",method=RequestMethod.POST,consumes="application/json")
	public void updatePtShop(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("获取产品上传请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String routeName = body.getString("routeName");
			String onlinePrice = body.getString("onlinePrice");
			String productCode = IdGeneratorzfb.genOrdId16(); //商品自定义编码
			String eShopCode = ResourceUtils.getProperty("airport_e_shop");//E店
			String eKey = ResourceUtils.getProperty("airport_e_key");//E店key
			ProductJson product = new ProductJson();
			product.setContent_tag("国安机票");
			//截取名称
			String rou= "";
			if(routeName.length()>10){
				rou= routeName.substring(0,10);
			}else{
				rou = routeName;
			}
			product.setContent_name(rou);
			product.setContent_price(Float.parseFloat(onlinePrice));
			product.setMin_number(0);
			product.setMax_number(999999);
			product.setIs_combo_split("no");
			product.setContent_type("product");
			product.setIs_combo("no");
			product.setContent_number(999999);
			product.setContent_img("");
			product.setContent_unit("1");
			product.setSelf_code(productCode);
			product.setContent_shelf("hidden");
			JSONObject object = JSONObject.fromObject(product);
			String obj=object.toString();
			ProductJsonVo query = new ProductJsonVo();
			AttachmentsInfo attachmentsInfo = new AttachmentsInfo();
			attachmentsInfo.setContent_img("");
			attachmentsInfo.setSort(1);
			attachmentsInfo.setType("carouse");
			List<AttachmentsInfo> list=new ArrayList<AttachmentsInfo>();
			list.add(attachmentsInfo);
			String obj2= JsonUtils.serialize(list);
			query.setAttachments(obj2);
			query.setEshop_code(eShopCode);
			query.setProduct(obj);
			String sign =SignUtils.getSign(query, eKey);
			query.setSign(sign);
			String buildLink=LinkUtils.buildLink(BeanUtils.getMap(query));
			String url = Constants.Eshop_key+Constants.addGoods+"?"+buildLink;
			HttpCommandProvider commandProvider = new HttpCommandProvider();
			String returnse= commandProvider.setGetMethod().setUrl(url).send();
			FAirportLog.logger.info("获取产品上传请求返回结果>>>" + returnse);
			JSONObject taParam = JSONObject.fromObject(returnse);
			if("添加成功".equals(taParam.getString("return_msg"))){
				FAirportLog.logger.info("商品上传成功");
			}else if("你所填的自定义编码商品库已有，请重新填写".equals(taParam.getString("return_msg"))){
				FAirportLog.logger.info("商品上传成功");
			}else{
				this.getErrorResponse(response,"上传产品失败");
				return;
			}
			this.getSuccessResponse(response,productCode);
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}

	}

	/**
	 * @Title: queryAirportCoupon
	 * @Description: 获取优惠卷（无用）
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/queryAirportCoupon",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String querydiscountCoupon(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("获取优惠卷请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String token = body.getString("token");
			String storeId = body.getString("storeId");
			String mount = body.getString("mount");
			String productCode = ""; //商品自定义编码
			productCode =body.getString("productCode");
			String eShopCode = ResourceUtils.getProperty("airport_e_shop");//E店
			JSONObject object = new JSONObject();
			object.put("groupID", "proSelfCode_"+productCode+"_"+eShopCode+"_"+mount);
			object.put("requestTimestamp", DateUtil.getDetailedTime());
//			FunOrderLog.logger.info("调取平台优惠券接口"+object);
//			String pTResult = GuoanHttpClient.postData(Constants.pt_querydiscountCoupon, object.toString(),token,storeId);
//			FunOrderLog.logger.info("调取平台优惠券返回接口"+pTResult);
			return "{\"body\":{\"status\":\"0\",\"mes\":\"请求成功\",\"result\":"+""+"}}";
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
	 * @Title: loadAirportTouristList
	 * @Description: 获取机票乘客信息
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/loadAirportTouristList",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void loadAirportTouristList(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("获取机票乘客信息请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String userId = body.getString("userId");
			if(StringUtils.isBlank(userId) ){
				this.getErrorResponse(response, "用户id或者orderStatus为空");
				return;
			}
			//查询机票旅客信息
			List<FAirportTourist> list = fAriportService.getAirportTourist(userId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			this.getSuccessResponse(response, map);
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * @Title: saveOrUpdateTourist
	 * @Description: 保存或者修改旅客信息
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/saveOrUpdateTourist",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void saveOrUpdateTourist(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("获取机票乘客信息请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			FAirportTourist Entity =  gson.fromJson(body.toString(),FAirportTourist.class);
			if(null==Entity){
				this.getErrorResponse(response, "旅客信息为空");
				return;
			}
			fAriportService.saveOrUpdateTourist(Entity);
			this.getSuccessResponse(response);
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * @Title: saveOrUpdateTourist
	 * @Description: 删除旅客信息
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/deleteTourist",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void deleteTourist(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("获取机票乘客信息请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String touristId = body.getString("touristId");
			if(StringUtils.isBlank(touristId) ){
				this.getErrorResponse(response, "touristid 为空");
				return;
			}
			fAriportService.deleteTourist(touristId);
			this.getSuccessResponse(response);
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * @Title: queryTourist
	 * @Description: 查询旅客信息
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/queryTourist",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void queryTourist(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("获取机票乘客信息请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String touristId = body.getString("touristId");
			if(StringUtils.isBlank(touristId) ){
				this.getErrorResponse(response, "touristid 为空");
				return;
			}
			FAirportTourist tourist = fAriportService.queryTourist(touristId);
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("tourist", tourist);
			this.getSuccessResponse(response,map);
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * @Title: createAirportOrder
	 * @Description: 创建飞机订单接口
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/createAirportOrder",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void createAirportOrder(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("下单接口参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			AriportOrderVo ariportOrder =  gson.fromJson(body.toString(),AriportOrderVo.class);
			CreateOrderAriportVo order = ariportOrder.getCreateOrderAriportVo();
			order.setCid(Constants.airportCId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonParams = mapper.writeValueAsString(order);
			FAirportLog.logger.info("调用机票【下单】接口参数" + jsonParams);
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/order.htm", jsonParams);
			FAirportLog.logger.info("调用机票【下单】返回接口" + httpResult);
			CreateOrderResultVo resp =  gson.fromJson(httpResult,CreateOrderResultVo.class);
			Map<String,Object> map = new HashMap<String, Object>();
			if(0 !=resp.getStatus()){ //下单成功
				map.put("result", resp);
				FAirportLog.logger.info("调用机票订单失败"+resp.getMsg());
				this.getSuccessResponse(response,map);
				return;
			}

			Double fenrun = 0.0;
			if("1".equals(ariportOrder.getAirportType())){
				fenrun = Double.parseDouble(ResourceUtils.getProperty("fenrun_price_guonei"));
			}else{
				fenrun = Double.parseDouble(ResourceUtils.getProperty("fenrun_price_guoji"));
			}

			List<CreateOrderPassengersVo> passengerList =  order.getPassengers();
			if(null==passengerList || passengerList.size()<=0){
				this.getErrorResponse(response,"请选择旅客信息");
				return;
			}
			fenrun = fenrun * passengerList.size();
			FAirportCouponVo coupon = ariportOrder.getfAirportCouponVo();
			Double couponPrice = (null != coupon && !StringUtils.isBlank(coupon.getfAmount()))?Double.parseDouble(coupon.getfAmount()):0.0;
			if(Double.parseDouble(resp.getOrderPrice().toString())- couponPrice - fenrun <= 0){
				this.getErrorResponse(response,"请核对当前机票价格");
				return;
			}
			// 调起支付
//			//拼装平台下单接口
//			CreatePTOrderInfoVo resultParams = new CreatePTOrderInfoVo();
//			resultParams.setEshopCode(Constants.guolv_e_shop);
//			resultParams.setStoreId(ariportOrder.getStoreId());
//			resultParams.setProductCode(ariportOrder.getProductCode());
//			resultParams.setUnitPrice("0.2"); //下单总价resp.getOrderPrice().toString()
//			resultParams.setQuantity("1");
//			resultParams.setStoreName(ariportOrder.getStoreName());
//			resultParams.setStoreType(ariportOrder.getStoreType());
//			resultParams.setDeliveryType("self");
//			resultParams.setBuyerRemark("");
//			resultParams.setCardCouponId((null != coupon)?coupon.getfCardCouponId():"");
//			List<CreatePTOrderInfoVo> productParams = new ArrayList<CreatePTOrderInfoVo>();
//			productParams.add(resultParams);
//			FAirportLog.logger.info("拼装组成平台下单接口参数");
//			ObjectMapper ptMapper = new ObjectMapper();
//			String ptPJson = ptMapper.writeValueAsString(productParams);
//			JSONObject objpt = new JSONObject();
//			objpt.put("productInfoParams", ptPJson);
//			FAirportLog.logger.info("调取平台创建订单接口"+objpt);
//		    String pTResult = GuoanHttpClient.postData(Constants.pt_create_order_url, objpt.toString(),ariportOrder.getToken(),"");
//		    FAirportLog.logger.info("调取平台创建返回订单接口"+pTResult);
//			JSONObject respTaiJson = JSONObject.fromObject(pTResult);
//			if(!"0".equals(respTaiJson.getString("code"))){
//				CreateOrderResultVo vo = new CreateOrderResultVo();
//				vo.setStatus(3);
//				vo.setMsg(respTaiJson.getString("message"));
//				FAirportLog.logger.info("调用平台订单失败"+respTaiJson.getString("message"));
//				map.put("result", vo);
//				this.getErrorResponse(response,map);
//				return;
//			}
//			String data = respTaiJson.getString("data");
//			JSONObject dataJson = JSONObject.fromObject(data);
//			String walletPayDiscountAmount = dataJson.getString("walletPayDiscountAmount"); //钱包支付金额
//
//			String orderGroupId = dataJson.getJSONArray("orderGroupIds").getString(0);
//			String orderSns = dataJson.getJSONArray("orderSns").getString(0); //平台订单编号
			// 需要修改 机票优惠卷 无参的无用
			fAriportService.saveOrderInfo(ariportOrder,resp,"","","",fenrun.toString());
			map.put("result", resp);
			map.put("walletPayDiscountAmount", "");
			map.put("payCloseRemainderTime", 900);
			map.put("orderGroupId", "");
			this.getSuccessResponse(response,map);
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * @Title: payValidate
	 * @Description: 支付前校验
	 * @param request
	 * @param response
	 * @return
	 * @return: String
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/payValidate",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String payValidate(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("支付前校验接口参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			AirportPayBeforeVo pay =  gson.fromJson(body.toString(),AirportPayBeforeVo.class);

			FAirportOrders order = fAriportService.getOrderByOrderGroupid(pay.getOrderGroupIds());
			if(null==order){
				FAirportLog.logger.info("订单校验失败，没有订单信息");
				return "{\"body\":{\"status\":\"-2\",\"mes\":\"订单校验失败，没有订单信息\"}}";
			}

			Date createTime = order.getCreateTime();
			long num = (new Date().getTime()-createTime.getTime())/(1000*60);
			if(num>14){
				FAirportLog.logger.info("此订单已超过付款时间，订单已取消，付款失败"+order.getStatus());
				order.setStatus("12");
				order.setStatusName("订单取消");
				order.setUpdateTime(new Date());
				fAriportService.updateFAirportStatus(order);
				return "{\"body\":{\"status\":\"-2\",\"mes\":\"此订单已超过付款时间，订单已取消，付款失败\"}}";
			}
			if("!0".equals(order.getStatus()) ){
				FAirportLog.logger.info("订单校验失败，该订单未在付款范围内"+order.getStatus());
				return "{\"body\":{\"status\":\"-2\",\"mes\":\"订单校验失败，该订单已取消，请重新下单\"}}";
			}
			PayValidateVo rule = pay.getPayValidateVo();
			JSONObject json = new JSONObject();
			json.put("cid", Constants.airportCId);
			json.put("orderId", rule.getOrderId());
			json.put("clientSite", rule.getClientSite());
			json.put("pmCode", "OUTDAIKOU");
			json.put("bankCode", "ALIPAY");
			FAirportLog.logger.info("支付前校验接口" + json.toString());
			String httpResult = HttpClientUtils.doPostJson(Constants.airportUrl+"ldy/payValidate.htm", json.toString());
			FAirportLog.logger.info("支付前校验返回接口" + httpResult);
			JSONObject result = JSONObject.fromObject(httpResult);
			Integer status = result.getInt("status");
			if(0 !=status){
				return "{\"body\":{\"status\":\"-2\",\"mes\":"+httpResult+"}}";
			}
			//调用支付宝或者微信支付接口 需要修改

//			JSONObject objpt = new JSONObject();
//			objpt.put("groupIds", new String[]{pay.getOrderGroupIds()});
//			objpt.put("payPlatform", pay.getPayPlatform());
//			objpt.put("redirectUrl", ResourceUtils.getProperty("redirectUrl"));
//			FAirportLog.logger.info("调取平台支付接口"+objpt);
//		    String pTResult = GuoanHttpClient.postData(Constants.pt_juhepay, objpt.toString(),"","");
//		    FAirportLog.logger.info("调取平台支付返回结果"+pTResult);
			return "{\"body\":{\"status\":\"0\",\"mes\":\"请求成功\",\"result\":"+"需要修改"+"}}";
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

//	/**
//	 * 微信支付
//	 */
//	@RequestMapping("/wxairportorderpay")
//	public Result<Object> createAirportOrderByWX(HttpServletRequest request, String orderId) throws UnsupportedEncodingException {
//		FAirportOrders oInfo = fAriportService.queryFAirportOrderByPrimaryKey(orderId);
//		BaseOrderInfo baseOrderInfo = new BaseOrderInfo(AppKeyProperties.get("weixin.pay.callbackurl"), oInfo.getfOrderId()+"", oInfo.getF(), oInfo.getOnlinePrice(), 1, oInfo.getGoodsName());
//		String xmlParam = WXPayService.mapToXml(WXPayService.buildAppAuthInfoMap(baseOrderInfo, HttpProtocolUtils.getRemortIP(request)));
//		return WXPayService.unifiedorder(baseOrderInfo, xmlParam);
//	}

	/**
	 * @Title: airportOrder
	 * @Description: 机票订单列表
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/airportOrder",method=RequestMethod.POST,consumes="application/json")
	public void airportOrder(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("查看订单请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String userId = body.getString("userId");
			if(StringUtils.isBlank(userId) ){
				this.getErrorResponse(response, "用户id或者orderStatus为空");
				return;
			}
			//查询机票订单信息
			List<AirportOrderListVo> airportList = fAriportService.getAriportOrderList(userId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("airport", airportList);
			this.getSuccessResponseJson(response, map);
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}


	/**
	 * @Title: airportOrderInfo
	 * @Description: 机票订单详情
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/airportOrderInfo",method=RequestMethod.POST,consumes="application/json")
	private void airportOrderInfo(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("订单详情查询接口参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String ldyOrderNo = body.getString("ldyOrderNo");
			String orderId = body.getString("orderId");
			JSONObject object = new JSONObject();
			object.put("cid", Constants.airportCId);
			object.put("orderNo",ldyOrderNo);
			FAirportLog.logger.info("调用订单详情下单接口" + object.toString());
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/orderDetail.htm", object.toString());
			FAirportLog.logger.info("调用订单详情下单接口返回结果" + httpResult);
			Gson gson=new Gson();
			AirportOrderInfoResultVo ariport =  gson.fromJson(httpResult,AirportOrderInfoResultVo.class);
			if(!StringUtils.isBlank(orderId) && ariport.getStatus()==0){
				FAirportOrders  fAirportOrder = fAriportService.queryFAirportOrderByPrimaryKey(orderId);
				AirportOrderSultVo sult = ariport.getResult();
				if(null!=sult){
					OrderDetailVo detail = sult.getDetail();
					if(null!=detail){
						if(!StringUtils.isBlank(detail.getStatus())){
							String status = getStatusByName(detail.getStatus());
							if("0-1".equals(fAirportOrder.getStatus()) || "0-3".equals(fAirportOrder.getStatus()) ||
							   "12".equals(fAirportOrder.getStatus()) || "52".equals(fAirportOrder.getStatus()) ){
								status = fAirportOrder.getStatus();
							}else{
								fAirportOrder.setStatus(status);
								fAirportOrder.setStatusName(detail.getStatus());
								fAirportOrder.setUpdateTime(new Date());
								fAriportService.updateFAirportStatus(fAirportOrder);
							}
							detail.setStatus(fAirportOrder.getStatus());
						}

					}
				}
			}
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("ariport", ariport);
			this.getSuccessResponse(response,map);
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}


	/**
	 * @Title: channelOrder
	 * @Description: 订单取消 - 12
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/channelOrder",method=RequestMethod.POST,consumes="application/json")
	public void channelOrder(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("取消订单参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String orderId = body.getString("orderId");
			FAirportOrders  fAirportOrder = fAriportService.queryFAirportOrderByPrimaryKey(orderId);
			if(null==fAirportOrder){
				this.getErrorResponse(response, "没有订单信息");
				return ;
			}
			fAirportOrder.setStatus("12");
			fAirportOrder.setStatusName("订单取消");
			fAirportOrder.setUpdateTime(new Date());
			fAriportService.updateFAirportStatus(fAirportOrder);
			this.getSuccessResponse(response);
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}


	/**
	 * @Title: createAirportOrder
	 * @Description: 申请退票查询
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/resundSearch",method=RequestMethod.POST,consumes="application/json")
	public void resundSearch(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("申请退票查询接口参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			JSONObject object = new JSONObject();
			object.put("cid", Constants.airportCId);
			object.put("orderNo", body.getString("ldyOrderNo"));
			FAirportLog.logger.info("调用来单云退票查询接口" + object.toString());
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/refundSearch.htm", object.toString());
			FAirportLog.logger.info("调用来单云退票返回接口" + httpResult);
			this.getSuccessResponse(response,httpResult);
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}


	/**
	 * @Title: resund
	 * @Description: 申请退票
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/refund",method=RequestMethod.POST,consumes="application/json")
	public void refund(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("申请退票查询接口参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			AirportRefundVo refund =  gson.fromJson(body.toString(),AirportRefundVo.class);
			JSONObject object = new JSONObject();
			object.put("cid", Constants.airportCId);
			object.put("orderNo", refund.getLdyOrderNo());
			object.put("refundCauseId", refund.getRefundCauseId());
			object.put("passengerIds", refund.getPassengerIds());
			object.put("refundCause", refund.getRefundCause());
			//拼装来单云请求参数
			FAirportLog.logger.info("申请退票来单云请求参数>>>" + object.toString());
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/refundSearch.htm", object.toString());
			Gson gsons=new Gson();
			AirportRefundResultVo result =  gsons.fromJson(httpResult,AirportRefundResultVo.class);
			if(null != result && 0 == result.getStatus()){
				List<AirportPassengerVo> passengerList = result.getResult();
				if(null!= passengerList){
					for(AirportPassengerVo vo:passengerList){
						if(vo.getSuccess()){
							//根据姓名与身份证号码匹配乘客信息
							FAirportTouristOrder tOrder = fAriportService.getPassengerInfoByNameAndCardNo(refund.getId(),vo.getName(),vo.getCardNum());
							if(null != tOrder){
								tOrder.setPassengerIdLdy(vo.getId().toString());
								tOrder.setRefundCause(refund.getRefundCause());
								tOrder.setRefundFeeLdy(refund.getRefundFee());
								tOrder.setReturnRefundFeeLdy(refund.getReturnRefundFee());
								tOrder.setOnePriceAll(refund.getOnePriceAll());
								tOrder.setUpdateTime(new Date());
								fAriportService.updateAirportTouristOrder(tOrder);
							}else{
								this.getErrorResponse(response, "找不到当前旅客信息");
								return ;
							}
						}
					}

				}
			}
			this.getSuccessResponse(response,httpResult);
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}


	/**
	 * @Title: endorseSearch
	 * @Description: 改签查询
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/endorseSearch",method=RequestMethod.POST,consumes="application/json")
	public void endorseSearch(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("申请退票查询接口参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			JSONObject object = new JSONObject();
			object.put("cid", Constants.airportCId);
			object.put("orderNo", body.getString("ldyOrderNo"));
			FAirportLog.logger.info("调用来单云改签查询接口" + object.toString());
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/endorseSearch.htm", object.toString());
			this.getSuccessResponse(response,httpResult);
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}


	/**
	 * @Title: endorse
	 * @Description: 改签申请
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/endorse",method=RequestMethod.POST,consumes="application/json")
	public void endorse(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FAirportLog.logger.info("申请退票查询接口参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			JSONObject object = new JSONObject();
			object.put("cid", Constants.airportCId);
			object.put("orderNo", body.getString("ldyOrderNo"));
			FAirportLog.logger.info("调用来单云改签查询接口" + object.toString());
			HttpCommandProvider sp = new HttpCommandProvider();
			String httpResult = sp.httpAirport(Constants.airportUrl+"ldy/endorseSearch.htm", object.toString());
			this.getSuccessResponse(response,httpResult);
		} catch (IOException e) {
			FAirportLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FAirportLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}



//	0-订座成功等待支付，
//	1-支付成功等待出票，
//	0-1-支付成功分润失败,  未出票申请退款
//	0-3-分润成功第三方分润失败   未出票申请退款
//	52-系统异常
//	2-出票完成，
//	5-出票中,
//	12-订单取消,
//	20-等待座位确认,
//	30-退款待确认,31-待退款,40-改签申请中,42-改签完成,50-未出票申请退款,51-订座成功等待价格确认
	public static String getStatusByName(String name){
		String status = "";
		switch (name) {
			case "订座成功等待支付":status = "0";
				break;
			case "支付成功等待出票":status = "1";
				break;
			case "出票完成":status = "2";
				break;
			case "出票中":status = "5";
				break;
			case "订单取消":status = "12";
				break;
			case "等待座位确认":status = "20";
				break;
			case "退款待确认":status = "30";
				break;
			case "待退款":status = "31";
				break;
			case "改签申请中":status = "40";
				break;
			case "改签完成":status = "42";
				break;
			case "未出票申请退款":status = "50";
				break;
			case "订座成功等待价格确认":status = "51";
				break;
		}
		return status;
	}

	public Map<String,String> getMapType(Map<byte[],byte[]> map){
		Map<String,String> reMap = new HashMap<String, String>();
		Iterator<Entry<byte[], byte[]>> it = map.entrySet().iterator();
		  while (it.hasNext()) {
		   @SuppressWarnings("rawtypes")
		   Map.Entry entry = (Map.Entry) it.next();
		   byte[] key = (byte[]) entry.getKey();
		   byte[] value = (byte[]) entry.getValue();
		   reMap.put(SerializeUtil.unserialize(key).toString(), SerializeUtil.unserialize(value).toString());
		  }
		return reMap;
	}
}
