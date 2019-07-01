package com.ecms.cums.model;

import java.io.Serializable;
import java.util.Date;

public class fAirportCoupon implements Serializable {
    private Integer fCardId;

    private Integer fOrderId;

    private String fCardCouponId;

    private String fStartDate;

    private String fExpirationDate;

    private String fAmount;

    private String fCouponName;

    private Date createDate;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getfCardId() {
        return fCardId;
    }

    public void setfCardId(Integer fCardId) {
        this.fCardId = fCardId;
    }

    public Integer getfOrderId() {
        return fOrderId;
    }

    public void setfOrderId(Integer fOrderId) {
        this.fOrderId = fOrderId;
    }

    public String getfCardCouponId() {
        return fCardCouponId;
    }

    public void setfCardCouponId(String fCardCouponId) {
        this.fCardCouponId = fCardCouponId == null ? null : fCardCouponId.trim();
    }

    public String getfStartDate() {
        return fStartDate;
    }

    public void setfStartDate(String fStartDate) {
        this.fStartDate = fStartDate == null ? null : fStartDate.trim();
    }

    public String getfExpirationDate() {
        return fExpirationDate;
    }

    public void setfExpirationDate(String fExpirationDate) {
        this.fExpirationDate = fExpirationDate == null ? null : fExpirationDate.trim();
    }

    public String getfAmount() {
        return fAmount;
    }

    public void setfAmount(String fAmount) {
        this.fAmount = fAmount == null ? null : fAmount.trim();
    }

    public String getfCouponName() {
        return fCouponName;
    }

    public void setfCouponName(String fCouponName) {
        this.fCouponName = fCouponName == null ? null : fCouponName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        fAirportCoupon other = (fAirportCoupon) that;
        return (this.getfCardId() == null ? other.getfCardId() == null : this.getfCardId().equals(other.getfCardId()))
            && (this.getfOrderId() == null ? other.getfOrderId() == null : this.getfOrderId().equals(other.getfOrderId()))
            && (this.getfCardCouponId() == null ? other.getfCardCouponId() == null : this.getfCardCouponId().equals(other.getfCardCouponId()))
            && (this.getfStartDate() == null ? other.getfStartDate() == null : this.getfStartDate().equals(other.getfStartDate()))
            && (this.getfExpirationDate() == null ? other.getfExpirationDate() == null : this.getfExpirationDate().equals(other.getfExpirationDate()))
            && (this.getfAmount() == null ? other.getfAmount() == null : this.getfAmount().equals(other.getfAmount()))
            && (this.getfCouponName() == null ? other.getfCouponName() == null : this.getfCouponName().equals(other.getfCouponName()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfCardId() == null) ? 0 : getfCardId().hashCode());
        result = prime * result + ((getfOrderId() == null) ? 0 : getfOrderId().hashCode());
        result = prime * result + ((getfCardCouponId() == null) ? 0 : getfCardCouponId().hashCode());
        result = prime * result + ((getfStartDate() == null) ? 0 : getfStartDate().hashCode());
        result = prime * result + ((getfExpirationDate() == null) ? 0 : getfExpirationDate().hashCode());
        result = prime * result + ((getfAmount() == null) ? 0 : getfAmount().hashCode());
        result = prime * result + ((getfCouponName() == null) ? 0 : getfCouponName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}