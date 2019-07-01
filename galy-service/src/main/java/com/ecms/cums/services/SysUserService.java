package com.ecms.cums.services;

import java.util.List;
import java.util.Map;

import com.ecms.cums.model.SysUser;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface SysUserService {

	/**
	 * @Title: getEntiyByUserCode
	 * @Description: 根据用户编码查询用户实体
	 * @param userCode
	 * @return
	 * @return: SysUser
	 */
	public SysUser getEntiyByUserCode(String userCode);
	/**
	 * 后台用户展示列表
	 * @param pageBounds
	 * @param searchParams
	 * @return
	 */
	public List<SysUser> queryPage(PageBounds pageBounds, Map<String, Object> searchParams);
	
	public List<SysUser> selectSysUserByKey(String userCode, Integer id);
	
	public void addSysUser(SysUser sysuser);
	
	public void updateSysUser(SysUser sysuser);
	/**
	 * 根据id进行查询跳转到修改页面
	 * @param parseInt
	 * @return
	 */
	public SysUser selectSysUserByID(Integer parseInt);
	/**
	 * 根据id进行删除
	 * @param parseInt
	 */
	public void deleteSysUserByid(Integer parseInt);
}
