package com.ecms.cums.dao;

import com.ecms.cums.model.CityComp;
import com.ecms.cums.model.CityCompCriteria;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CityCompMapper {
    int countByExample(CityCompCriteria example);

    int deleteByExample(CityCompCriteria example);

    int deleteByPrimaryKey(Integer cityId);

    int insert(CityComp record);

    int insertSelective(CityComp record);

    List<CityComp> selectByExample(CityCompCriteria example);

    CityComp selectByPrimaryKey(Integer cityId);

    int updateByExampleSelective(@Param("record") CityComp record, @Param("example") CityCompCriteria example);

    int updateByExample(@Param("record") CityComp record, @Param("example") CityCompCriteria example);

    int updateByPrimaryKeySelective(CityComp record);

    int updateByPrimaryKey(CityComp record);

	List<CityComp> queryPage(PageBounds pageBounds, Map<String, Object> params);
}