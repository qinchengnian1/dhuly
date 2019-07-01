package com.ecms.cums.services;

import java.util.List;

import com.ecms.cums.model.SysUserRoleKey;

public interface SysUserRoleService {

	void saveOrupdate(Integer id,String idCard);

	List<SysUserRoleKey> findSysUserRoleKey(Integer id);

	void deletSysUserRolebykey(SysUserRoleKey sysUserRoleKey);



}
