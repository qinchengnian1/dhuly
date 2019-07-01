package com.ecms.cums.dao;

import com.ecms.cums.model.OrderTourist;
import com.ecms.cums.model.OrderTouristCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderTouristMapper {
    int countByExample(OrderTouristCriteria example);

    int deleteByExample(OrderTouristCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderTourist record);

    int insertSelective(OrderTourist record);

    List<OrderTourist> selectByExample(OrderTouristCriteria example);

    OrderTourist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderTourist record, @Param("example") OrderTouristCriteria example);

    int updateByExample(@Param("record") OrderTourist record, @Param("example") OrderTouristCriteria example);

    int updateByPrimaryKeySelective(OrderTourist record);

    int updateByPrimaryKey(OrderTourist record);
}