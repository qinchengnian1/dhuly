package com.ecms.cums.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecms.cums.model.*;
import com.ecms.cums.services.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;

import com.ecms.cums.authvo.ActiveUser;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping("/sysUserManage")
public class SysUserController extends BaseController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private CitysService citysService;

	@Autowired
	private UserService userService;

	@RequestMapping("/JumpRegisterUser")
	public String JumpRegisterUser(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
								   @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize, ServletRequest request, Model model){
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		PageBounds pageBounds = new PageBounds(pageNumber, pageSize);
		List<User> list = userService.queryPage(pageBounds,searchParams);
		PageList<User> pageList = (PageList<User>)list;
		model.addAttribute("list", list);
		model.addAttribute("pageList", pageList);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "sysUser/registerUserList";
	}

	@RequestMapping("/JumpSysUser")
	public String JumpSysUser(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,ServletRequest request,Model model){
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		PageBounds pageBounds = new PageBounds(pageNumber, pageSize);
		List<SysUser> list = sysUserService.queryPage(pageBounds,searchParams);
		//获取部门名称装入list中返回到添加页面
		List<Department> departmentlist = departmentService.selectDepartmentList();
		//获取角色装入list返回到添加页面
		List<Role> rolelist = roleService.selectRoleList();
		PageList<SysUser> pageList = (PageList<SysUser>)list;
		model.addAttribute("list", list);
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("departmentlist", departmentlist);
		model.addAttribute("pageList", pageList);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "sysUser/sysUserList";
	}

	@RequestMapping("/querySysUser")
	public String querySysUser(Model model){
		//获取部门名称装入list中返回到添加页面
		List<Department> departmentlist = departmentService.selectDepartmentList();
		//获取角色装入list返回到添加页面
		List<Role> rolelist = roleService.selectRoleList();
		//获取城市装入list返回到页面
		List<CityComp> citylist = citysService.selectCityCompList();
		model.addAttribute("departmentlist", departmentlist);
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("citylist", citylist);
		return "sysUser/sysUserModel";
	}

	@RequestMapping("/addSysUser")
	@ResponseBody
	public String addSysUser(HttpServletRequest request,
			HttpServletResponse response,SysUser sysuser){
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		String msg="";
		try {
			List<SysUser> list = sysUserService.selectSysUserByKey(sysuser.getUserCode(),sysuser.getId());
			if(list.size()<1){
				if(sysuser.getId()==null||sysuser.getId().equals("")){
					String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
					SimpleHash hash = new SimpleHash("md5", sysuser.getPassword(),salt, 3);
					sysuser.setSalt(salt);
					String encodedPassword = hash.toHex();
					sysuser.setPassword(encodedPassword);
					sysuser.setCreateTime(new Date());
					sysuser.setStatus("1");
					sysuser.setCreatePerson(activeUser.getUsername());
					//添加到用户表
					sysUserService.addSysUser(sysuser);
					SysUser user= sysUserService.getEntiyByUserCode(sysuser.getUserCode());
					sysUserRoleService.saveOrupdate(user.getId(),user.getCardNo());
					msg="1";
				}else{
					//判断密码是否为空
					if(!sysuser.getPassword().equals("")){
						String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
						SimpleHash hash = new SimpleHash("md5",sysuser.getPassword(),salt, 3);
						sysuser.setSalt(salt);
						String encodedPassword = hash.toHex();
						sysuser.setPassword(encodedPassword);
					}else{

						SysUser users=sysUserService.selectSysUserByID(sysuser.getId());
						sysuser.setPassword(users.getPassword());
					}
					sysuser.setUpdateTime(new Date());
					sysuser.setUpdatePerson(activeUser.getUsername());
					sysUserService.updateSysUser(sysuser);
					sysUserRoleService.saveOrupdate(sysuser.getId(),sysuser.getCardNo());
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

	@RequestMapping("/updateSysUser")
	public String updateSysUser(HttpServletRequest request,HttpServletResponse response,
			Model model,String id){
		SysUser sysUser= sysUserService.selectSysUserByID(Integer.parseInt(id));
		List<Department> departmentlist = departmentService.selectDepartmentList();
		//获取角色装入list返回到添加页面
		List<Role> rolelist = roleService.selectRoleList();
		//获取城市装入list返回到页面
		List<CityComp> citylist = citysService.selectCityCompList();
		model.addAttribute("citylist", citylist);
		model.addAttribute("departmentlist", departmentlist);
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("sysUser",sysUser);
		return "sysUser/sysUserModel";

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
				  SysUser sysUser= sysUserService.selectSysUserByID(Integer.parseInt(id));
				  if(nums.equals("3")){
					  sysUserService.deleteSysUserByid(Integer.parseInt(id));
					  List<SysUserRoleKey> sysUserRoleKey =sysUserRoleService.findSysUserRoleKey(Integer.parseInt(id));
					  sysUserRoleService.deletSysUserRolebykey(sysUserRoleKey.get(0));
				  }else{
					  if(nums.equals("1")){
						  sysUser.setStatus("1");
						}else if(nums.equals("2")){
						sysUser.setStatus("0");
						}
					  sysUser.setUpdateTime(new Date());
					  sysUser.setUpdatePerson(activeUser.getUsername());
					  sysUserService.updateSysUser(sysUser);
				  }

			  }

		  }
	}


}
