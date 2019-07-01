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
import com.ecms.cums.model.Role;
import com.ecms.cums.services.RoleService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * @ClassName: AuthorityController
 * @Description: 角色权限管理
 * @author: wangyinglei
 * @date: 2018年6月28日 下午4:18:22
 */
@Controller
@RequestMapping("/roleManage")
public class RoleController extends BaseController{
	@Autowired
	private RoleService roleService;
	@RequestMapping("/JumpRole")
	public String JumpAuthority(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,ServletRequest request,Model model){
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		PageBounds pageBounds = new PageBounds(pageNumber, pageSize);
		List<Role> list = roleService.queryPage(pageBounds,searchParams);
		PageList<Role> pageList = (PageList<Role>)list;
		model.addAttribute("list", list);
		model.addAttribute("pageList", pageList);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "role/roleList";
	}

	@RequestMapping("/queryRole")
	public String queryRole(){
		return "role/roleModel";
	}

	@RequestMapping("/addRole")
	@ResponseBody
	public String addRole(HttpServletRequest request,
			HttpServletResponse response,Role role){
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		String msg="";
		try {
			List<Role> list = roleService.selectRoleByKey(role.getRoleKey(),role.getId());
			if(list.size()<1){
				if(role.getId()==null||role.getId().equals("")){
					role.setCreateTime(new Date());
					role.setCreatePerson(activeUser.getUsername());
					roleService.addRole(role);
					msg="1";
				}else{
					role.setUpdateTime(new Date());
					role.setUpdatePerson(activeUser.getUsername());
					roleService.updateRole(role);
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

	@RequestMapping("/updateRole")
	public String updateRole(HttpServletRequest request,HttpServletResponse response,
			Model model,String id){
		Role role= roleService.selectRoleByID(Integer.parseInt(id));
		model.addAttribute("role",role);
		return "role/roleModel";
	}

	@RequestMapping(value="/toExamine")
	public void toExamine(HttpServletRequest request,HttpServletResponse response,
			String ids,String nums)throws Exception{
		 	ids = ids.substring(0, ids.length() - 1);
		 	String[] idss = ids.split(",");
		 	for (String id : idss) {
			  if(!id.equals("on")){
					  roleService.deleteRoleByid(Integer.parseInt(id));
			  }

		  }
	}

}
