package com.ecms.cums.web.mvc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecms.cums.core.util.*;
import com.ecms.cums.utils.ResultUtil;
import com.ecms.cums.utils.account.AppKeyProperties;
import com.ecms.cums.utils.aliyun.AliPayService;
import com.ecms.cums.utils.weixin.HttpProtocolUtils;
import com.ecms.cums.utils.weixin.WXPayService;
import com.ecms.cums.web.vo.BaseOrderInfo;
import com.ecms.cums.web.vo.Result;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ecms.cums.cores.Constants;
import com.ecms.cums.logutils.FAirportLog;
import com.ecms.cums.logutils.FunOrderLog;
import com.ecms.cums.model.EShop;
import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.Tourist;
import com.ecms.cums.ordervo.Message;
import com.ecms.cums.ordervo.OrderQueryVo;
import com.ecms.cums.ordervo.local.CreateOrderVoLocal;
import com.ecms.cums.productvo.AttachmentsInfo;
import com.ecms.cums.productvo.ProductJson;
import com.ecms.cums.productvo.ProductJsonVo;
import com.ecms.cums.services.GuoLvService;
import com.ecms.cums.services.PortService;
import com.ecms.cums.utils.DateUtil;
import com.ecms.cums.utils.StringReaderUtils;
import com.ecms.cums.web.vo.Response;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
/**
 * @ClassName: OrderController
 * @Description: 本地订单详情接口
 * @author: zJin
 * @date: 2018年4月11日 上午9:09:04
 */
@Controller
@RequestMapping("/sys/port")
public class OrderController extends BaseController{

	@Autowired
	private PortService portService;

	@Autowired
	private GuoLvService guoLvService;

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
			FunOrderLog.logger.info("获取产品上传请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String routeName = body.getString("routeName");
			String onlinePrice = body.getString("onlinePrice");
			String pId = body.getString("productId");
			String ifLocal = body.getString("ifLocal");
			String productCode = ""; //商品自定义编码
			String eShopCode = "";//E店
			String eKey = "";//E店key
			if("1".equals(ifLocal)){
				//本地商品
				Product pro = portService.selectProductByPrimarykey(Integer.parseInt(pId));
				productCode = pro.getPtNo();
				EShop eShop = portService.selectEshopByPrimarykey(pro.getCompId());
				eShopCode = eShop.geteKey();
				eKey = eShop.geteKeyNo();
			}else{
				//国旅商品
				productCode =body.getString("routeId");
				eShopCode = Constants.guolv_e_shop;
				eKey = Constants.guolv_e_key;
			}

			ProductJson product = new ProductJson();
			product.setContent_tag("豆会玩旅游");
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
			FunOrderLog.logger.info("获取产品上传请求返回结果>>>" + returnse);
			JSONObject taParam = JSONObject.fromObject(returnse);
			if("添加成功".equals(taParam.getString("return_msg"))){
				FunOrderLog.logger.info("商品上传成功");
			}else if("你所填的自定义编码商品库已有，请重新填写".equals(taParam.getString("return_msg"))){
				FunOrderLog.logger.info("商品上传成功");
			}else{
				this.getErrorResponse(response,"上传产品失败");
				return;
			}
			this.getSuccessResponse(response);
		} catch (IOException e) {
			FunOrderLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}

	}

	/**
	 * @Title: employeeListByStore
	 * @Description: 获取门店在线配送(无用)
	 * @param request
	 * @param response
	 * @return
	 * @return: String
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/employeeListByStore",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String employeeListByStore(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("获取在线配送请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String token = body.getString("token");
			String storeId = body.getString("storeId");
//			String pTResult = GuoanHttpClient.postData(Constants.employeeListByStroe, "",token,storeId);
//			FunOrderLog.logger.info("调取国安侠返回接口"+pTResult);
			return "{\"body\":{\"status\":\"0\",\"mes\":\"请求成功\",\"result\":"+"无用"+"}}";
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
	 * @Title: querydiscountCoupon
	 * @Description: 获取优惠卷(无用)
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/querydiscountCoupon",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String querydiscountCoupon(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("获取优惠卷请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String token = body.getString("token");
			String ifLocal = body.getString("ifLocal");
			String storeId = body.getString("storeId");
			String mount = body.getString("mount");
			String productCode = ""; //商品自定义编码
			String eShopCode = "";//E店
			if("1".equals(ifLocal)){
				//本地商品
				String pId = body.getString("productId");
				Product pro = portService.selectProductByPrimarykey(Integer.parseInt(pId));
				productCode = pro.getPtNo();
				EShop eShop = portService.selectEshopByPrimarykey(pro.getCompId());
				eShopCode = eShop.geteKey();
			}else{
				//国旅商品
				productCode =body.getString("routeId");
				eShopCode = Constants.guolv_e_shop;
			}

			JSONObject object = new JSONObject();
			object.put("groupID", "proSelfCode_"+productCode+"_"+eShopCode+"_"+mount);
			object.put("requestTimestamp", DateUtil.getDetailedTime());
//			FunOrderLog.logger.info("调取平台优惠券接口"+object);
//			String pTResult = GuoanHttpClient.postData(Constants.pt_querydiscountCoupon, object.toString(),token,storeId);
//			FunOrderLog.logger.info("调取平台优惠券返回接口"+pTResult);
			return "{\"body\":{\"status\":\"0\",\"mes\":\"请求成功\",\"result\":"+"无用"+"}}";
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
	 * @Title: createOrder
	 * @Description: 创建订单（本地）  出境：createOutboundOrder
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/createOrder",method=RequestMethod.POST,consumes="application/json")
	public void createOrder(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("报案请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			Gson gson=new Gson();
			CreateOrderVoLocal cOrder =  gson.fromJson(body.toString(),CreateOrderVoLocal.class);
			FunOrderLog.logger.info("验证前台请求JSON 是否传值正确");
			Message mes = portService.CheckOrderIsBlack(cOrder);
			if(!"1".equals(mes.getHeader().get("resCode"))){
				FunOrderLog.logger.info("报案请求参数>>>" + mes.getHeader().get("resMsg").toString());
				this.getErrorResponse(response, mes.getHeader().get("resMsg").toString());
				return ;
			}
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOrderNoLocal(IdGenerator.INSTANCE.nextId());
			Integer orderId = portService.saveOrderInfoByParams(orderInfo,cOrder);
 			Map<String,Object> resmap = new HashMap<>();
			resmap.put("orderId", orderId);
			this.getSuccessResponse(response, resmap);
		} catch (IOException e) {
			FunOrderLog.logger.error("请求流解析异常",e);
			this.getErrorResponse(response, "请求流解析异常");
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

	/**
	 * 微信支付
	 */
	@RequestMapping("/wxorderpay")
	public Result<Object> createOrderByWX(HttpServletRequest request, String orderId) throws UnsupportedEncodingException {
		OrderInfo oInfo;
		if (StringUtils.isBlank(orderId)){
			// 生成订单
			String reqJSON;
			try {
				reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
				FunOrderLog.logger.info("报案请求参数>>>" + reqJSON);
				JSONObject param = JSONObject.fromObject(reqJSON);
				JSONObject body = param.getJSONObject("body");
				Gson gson=new Gson();
				CreateOrderVoLocal cOrder =  gson.fromJson(body.toString(),CreateOrderVoLocal.class);
				FunOrderLog.logger.info("验证前台请求JSON 是否传值正确");
				Message mes = portService.CheckOrderIsBlack(cOrder);
				if(!"1".equals(mes.getHeader().get("resCode"))){
					FunOrderLog.logger.info("报案请求参数>>>" + mes.getHeader().get("resMsg").toString());
					return new ResultUtil<>().setErrorMsg("订单解析失败");
				}
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setOrderNoLocal(IdGenerator.INSTANCE.nextId());
				orderInfo.setStateLocal("1");
				Integer orderIdNew = portService.saveOrderInfoByParams(orderInfo,cOrder);
				oInfo = portService.selectOrderInfoByPrimaryKey(orderIdNew.toString());
			} catch (IOException e) {
				FunOrderLog.logger.error("请求流解析异常",e);
				return new ResultUtil<>().setErrorMsg("订单解析失败");
			}
		} else {
			oInfo = portService.selectOrderInfoByPrimaryKey(orderId);
		}
		BaseOrderInfo baseOrderInfo = new BaseOrderInfo(AppKeyProperties.get("weixin.pay.callbackurl"), oInfo.getOrderId()+"", oInfo.getOrderNoLocal(), oInfo.getOnlinePrice(), 1, oInfo.getGoodsName());
		String xmlParam = WXPayService.mapToXml(WXPayService.buildAppAuthInfoMap(baseOrderInfo, HttpProtocolUtils.getRemortIP(request)));
		return WXPayService.unifiedorder(baseOrderInfo, xmlParam);
	}


	/**
	 * 阿里支付
	 */
	@RequestMapping("/aliorderpay")
	public Result<String> createOrderByAli(HttpServletRequest request, String orderId) {
		OrderInfo oInfo;
		if (StringUtils.isBlank(orderId)){
			// 生成订单
			String reqJSON;
			try {
				reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
				FunOrderLog.logger.info("报案请求参数>>>" + reqJSON);
				JSONObject param = JSONObject.fromObject(reqJSON);
				JSONObject body = param.getJSONObject("body");
				Gson gson=new Gson();
				CreateOrderVoLocal cOrder =  gson.fromJson(body.toString(),CreateOrderVoLocal.class);
				FunOrderLog.logger.info("验证前台请求JSON 是否传值正确");
				Message mes = portService.CheckOrderIsBlack(cOrder);
				if(!"1".equals(mes.getHeader().get("resCode"))){
					FunOrderLog.logger.info("报案请求参数>>>" + mes.getHeader().get("resMsg").toString());
					return new ResultUtil<String>().setErrorMsg("订单解析失败");
				}
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setOrderNoLocal(IdGenerator.INSTANCE.nextId());
				orderInfo.setStateLocal("1");
				Integer orderIdNew = portService.saveOrderInfoByParams(orderInfo,cOrder);
				oInfo = portService.selectOrderInfoByPrimaryKey(orderIdNew.toString());
			} catch (IOException e) {
				FunOrderLog.logger.error("请求流解析异常",e);
				return new ResultUtil<String>().setErrorMsg("订单解析失败");
			}
		} else {
			oInfo = portService.selectOrderInfoByPrimaryKey(orderId);
		}
		BaseOrderInfo baseOrderInfo = new BaseOrderInfo(AppKeyProperties.get("ali.pay.callbackurl"), oInfo.getOrderId()+"", oInfo.getOrderNoLocal(), oInfo.getOnlinePrice(), 2, oInfo.getGoodsName());
		return AliPayService.aliOrderReq(baseOrderInfo);
	}

	/**
	 * @Title: orderPayBefore
	 * @Description: 订单支付验证 ;
	 * 0：找不到订单信息 1：已取消  2：不可立即支付，并且订单未确认，并且没有请款，并且没有收过款 3：订单没有客户，或者订单已截止，或者团不可销售 9：订单频道错误
	 *      注意：判断订单是否已经支付
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/orderPayBefore",method=RequestMethod.POST,consumes="application/json")
	public void orderPayBefore(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("报案请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String orderId = body.getString("orderId");
			OrderInfo oInfo = portService.selectOrderInfoByPrimaryKey(orderId);
			if(null==oInfo){
				this.getErrorResponse(response, "订单编号为空");
				return;
			}
			oInfo.setUpdateTime(new Date());
			Map<String,Object> map = new HashMap<>();
			Date createTime = oInfo.getCreateTime();
			long num = (new Date().getTime()-createTime.getTime())/(1000*60);
			if(num>14){
				oInfo.setStateLocal("4");
				portService.updateOrderInfo(oInfo);
				Response res = new Response();
				res.getHeader().put("resCode", "4");
		    	res.getHeader().put("repDes", "订单已经取消，请重新下单");
		    	this.writeJsonResponse(response, res);
				return;
			}
			oInfo.setStateLocal("1");
			portService.updateOrderInfo(oInfo);
			map.put("orderId", oInfo.getOrderId());
			map.put("orderNo", oInfo.getOrderNoLocal());
			map.put("totalPrice", oInfo.getOnlinePrice());
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
	 * @Title: checkOrderStatus
	 * @Description: 查看订单状态
	 * @param request
	 * @param response
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/checkOrderStatus",method=RequestMethod.POST,consumes="application/json")
	public void checkOrderStatus(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("查看订单请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String userId = body.getString("userId");
			String orderStatus = body.getString("orderStatus");
			String orderId = body.getString("orderId");
			if(StringUtils.isBlank(userId) || StringUtils.isBlank(orderStatus)){
				this.getErrorResponse(response, "用户id或者orderStatus为空");
				return;
			}
			if(!StringUtils.isBlank(orderId)){
//				updateOrderInfoStatus(orderId,"1");
			}else{
				List<OrderInfo> checkOrder = portService.checkOrderInfoByUserId(userId);
				if(null!=checkOrder && checkOrder.size()>0){
					for(OrderInfo check:checkOrder){
//						updateOrderInfoStatus(check.getOrderId().toString(),"0");
					}
				}
			}
			List<OrderInfo> orderInfo = portService.checkOrderStatusByuserId( userId, orderStatus);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("orderInfo", orderInfo);
			this.getSuccessResponseJson(response, map);
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");
		}
	}

//	public void updateOrderInfoStatus(String orderId,String type){
//		String eShopKey = "";
//		String eCodeKey ="";
//		OrderInfo orderInfo = portService.selectOrderInfoByPrimaryKey(orderId);
//		FunOrderLog.logger.info("更改订单状态查询接口订单id"+orderInfo.getOrderId()+",订单编号"+orderInfo.getOrderNoLocal());
//		if(null!=orderInfo && !StringUtils.isBlank(orderInfo.getOrderNoPt()) && !"3".equals(orderInfo.getStateLocal())){
//			if("1".equals(orderInfo.getIfLocal())){ //本地订单
//				Product product = portService.selectProductByPrimarykey(orderInfo.getProductId());
//				if(null!=product){
//					EShop eShop = portService.selectEshopByPrimarykey(product.getCompId());
//					eShopKey = eShop.geteKey();
//					eCodeKey=eShop.geteKeyNo();
//				}
//			}else{
//				eShopKey = Constants.guolv_e_shop;//国旅e店
//				eCodeKey = Constants.guolv_e_key;//国旅秘钥
//			}
//			if(!StringUtils.isBlank(eShopKey)){
//				OrderQueryVo query = new OrderQueryVo();
//				query.setOrder_id(orderInfo.getOrderNoLocal());
//				query.setEshop_id(eShopKey);
//				String sign =SignUtils.getSign(query,eCodeKey);
//				query.setSign(sign);
//				String buildLink=LinkUtils.buildLink(BeanUtils.getMap(query));
//				String  url = Constants.Eshop_key+Constants.orderQuery+"?"+buildLink;
//				HttpCommandProvider commandProvider = new HttpCommandProvider();
//				commandProvider.setGetMethod().setUrl(url).send();
//				String result = commandProvider.setGetMethod().setUrl(url).send();
//				FunOrderLog.logger.info("查询平台返回结果"+result);
//				if(!StringUtils.isBlank(result)){
//					JSONObject taParam = JSONObject.fromObject(result);
//					if("0".equals(taParam.getString("return_code"))){
//						JSONObject jsonObject = JSONObject.fromObject(taParam.getString("return_data"));
//						String order_status = jsonObject.getString("order_status");
//						String status = "";
//						if("waitpay".equals(order_status)){
//							status = "0"; //待支付
//						}else if("cancel".equals(order_status)){
//							status = "0"; //4 -支付取消，还是待支付状态
//						}else{
//							status = "3";//支付完成
//						}
//						orderInfo.setStateLocal(status);
//						orderInfo.setUpdateTime(new Date());
//						if("2".equals(orderInfo.getIfLocal()) && "3".equals(status)){
//							JSONObject obj = new JSONObject();
//							//获取国旅国内订单支付验证接口
//							Map<String,Object> results = new HashMap<String, Object>();
//							if("1".equals(orderInfo.getGlOrderType())){//国内
//								results = guoLvService.effectDomesticOrder(obj.toString());
//							}else{
//								results = guoLvService.effectOutboundOrder(obj.toString());
//							}
//							FunOrderLog.logger.info("调取创建订单正式报名接口返回接口"+results);
//							JSONObject resheader = JSONObject.fromObject(results.get("responseHeader"));
//							if(!"1".equals(resheader.getString("msgId"))){
//								FunOrderLog.logger.info("调用国旅订单报名接口失败"+result.toString());
//								portService.insertOrderLogByParams(orderInfo.getOrderId(),"2","",result.toString());
//								return;
//							}
//							JSONObject resBody = JSONObject.fromObject(results.get("responseBody"));
//							Boolean effectSuccessFlg = resBody.getBoolean("effectSuccessFlg");
//							if(!effectSuccessFlg){
//								orderInfo.setStateLocal("2"); //审核中
//								FunOrderLog.logger.info("调用国旅订单正式报名失败"+resBody.getString("effectFailReasonText"));
//								portService.insertOrderLogByParams(orderInfo.getOrderId(),"2","",result.toString());
//								return;
//							}
//						}
//						portService.updateOrderInfo(orderInfo);
//
//						if("3".equals(status) && "1".equals(orderInfo.getIfLocal())){
//							//如果是本地订单并且支付成功 那么减去库存
//							String teamId = orderInfo.getTeamId();
//							if(!StringUtils.isBlank(teamId)){
//								List<Tourist> list = portService.selectOrderTouristInfoByOrderId(orderInfo.getOrderId());
//								if(null!=list && list.size()>0){
//									Integer num = list.size();
//									portService.updateTreamDetailLeftNumByPrimaryId(Integer.parseInt(teamId),num);
//
//								}
//
//							}
//						}
//					}
//
//				}
//			}
//		}
//	}

	/**
	 * @Title: checkOrderInfo
	 * @Description: 查看订单详情接口
	 * @return: void
	 */
	@CrossOrigin
	@RequestMapping(value="/checkOrderInfo",method=RequestMethod.POST,consumes="application/json")
	public void checkOrderInfo(HttpServletRequest request,HttpServletResponse response){
		String reqJSON = null;
		try {
			reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
			FunOrderLog.logger.info("报案请求参数>>>" + reqJSON);
			JSONObject param = JSONObject.fromObject(reqJSON);
			JSONObject body = param.getJSONObject("body");
			String orderId = body.getString("orderId");
			if(StringUtils.isBlank(orderId)){
				this.getErrorResponse(response, "订单id不能为空");
				return ;
			}
			OrderInfo orderInfo = portService.selectOrderInfoByPrimaryKey(orderId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("orderInfo", orderInfo);
			List<Tourist> ot = portService.getTouristInfoByOrderId(orderInfo.getOrderId());
			map.put("tourist", ot);
			this.getSuccessResponseJson(response, map);
		} catch (JsonSyntaxException e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "解析json转化异常");
		}catch (Exception e) {
			FunOrderLog.logger.error("解析json转化异常",e);
			this.getErrorResponse(response, "操作失败");

		}
	}

}
