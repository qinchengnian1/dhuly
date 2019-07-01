package com.ecms.cums.dao;

import com.ecms.cums.model.FAirportTouristOrder;
import com.ecms.cums.model.FAirportTouristOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FAirportTouristOrderMapper {
    int countByExample(FAirportTouristOrderCriteria example);

    int deleteByExample(FAirportTouristOrderCriteria example);

    int deleteByPrimaryKey(Integer fOTId);

    int insert(FAirportTouristOrder record);

    int insertSelective(FAirportTouristOrder record);

    List<FAirportTouristOrder> selectByExample(FAirportTouristOrderCriteria example);

    FAirportTouristOrder selectByPrimaryKey(Integer fOTId);

    int updateByExampleSelective(@Param("record") FAirportTouristOrder record, @Param("example") FAirportTouristOrderCriteria example);

    int updateByExample(@Param("record") FAirportTouristOrder record, @Param("example") FAirportTouristOrderCriteria example);

    int updateByPrimaryKeySelective(FAirportTouristOrder record);

    int updateByPrimaryKey(FAirportTouristOrder record);
}