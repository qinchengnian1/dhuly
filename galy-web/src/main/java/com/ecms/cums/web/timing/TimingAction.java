package com.ecms.cums.web.timing;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecms.cums.authvo.ProductDestVo;
import com.ecms.cums.core.cached.ICached;
import com.ecms.cums.core.util.BeanUtils;
import com.ecms.cums.core.util.HttpCommandProvider;
import com.ecms.cums.core.util.LinkUtils;
import com.ecms.cums.core.util.SignUtils;
import com.ecms.cums.cores.Constants;
import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.model.ProShelfState;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.Routes;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.services.AbroadRouteService;
import com.ecms.cums.services.DomesticRouteService;
import com.ecms.cums.services.PortService;
import com.ecms.cums.services.ProductService;
import com.ecms.cums.services.TimingService;
import com.ecms.cums.services.TreamDetailService;
import com.ecms.cums.web.mvc.BaseController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/sys/TimingAction")
public class TimingAction extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(TimingAction.class);
	@Autowired
	private DomesticRouteService domesticRoute;
	@Autowired
	private AbroadRouteService abroadRouteService;
	@Autowired
	private TimingService timingService;
	@Resource
	private ICached cached;
	@Autowired
	private PortService portService;
	@Autowired
	private TreamDetailService treamDetailService;
	@Autowired
	private ProductService productService;

	/**
	 * 获取全网下有产品的目的地信息接口（getProductDest）
	 * 定时任务每天凌晨1点进行查询并且插入数据库中
	 */
	//@Scheduled(cron="0 0 1 * * ?")
	public void getProductDest(){
			JSONObject params = new JSONObject();
			JSONObject header = new JSONObject();
			JSONObject body = new JSONObject();
			params.put("header", header);
			params.put("body", body);
			logger.info("报案请求参数>>>" + params);
		try {
			logger.info("查询全网下的路线信息");
			Map<String,Object> reMap = timingService.getProductDest(params.toString());
			ProductDestVo[] routesPush= (ProductDestVo[]) JSONArray.toArray(JSONArray.fromObject(reMap.get("responseBody").toString()),ProductDestVo.class);
			try {
				logger.info("删除数据库中的所有数据");
				timingService.deleteProductDest();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ProductDest productDest= new ProductDest();
			for(ProductDestVo productDestVo : routesPush){
				//目的地ID
				productDest.setDestId(productDestVo.getDest_id());
				//目的地名称
				productDest.setDestName(productDestVo.getDest_name());
				//目的地拼音
				productDest.setPinyin(productDestVo.getPinyin());
				//目的地父级目的地ID
				productDest.setDestPId(productDestVo.getDest_pid());
				//目的地英文名称
				productDest.seteName(productDestVo.getE_name());
				//国内：‘1’；出境：‘2’
				productDest.setSystemFlag(productDestVo.getSystem_flag());
				productDest.setStatus("1");
				productDest.setCreateTime(new Date());
				productDest.setHotDest("0");
				if(productDestVo.getB2c_flag().equals("9")){
					productDest.setSystemFlag("2");
				}
				try {
					logger.info("数据保存到数据库中");
					timingService.saveProductDest(productDest);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * 接口：获取--所有参团路线推送到国安社区E店商品上传
	 * 接口描述：获取中国国旅所有参团路线并且半小时推送到国安社区E店
	 * 接口apiId:getDomesticRouteDetail
	 * 参数示例{"routeId": "07001595620"}
	 * @param body
	 * @param request
	 * @param response
	 */
	//@Scheduled(cron="0 0 0/1 * * ?")（无用）
//	@RequestMapping(value="getDomesticGroupRoutesPush")
	public void  getDomesticGroupRoutesPush(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>1");
		//获取国内参团所属区域列表接口
		JSONObject params = new JSONObject();
		JSONObject header = new JSONObject();
		JSONObject body = new JSONObject();
		params.put("header", header);
		params.put("body", body);
		logger.info("报案请求参数>>>" + params);
		try {
			logger.info("查询国内参团所属区域列表>>>>>>");
			Map<String,Object> reMap = domesticRoute.getDomesticGroupDestArea(params.toString());
			Routes[] routesPush= (Routes[]) JSONArray.toArray(JSONArray.fromObject(reMap.get("responseBody").toString()),Routes.class);
			logger.info("查询所有数据进行拼接");
			StringBuffer stringBuffer= new StringBuffer("{\"destArea\":\"");
			for(Routes routes : routesPush){
				stringBuffer.append(routes.getAreaId()+",");
			}
			stringBuffer.append("\"}");
			int idx = stringBuffer.lastIndexOf(",");
			String str1 = stringBuffer.substring(0,idx);//通过截取逗号前的字符串
			String str2 = stringBuffer.substring(idx+1,stringBuffer.length());//截取逗号后的字符串
			logger.info("获取到所需要的参数列表",str1+str2);
			logger.info("查询国内参团线路列表>>>>>>");
			Map<String,Object> map = domesticRoute.getDomesticGroupRoutes((str1+str2).toString());
			JSONObject jsObject=JSONObject.fromObject(map.get("responseBody").toString());
			jsObject.get("ResultInfoLs").toString();
			JSONArray jsonArray=JSONArray.fromObject(jsObject.get("ResultInfoLs").toString());
			StringBuffer stringBu= new StringBuffer("[");
			for(int i=0;i<jsonArray.size();i++){
				JSONObject job = jsonArray.getJSONObject(i);
				stringBu.append("{\"proCode\":\""+job.get("routeId")+"\",\"shelfState\":\"on\"},");
			}
			stringBu.append("]");
			int idx2 = stringBu.lastIndexOf(",");
			String str3 = stringBu.substring(0,idx2);//通过截取逗号前的字符串
			String str4 = stringBu.substring(idx2+1,stringBu.length());//截取逗号后的字符串
			logger.info("获取到所需要的参数列表",str3+str4);
			ProShelfState proShelfState = new ProShelfState();
			proShelfState.setEshopCode(Constants.guolv_e_shop);
			proShelfState.setShelfInfo(str3+str4);
			String sign =SignUtils.getSign(proShelfState, Constants.guolv_e_key);
			proShelfState.setSign(sign);
			String buildLink=LinkUtils.buildLink(BeanUtils.getMap(proShelfState));
			logger.info("获取到所需要的参数列表","sign="+sign);
			String  url = Constants.Eshop_key+Constants.updateProShelfState+"?"+buildLink;
			HttpCommandProvider commandProvider = new HttpCommandProvider();
			commandProvider.setGetMethod().setUrl(url).send();
		} catch (Exception e) {
			logger.error("请求流解析异常",e);
			e.printStackTrace();
		}
	}
	@Scheduled(cron="0 0 0/1 * * ?")
	@RequestMapping(value="getOutboundGroupRoutesPush")
	public void getOutboundGroupRoutesPush(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>2");
		//获取国内参团所属区域列表接口
		JSONObject params = new JSONObject();
		JSONObject header = new JSONObject();
		JSONObject body = new JSONObject();
		params.put("header", header);
		params.put("body", body);
		logger.info("报案请求参数>>>" + params);
		try {
			logger.info("查询国内参团所属区域列表>>>>>>");
			Map<String,Object> reMap = abroadRouteService.getOutboundGroupDestArea(params.toString());
			Routes[] routesPush= (Routes[]) JSONArray.toArray(JSONArray.fromObject(reMap.get("responseBody").toString()),Routes.class);
			logger.info("查询所有数据进行拼接");
			StringBuffer stringBuffer= new StringBuffer("{\"destArea\":\"");
			for(Routes routes : routesPush){
				stringBuffer.append(routes.getAreaId()+",");
			}
			stringBuffer.append("\"}");
			int idx = stringBuffer.lastIndexOf(",");
			String str1 = stringBuffer.substring(0,idx);//通过截取逗号前的字符串
			String str2 = stringBuffer.substring(idx+1,stringBuffer.length());//截取逗号后的字符串
			logger.info("获取到所需要的参数列表",str1+str2);
			logger.info("查询国内参团线路列表>>>>>>");
			Map<String,Object> map = abroadRouteService.getOutboundGroupRoutes((str1+str2).toString());
			JSONObject jsObject=JSONObject.fromObject(map.get("responseBody").toString());
			jsObject.get("ResultInfoLs").toString();
			JSONArray jsonArray=JSONArray.fromObject(jsObject.get("ResultInfoLs").toString());
			StringBuffer stringBu= new StringBuffer("[");
			for(int i=0;i<jsonArray.size();i++){
				JSONObject job = jsonArray.getJSONObject(i);
				stringBu.append("{\"proCode\":\""+job.get("routeId")+"\",\"shelfState\":\"on\"},");
			}
			stringBu.append("]");
			int idx2 = stringBu.lastIndexOf(",");
			String str3 = stringBu.substring(0,idx2);//通过截取逗号前的字符串
			String str4 = stringBu.substring(idx2+1,stringBu.length());//截取逗号后的字符串
			logger.info("获取到所需要的参数列表",str3+str4);
			ProShelfState proShelfState = new ProShelfState();
			proShelfState.setEshopCode(Constants.guolv_e_shop);
			proShelfState.setShelfInfo(str3+str4);
			String sign =SignUtils.getSign(proShelfState, Constants.guolv_e_key);
			proShelfState.setSign(sign);
			String buildLink=LinkUtils.buildLink(BeanUtils.getMap(proShelfState));
			logger.info("获取到所需要的参数列表","sign="+sign);
			String  url = Constants.Eshop_key+Constants.updateProShelfState+"?"+buildLink;
			HttpCommandProvider commandProvider = new HttpCommandProvider();
			System.out.println(url);
			commandProvider.setGetMethod().setUrl(url).send();
		} catch (Exception e) {
			logger.error("请求流解析异常",e);
			e.printStackTrace();
		}
	}

	/**
	 * 删除 已取消订单的数据每个月的第一天 以后每隔5天启动一次
	 */
	//@RequestMapping(value="delectCancellationorder")
	@Scheduled(cron="0 0 12 1/5 * ?")
	public void delectCancellationorder(){
		try {
			String statelocal="4";
			//查询所有的已取消订单信息
			List<OrderInfo> orderInfoLIst =portService.getorderList(statelocal);
			//循环list 根据id进行删除
			for(int i = 0;i < orderInfoLIst.size();i ++){
				//根据id删除数据
				int orderTouristOne=portService.delectOrderTouristByOrderId(orderInfoLIst.get(i).getOrderId());
				int orderInfoOne=portService.delectorderInfoByOrderId(orderInfoLIst.get(i).getOrderId());
				logger.info("删除数据",orderInfoOne+orderTouristOne);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	   
	/**
	 * 根据查询所有的的数据并且根据创建时间和当前的时间进行比较 修改state_local的状态为0，1,2 修改为4
	 */
	@Scheduled(cron="0 0/15 * * * ?")
	public void updateCancellationorder(){
	try {
		//查询所有的订单进行
		portService.updateOrderTourist();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	/**
	* 获取国旅的路线信息上传到e店上
	* 定时：每天晚上十二点上传尚品
	*/
	//@Scheduled(cron="0 0/15 * * * ?")
	@RequestMapping(value="addGoods")
	public void addGoods(){
		JSONObject params = new JSONObject();
		JSONObject header = new JSONObject();
		JSONObject body = new JSONObject();
		params.put("header", header);
		params.put("body", body);
		try {
			logger.info("报案请求参数>>>" + params);
				logger.info("查询国内参团所属区域列表>>>>>>");
				Map<String,Object> reMap = abroadRouteService.getOutboundGroupDestArea(params.toString());
				Routes[] routesPush= (Routes[]) JSONArray.toArray(JSONArray.fromObject(reMap.get("responseBody").toString()),Routes.class);
				logger.info("查询所有数据进行拼接");
				StringBuffer stringBuffer= new StringBuffer("{\"destArea\":\"");
				for(Routes routes : routesPush){
				stringBuffer.append(routes.getAreaId()+",");
				//查询所有的订单进行
				List<OrderInfo> orderInfoLIst =portService.getorderAllList();
				for(int i = 0;i < orderInfoLIst.size();i ++){
					//根据id删除数据
					portService.updateOrderTourist();
					logger.info("修改数据",orderInfoLIst.get(i).getOrderId());
				}
				stringBuffer.append("\"}");
				int idx = stringBuffer.lastIndexOf(",");
				String str1 = stringBuffer.substring(0,idx);//通过截取逗号前的字符串
				String str2 = stringBuffer.substring(idx+1,stringBuffer.length());//截取逗号后的字符串
				logger.info("获取到所需要的参数列表",str1+str2);
				logger.info("查询国内参团线路列表>>>>>>");
				Map<String,Object> map = abroadRouteService.getOutboundGroupRoutes((str1+str2).toString());
				JSONObject jsObject=JSONObject.fromObject(map.get("responseBody").toString());
				jsObject.get("ResultInfoLs").toString();
				JSONArray jsonArray=JSONArray.fromObject(jsObject.get("ResultInfoLs").toString());
				StringBuffer stringBu= new StringBuffer("[");
				for(int i=0;i<jsonArray.size();i++){
					JSONObject job = jsonArray.getJSONObject(i);
					stringBu.append("{\"proCode\":\""+job.get("routeId")+"\",\"shelfState\":\"on\"},");
				}
				stringBu.append("]");
				int idx2 = stringBu.lastIndexOf(",");
				String str3 = stringBu.substring(0,idx2);//通过截取逗号前的字符串
				String str4 = stringBu.substring(idx2+1,stringBu.length());//截取逗号后的字符串
				logger.info("获取到所需要的参数列表",str3+str4);
				ProShelfState proShelfState = new ProShelfState();
				proShelfState.setEshopCode(Constants.guolv_e_shop);
				proShelfState.setShelfInfo(str3+str4);
				String sign =SignUtils.getSign(proShelfState, Constants.guolv_e_key);
				proShelfState.setSign(sign);
				String buildLink=LinkUtils.buildLink(BeanUtils.getMap(proShelfState));
				logger.info("获取到所需要的参数列表","sign="+sign);
				String  url = Constants.Eshop_key+Constants.updateProShelfState+"?"+buildLink;
				HttpCommandProvider commandProvider = new HttpCommandProvider();
				System.out.println(url);
				commandProvider.setGetMethod().setUrl(url).send();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 每天一点删除今天之间的价格日历
	 */

	//@RequestMapping(value="deleteTreamdetail")
	@Scheduled(cron="0 0 1 * * ?")
	public void deleteTreamdetail(){
		try {
			treamDetailService.deleteTreamdetailByStartDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 判断产品中是否有价格日历，没有价格日历关闭该产品
	 */
	@RequestMapping(value="closeProduct")
	@Scheduled(cron="0 0 3 * * ?")
	public void closeProduct(){
		//获取所有的非关闭的线路数据
		List<Product> productList = productService.selectProductList();
		if(productList.size()>0){
			for(int i=0;  i <productList.size();i++ ){
				productList.get(i).getpId();
				List<ProductInfoWithBLOBs> productInfoList=productService.queryProductByPID(productList.get(i).getpId().toString());
				if(productInfoList.size()>0){
					List<TreamDetail> treamDetail=productService.selectTreamDetailByIid(productInfoList.get(0).getiId());
					if(treamDetail.size()<1){
						productList.get(i).setStatus("0");
						productService.updateProduct(productList.get(i));
					}
				}
			}
		}

	}
}