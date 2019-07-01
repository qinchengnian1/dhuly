package com.ecms.cums.dao;

import com.ecms.cums.model.Authority;
import com.ecms.cums.model.AuthorityCriteria;
import com.ecms.cums.sysuservo.MenuChildVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AuthorityMapper {
    long countByExample(AuthorityCriteria example);

    int deleteByExample(AuthorityCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Authority record);

    int insertSelective(Authority record);

    List<Authority> selectByExample(AuthorityCriteria example);

    Authority selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Authority record, @Param("example") AuthorityCriteria example);

    int updateByExample(@Param("record") Authority record, @Param("example") AuthorityCriteria example);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);

	List<Authority> queryPage(PageBounds pageBounds, Map<String, Object> params);

	List<MenuChildVo> getMenuChildList();
}