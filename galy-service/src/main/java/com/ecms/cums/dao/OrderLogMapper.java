package com.ecms.cums.dao;

import com.ecms.cums.model.OrderLog;
import com.ecms.cums.model.OrderLogCriteria;
import com.ecms.cums.model.OrderLogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderLogMapper {
    int countByExample(OrderLogCriteria example);

    int deleteByExample(OrderLogCriteria example);

    int deleteByPrimaryKey(Integer oLogId);

    int insert(OrderLogWithBLOBs record);

    int insertSelective(OrderLogWithBLOBs record);

    List<OrderLogWithBLOBs> selectByExampleWithBLOBs(OrderLogCriteria example);

    List<OrderLog> selectByExample(OrderLogCriteria example);

    OrderLogWithBLOBs selectByPrimaryKey(Integer oLogId);

    int updateByExampleSelective(@Param("record") OrderLogWithBLOBs record, @Param("example") OrderLogCriteria example);

    int updateByExampleWithBLOBs(@Param("record") OrderLogWithBLOBs record, @Param("example") OrderLogCriteria example);

    int updateByExample(@Param("record") OrderLog record, @Param("example") OrderLogCriteria example);

    int updateByPrimaryKeySelective(OrderLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrderLogWithBLOBs record);

    int updateByPrimaryKey(OrderLog record);
}