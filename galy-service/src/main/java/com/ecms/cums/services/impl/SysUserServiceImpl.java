package com.ecms.cums.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecms.cums.cores.MySearchFilter;
import com.ecms.cums.dao.SysUserMapper;
import com.ecms.cums.model.SysUser;
import com.ecms.cums.model.SysUserCriteria;
import com.ecms.cums.services.SysUserService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser getEntiyByUserCode(String userCode) {
		// TODO Auto-generated method stub
		SysUserCriteria criteria = new SysUserCriteria();
		SysUserCriteria.Criteria c = criteria.createCriteria();
		c.andUserCodeEqualTo(userCode);
		List<SysUser> list =  sysUserMapper.selectByExample(criteria);
		if(null!=list && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<SysUser> queryPage(PageBounds pageBounds, Map<String, Object> searchParams) {
		Map<String, Object> params = MySearchFilter.filter(searchParams);
		return sysUserMapper.queryPage(pageBounds,params);
	}
	@Override
	public List<SysUser> selectSysUserByKey(String userCode, Integer id) {
		SysUserCriteria criteria = new SysUserCriteria();
		SysUserCriteria.Criteria c = criteria.createCriteria();
		c.andUserCodeEqualTo(userCode);
		if(id!=null){
			c.andIdNotEqualTo(id);
		}
		List<SysUser> list =  sysUserMapper.selectByExample(criteria);
		return list;
	}
	
	@Override
	public void addSysUser(SysUser sysuser) {
		sysUserMapper.insertSelective(sysuser);
	}
	@Override
	public void updateSysUser(SysUser sysuser) {
		sysUserMapper.updateByPrimaryKeySelective(sysuser);
	}
	
	@Override
	public SysUser selectSysUserByID(Integer id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
	@Override
	@Transactional
	public void deleteSysUserByid(Integer id) {
		sysUserMapper.deleteByPrimaryKey(id);
	}
}
