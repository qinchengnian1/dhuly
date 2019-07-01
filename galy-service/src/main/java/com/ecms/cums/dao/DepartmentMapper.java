package com.ecms.cums.dao;

import com.ecms.cums.model.Department;
import com.ecms.cums.model.DepartmentCriteria;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    long countByExample(DepartmentCriteria example);

    int deleteByExample(DepartmentCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentCriteria example);

    Department selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentCriteria example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentCriteria example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

	List<Department> queryPage(PageBounds pageBounds, Map<String, Object> params);
}