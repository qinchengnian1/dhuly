package com.ecms.cums.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecms.cums.authvo.ActiveUser;
import com.ecms.cums.model.Role;
import com.ecms.cums.model.RoleAuthority;
import com.ecms.cums.model.SysUser;
import com.ecms.cums.model.SysUserRoleKey;
import com.ecms.cums.services.RoleAuthorityService;
import com.ecms.cums.services.RoleService;
import com.ecms.cums.services.SysUserRoleService;
import com.ecms.cums.services.SysUserService;
@Component
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleAuthorityService roleAuthorityService;
	// 设置realm的名称
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String userCode = (String) token.getPrincipal();

		SysUser sysUser = null;
		try {
			sysUser = sysUserService.getEntiyByUserCode(userCode);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if(null == sysUser)
			throw new UnknownAccountException();
		if(!"1".equals(sysUser.getStatus()))
			throw new LockedAccountException();

		String password = sysUser.getPassword();
		String salt = sysUser.getSalt();

		ActiveUser activeUser = new ActiveUser();

		activeUser.setUserid(sysUser.getId().toString());
		activeUser.setUsercode(sysUser.getUserCode());
		activeUser.setUsername(sysUser.getUserName());

		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				activeUser, password,ByteSource.Util.bytes(salt), this.getName());

		return simpleAuthenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ActiveUser activeUser = (ActiveUser)principals.getPrimaryPrincipal();
		SysUser user =  sysUserService.selectSysUserByID(Integer.parseInt(activeUser.getUserid()));
		if (user != null) {
			List<SysUserRoleKey> sysUser =sysUserRoleService.findSysUserRoleKey(user.getId());
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			Role role = roleService.selectRoleByID(sysUser.get(0).getRoleId().intValue());
			info.addRole(role.getRoleKey());
			List<RoleAuthority> authority = roleAuthorityService.getRoleAuthority(role.getRoleKey());
			List<String> list = new ArrayList<String>();
			for(RoleAuthority ro:authority){
				list.add(ro.getMenuCode());
			}
			info.addStringPermissions(list);
			return info;
		} else {
			return null;
		}
	}

	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}


}
