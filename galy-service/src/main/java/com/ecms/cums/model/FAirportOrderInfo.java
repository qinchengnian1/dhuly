package com.ecms.cums.model;

import java.io.Serializable;
import java.util.Date;

public class FAirportOrderInfo implements Serializable {
    private Integer fOiId;

    private Integer fOrderId;

    private String fPerName;

    private String fPerTel;

    private String fromToCity;

    private String airportName;

    private String aircraftName;

    private String fromToTime;

    private String airportTime;

    private String fStoreId;

    private String storeName;

    private String storeType;

    private String couponId;

    private String productCode;

    private String adultPrice;

    private String adultTax;

    private String childPrice;

    private String childTax;

    private Date createTime;

    private Date updateTime;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getfOiId() {
        return fOiId;
    }

    public void setfOiId(Integer fOiId) {
        this.fOiId = fOiId;
    }

    public Integer getfOrderId() {
        return fOrderId;
    }

    public void setfOrderId(Integer fOrderId) {
        this.fOrderId = fOrderId;
    }

    public String getfPerName() {
        return fPerName;
    }

    public void setfPerName(String fPerName) {
        this.fPerName = fPerName == null ? null : fPerName.trim();
    }

    public String getfPerTel() {
        return fPerTel;
    }

    public void setfPerTel(String fPerTel) {
        this.fPerTel = fPerTel == null ? null : fPerTel.trim();
    }

    public String getFromToCity() {
        return fromToCity;
    }

    public void setFromToCity(String fromToCity) {
        this.fromToCity = fromToCity == null ? null : fromToCity.trim();
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName == null ? null : airportName.trim();
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName == null ? null : aircraftName.trim();
    }

    public String getFromToTime() {
        return fromToTime;
    }

    public void setFromToTime(String fromToTime) {
        this.fromToTime = fromToTime == null ? null : fromToTime.trim();
    }

    public String getAirportTime() {
        return airportTime;
    }

    public void setAirportTime(String airportTime) {
        this.airportTime = airportTime == null ? null : airportTime.trim();
    }

    public String getfStoreId() {
        return fStoreId;
    }

    public void setfStoreId(String fStoreId) {
        this.fStoreId = fStoreId == null ? null : fStoreId.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType == null ? null : storeType.trim();
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(String adultPrice) {
        this.adultPrice = adultPrice == null ? null : adultPrice.trim();
    }

    public String getAdultTax() {
        return adultTax;
    }

    public void setAdultTax(String adultTax) {
        this.adultTax = adultTax == null ? null : adultTax.trim();
    }

    public String getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(String childPrice) {
        this.childPrice = childPrice == null ? null : childPrice.trim();
    }

    public String getChildTax() {
        return childTax;
    }

    public void setChildTax(String childTax) {
        this.childTax = childTax == null ? null : childTax.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        FAirportOrderInfo other = (FAirportOrderInfo) that;
        return (this.getfOiId() == null ? other.getfOiId() == null : this.getfOiId().equals(other.getfOiId()))
            && (this.getfOrderId() == null ? other.getfOrderId() == null : this.getfOrderId().equals(other.getfOrderId()))
            && (this.getfPerName() == null ? other.getfPerName() == null : this.getfPerName().equals(other.getfPerName()))
            && (this.getfPerTel() == null ? other.getfPerTel() == null : this.getfPerTel().equals(other.getfPerTel()))
            && (this.getFromToCity() == null ? other.getFromToCity() == null : this.getFromToCity().equals(other.getFromToCity()))
            && (this.getAirportName() == null ? other.getAirportName() == null : this.getAirportName().equals(other.getAirportName()))
            && (this.getAircraftName() == null ? other.getAircraftName() == null : this.getAircraftName().equals(other.getAircraftName()))
            && (this.getFromToTime() == null ? other.getFromToTime() == null : this.getFromToTime().equals(other.getFromToTime()))
            && (this.getAirportTime() == null ? other.getAirportTime() == null : this.getAirportTime().equals(other.getAirportTime()))
            && (this.getfStoreId() == null ? other.getfStoreId() == null : this.getfStoreId().equals(other.getfStoreId()))
            && (this.getStoreName() == null ? other.getStoreName() == null : this.getStoreName().equals(other.getStoreName()))
            && (this.getStoreType() == null ? other.getStoreType() == null : this.getStoreType().equals(other.getStoreType()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getAdultPrice() == null ? other.getAdultPrice() == null : this.getAdultPrice().equals(other.getAdultPrice()))
            && (this.getAdultTax() == null ? other.getAdultTax() == null : this.getAdultTax().equals(other.getAdultTax()))
            && (this.getChildPrice() == null ? other.getChildPrice() == null : this.getChildPrice().equals(other.getChildPrice()))
            && (this.getChildTax() == null ? other.getChildTax() == null : this.getChildTax().equals(other.getChildTax()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfOiId() == null) ? 0 : getfOiId().hashCode());
        result = prime * result + ((getfOrderId() == null) ? 0 : getfOrderId().hashCode());
        result = prime * result + ((getfPerName() == null) ? 0 : getfPerName().hashCode());
        result = prime * result + ((getfPerTel() == null) ? 0 : getfPerTel().hashCode());
        result = prime * result + ((getFromToCity() == null) ? 0 : getFromToCity().hashCode());
        result = prime * result + ((getAirportName() == null) ? 0 : getAirportName().hashCode());
        result = prime * result + ((getAircraftName() == null) ? 0 : getAircraftName().hashCode());
        result = prime * result + ((getFromToTime() == null) ? 0 : getFromToTime().hashCode());
        result = prime * result + ((getAirportTime() == null) ? 0 : getAirportTime().hashCode());
        result = prime * result + ((getfStoreId() == null) ? 0 : getfStoreId().hashCode());
        result = prime * result + ((getStoreName() == null) ? 0 : getStoreName().hashCode());
        result = prime * result + ((getStoreType() == null) ? 0 : getStoreType().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getAdultPrice() == null) ? 0 : getAdultPrice().hashCode());
        result = prime * result + ((getAdultTax() == null) ? 0 : getAdultTax().hashCode());
        result = prime * result + ((getChildPrice() == null) ? 0 : getChildPrice().hashCode());
        result = prime * result + ((getChildTax() == null) ? 0 : getChildTax().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}