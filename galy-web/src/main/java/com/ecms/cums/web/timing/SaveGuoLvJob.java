package com.ecms.cums.web.timing;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductGuolv;
import com.ecms.cums.services.AbroadRouteService;
import com.ecms.cums.services.DomesticRouteService;
import com.ecms.cums.services.LocalRouteService;
import com.ecms.cums.services.SaveGuoLvJobService;
import com.ecms.cums.web.vo.ResponseBodyVo;
import com.ecms.cums.web.vo.ResultInfosLsVo;
import com.google.gson.Gson;

/**
 * @ClassName: SaveGuoLvJob
 * @Description: 同步全网下国旅产品接口
 * @author: zJin
 * @date: 2018年5月17日 下午3:13:21
 */
@Component("saveGuoLvJob")
public class SaveGuoLvJob {

	private static final Logger logger = LoggerFactory.getLogger(SaveGuoLvJob.class);

	@Autowired
	private SaveGuoLvJobService saveGuoLvJobService;

	@Autowired
	private DomesticRouteService domesticRoute;

	@Autowired
	private AbroadRouteService abroadRouteService;

	@Autowired
	private LocalRouteService localRouteService;

//	@Scheduled(fixedRate= 2*60*60*1000)(无用)
	public void saveGuoLvManage(){
		logger.info("执行同步国旅国内参团所属区域列表接口开始："+ new Date());
		JSONObject params = new JSONObject();
		params.put("rowNum", "9999");
		List<ProductDest> productDest = saveGuoLvJobService.queryAllDest();
		List<ProductGuolv> guolvList = new ArrayList<ProductGuolv>();
		if(null!=productDest && productDest.size()>0){
			for(ProductDest dest:productDest){
				String systemFlag = "";
				params.put("destId",dest.getDestId());
				Map<String ,Object> map = new HashMap<String, Object>();
				if(dest.getSystemFlag().equals("1")){
					if("1".equals(dest.getSystemType())){ //国内参团
						//获取国旅国内跟团游接口数据
						map = localRouteService.getDomesticGroupRoutes(params.toString());
					}else{ //国内自由行
						//获取国旅国内自由行接口数据
						map = localRouteService.seachDomesticFree(params.toString());
					}
					systemFlag = "1";
				}else{
					if("1".equals(dest.getSystemType())){ //国外参团
						//获取国旅国外跟团游接口数据
						map = localRouteService.getOutboundGroupRoutes(params.toString());
					}else{
						//获取国旅国外自由行接口数据
						map = localRouteService.seachOutboundFree(params.toString());
					}
					systemFlag = "2";
				}
				if(null !=map){
					String responseBody = (String) map.get("responseBody");
					Gson gson=new Gson();
					ResponseBodyVo body =  gson.fromJson(responseBody,ResponseBodyVo.class);
					List<ResultInfosLsVo>  list = body.getResultInfoLs();
					if(null!=list){
						for(ResultInfosLsVo vo:list){
							ProductGuolv guolv = new ProductGuolv();
							guolv.setpSystemFlag(systemFlag);
							guolv.setpImageUrl(vo.getPicPath());
							guolv.setpPrice(vo.getPrice());
							guolv.setpRouteId(vo.getRouteId());
							guolv.setpRouteMain(vo.getRouteMain());
							String routeType = "";
							if("LY".equals(vo.getRouteType())){
								routeType = "两游自由行";
							}else if("ST".equals(vo.getRouteType())){
								routeType = "自由行";
							}else if("0".equals(vo.getRouteType())){
								routeType = "短途游";
							}else if("1".equals(vo.getRouteType())){
								routeType = "参团";
							}else if("3".equals(vo.getRouteType())){
								routeType = "自驾游";
							}else if("ticket".equals(vo.getRouteType())){
								routeType = "船票邮轮";
							}else if("package".equals(vo.getRouteType())){
								routeType = "打包游轮";
							}else if("team".equals(vo.getRouteType())){
								routeType = "两游假邮轮";
							}
							guolv.setpRouteType(routeType);
							guolv.setpStartDest(vo.getStartPlace());
							guolvList.add(guolv);
						}
					}
				}
			}

			if(null!=guolvList && guolvList.size()>0){
				saveGuoLvJobService.deleteGuolvProduct();
				for(ProductGuolv guolv:guolvList){
					saveGuoLvJobService.saveGuoLvProduct(guolv);
				}
			}



		}



	}


}
