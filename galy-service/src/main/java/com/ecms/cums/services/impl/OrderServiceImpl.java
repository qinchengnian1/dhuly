package com.ecms.cums.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.cores.MySearchFilter;
import com.ecms.cums.dao.OrderInfoMapper;
import com.ecms.cums.model.OrderInfo;
import com.ecms.cums.services.OrderService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private  OrderInfoMapper orderInfoMapper;

	@Override
	public List<OrderInfo> queryPage(PageBounds pageBounds, Map<String, Object> searchParams) {
		Map<String, Object> params = MySearchFilter.filter(searchParams);
		return orderInfoMapper.queryPage(pageBounds,params);
	}

	@Override
	public OrderInfo selectOrderInfoById(String orderId) {
		return orderInfoMapper.selectByPrimaryKey(Integer.parseInt(orderId));
	}

	@Override
	public List<OrderInfo> selectExportExcel(String perName, String stateLocal) {
		return orderInfoMapper.selectExportExcel(perName,stateLocal);
	}

	@Override
	public OrderInfo selectOrderInfoByPrimaryKey(String orderId) {
		return orderInfoMapper.selectByPrimaryKey(Integer.parseInt(orderId));


	}

}
