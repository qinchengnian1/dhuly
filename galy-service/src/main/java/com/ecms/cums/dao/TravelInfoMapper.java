package com.ecms.cums.dao;

import com.ecms.cums.model.TravelInfo;
import com.ecms.cums.model.TravelInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TravelInfoMapper {
    int countByExample(TravelInfoCriteria example);

    int deleteByExample(TravelInfoCriteria example);

    int deleteByPrimaryKey(Integer tId);

    int insert(TravelInfo record);

    int insertSelective(TravelInfo record);

    List<TravelInfo> selectByExampleWithBLOBs(TravelInfoCriteria example);

    List<TravelInfo> selectByExample(TravelInfoCriteria example);

    TravelInfo selectByPrimaryKey(Integer tId);

    int updateByExampleSelective(@Param("record") TravelInfo record, @Param("example") TravelInfoCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TravelInfo record, @Param("example") TravelInfoCriteria example);

    int updateByExample(@Param("record") TravelInfo record, @Param("example") TravelInfoCriteria example);

    int updateByPrimaryKeySelective(TravelInfo record);

    int updateByPrimaryKeyWithBLOBs(TravelInfo record);

    int updateByPrimaryKey(TravelInfo record);
}