package com.ecms.cums.dao;

import com.ecms.cums.model.FAirportTourist;
import com.ecms.cums.model.FAirportTouristCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FAirportTouristMapper {
    int countByExample(FAirportTouristCriteria example);

    int deleteByExample(FAirportTouristCriteria example);

    int deleteByPrimaryKey(Integer fTouristId);

    int insert(FAirportTourist record);

    int insertSelective(FAirportTourist record);

    List<FAirportTourist> selectByExample(FAirportTouristCriteria example);

    FAirportTourist selectByPrimaryKey(Integer fTouristId);

    int updateByExampleSelective(@Param("record") FAirportTourist record, @Param("example") FAirportTouristCriteria example);

    int updateByExample(@Param("record") FAirportTourist record, @Param("example") FAirportTouristCriteria example);

    int updateByPrimaryKeySelective(FAirportTourist record);

    int updateByPrimaryKey(FAirportTourist record);
}