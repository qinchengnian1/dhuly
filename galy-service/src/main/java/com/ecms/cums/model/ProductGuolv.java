package com.ecms.cums.model;

import java.io.Serializable;

public class ProductGuolv implements Serializable {
    private Integer pGId;

    private String pRouteMain;

    private String pImageUrl;

    private String pStartDest;

    private String pPrice;

    private String pSystemFlag;

    private String pRouteType;

    private String pRouteId;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getpGId() {
        return pGId;
    }

    public void setpGId(Integer pGId) {
        this.pGId = pGId;
    }

    public String getpRouteMain() {
        return pRouteMain;
    }

    public void setpRouteMain(String pRouteMain) {
        this.pRouteMain = pRouteMain == null ? null : pRouteMain.trim();
    }

    public String getpImageUrl() {
        return pImageUrl;
    }

    public void setpImageUrl(String pImageUrl) {
        this.pImageUrl = pImageUrl == null ? null : pImageUrl.trim();
    }

    public String getpStartDest() {
        return pStartDest;
    }

    public void setpStartDest(String pStartDest) {
        this.pStartDest = pStartDest == null ? null : pStartDest.trim();
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice == null ? null : pPrice.trim();
    }

    public String getpSystemFlag() {
        return pSystemFlag;
    }

    public void setpSystemFlag(String pSystemFlag) {
        this.pSystemFlag = pSystemFlag == null ? null : pSystemFlag.trim();
    }

    public String getpRouteType() {
        return pRouteType;
    }

    public void setpRouteType(String pRouteType) {
        this.pRouteType = pRouteType == null ? null : pRouteType.trim();
    }

    public String getpRouteId() {
        return pRouteId;
    }

    public void setpRouteId(String pRouteId) {
        this.pRouteId = pRouteId == null ? null : pRouteId.trim();
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
        ProductGuolv other = (ProductGuolv) that;
        return (this.getpGId() == null ? other.getpGId() == null : this.getpGId().equals(other.getpGId()))
            && (this.getpRouteMain() == null ? other.getpRouteMain() == null : this.getpRouteMain().equals(other.getpRouteMain()))
            && (this.getpImageUrl() == null ? other.getpImageUrl() == null : this.getpImageUrl().equals(other.getpImageUrl()))
            && (this.getpStartDest() == null ? other.getpStartDest() == null : this.getpStartDest().equals(other.getpStartDest()))
            && (this.getpPrice() == null ? other.getpPrice() == null : this.getpPrice().equals(other.getpPrice()))
            && (this.getpSystemFlag() == null ? other.getpSystemFlag() == null : this.getpSystemFlag().equals(other.getpSystemFlag()))
            && (this.getpRouteType() == null ? other.getpRouteType() == null : this.getpRouteType().equals(other.getpRouteType()))
            && (this.getpRouteId() == null ? other.getpRouteId() == null : this.getpRouteId().equals(other.getpRouteId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getpGId() == null) ? 0 : getpGId().hashCode());
        result = prime * result + ((getpRouteMain() == null) ? 0 : getpRouteMain().hashCode());
        result = prime * result + ((getpImageUrl() == null) ? 0 : getpImageUrl().hashCode());
        result = prime * result + ((getpStartDest() == null) ? 0 : getpStartDest().hashCode());
        result = prime * result + ((getpPrice() == null) ? 0 : getpPrice().hashCode());
        result = prime * result + ((getpSystemFlag() == null) ? 0 : getpSystemFlag().hashCode());
        result = prime * result + ((getpRouteType() == null) ? 0 : getpRouteType().hashCode());
        result = prime * result + ((getpRouteId() == null) ? 0 : getpRouteId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}