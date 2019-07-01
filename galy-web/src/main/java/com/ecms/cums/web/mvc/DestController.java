package com.ecms.cums.web.mvc;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecms.cums.logutils.FunOrderLog;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ecms.cums.logutils.FunOrderLog;
import com.ecms.cums.services.DomesticRouteService;
import com.ecms.cums.services.GuoLvOutService;
import com.ecms.cums.services.GuoLvService;



/**
 *
 * @ClassName: DestController
 * @Description: 获取并更新本地仓库产品列表
 * @author: zJin
 * @date: 2018年3月27日 上午11:22:43
 */
@Controller
@RequestMapping("/sys/dest")
public class DestController extends BaseController{

	@Autowired
	private GuoLvService guoLvService;

	@Autowired
	private DomesticRouteService domesticRoute;

	@Autowired
	private GuoLvOutService guoLvOutService;

	@RequestMapping("/getProductDest")
	public void getProductDest(HttpServletRequest request,HttpServletResponse response){
//		Map<String,Object> map = guoLvService.getProductDest("");
//		Map<String, Object> map = new HashMap<>();
//		JSONObject resheader = JSONObject.fromObject(map.get("responseHeader"));
//		if(!"1".equals(resheader.getString("msgId"))){
//			FunOrderLog.logger.info("调用国旅目的地接口失败"+map.toString());
//			this.getErrorResponse(response);
//			return;
//		}
//
//		JSONArray resBody = JSONArray.fromObject(map.get("responseBody"));
//		for(int i=0;i<resBody.size();i++){
//			JSONObject jo = JSONObject.fromObject(resBody.get(i));
//			String destId = jo.getString("dest_id");
//			String systemFlag = jo.getString("system_flag");
//			String b2c_flag = jo.getString("b2c_flag");
//			if("9".equals(b2c_flag))
//				systemFlag = "2";
//			if("1".equals(systemFlag)){ // 国内
//				Map<String,Object> reMap = domesticRoute.getDomesticGroupRoutes("{'destId':'"+destId+"'}");
//				FunOrderLog.logger.info("国内"+reMap.toString());
//			}else{ //出境
////				Map<String,Object> reMap = guoLvOutService.getOutboundGroupRoutes("{'destId':'"+destId+"'}");
////				FunOrderLog.logger.info("出境"+reMap.toString());
//			}
//
//		}

	}



}
