package com.ecms.cums.model;

import java.io.Serializable;
import java.util.Date;

public class ProductDest implements Serializable {
    private Integer pDId;

    private String destId;

    private String destName;

    private String pinyin;

    private String destPId;

    private String eName;

    private String systemFlag;

    private String systemType;

    private String hotDest;

    private String status;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getpDId() {
        return pDId;
    }

    public void setpDId(Integer pDId) {
        this.pDId = pDId;
    }

    public String getDestId() {
        return destId;
    }

    public void setDestId(String destId) {
        this.destId = destId == null ? null : destId.trim();
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName == null ? null : destName.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getDestPId() {
        return destPId;
    }

    public void setDestPId(String destPId) {
        this.destPId = destPId == null ? null : destPId.trim();
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String getSystemFlag() {
        return systemFlag;
    }

    public void setSystemFlag(String systemFlag) {
        this.systemFlag = systemFlag == null ? null : systemFlag.trim();
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType == null ? null : systemType.trim();
    }

    public String getHotDest() {
        return hotDest;
    }

    public void setHotDest(String hotDest) {
        this.hotDest = hotDest == null ? null : hotDest.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        ProductDest other = (ProductDest) that;
        return (this.getpDId() == null ? other.getpDId() == null : this.getpDId().equals(other.getpDId()))
            && (this.getDestId() == null ? other.getDestId() == null : this.getDestId().equals(other.getDestId()))
            && (this.getDestName() == null ? other.getDestName() == null : this.getDestName().equals(other.getDestName()))
            && (this.getPinyin() == null ? other.getPinyin() == null : this.getPinyin().equals(other.getPinyin()))
            && (this.getDestPId() == null ? other.getDestPId() == null : this.getDestPId().equals(other.getDestPId()))
            && (this.geteName() == null ? other.geteName() == null : this.geteName().equals(other.geteName()))
            && (this.getSystemFlag() == null ? other.getSystemFlag() == null : this.getSystemFlag().equals(other.getSystemFlag()))
            && (this.getSystemType() == null ? other.getSystemType() == null : this.getSystemType().equals(other.getSystemType()))
            && (this.getHotDest() == null ? other.getHotDest() == null : this.getHotDest().equals(other.getHotDest()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getpDId() == null) ? 0 : getpDId().hashCode());
        result = prime * result + ((getDestId() == null) ? 0 : getDestId().hashCode());
        result = prime * result + ((getDestName() == null) ? 0 : getDestName().hashCode());
        result = prime * result + ((getPinyin() == null) ? 0 : getPinyin().hashCode());
        result = prime * result + ((getDestPId() == null) ? 0 : getDestPId().hashCode());
        result = prime * result + ((geteName() == null) ? 0 : geteName().hashCode());
        result = prime * result + ((getSystemFlag() == null) ? 0 : getSystemFlag().hashCode());
        result = prime * result + ((getSystemType() == null) ? 0 : getSystemType().hashCode());
        result = prime * result + ((getHotDest() == null) ? 0 : getHotDest().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}