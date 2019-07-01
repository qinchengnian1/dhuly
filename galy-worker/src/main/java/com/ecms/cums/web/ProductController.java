package com.ecms.cums.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springside.modules.web.Servlets;

import com.ecms.cums.core.util.BeanUtils;
import com.ecms.cums.core.util.DateConversionWeek;
import com.ecms.cums.core.util.HttpCommandProvider;
import com.ecms.cums.core.util.JsonUtils;
import com.ecms.cums.core.util.LinkUtils;
import com.ecms.cums.core.util.SignUtils;
import com.ecms.cums.cores.Constants;
import com.ecms.cums.model.CityComp;
import com.ecms.cums.model.EShop;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.productvo.AttachmentsInfo;
import com.ecms.cums.productvo.ProductJson;
import com.ecms.cums.productvo.ProductJsonVo;
import com.ecms.cums.services.EshopService;
import com.ecms.cums.services.ProductDestService;
import com.ecms.cums.services.ProductService;
import com.ecms.cums.services.TravelTypeService;
import com.ecms.cums.util.ExportExcel;
import com.ecms.cums.util.FileUpload;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * @ClassName: ProductController
 * @Description: 产品管理
 * @author: zJin
 * @date: 2018年4月4日 下午2:51:14
 */
@Controller
@RequestMapping("/productManage")
public class ProductController extends BaseController{
	@Autowired
	private ProductService productService;
	@Autowired
	private TravelTypeService travelTypeService;
	@Autowired
	private ProductDestService productDestService;
	@Autowired
	private EshopService eshopService;


	/**
	 * @Title: chooseDefultPage
	 * @Description: 选择供应商默认页面
	 * @return
	 * @return: String
	 */
	@RequestMapping("/chooseDefultPage")
	public String chooseDefultPage(){
		return "product/chooseDefultPage";
	}

	/**
	 * @Title: getCityList
	 * @Description: 获取城市公司下所有供应商列表
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/getCityList")
	public String getCityList(HttpServletRequest request,HttpServletResponse response,Model model){
		String citycompid= (String)request.getSession().getAttribute("citycompid");
		List<CityComp> list = productService.selectCityCompList(citycompid);
		model.addAttribute("cityList", list);
		return "product/cityComp";
	}

	/**
	 * @Title: getProductList
	 * @Description: 获取产品列表
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("/productList/{eId}")
	public String getProductList(@RequestParam(value = "page", defaultValue = "1") int pageNumber,@PathVariable("eId") String eId,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,ServletRequest request,Model model){
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		searchParams.put("eShopId", eId);
		PageBounds pageBounds = new PageBounds(pageNumber, pageSize);
		List<Product> list = productService.queryPage(pageBounds,searchParams);
		PageList<Product> pageList = (PageList<Product>)list;
		model.addAttribute("pageList",pageList);
		model.addAttribute("eId", eId);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "product/list";
	}

	/**
	 * @Title: addTravel
	 * @Description: 添加线路信息
	 * @return
	 * @return: String
	 */
	@RequestMapping("/queryTravel/{eId}")
	public String queryTravel(ServletRequest request,@PathVariable("eId") String eId,Model model){
		//获取线路类型
		List<TravelType> travelTypelist = travelTypeService.queryTravelTypeList();
		List<ProductDest> productDestList= productDestService.queryProductDestLsit();
		//获取目的地城市列表
		model.addAttribute("travelTypelist",travelTypelist);
		model.addAttribute("productDestList",productDestList);
		model.addAttribute("eId",eId);
		return "product/modelPage";
	}
	@RequestMapping("/addProduct")
	public  void addProduct(HttpServletRequest request,HttpServletResponse response,
			Product product,String num,String nums,MultipartFile file,String eId)throws Exception{
			try {
				if(file!=null){
					String filePath = FileUpload.uploadFile(file, request);
					product.setPicPath(filePath);
				}
				product.setCityIds("010");
				product.setStatus("0");
				if(product.getpId()==null){
					product.setCreateTime(new Date());
					product.setCompId(Integer.parseInt(eId));
					productService.addProduct(product);
				}else{
					product.setUpdateTime(new Date());
					productService.updateProduct(product);
				}
				if(num.equals("1")){
					List<Product> productList=productService.queryProductByName(product.getPtNo());
					request.getSession().setAttribute("pId", productList.get(0).getpId());
					Map<String, Object> map =new HashMap<String, Object>();
					map.put("eId", eId);
					this.getSuccessResponse(response,map);
				}else{
					Map<String, Object> map =new HashMap<String, Object>();
					map.put("eId", eId);
					this.getSuccessResponse(response,map);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}


	}
	@RequestMapping("/addProductInfo")
	public  void addProductInfo(HttpServletRequest request,HttpServletResponse response,
			ProductInfoWithBLOBs productInfoWithBLOBs,String numTwo,MultipartFile fileOne,
			MultipartFile fileTwo,MultipartFile fileThree,MultipartFile fileFour,String eId)throws Exception{
			Integer pId=(Integer) request.getSession().getAttribute("pId");
			try {
				if(fileOne!=null){
					 String filePath1 = FileUpload.uploadFile(fileOne, request);
				     String filePath2 = FileUpload.uploadFile(fileTwo, request);
				     String filePath3 = FileUpload.uploadFile(fileThree, request);
				     String filePath4 = FileUpload.uploadFile(fileFour, request);
				     filePath1 = filePath1+","+filePath2+","+filePath3+","+filePath4;
				     productInfoWithBLOBs.setPicPath(filePath1);
				}
				if(productInfoWithBLOBs.getiId()==null){
					 productInfoWithBLOBs.setpId(pId);
					 productInfoWithBLOBs.setCreateTime(new Date());
					 productService.addProductInfo(productInfoWithBLOBs);
				}else{
					productInfoWithBLOBs.setUpdateTime(new Date());
					productService.updateProductInfo(productInfoWithBLOBs);
				}

			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			if(numTwo.equals("1")){
				try {
					List<ProductInfoWithBLOBs> productInfoList=productService.queryProductByPID(productInfoWithBLOBs.getpId().toString());
					request.getSession().setAttribute("iId", productInfoList.get(0).getiId());
					request.getSession().setAttribute("jnyDays", productInfoList.get(0).getJnyDays());
					Map<String, Object> map =new HashMap<String, Object>();
					map.put("eId", eId);
					this.getSuccessResponse(response,map);
			} catch (Exception e) {
					this.getErrorResponse(response,"系统错误，请联系管理员");
					e.printStackTrace();
				}
			}else{
				//request.getSession().setAttribute("iId", productInfoList.get(0).getiId());
				Map<String, Object> map =new HashMap<String, Object>();
				map.put("eId", eId);
				this.getSuccessResponse(response,map);
			}

	}
	@RequestMapping(value="/addTreamDetail",method = RequestMethod.POST)
	@ResponseBody
	public  void addTreamDetail(@RequestBody String data,HttpServletRequest request)throws Exception{
		try {
			Integer iID=(Integer) request.getSession().getAttribute("iId");
			String jnyDays=(String) request.getSession().getAttribute("jnyDays");
			JSONArray jsonArray=JSONArray.fromObject(data);
			TreamDetail treamDetail = new TreamDetail();
			if(jsonArray.size()>0){
				for(int i=0;i<jsonArray.size();i++){
				JSONObject job = jsonArray.getJSONObject(i);
				treamDetail.setiId(iID);
				//开始时间
				treamDetail.setStartDate(job.get("date").toString());
				String week_date=DateConversionWeek.dateToWeek(job.get("date").toString());
				//开始时间对应的星期几
				treamDetail.setWeekDate(week_date);
				//最小的成团人数
				treamDetail.setMinNum(job.get("min_num").toString());
				//剩余人数
				treamDetail.setLeftNum(job.get("left_num").toString());
				//儿童价
				treamDetail.setChildPrice(job.get("child_price").toString());
				//成人价
				treamDetail.setAdultPrice(job.get("adult_price").toString());
				//返回日期
				Calendar calendar=Calendar.getInstance();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				calendar.setTime(df.parse((String)job.get("date")) );
				calendar.add(Calendar.DATE,Integer.parseInt(jnyDays)-1);
				treamDetail.setReturnDate(df.format(calendar.getTime()).toString());
				//返回日期对应星期几
				String reWeekDate=DateConversionWeek.dateToWeek(df.format(calendar.getTime()).toString());
				//报名截止日期
				Calendar calendar2=Calendar.getInstance();
				calendar2.setTime(df.parse((String)job.get("date")));
				calendar2.add(Calendar.DATE,-1);
				treamDetail.setDeadlineDate(df.format(calendar2.getTime()).toString());
				treamDetail.setReWeekDate(reWeekDate);
				if(job.get("tId").toString()==null || job.get("tId").toString().length()==0){
					List<TreamDetail> re=productService.getTreamDetail(job.get("date").toString(),iID);
					if(re.size()>0){
						treamDetail.settId(re.get(0).gettId());
						productService.updateTreamDetail(treamDetail);
					}else{
						treamDetail.setCreateTime(new Date());
						productService.addTreamDetail(treamDetail);
					}
				}else{
					treamDetail.setUpdateTime(new Date());
					treamDetail.settId(Integer.parseInt(job.get("tId").toString()));
					productService.updateTreamDetail(treamDetail);
				}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/viewTheDetails",method = RequestMethod.POST)
	public String viewTheDetails(HttpServletRequest request,HttpServletResponse response,
			String id,Model model)throws Exception{
		//根据id 查询
		Product product= productService.selectProductByID(Integer.parseInt(id));
		List<TravelType> travelTypelist = travelTypeService.queryTravelTypeList();
		List<ProductDest> productDestList= productDestService.queryProductDestLsit();
		List<ProductInfoWithBLOBs> productInfoList=productService.queryProductByPID(product.getpId().toString());
		List<TreamDetail> treamDetail=productService.selectTreamDetailByIid(productInfoList.get(0).getiId());
		model.addAttribute("product",product);
		model.addAttribute("productInfoList", productInfoList.get(0));
		model.addAttribute("treamDetail", treamDetail);
		model.addAttribute("travelTypelist",travelTypelist);
		model.addAttribute("productDestList",productDestList);
		return "product/viewDetails";
	}
	@RequestMapping(value="/toExamine")
	public void toExamine(HttpServletRequest request,HttpServletResponse response,
			String ids,String nums, String eId)throws Exception{
		 	ids = ids.substring(0, ids.length() - 1);
		 	String[] idss = ids.split(",");
		 		for (String id : idss) {
			  if(!id.equals("on")){
					Product product =  (Product) productService.selectProductByID(Integer.parseInt(id));
					if(nums.equals("1")){
						product.setStatus("1");
						ProductJson productJson = new ProductJson();
						productJson.setContent_tag("国安旅游");
						int len = product.getRouteMain().length();
						if(len>10){
							String rou=product.getRouteMain().substring(0,10);
							productJson.setContent_name(rou);
						}else{
							productJson.setContent_name(product.getRouteMain());
						}
						productJson.setContent_price(Float.parseFloat(product.getPrice()));
						productJson.setMin_number(0);
						productJson.setMax_number(999999);
						productJson.setIs_combo_split("no");
						productJson.setContent_type("product");
						productJson.setIs_combo("no");
						productJson.setContent_number(999999);
						productJson.setContent_img("");
						productJson.setContent_unit("1");
						productJson.setSelf_code(product.getPtNo());
						productJson.setContent_shelf("hidden");
						JSONObject object = JSONObject.fromObject(productJson);
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
						//根据t_id得到e店的编码和e店的秘钥
						 EShop eShop= eshopService.selectEShopByID(product.getCompId());
						query.setEshop_code(eShop.geteKey());
						query.setProduct(obj);
						String sign =SignUtils.getSign(query, eShop.geteKeyNo());
						/*query.setEshop_code(Constants.guolv_e_shop);
						query.setProduct(obj);
						String sign =SignUtils.getSign(query, Constants.guolv_e_key);*/
						query.setSign(sign);
						String buildLink=LinkUtils.buildLink(BeanUtils.getMap(query));
						String url = Constants.Eshop_key+Constants.addGoods+"?"+buildLink;
						HttpCommandProvider commandProvider = new HttpCommandProvider();
						String returnse= commandProvider.setGetMethod().setUrl(url).send();
						JSONObject taParam = JSONObject.fromObject(returnse);
						if("添加成功".equals(taParam.getString("return_msg"))){
							product.setStatus("1");
						}else if("你所填的自定义编码商品库已有，请重新填写".equals(taParam.getString("return_msg"))){
							product.setStatus("1");
						}else{
							this.getErrorResponse(response,"上传产品失败");
							return;
						}
					}else if(nums.equals("2")){
						product.setStatus("0");
					}
					Date data = new Date();
					product.setUpdateTime(data);
					productService.updateProduct(product);
			  }

		  }
	}
	@RequestMapping("/returnProduc")
	public String returnProduc(HttpServletRequest request,
			HttpServletResponse response,Model model,String status,String eId){
		Integer pId=(Integer) request.getSession().getAttribute("pId");
		Product product= productService.selectProductByID(pId);
		List<ProductDest> productDestList= productDestService.queryProductDestLsit();
		List<TravelType> travelTypelist = travelTypeService.queryTravelTypeList();
		model.addAttribute("productDestList",productDestList);
		model.addAttribute("travelTypelist",travelTypelist);
		model.addAttribute("product", product);
		model.addAttribute("status", status);
		model.addAttribute("eId", eId);
		return "product/modelPage";

	}

	@RequestMapping("/findProducByPtNo")
	@ResponseBody
	public String findProducByPtNo(Model model,String ptNo){
		String msg="";
		List<Product> productList = (List<Product>) productService.queryProductByName(ptNo);
		if(productList.size()<1 ){
			msg="0";
		}else{
			 msg ="1";
		}
		return msg;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/returnProducInfo")
	public String returnProducInfo(HttpServletRequest request,HttpServletResponse response,
			Model model,String eId){
		Integer iID=(Integer) request.getSession().getAttribute("iId");
		ProductInfoWithBLOBs bloBs=productService.selectProductInfoByID(iID);
		String[] strs=bloBs.getPicPath().split(",");
		ArrayList  b = new ArrayList();
		for(int i=0,len=strs.length;i<len;i++){
			 b.add(strs[i]);
		}
		model.addAttribute("bloBs",bloBs);
		model.addAttribute("list", b);
		model.addAttribute("eId", eId);
		return "product/modelPage";
	}
	@RequestMapping("/updateProduc")
	public String updateProduc(HttpServletRequest request,HttpServletResponse response,
			Model model,String pId,String status,String eId){
		Product product= productService.selectProductByID(Integer.parseInt(pId));
		List<ProductDest> productDestList= productDestService.queryProductDestLsit();
		List<TravelType> travelTypelist = travelTypeService.queryTravelTypeList();
		model.addAttribute("productDestList",productDestList);
		model.addAttribute("travelTypelist",travelTypelist);
		model.addAttribute("product", product);
		model.addAttribute("status", status);
		model.addAttribute("eId", eId);
		return "product/modelPage";

	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/updataProducInfo")
	public String updataProducInfo(HttpServletRequest request,HttpServletResponse response,
			Model model,String status,String eId){
		Integer pId=(Integer) request.getSession().getAttribute("pId");
		List<ProductInfoWithBLOBs> productInfoList=productService.queryProductByPID(pId.toString());
		if(productInfoList.size()>0){
			String[] strs=productInfoList.get(0).getPicPath().split(",");
			ArrayList  b = new ArrayList();
			for(int i=0,len=strs.length;i<len;i++){
				 b.add(strs[i]);
				 model.addAttribute("list", b);
			}
			model.addAttribute("bloBs",productInfoList.get(0));
			model.addAttribute("status", status);
			model.addAttribute("eId", eId);
		}
		return "product/modelPage";

	}
	@RequestMapping("/updataTreamDetail")
	public void updataTreamDetail(HttpServletRequest request,HttpServletResponse response){
		Integer iId=(Integer) request.getSession().getAttribute("iId");
		List<TreamDetail> treamDetail=productService.selectTreamDetailByIid(iId);
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("treamDetail", treamDetail);
		this.getSuccessResponse(response, map);
	}

	@RequestMapping("/deleteTreamDetail")
	public String deleteTreamDetail(HttpServletRequest request,HttpServletResponse response,String tid){
		//Integer iId=(Integer) request.getSession().getAttribute("iId");
			productService.deleteBydata(tid);
			return "product/modelPage";

	}

	@RequestMapping("/deleteTreamDetailAll")
	public String deleteTreamDetailAll(HttpServletRequest request,HttpServletResponse response,
			String delstartDay,String delendDay){
			Integer iId=(Integer) request.getSession().getAttribute("iId");
			productService.deleteTimeslot(iId,delstartDay,delendDay);
			return "product/modelPage";

	}

	/**
	 * @Title: addTravel
	 * @Description: 添加线路信息
	 * @return
	 * @return: String
	 * 		window.location.href="${ctx}/productManage/exportExcel/${eId}?routeMain="+search_routeMain+
	 * "&systemFlag="+search_systemFlag+"agentType="+search_agentType+"&status="+search_status;

	 */
	@RequestMapping("/exportExcel/{eId}")
	public ModelAndView exportExcel(ServletRequest request,HttpServletResponse response,@PathVariable("eId") String eId,String routeMain,
			String systemFlag,String agentType,String status){
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		searchParams.put("eShopId", eId);
		searchParams.put("routeMain", routeMain);
		searchParams.put("systemFlag", systemFlag);
		searchParams.put("agentType", agentType);
		searchParams.put("status", status);
		PageBounds pageBounds = new PageBounds();
		List<Product> list = productService.queryPage(pageBounds,searchParams);
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		String title ="路线列表"+dateFormater.format(new Date());
		String[] rowsName=new String[]{"序号","线路编号","线路名称","线路类别","推荐类别","价格","状态","创建时间"};
		List<Object[]>  dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		for (int i = 0; i < list.size(); i++) {
			Product po =list.get(i);
			objs = new Object[rowsName.length];
			objs[0] = i;
			objs[1] = po.getPtNo();
			objs[2] = po.getRouteMain();
			TravelType tra=travelTypeService.selectByid(po.gettId());
			objs[3] = tra.getTypeName();
			if(po.getAgentType().equals("1")){
				objs[4] = "自销";
			}else if(po.getAgentType().equals("2")){
				objs[4] = "推荐";
			}else if(po.getAgentType().equals("3")){
				objs[4] = "精品";
			}else {
				objs[4] = "人气";
			}
			objs[5] = po.getPrice();
			if(po.getStatus().equals("1")){
				objs[6] = "打开";
			}else{
				objs[6] = "关闭";
			}
			objs[7] = po.getCreateTime();

			dataList.add(objs);
		}
		ExportExcel ex =new ExportExcel(title, rowsName, dataList,response);
		ex.exportData();
		return null;
	}






}
