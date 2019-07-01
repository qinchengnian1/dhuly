package com.ecms.cums.dao;

import com.ecms.cums.model.RoleAuthority;
import com.ecms.cums.model.RoleAuthorityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAuthorityMapper {
    long countByExample(RoleAuthorityCriteria example);

    int deleteByExample(RoleAuthorityCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);

    List<RoleAuthority> selectByExample(RoleAuthorityCriteria example);

    RoleAuthority selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleAuthority record, @Param("example") RoleAuthorityCriteria example);

    int updateByExample(@Param("record") RoleAuthority record, @Param("example") RoleAuthorityCriteria example);

    int updateByPrimaryKeySelective(RoleAuthority record);

    int updateByPrimaryKey(RoleAuthority record);

	RoleAuthority getByProerties(@Param("propName") String propName,@Param("propValue") String propValue);
}