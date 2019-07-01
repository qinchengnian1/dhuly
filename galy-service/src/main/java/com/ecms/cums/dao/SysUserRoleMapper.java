package com.ecms.cums.dao;

import com.ecms.cums.model.SysUserRoleCriteria;
import com.ecms.cums.model.SysUserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    long countByExample(SysUserRoleCriteria example);

    int deleteByExample(SysUserRoleCriteria example);

    int deleteByPrimaryKey(SysUserRoleKey key);

    int insert(SysUserRoleKey record);

    int insertSelective(SysUserRoleKey record);

    List<SysUserRoleKey> selectByExample(SysUserRoleCriteria example);

    int updateByExampleSelective(@Param("record") SysUserRoleKey record, @Param("example") SysUserRoleCriteria example);

    int updateByExample(@Param("record") SysUserRoleKey record, @Param("example") SysUserRoleCriteria example);

	void saveOrupdate(Integer id, String cardNo);

	List<SysUserRoleKey> selectBykey(long longValue);
}