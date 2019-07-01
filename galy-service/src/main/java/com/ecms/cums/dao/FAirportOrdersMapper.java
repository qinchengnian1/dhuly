package com.ecms.cums.dao;

import com.ecms.cums.airportvo.AirportOrderListVo;
import com.ecms.cums.model.FAirportOrders;
import com.ecms.cums.model.FAirportOrdersCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FAirportOrdersMapper {
    int countByExample(FAirportOrdersCriteria example);

    int deleteByExample(FAirportOrdersCriteria example);

    int deleteByPrimaryKey(Integer fOrderId);

    int insert(FAirportOrders record);

    int insertSelective(FAirportOrders record);

    List<FAirportOrders> selectByExample(FAirportOrdersCriteria example);

    FAirportOrders selectByPrimaryKey(Integer fOrderId);

    int updateByExampleSelective(@Param("record") FAirportOrders record, @Param("example") FAirportOrdersCriteria example);

    int updateByExample(@Param("record") FAirportOrders record, @Param("example") FAirportOrdersCriteria example);

    int updateByPrimaryKeySelective(FAirportOrders record);

    int updateByPrimaryKey(FAirportOrders record);

	List<AirportOrderListVo> getAriportOrderList(Integer parseInt);
}