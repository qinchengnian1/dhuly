package com.ecms.cums.dao;

import com.ecms.cums.model.FAirportOrderInfo;
import com.ecms.cums.model.FAirportOrderInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FAirportOrderInfoMapper {
    int countByExample(FAirportOrderInfoCriteria example);

    int deleteByExample(FAirportOrderInfoCriteria example);

    int deleteByPrimaryKey(Integer fOiId);

    int insert(FAirportOrderInfo record);

    int insertSelective(FAirportOrderInfo record);

    List<FAirportOrderInfo> selectByExample(FAirportOrderInfoCriteria example);

    FAirportOrderInfo selectByPrimaryKey(Integer fOiId);

    int updateByExampleSelective(@Param("record") FAirportOrderInfo record, @Param("example") FAirportOrderInfoCriteria example);

    int updateByExample(@Param("record") FAirportOrderInfo record, @Param("example") FAirportOrderInfoCriteria example);

    int updateByPrimaryKeySelective(FAirportOrderInfo record);

    int updateByPrimaryKey(FAirportOrderInfo record);
}