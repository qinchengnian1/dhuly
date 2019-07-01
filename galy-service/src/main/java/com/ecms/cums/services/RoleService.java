package com.ecms.cums.services;

import java.util.List;
import java.util.Map;

import com.ecms.cums.model.Role;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface RoleService {

	List<Role> queryPage(PageBounds pageBounds, Map<String, Object> searchParams);

	List<Role> selectRoleByKey(String roleKey, Long id);

	void addRole(Role role);

	void updateRole(Role role);

	Role selectRoleByID(Integer id);

	void deleteRoleByid(Integer id);

	List<Role> selectRoleList(Integer id);

	List<Role> selectRoleList();

	

}
