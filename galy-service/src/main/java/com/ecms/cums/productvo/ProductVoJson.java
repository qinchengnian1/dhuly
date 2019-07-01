package com.ecms.cums.productvo;

import java.util.Date;
import java.util.List;

import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TreamDetail;

public class ProductVoJson {
	//主键id
	private Integer pId;
	//类型id
    private String tId;
  //线路主标题
    private String routeMain;
    //推荐
    private String agentType;
    //图片路径
    private String picPath;
    //价格
    private String price;
    //线路副标题
    private String routeSub;
    //出发日期
    private Date startDateStr;
    //出发城市
    private String startPlaceId;
    //目的地
    private String destPlaceId;
    // 供应商
    private Integer compId;
    //城市id
    private String cityIds;
    //国内
    private String systemFlag;
    //状态
    private String status;

	private List<ProductInfoWithBLOBs> productInfoWithBLOBs;

	private List<TreamDetail> treamDetailList;

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String getRouteMain() {
		return routeMain;
	}

	public void setRouteMain(String routeMain) {
		this.routeMain = routeMain;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRouteSub() {
		return routeSub;
	}

	public void setRouteSub(String routeSub) {
		this.routeSub = routeSub;
	}

	public Date getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(Date startDateStr) {
		this.startDateStr = startDateStr;
	}

	public String getStartPlaceId() {
		return startPlaceId;
	}

	public void setStartPlaceId(String startPlaceId) {
		this.startPlaceId = startPlaceId;
	}

	public String getDestPlaceId() {
		return destPlaceId;
	}

	public void setDestPlaceId(String destPlaceId) {
		this.destPlaceId = destPlaceId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getCityIds() {
		return cityIds;
	}

	public void setCityIds(String cityIds) {
		this.cityIds = cityIds;
	}


	public List<TreamDetail> getTreamDetailList() {
		return treamDetailList;
	}

	public void setTreamDetailList(List<TreamDetail> treamDetailList) {
		this.treamDetailList = treamDetailList;
	}

	public List<ProductInfoWithBLOBs> getProductInfoWithBLOBs() {
		return productInfoWithBLOBs;
	}

	public void setProductInfoWithBLOBs(List<ProductInfoWithBLOBs> productInfoWithBLOBs) {
		this.productInfoWithBLOBs = productInfoWithBLOBs;
	}

	public String getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
