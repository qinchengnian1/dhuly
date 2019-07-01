package com.ecms.cums.services;

import java.util.List;

import com.ecms.cums.model.RoleAuthority;

public interface RoleAuthorityService {

	RoleAuthority getByProerties(String propName, String propValue);

	void deleteByRoleKey(String roleKey);

	void saveRoleAuthority(RoleAuthority roleAuthority);

	List<RoleAuthority> getRoleAuthority(String roleKey);

	

}
