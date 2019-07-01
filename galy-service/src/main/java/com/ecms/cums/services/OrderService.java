package com.ecms.cums.services;

import java.util.List;
import java.util.Map;

import com.ecms.cums.model.OrderInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface OrderService {

	List<OrderInfo> queryPage(PageBounds pageBounds, Map<String, Object> searchParams);

	OrderInfo selectOrderInfoById(String orderId);

	List<OrderInfo> selectExportExcel(String perName, String stateLocal);

	OrderInfo selectOrderInfoByPrimaryKey(String orderId);




}
