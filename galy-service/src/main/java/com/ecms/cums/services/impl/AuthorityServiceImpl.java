package com.ecms.cums.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.cores.MySearchFilter;
import com.ecms.cums.dao.AuthorityMapper;
import com.ecms.cums.model.Authority;
import com.ecms.cums.model.AuthorityCriteria;
import com.ecms.cums.services.AuthorityService;
import com.ecms.cums.sysuservo.MenuChildVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	private AuthorityMapper authorityMapper;
	@Override
	public List<Authority> queryPage(PageBounds pageBounds, Map<String, Object> searchParams) {
		Map<String, Object> params = MySearchFilter.filter(searchParams);
		return authorityMapper.queryPage(pageBounds,params);
	}
	@Override
	public void addAuthority(Authority authority) {
		authorityMapper.insertSelective(authority);
		
	}
	@Override
	public void updateAuthority(Authority authority) {
		authorityMapper.updateByPrimaryKeySelective(authority);
		
	}
	
	@Override
	public List<Authority> selectAuthorityByKey(String menuCode, Long id) {
		AuthorityCriteria criteria = new AuthorityCriteria();
		AuthorityCriteria.Criteria c=criteria.createCriteria();
		c.andMenuCodeEqualTo(menuCode);
		if(id!=null){
			c.andIdNotEqualTo(id);
		}
		List<Authority> list=authorityMapper.selectByExample(criteria);
		return list;
	}
	@Override
	public Authority selectAuthorityID(Integer id) {
		return authorityMapper.selectByPrimaryKey(id.longValue());
	}
	@Override
	public void deleteAuthorityByid(Integer id) {
		// TODO Auto-generated method stub
		authorityMapper.deleteByPrimaryKey(id.longValue());
	}
	/**
	 * 获取菜单中父级的列表
	 */
	@Override
	public List<Authority> queryByParentMenucode() {
		AuthorityCriteria criteria = new AuthorityCriteria();
		AuthorityCriteria.Criteria c=criteria.createCriteria();
		c.andParentMenucodeEqualTo("0");
		List<Authority> list=authorityMapper.selectByExample(criteria);
		return list;
	}
	@Override
	public List<Authority> queryByProerties(String menuCode) {
		AuthorityCriteria criteria = new AuthorityCriteria();
		AuthorityCriteria.Criteria c=criteria.createCriteria();
		c.andParentMenucodeEqualTo(menuCode);
		List<Authority> list=authorityMapper.selectByExample(criteria);
		return list;
	}
	
	@Override
	public List<MenuChildVo> getMenuChildList() {
		// TODO Auto-generated method stub
		return authorityMapper.getMenuChildList();
	}

}
