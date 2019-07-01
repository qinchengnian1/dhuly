package com.ecms.cums.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecms.cums.authvo.ActiveUser;
import com.ecms.cums.authvo.AuthorityVo;
import com.ecms.cums.model.Authority;
import com.ecms.cums.model.CityComp;
import com.ecms.cums.model.Role;
import com.ecms.cums.model.RoleAuthority;
import com.ecms.cums.model.SysUser;
import com.ecms.cums.model.SysUserRoleKey;
import com.ecms.cums.services.AuthorityService;
import com.ecms.cums.services.CitysService;
import com.ecms.cums.services.RoleAuthorityService;
import com.ecms.cums.services.RoleService;
import com.ecms.cums.services.SysUserRoleService;
import com.ecms.cums.services.SysUserService;
/**
 *
 * @ClassName: LoginController
 * @Description: 用户中心
 * @author: zJin
 * @date: 2018年3月29日 上午10:33:07
 */
@Controller
@RequestMapping("/sys/sysuser")
public class LoginController extends BaseController{

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private RoleAuthorityService roleAuthorityService;

	@Autowired
	private SysUserRoleService sysUserRoleService;

	@Autowired
	private RoleService  roleService;

	@Autowired
	private CitysService citysService;


	/**
	 * @Title: login
	 * @Description: 登录
	 * @param request
	 * @param response
	 * @throws IOException
	 * @return: void
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        try {
        	 currentUser.login(token);
        }catch(UnknownAccountException uae){
            this.getErrorResponse(response, "未知账户");
            return;
        }catch(IncorrectCredentialsException ice){
            this.getErrorResponse(response, "密码不正确");
            return;
        }catch(LockedAccountException lae){
            this.getErrorResponse(response, "账户已锁定");
            return;
        }catch(AuthenticationException ae){
        	this.getErrorResponse(response, "用户名或密码不正确");
        	return;
        }catch(Exception e){
        	this.getErrorResponse(response, "操作异常");
        	return;
        }
       this.getSuccessResponse(response);

	}

	/**
	 * @Title: home
	 * @Description: 首页
	 * @return
	 * @return: String
	 */
	@RequestMapping("/home")
	public String home(HttpServletRequest request, HttpServletResponse response,Model model,String citysid){
		Subject subject = SecurityUtils.getSubject();
		ActiveUser user = (ActiveUser) subject.getPrincipal();
		//根据用户id进行查询的到用户的code
		SysUser us=sysUserService.selectSysUserByID(Integer.parseInt(user.getUserid()));
		if(citysid ==null){
			String[] citycompid = us.getCityId().split(",");
			System.out.println(citycompid[0]);
			model.addAttribute("citycompid",citycompid[0]);
			request.getSession().setAttribute("citycompid",citycompid[0]);
		}else{
			model.addAttribute("citycompid",citysid);
			request.getSession().setAttribute("citycompid",citysid);
		}
		//根据用户的code去 用户和权限表查询
		List<SysUserRoleKey> sysuser=sysUserRoleService.findSysUserRoleKey(us.getId());
		Role role=roleService.selectRoleByID(sysuser.get(0).getRoleId().intValue());
		List<RoleAuthority> roleAuthorityList = roleAuthorityService.getRoleAuthority(role.getRoleKey());
		List<String> menuCodeList = new ArrayList<String>();
		for (int j = 0; j < roleAuthorityList.size(); j++) {
			menuCodeList.add(roleAuthorityList.get(j).getMenuCode());
		}
		//获取登录用户的父级的全部列表
		List<Authority> mainMenuList = authorityService.queryByParentMenucode();
		//根据父级的编码获取子集的列表
		//List<Authority> allMenuList=authorityService.queryByParentMenucodeAll(mainMenuList);
		List<AuthorityVo> authorityList = new ArrayList<AuthorityVo>();
		for (Authority entity : mainMenuList) {
			AuthorityVo authority = new AuthorityVo();
			authority.setId(entity.getId());
			authority.setMenuCode(entity.getMenuCode());
			authority.setMenuName(entity.getMenuName());
			authority.setMenuClass(entity.getMenuClass());
			authority.setDataUrl(entity.getDataUrl());
			authority.setSequence(entity.getSequence());
			authority.setParentMenucode(entity.getParentMenucode());
			List<Authority> subAuthorityList = authorityService.queryByProerties(entity.getMenuCode());
			List<Authority> resultSubAuthorityList = new ArrayList<Authority>();
			for (int i = 0; i < subAuthorityList.size(); i++) {
				if (menuCodeList.contains(subAuthorityList.get(i).getMenuCode())) {
					resultSubAuthorityList.add(subAuthorityList.get(i));
				}
			}
			authority.setAuthorityEntity(resultSubAuthorityList);
			if (subAuthorityList.size() == 0) {
				authorityList.add(null);
			} else {
				authorityList.add(authority);
			}
		}
		//根据登录的用户进行查询所关联的城市list
		List<Object> cityList = new ArrayList<Object>();
		String citys=us.getCityId();
		String[] str1 = citys.split(",");
		for(String city : str1){
			CityComp cityComp =citysService.selectCitysByID(Integer.parseInt(city));
			cityList.add(cityComp);
		}
		model.addAttribute("authorityList",authorityList);
		model.addAttribute("cityList",cityList);
		return "home";

	}






	@RequestMapping("/navContent")
	public String navContent(){
		return "navContent";
	}

	@RequestMapping("/menu")
	public String menu(){
		return "admin_top";
	}

	@RequestMapping("/left")
	public String left(){
		return "left";
	}

	@RequestMapping("/right")
	public String right(){
		return "right";
	}

	/**
	 * @Title: logout
	 * @Description: 用户退出
	 * @param request
	 * @return: void
	 */
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request){
         SecurityUtils.getSubject().logout();
    }

    /**
     * @Title: main
     * @Description: 注册密码
     * @param args
     * @return: void
     */
    public static void main(String[] args) {
    	String algorithmName = "md5";
        String password = "guoan_Aa6532";
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        SimpleHash hash = new SimpleHash(algorithmName, password,salt2, 3);
        String encodedPassword = hash.toHex();
        System.out.println(encodedPassword);
        System.out.println(salt2);
	}

    /**
     * 切换城市
     */
}
