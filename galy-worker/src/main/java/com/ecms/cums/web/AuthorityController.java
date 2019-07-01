package com.ecms.cums.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;

import com.ecms.cums.authvo.ActiveUser;
import com.ecms.cums.model.Authority;
import com.ecms.cums.model.RoleAuthority;
import com.ecms.cums.services.AuthorityService;
import com.ecms.cums.services.RoleAuthorityService;
import com.ecms.cums.shiro.CustomRealm;
import com.ecms.cums.sysuservo.ButtonTree;
import com.ecms.cums.sysuservo.ChildTree;
import com.ecms.cums.sysuservo.MenuChildVo;
import com.ecms.cums.sysuservo.MenuTree;
import com.ecms.cums.sysuservo.StatesTree;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import net.sf.json.JSONArray;

/**
 * @ClassName: AuthorityController
 * @Description: 菜单管理
 * @author: wangyinglei
 * @date: 2018年612日 下午4:18:22
 */
@Controller
@RequestMapping("/authorityManage")
public class AuthorityController extends BaseController{
	@Autowired
	private  AuthorityService authorityService;
	@Autowired
	private RoleAuthorityService roleAuthorityService;

	@RequestMapping("/JumpAuthority")
	public String JumpAuthority(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,ServletRequest request,Model model){
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		PageBounds pageBounds = new PageBounds(pageNumber, pageSize);
		List<Authority> list = authorityService.queryPage(pageBounds,searchParams);
		PageList<Authority> pageList = (PageList<Authority>)list;
		model.addAttribute("list", list);
		model.addAttribute("pageList", pageList);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "authority/authorityList";
	}

	@RequestMapping("/queryAuthority")
	public String queryAuthority(){
		return "authority/authorityModel";
	}
	@RequestMapping("/addAuthority")
	@ResponseBody
	public String addAuthority(HttpServletRequest request,
			HttpServletResponse response,Authority authority){
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		String msg="";
		try {
			List<Authority> list = authorityService.selectAuthorityByKey(authority.getMenuCode(),authority.getId());
			if(list.size()<1){
				if(authority.getId()==null||authority.getId().equals("")){
					authority.setCreateTime(new Date());
					authority.setCreatePerson(activeUser.getUsername());
					authorityService.addAuthority(authority);
					msg="1";
				}else{
					authority.setUpdateTime(new Date());
					authority.setUpdatePerson(activeUser.getUsername());
					authorityService.updateAuthority(authority);
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


	@RequestMapping(value="/toExamine")
	public void toExamine(HttpServletRequest request,HttpServletResponse response,
			String ids,String nums)throws Exception{
			Subject subject = SecurityUtils.getSubject();
			ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		 	ids = ids.substring(0, ids.length() - 1);
		 	String[] idss = ids.split(",");
		 		for (String id : idss) {
			  if(!id.equals("on")){
				  Authority authority = authorityService.selectAuthorityID(Integer.parseInt(id));
				  if(nums.equals("3")){
					  authorityService.deleteAuthorityByid(Integer.parseInt(id));
				  }else{
					  if(nums.equals("1")){
							authority.setStatus("1");
						}else if(nums.equals("2")){
							authority.setStatus("0");
						}
					  authority.setUpdateTime(new Date());
					  authority.setUpdatePerson(activeUser.getUsername());
					  authorityService.updateAuthority(authority);
				  }

			  }

		  }
	}

	//
	@ResponseBody
	@RequestMapping(value="firstMenu",produces = "text/plain;charset=UTF-8")
	public String  firstMenu(HttpServletRequest request,HttpServletResponse response){
		//获取传过来的参数
		String roleKey = request.getParameter("roleKey");
		request.getSession().setAttribute("roleKey", roleKey);
		List<MenuChildVo> mainMenuList = authorityService.getMenuChildList();
		List<MenuTree> menuTreeList = new ArrayList<MenuTree>();
		Boolean flag = false;
		for (MenuChildVo auth:mainMenuList) {
			StatesTree menuCheck = new StatesTree();
			menuCheck.setChecked(false);
			MenuTree menuTree = new MenuTree();
			menuTree.setId("0");
			menuTree.setMenuCode("0");
			menuTree.setText(auth.getMenuName());
			if(!StringUtils.isBlank(auth.getChildMenucode())){
				String[] childMenucode = auth.getChildMenucode().split(",");
				String[] childMenuname = auth.getChildMenuName().split(",");
				List<ChildTree> childTreeList = new ArrayList<ChildTree>();
				for(int i=0;i<childMenucode.length;i++){
					StatesTree childCheck = new StatesTree();
					childCheck.setChecked(false);
					RoleAuthority roleAuthority = roleAuthorityService.getByProerties(childMenucode[i],roleKey);
					if(null!=roleAuthority){
						flag = true;
						menuCheck.setChecked(flag);
						childCheck.setChecked(true);
					}
					ChildTree childTree = new ChildTree();
					childTree.setId("1");
					childTree.setState(childCheck);
					childTree.setText(childMenuname[i]);
					childTree.setChildCode(childMenucode[i]);
					/*根据子节点查询按钮节点信息*/
					List<Authority> authority = authorityService.queryByProerties(childMenucode[i]);
					if(null != authority){
						 List<ButtonTree> buttonList = new ArrayList<ButtonTree>();
						 for(Authority button:authority){
							 StatesTree buttonCheck = new StatesTree();
							 buttonCheck.setChecked(false);
							 ButtonTree tree = new ButtonTree();
							 tree.setId("2");
							 tree.setText(button.getMenuName());
							 tree.setButtonCode(button.getMenuCode());
							 RoleAuthority buttonAuthority = roleAuthorityService.getByProerties(button.getMenuCode(),roleKey);
							 if(null!=buttonAuthority){
								buttonCheck.setChecked(true);
							 }
							 tree.setState(buttonCheck);
							 buttonList.add(tree);
						 }
						 childTree.setNodes(buttonList);
					}
					childTreeList.add(childTree);
				}
				menuTree.setNodes(childTreeList);
			}
			menuTree.setState(menuCheck);

			menuTreeList.add(menuTree);
		}

		return JSONArray.fromObject(menuTreeList).toString();
	}

	@RequestMapping(value = "/saveRoleAuthority")
	public void saveRoleAuthority(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roleKey = (String) request.getSession().getAttribute("roleKey");
		String menuCode = request.getParameter("menuCode");
		roleAuthorityService.deleteByRoleKey(roleKey);
		String[] menuCodesValue = menuCode.split(",");
		for (int i = 0; i < menuCodesValue.length; i++) {
			RoleAuthority roleAuthority = new RoleAuthority();
			roleAuthority.setRoleKey(roleKey);
			roleAuthority.setMenuCode(menuCodesValue[i]);
			roleAuthorityService.saveRoleAuthority(roleAuthority);
		}

		clearCach();

	}
	public void clearCach(){
		RealmSecurityManager rsm = (RealmSecurityManager)SecurityUtils.getSecurityManager();
		CustomRealm realm = (CustomRealm)rsm.getRealms().iterator().next();
		realm.clearCached();
	}
	@RequestMapping(value="updateAuthority")
	public String updateAuthority(HttpServletRequest request,HttpServletResponse response,
			Model model,String id){
		 Authority authority = authorityService.selectAuthorityID(Integer.parseInt(id));
		 model.addAttribute("authority",authority);
		return "authority/authorityModel";
	}






}
