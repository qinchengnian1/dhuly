package com.ecms.cums.dao;

import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TravelTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TravelTypeMapper {
    int countByExample(TravelTypeCriteria example);

    int deleteByExample(TravelTypeCriteria example);

    int deleteByPrimaryKey(Integer tId);

    int insert(TravelType record);

    int insertSelective(TravelType record);

    List<TravelType> selectByExample(TravelTypeCriteria example);

    TravelType selectByPrimaryKey(Integer tId);

    int updateByExampleSelective(@Param("record") TravelType record, @Param("example") TravelTypeCriteria example);

    int updateByExample(@Param("record") TravelType record, @Param("example") TravelTypeCriteria example);

    int updateByPrimaryKeySelective(TravelType record);

    int updateByPrimaryKey(TravelType record);
}