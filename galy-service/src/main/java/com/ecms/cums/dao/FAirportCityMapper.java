package com.ecms.cums.dao;

import com.ecms.cums.model.FAirportCity;
import com.ecms.cums.model.FAirportCityCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FAirportCityMapper {
    int countByExample(FAirportCityCriteria example);

    int deleteByExample(FAirportCityCriteria example);

    int deleteByPrimaryKey(Integer fCId);

    int insert(FAirportCity record);

    int insertSelective(FAirportCity record);

    List<FAirportCity> selectByExample(FAirportCityCriteria example);

    FAirportCity selectByPrimaryKey(Integer fCId);

    int updateByExampleSelective(@Param("record") FAirportCity record, @Param("example") FAirportCityCriteria example);

    int updateByExample(@Param("record") FAirportCity record, @Param("example") FAirportCityCriteria example);

    int updateByPrimaryKeySelective(FAirportCity record);

    int updateByPrimaryKey(FAirportCity record);

	List<FAirportCity> queryCityListByStatus(String fNation);

	List<FAirportCity> queryHotCityListByStatus(String fNation);
}