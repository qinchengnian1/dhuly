package com.ecms.cums.model;

import java.io.Serializable;
import java.util.Date;

public class ProductInfo implements Serializable {
    private Integer iId;

    private Integer pId;

    private String jnyDays;

    private String ownFlg;

    private String ifEdute;

    private String ifPriceStart;

    private String priceRemark;

    private String adultPrice;

    private String childPrice;

    private Date createTime;

    private Date updateTime;

    private String createPerson;

    private String updatePerson;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getJnyDays() {
        return jnyDays;
    }

    public void setJnyDays(String jnyDays) {
        this.jnyDays = jnyDays == null ? null : jnyDays.trim();
    }

    public String getOwnFlg() {
        return ownFlg;
    }

    public void setOwnFlg(String ownFlg) {
        this.ownFlg = ownFlg == null ? null : ownFlg.trim();
    }

    public String getIfEdute() {
        return ifEdute;
    }

    public void setIfEdute(String ifEdute) {
        this.ifEdute = ifEdute == null ? null : ifEdute.trim();
    }

    public String getIfPriceStart() {
        return ifPriceStart;
    }

    public void setIfPriceStart(String ifPriceStart) {
        this.ifPriceStart = ifPriceStart == null ? null : ifPriceStart.trim();
    }

    public String getPriceRemark() {
        return priceRemark;
    }

    public void setPriceRemark(String priceRemark) {
        this.priceRemark = priceRemark == null ? null : priceRemark.trim();
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

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson == null ? null : updatePerson.trim();
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
        ProductInfo other = (ProductInfo) that;
        return (this.getiId() == null ? other.getiId() == null : this.getiId().equals(other.getiId()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getJnyDays() == null ? other.getJnyDays() == null : this.getJnyDays().equals(other.getJnyDays()))
            && (this.getOwnFlg() == null ? other.getOwnFlg() == null : this.getOwnFlg().equals(other.getOwnFlg()))
            && (this.getIfEdute() == null ? other.getIfEdute() == null : this.getIfEdute().equals(other.getIfEdute()))
            && (this.getIfPriceStart() == null ? other.getIfPriceStart() == null : this.getIfPriceStart().equals(other.getIfPriceStart()))
            && (this.getPriceRemark() == null ? other.getPriceRemark() == null : this.getPriceRemark().equals(other.getPriceRemark()))
            && (this.getAdultPrice() == null ? other.getAdultPrice() == null : this.getAdultPrice().equals(other.getAdultPrice()))
            && (this.getChildPrice() == null ? other.getChildPrice() == null : this.getChildPrice().equals(other.getChildPrice()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreatePerson() == null ? other.getCreatePerson() == null : this.getCreatePerson().equals(other.getCreatePerson()))
            && (this.getUpdatePerson() == null ? other.getUpdatePerson() == null : this.getUpdatePerson().equals(other.getUpdatePerson()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getiId() == null) ? 0 : getiId().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getJnyDays() == null) ? 0 : getJnyDays().hashCode());
        result = prime * result + ((getOwnFlg() == null) ? 0 : getOwnFlg().hashCode());
        result = prime * result + ((getIfEdute() == null) ? 0 : getIfEdute().hashCode());
        result = prime * result + ((getIfPriceStart() == null) ? 0 : getIfPriceStart().hashCode());
        result = prime * result + ((getPriceRemark() == null) ? 0 : getPriceRemark().hashCode());
        result = prime * result + ((getAdultPrice() == null) ? 0 : getAdultPrice().hashCode());
        result = prime * result + ((getChildPrice() == null) ? 0 : getChildPrice().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreatePerson() == null) ? 0 : getCreatePerson().hashCode());
        result = prime * result + ((getUpdatePerson() == null) ? 0 : getUpdatePerson().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}