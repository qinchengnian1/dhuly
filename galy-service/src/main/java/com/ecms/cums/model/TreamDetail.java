package com.ecms.cums.model;

import java.io.Serializable;
import java.util.Date;

public class TreamDetail implements Serializable {
    private Integer tId;

    private Integer iId;

    private String isHot;

    private String minNum;

    private String startDate;

    private String returnDate;

    private String deadlineDate;

    private String adultPrice;

    private String childPrice;

    private String leftNum;

    private String weekDate;

    private String reWeekDate;

    private String remark;

    private Integer createMan;

    private Integer updateMan;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot == null ? null : isHot.trim();
    }

    public String getMinNum() {
        return minNum;
    }

    public void setMinNum(String minNum) {
        this.minNum = minNum == null ? null : minNum.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate == null ? null : returnDate.trim();
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate == null ? null : deadlineDate.trim();
    }

    public String getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(String adultPrice) {
        this.adultPrice = adultPrice == null ? null : adultPrice.trim();
    }

    public String getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(String childPrice) {
        this.childPrice = childPrice == null ? null : childPrice.trim();
    }

    public String getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(String leftNum) {
        this.leftNum = leftNum == null ? null : leftNum.trim();
    }

    public String getWeekDate() {
        return weekDate;
    }

    public void setWeekDate(String weekDate) {
        this.weekDate = weekDate == null ? null : weekDate.trim();
    }

    public String getReWeekDate() {
        return reWeekDate;
    }

    public void setReWeekDate(String reWeekDate) {
        this.reWeekDate = reWeekDate == null ? null : reWeekDate.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreateMan() {
        return createMan;
    }

    public void setCreateMan(Integer createMan) {
        this.createMan = createMan;
    }

    public Integer getUpdateMan() {
        return updateMan;
    }

    public void setUpdateMan(Integer updateMan) {
        this.updateMan = updateMan;
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
        TreamDetail other = (TreamDetail) that;
        return (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.getiId() == null ? other.getiId() == null : this.getiId().equals(other.getiId()))
            && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()))
            && (this.getMinNum() == null ? other.getMinNum() == null : this.getMinNum().equals(other.getMinNum()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getReturnDate() == null ? other.getReturnDate() == null : this.getReturnDate().equals(other.getReturnDate()))
            && (this.getDeadlineDate() == null ? other.getDeadlineDate() == null : this.getDeadlineDate().equals(other.getDeadlineDate()))
            && (this.getAdultPrice() == null ? other.getAdultPrice() == null : this.getAdultPrice().equals(other.getAdultPrice()))
            && (this.getChildPrice() == null ? other.getChildPrice() == null : this.getChildPrice().equals(other.getChildPrice()))
            && (this.getLeftNum() == null ? other.getLeftNum() == null : this.getLeftNum().equals(other.getLeftNum()))
            && (this.getWeekDate() == null ? other.getWeekDate() == null : this.getWeekDate().equals(other.getWeekDate()))
            && (this.getReWeekDate() == null ? other.getReWeekDate() == null : this.getReWeekDate().equals(other.getReWeekDate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateMan() == null ? other.getCreateMan() == null : this.getCreateMan().equals(other.getCreateMan()))
            && (this.getUpdateMan() == null ? other.getUpdateMan() == null : this.getUpdateMan().equals(other.getUpdateMan()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((getiId() == null) ? 0 : getiId().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        result = prime * result + ((getMinNum() == null) ? 0 : getMinNum().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getReturnDate() == null) ? 0 : getReturnDate().hashCode());
        result = prime * result + ((getDeadlineDate() == null) ? 0 : getDeadlineDate().hashCode());
        result = prime * result + ((getAdultPrice() == null) ? 0 : getAdultPrice().hashCode());
        result = prime * result + ((getChildPrice() == null) ? 0 : getChildPrice().hashCode());
        result = prime * result + ((getLeftNum() == null) ? 0 : getLeftNum().hashCode());
        result = prime * result + ((getWeekDate() == null) ? 0 : getWeekDate().hashCode());
        result = prime * result + ((getReWeekDate() == null) ? 0 : getReWeekDate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateMan() == null) ? 0 : getCreateMan().hashCode());
        result = prime * result + ((getUpdateMan() == null) ? 0 : getUpdateMan().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}