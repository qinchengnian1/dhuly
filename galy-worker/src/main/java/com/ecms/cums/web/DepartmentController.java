package com.ecms.cums.web;

import java.util.Date;
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
import com.ecms.cums.model.Department;
import com.ecms.cums.services.DepartmentService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * @ClassName: DepartmentController
 * @Description: 部门管理
 * @author: wangyinglei
 * @date: 2018年612日 下午4:18:22
 */
@Controller
@RequestMapping("/departmentManage")
public class DepartmentController extends BaseController{
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/JumpDepartment")
	public String JumpDepartment(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,ServletRequest request,Model model){
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		PageBounds pageBounds = new PageBounds(pageNumber, pageSize);
		List<Department> list = departmentService.queryPage(pageBounds,searchParams);
		PageList<Department> pageList = (PageList<Department>)list;
		model.addAttribute("list", list);
		model.addAttribute("pageList", pageList);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "department/departmentList";
	}
	@RequestMapping("/addDepartment")
	@ResponseBody
	public String addDepartment(HttpServletRequest request,
			HttpServletResponse response,Department department){
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		String msg="";
		try {
			List<Department> list = departmentService.selectDepartmentByKey(department.getDepartmentKey(),department.getId());
			if(list.size()<1){
				if(department.getId()==null||department.getId().equals("")){
					department.setStatus("0");
					department.setCreateTime(new Date());
					department.setCreatePerson(activeUser.getUsername());
					departmentService.addDepartment(department);
					msg="1";
				}else{
					department.setUpdateTime(new Date());
					department.setUpdatePerson(activeUser.getUsername());
					departmentService.updateDepartment(department);
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

	@RequestMapping("/queryDepartment")
	public String queryDepartment(){
		return "department/departmentModel";
	}
	@RequestMapping("/updateDepartment")
	public String updateDepartment(HttpServletRequest request,HttpServletResponse response,
			Model model,String id){
		Department department= departmentService.selectDepartmentID(Integer.parseInt(id));
		model.addAttribute("department",department);
		return "department/departmentModel";

	}
	@RequestMapping(value="/toExamine")
	public void toExamine(HttpServletRequest request,HttpServletResponse response,
			String ids,String nums)throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		 	ids = ids.substring(0, ids.length() - 1);
		 	String[] idss = ids.split(",");
		 		for (String id : idss) {
			  if(!id.equals("on")){
				  Department department = departmentService.selectDepartmentByID(Integer.parseInt(id));
				  if(nums.equals("3")){
					  departmentService.deleteDepartmentByid(Integer.parseInt(id));
				  }else{
					  if(nums.equals("1")){
							department.setStatus("1");
						}else if(nums.equals("2")){
							department.setStatus("0");
						}
						department.setUpdateTime(new Date());
						department.setUpdatePerson(activeUser.getUsername());
						departmentService.updateDepartment(department);
				  }
			  }

		  }
	}


}
