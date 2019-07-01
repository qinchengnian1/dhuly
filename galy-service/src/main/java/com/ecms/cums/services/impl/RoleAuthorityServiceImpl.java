package com.ecms.cums.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.dao.RoleAuthorityMapper;
import com.ecms.cums.model.RoleAuthority;
import com.ecms.cums.model.RoleAuthorityCriteria;
import com.ecms.cums.services.RoleAuthorityService;

@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService{
	@Autowired
	private  RoleAuthorityMapper roleAuthorityMapper;
		
	@Override
	public RoleAuthority getByProerties(String propName, String propValue) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.getByProerties(propName, propValue);
	}
	
	@Override
	public void deleteByRoleKey(String roleKey) {
		RoleAuthorityCriteria criteria =new RoleAuthorityCriteria();
		RoleAuthorityCriteria.Criteria c= criteria.createCriteria();
		c.andRoleKeyEqualTo(roleKey);
		roleAuthorityMapper.deleteByExample(criteria);
		
	}
	@Override
	public void saveRoleAuthority(RoleAuthority roleAuthority) {
		// TODO Auto-generated method stub
		roleAuthorityMapper.insertSelective(roleAuthority);
	}
	
	@Override
	public List<RoleAuthority> getRoleAuthority(String roleKey) {
		RoleAuthorityCriteria criteria =new RoleAuthorityCriteria();
		RoleAuthorityCriteria.Criteria c= criteria.createCriteria();
		c.andRoleKeyEqualTo(roleKey);
		List<RoleAuthority> list =roleAuthorityMapper.selectByExample(criteria);
		return list;
	}
	
}
