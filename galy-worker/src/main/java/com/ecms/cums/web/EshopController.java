package com.ecms.cums.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;

import com.ecms.cums.model.EShop;
import com.ecms.cums.services.EshopService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping("eshopManage")
public class EshopController  extends BaseController{
	@Autowired
	private EshopService eshopService;

	@RequestMapping("/JumpEshop")
	public String JumpAuthority(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
			HttpServletRequest request,Model model){
		String citycompid= (String)request.getSession().getAttribute("citycompid");
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		searchParams.put("cityId",citycompid);
		PageBounds pageBounds = new PageBounds(pageNumber, pageSize);
		List<EShop> list = eshopService.queryPage(pageBounds,searchParams);
		PageList<EShop> pageList = (PageList<EShop>)list;
		model.addAttribute("list", list);
		model.addAttribute("pageList", pageList);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "eshop/eshopList";
	}

	@RequestMapping("/queryEshop")
	public String queryEshop(){
		return "eshop/eshopModel";
	}

	@RequestMapping("/addEshop")
	@ResponseBody
	public String addEshop(HttpServletRequest request,
			HttpServletResponse response,EShop eShop){
		String msg="";
		try {
			if(eShop.geteId()==null||eShop.geteId().equals("")){
				String citycompid= (String)request.getSession().getAttribute("citycompid");
				eShop.setCityId(Integer.parseInt(citycompid));
				eshopService.addEshop(eShop);
				msg="1";
			}else{
				eshopService.updateEshop(eShop);
				msg="1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping("/updateEshop")
	public String updateEshop(HttpServletRequest request,HttpServletResponse response,
			Model model,String id){
		EShop eShop= eshopService.selectEShopByID(Integer.parseInt(id));
		model.addAttribute("eShop",eShop);
		return "eshop/eshopModel";
	}

	@RequestMapping(value="/toExamine")
	public void toExamine(HttpServletRequest request,HttpServletResponse response,
			String ids,String nums)throws Exception{
		 	ids = ids.substring(0, ids.length() - 1);
		 	String[] idss = ids.split(",");
		 	for (String id : idss) {
			  if(!id.equals("on")){
				  EShop eShop= eshopService.selectEShopByID(Integer.parseInt(id));
				  if(nums.equals("3")){
					  eshopService.deleteCitysByid(Integer.parseInt(id));
				  }else{
					  if(nums.equals("1")){
						  eShop.setStatus("1");
						}else if(nums.equals("2")){
							eShop.setStatus("0");
						}
					  eshopService.updateEshop(eShop);
				  }

			  }

		  }
	}
}
