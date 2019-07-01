package com.ecms.cums.services;

import java.util.Map;

import com.ecms.cums.ordervo.CreatePTOrderVo;

/**
 * @ClassName: PingTaiService
 * @Description: 平台接口
 * @author: zJin
 * @date: 2018年3月12日 下午6:16:34
 */
public interface PingTaiService {
	/**
	 * @Title: getSignByMap
	 * @Description: 获取平台SIGN
	 * @param map
	 * @return
	 * @return: String
	 */
	public String getSignByMap(Map<String,Object> map);

	public String createOrder(CreatePTOrderVo pOrder);
}
