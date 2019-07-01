package com.ecms.cums.web;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;

import com.ecms.cums.authvo.ActiveUser;
import com.ecms.cums.model.CityComp;
import com.ecms.cums.services.CitysService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping("/citysManage")
public class CitysControll extends BaseController{
	@Autowired
	private CitysService citysService;
	@RequestMapping("/JumpCitys")
	public String JumpAuthority(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,ServletRequest request,Model model){
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		PageBounds pageBounds = new PageBounds(pageNumber, pageSize);
		List<CityComp> list = citysService.queryPage(pageBounds,searchParams);
		PageList<CityComp> pageList = (PageList<CityComp>)list;
		model.addAttribute("list", list);
		model.addAttribute("pageList", pageList);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "citys/citysList";
	}

	@RequestMapping("/queryCitys")
	public String queryAuthority(){
		return "citys/citysModel";
	}

	@RequestMapping("/addCitys")
	@ResponseBody
	public String addCitys(HttpServletRequest request,
			HttpServletResponse response,CityComp cityComp){
		String msg="";
		try {
			List<CityComp> list = citysService.selectCitysBykey(cityComp.getRemark(),cityComp.getCityId());
			if(list.size()<1){
				if(cityComp.getCityId()==null||cityComp.getCityId().equals("")){
					citysService.addCitys(cityComp);
					msg="1";
				}else{
					citysService.updateCitys(cityComp);
					msg="1";
				}
			}else{
				msg="0";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@RequestMapping("/updateCitys")
	public String updateRole(HttpServletRequest request,HttpServletResponse response,
			Model model,String id){
		CityComp cityComp= citysService.selectCitysByID(Integer.parseInt(id));
		model.addAttribute("cityComp",cityComp);
		return "citys/citysModel";
	}
	@RequestMapping(value="/toExamine")
	public void toExamine(HttpServletRequest request,HttpServletResponse response,
			String ids,String nums)throws Exception{
		 	ids = ids.substring(0, ids.length() - 1);
		 	String[] idss = ids.split(",");
		 	for (String id : idss) {
			  if(!id.equals("on")){
				  CityComp cityComp= citysService.selectCitysByID(Integer.parseInt(id));
				  if(nums.equals("3")){
					  citysService.deleteCitysByid(Integer.parseInt(id));
				  }else{
					  if(nums.equals("1")){
						  cityComp.setStatus("1");
						}else if(nums.equals("2")){
							cityComp.setStatus("0");
						}
					  citysService.updateCitys(cityComp);
				  }

			  }

		  }
	}

}
