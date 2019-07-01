package com.ecms.cums.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.model.OrderInfoCriteria;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface OrderInfoMapper {
	int countByExample(OrderInfoCriteria example);

	int deleteByExample(OrderInfoCriteria example);

	int deleteByPrimaryKey(Integer orderId);

	int insert(OrderInfo record);

	int insertSelective(OrderInfo record);

	List<OrderInfo> selectByExampleWithBLOBs(OrderInfoCriteria example);

	List<OrderInfo> selectByExample(OrderInfoCriteria example);

	OrderInfo selectByPrimaryKey(Integer orderId);

	int updateByExampleSelective(@Param("record") OrderInfo record,
			@Param("example") OrderInfoCriteria example);

	int updateByExampleWithBLOBs(@Param("record") OrderInfo record,
			@Param("example") OrderInfoCriteria example);

	int updateByExample(@Param("record") OrderInfo record,
			@Param("example") OrderInfoCriteria example);

	int updateByPrimaryKeySelective(OrderInfo record);

	int updateByPrimaryKeyWithBLOBs(OrderInfo record);

	int updateByPrimaryKey(OrderInfo record);

    void updateOrderInfoStatusByTime();

	List<OrderInfo> checkOrderInfoByUserId(Integer userId);

	List<OrderInfo> queryPage(PageBounds pageBounds, Map<String, Object> params);

	List<OrderInfo> selectExportExcel(@Param("perName")String perName,  @Param("stateLocal")  String stateLocal);

}