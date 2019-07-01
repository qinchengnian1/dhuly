package com.ecms.cums.model;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Integer pId;

    private Integer tId;

    private String routeMain;

    private String routeSub;

    private String ptNo;

    private Date startDateStr;

    private String startPlaceId;

    private String destPlaceId;

    private String agentType;

    private String picPath;

    private String price;

    private Integer clickCount;

    private Integer askedCount;

    private String status;

    private String cityIds;

    private Integer compId;

    private String systemFlag;

    private String createName;

    private String updateName;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getRouteMain() {
        return routeMain;
    }

    public void setRouteMain(String routeMain) {
        this.routeMain = routeMain == null ? null : routeMain.trim();
    }

    public String getRouteSub() {
        return routeSub;
    }

    public void setRouteSub(String routeSub) {
        this.routeSub = routeSub == null ? null : routeSub.trim();
    }

    public String getPtNo() {
        return ptNo;
    }

    public void setPtNo(String ptNo) {
        this.ptNo = ptNo == null ? null : ptNo.trim();
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
        this.startPlaceId = startPlaceId == null ? null : startPlaceId.trim();
    }

    public String getDestPlaceId() {
        return destPlaceId;
    }

    public void setDestPlaceId(String destPlaceId) {
        this.destPlaceId = destPlaceId == null ? null : destPlaceId.trim();
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType == null ? null : agentType.trim();
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getAskedCount() {
        return askedCount;
    }

    public void setAskedCount(Integer askedCount) {
        this.askedCount = askedCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCityIds() {
        return cityIds;
    }

    public void setCityIds(String cityIds) {
        this.cityIds = cityIds == null ? null : cityIds.trim();
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getSystemFlag() {
        return systemFlag;
    }

    public void setSystemFlag(String systemFlag) {
        this.systemFlag = systemFlag == null ? null : systemFlag.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Product other = (Product) that;
        return (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.getRouteMain() == null ? other.getRouteMain() == null : this.getRouteMain().equals(other.getRouteMain()))
            && (this.getRouteSub() == null ? other.getRouteSub() == null : this.getRouteSub().equals(other.getRouteSub()))
            && (this.getPtNo() == null ? other.getPtNo() == null : this.getPtNo().equals(other.getPtNo()))
            && (this.getStartDateStr() == null ? other.getStartDateStr() == null : this.getStartDateStr().equals(other.getStartDateStr()))
            && (this.getStartPlaceId() == null ? other.getStartPlaceId() == null : this.getStartPlaceId().equals(other.getStartPlaceId()))
            && (this.getDestPlaceId() == null ? other.getDestPlaceId() == null : this.getDestPlaceId().equals(other.getDestPlaceId()))
            && (this.getAgentType() == null ? other.getAgentType() == null : this.getAgentType().equals(other.getAgentType()))
            && (this.getPicPath() == null ? other.getPicPath() == null : this.getPicPath().equals(other.getPicPath()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getClickCount() == null ? other.getClickCount() == null : this.getClickCount().equals(other.getClickCount()))
            && (this.getAskedCount() == null ? other.getAskedCount() == null : this.getAskedCount().equals(other.getAskedCount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCityIds() == null ? other.getCityIds() == null : this.getCityIds().equals(other.getCityIds()))
            && (this.getCompId() == null ? other.getCompId() == null : this.getCompId().equals(other.getCompId()))
            && (this.getSystemFlag() == null ? other.getSystemFlag() == null : this.getSystemFlag().equals(other.getSystemFlag()))
            && (this.getCreateName() == null ? other.getCreateName() == null : this.getCreateName().equals(other.getCreateName()))
            && (this.getUpdateName() == null ? other.getUpdateName() == null : this.getUpdateName().equals(other.getUpdateName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((getRouteMain() == null) ? 0 : getRouteMain().hashCode());
        result = prime * result + ((getRouteSub() == null) ? 0 : getRouteSub().hashCode());
        result = prime * result + ((getPtNo() == null) ? 0 : getPtNo().hashCode());
        result = prime * result + ((getStartDateStr() == null) ? 0 : getStartDateStr().hashCode());
        result = prime * result + ((getStartPlaceId() == null) ? 0 : getStartPlaceId().hashCode());
        result = prime * result + ((getDestPlaceId() == null) ? 0 : getDestPlaceId().hashCode());
        result = prime * result + ((getAgentType() == null) ? 0 : getAgentType().hashCode());
        result = prime * result + ((getPicPath() == null) ? 0 : getPicPath().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getClickCount() == null) ? 0 : getClickCount().hashCode());
        result = prime * result + ((getAskedCount() == null) ? 0 : getAskedCount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCityIds() == null) ? 0 : getCityIds().hashCode());
        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());
        result = prime * result + ((getSystemFlag() == null) ? 0 : getSystemFlag().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}