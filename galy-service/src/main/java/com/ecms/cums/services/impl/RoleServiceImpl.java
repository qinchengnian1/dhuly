package com.ecms.cums.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.cores.MySearchFilter;
import com.ecms.cums.dao.RoleMapper;
import com.ecms.cums.model.Authority;
import com.ecms.cums.model.AuthorityCriteria;
import com.ecms.cums.model.Role;
import com.ecms.cums.model.RoleCriteria;
import com.ecms.cums.services.RoleService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> queryPage(PageBounds pageBounds, Map<String, Object> searchParams) {
		Map<String, Object> params = MySearchFilter.filter(searchParams);
		return roleMapper.queryPage(pageBounds,params);
	}
	@Override
	public void addRole(Role role) {
		roleMapper.insertSelective(role);		
	}
	
	@Override
	public void updateRole(Role role) {
		roleMapper.updateByPrimaryKeySelective(role);
		
	}
	
	@Override
	public Role selectRoleByID(Integer id) {
		return roleMapper.selectByPrimaryKey(id.longValue());
	}
	@Override
	public List<Role> selectRoleByKey(String roleKey, Long id) {
		RoleCriteria criteria = new RoleCriteria();
		RoleCriteria.Criteria c=criteria.createCriteria();
		c.andRoleKeyEqualTo(roleKey);
		if(id!=null){
			c.andIdNotEqualTo(id);
		}
		List<Role> list=roleMapper.selectByExample(criteria);
		return list;
	}
	
	@Override
	public void deleteRoleByid(Integer id) {
		roleMapper.deleteByPrimaryKey(id.longValue());
	}
	
	@Override
	public List<Role> selectRoleList(Integer id) {
		RoleCriteria criteria = new RoleCriteria();
		RoleCriteria.Criteria c=criteria.createCriteria();
		c.andIdEqualTo(id.longValue());
		List<Role> list=roleMapper.selectByExample(criteria);
		return list;
	}
	@Override
	public List<Role> selectRoleList() {
		RoleCriteria criteria = new RoleCriteria();
		RoleCriteria.Criteria c=criteria.createCriteria();
		List<Role> list=roleMapper.selectByExample(criteria);
		return list;
	}

}
