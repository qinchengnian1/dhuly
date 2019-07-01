package com.ecms.cums.dao;

import com.ecms.cums.model.Tourist;
import com.ecms.cums.model.TouristCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TouristMapper {
    int countByExample(TouristCriteria example);

    int deleteByExample(TouristCriteria example);

    int deleteByPrimaryKey(Integer touristId);

    int insert(Tourist record);

    int insertSelective(Tourist record);

    List<Tourist> selectByExample(TouristCriteria example);

    Tourist selectByPrimaryKey(Integer touristId);

    int updateByExampleSelective(@Param("record") Tourist record, @Param("example") TouristCriteria example);

    int updateByExample(@Param("record") Tourist record, @Param("example") TouristCriteria example);

    int updateByPrimaryKeySelective(Tourist record);

    int updateByPrimaryKey(Tourist record);

	List<Tourist> getTouristInfoByOrderId(Integer orderId);
}