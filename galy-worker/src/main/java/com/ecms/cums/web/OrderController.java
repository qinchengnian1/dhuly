package com.ecms.cums.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springside.modules.web.Servlets;

import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.model.Tourist;
import com.ecms.cums.services.OrderService;
import com.ecms.cums.services.PortService;
import com.ecms.cums.util.ExportExcel;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping("orderManage")
public class OrderController extends BaseController{
	@Autowired
	private  OrderService orderService;

	@Autowired
	private PortService portService;

	@RequestMapping("/JumpOrderInfo")
	public String JumpOrderInfo(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,HttpServletRequest request,Model model){
		String citycompid= (String)request.getSession().getAttribute("citycompid");
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		searchParams.put("cityId",citycompid);
		PageBounds pageBounds = new PageBounds(pageNumber, pageSize);
		List<OrderInfo> list = orderService.queryPage(pageBounds,searchParams);
		PageList<OrderInfo> pageList = (PageList<OrderInfo>)list;
		model.addAttribute("list", list);
		model.addAttribute("pageList", pageList);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "orderInfo/ordrInfoList";
	}

	/**
	 * 查看详情
	 */
	@RequestMapping("viewOrder")
	public String viewOrder(HttpServletRequest request,HttpServletResponse response,
			Model model,String orderId){
		OrderInfo orderInfo = orderService.selectOrderInfoByPrimaryKey(orderId);
		model.addAttribute("orderInfo", orderInfo);
		List<Tourist> ot = portService.getTouristInfoByOrderId(orderInfo.getOrderId());
		model.addAttribute("touristlist", ot);
		return "orderInfo/orderInfoView";
	}

	/**
	 * 导出数据
	 * @param request
	 * @param response
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/exportExcel")
	public ModelAndView  exportExcel(HttpServletRequest request, HttpServletResponse response,
			String perName,String stateLocal){
		List<OrderInfo> list = orderService.selectExportExcel(perName,stateLocal);
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		String title ="订单列表"+dateFormater.format(new Date());
		String[] rowsName=new String[]{"序号","平台编码","本地订单编号","下单用户","下单用户手机号","线路名称","网上预订价格","出发地址","支付状态","创建时间"};
		List<Object[]>  dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		for (int i = 0; i < list.size(); i++) {
			OrderInfo po =list.get(i);
			objs = new Object[rowsName.length];
			objs[0] = i;
			objs[1] = po.getOrderNoPt();
			objs[3] = po.getOrderNoLocal();
			objs[4] = po.getPerName();
			objs[5] = po.getPerTel();
			objs[6] = po.getRouteName();
			objs[7] = po.getOnlinePrice();
			objs[8] = po.getStartPlace();
			//0--待支付，1支付中 ，2正式报名失败，3 支付完成 ，4 支付取消,5--支付失败
			if(po.getStateLocal().equals("0")){
				objs[9] ="待支付";
			}else if(po.getStateLocal().equals("1")){
				objs[9] ="支付中";
			}else if (po.getStateLocal().equals("2")){
				objs[9] ="正式报名失败";
			}else if (po.getStateLocal().equals("3")){
				objs[9] ="支付完成";
			}else if (po.getStateLocal().equals("4")){
				objs[9] ="支付取消";
			}else {
				objs[9] ="支付失败 ";
			}

			objs[10] = po.getCreateTime();

			dataList.add(objs);
		}
		ExportExcel ex =new ExportExcel(title, rowsName, dataList,response);
		ex.exportData();
		return null;

	}

}
