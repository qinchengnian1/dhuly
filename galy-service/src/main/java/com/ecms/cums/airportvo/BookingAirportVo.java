package com.ecms.cums.airportvo;
/**
 * @ClassName: BookingAirportVo
 * @Description: 校验接口实体类
 * @author: zJin
 * @date: 2018年4月25日 下午1:59:01
 */
public class BookingAirportVo {
	//接口身份标识用户名
	private String cid;
	//航程类型 1：单程；2：往返
	private String tripType;
	private RoutingVo routing;

	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public RoutingVo getRouting() {
		return routing;
	}
	public void setRouting(RoutingVo routing) {
		this.routing = routing;
	}

}
