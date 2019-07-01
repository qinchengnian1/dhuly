package com.ecms.cums.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.dao.SysUserRoleMapper;
import com.ecms.cums.model.SysUserRoleCriteria;
import com.ecms.cums.model.SysUserRoleKey;
import com.ecms.cums.services.SysUserRoleService;

@Service
public class SysUserRoleServiceImpl  implements SysUserRoleService{
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
		@Override
		public void saveOrupdate(Integer id,String idCard) {
			//先删除用户和角色的关系
			SysUserRoleKey sysUserRoleKey = new SysUserRoleKey();
			sysUserRoleKey.setSysuserId(id.longValue());
			SysUserRoleCriteria criteria = new SysUserRoleCriteria();
			SysUserRoleCriteria.Criteria c= criteria.createCriteria();
			c.andSysuserIdEqualTo(id.longValue());
			sysUserRoleMapper.deleteByExample(criteria);
			sysUserRoleKey.setRoleId(Long.parseLong(idCard));
			//重新添加
			sysUserRoleMapper.insertSelective(sysUserRoleKey);
		}
		
		@Override
		public List<SysUserRoleKey> findSysUserRoleKey(Integer id) {
			SysUserRoleCriteria criteria = new SysUserRoleCriteria();
			SysUserRoleCriteria.Criteria c=criteria.createCriteria();
			c.andSysuserIdEqualTo(id.longValue());
			List<SysUserRoleKey> list =  sysUserRoleMapper.selectByExample(criteria);
			return list;
		}
		
		@Override
		public void deletSysUserRolebykey(SysUserRoleKey sysUserRoleKey) {
			sysUserRoleMapper.deleteByPrimaryKey(sysUserRoleKey);		
		}
		
		
		
}
