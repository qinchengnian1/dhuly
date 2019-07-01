package com.ecms.cums.model;

import java.io.Serializable;
import java.util.Date;

public class FAirportTouristOrder implements Serializable {
    private Integer fOTId;

    private Integer fOrderId;

    private Integer fTouristId;

    private String fTouristName;

    private String cardNum;

    private String returnRefundFeeLdy;

    private String refundFeeLdy;

    private String passengerIdLdy;

    private String refundCause;

    private String onePriceAll;

    private String factReturnFee;

    private Date createTime;

    private Date updateTime;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getfOTId() {
        return fOTId;
    }

    public void setfOTId(Integer fOTId) {
        this.fOTId = fOTId;
    }

    public Integer getfOrderId() {
        return fOrderId;
    }

    public void setfOrderId(Integer fOrderId) {
        this.fOrderId = fOrderId;
    }

    public Integer getfTouristId() {
        return fTouristId;
    }

    public void setfTouristId(Integer fTouristId) {
        this.fTouristId = fTouristId;
    }

    public String getfTouristName() {
        return fTouristName;
    }

    public void setfTouristName(String fTouristName) {
        this.fTouristName = fTouristName == null ? null : fTouristName.trim();
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getReturnRefundFeeLdy() {
        return returnRefundFeeLdy;
    }

    public void setReturnRefundFeeLdy(String returnRefundFeeLdy) {
        this.returnRefundFeeLdy = returnRefundFeeLdy == null ? null : returnRefundFeeLdy.trim();
    }

    public String getRefundFeeLdy() {
        return refundFeeLdy;
    }

    public void setRefundFeeLdy(String refundFeeLdy) {
        this.refundFeeLdy = refundFeeLdy == null ? null : refundFeeLdy.trim();
    }

    public String getPassengerIdLdy() {
        return passengerIdLdy;
    }

    public void setPassengerIdLdy(String passengerIdLdy) {
        this.passengerIdLdy = passengerIdLdy == null ? null : passengerIdLdy.trim();
    }

    public String getRefundCause() {
        return refundCause;
    }

    public void setRefundCause(String refundCause) {
        this.refundCause = refundCause == null ? null : refundCause.trim();
    }

    public String getOnePriceAll() {
        return onePriceAll;
    }

    public void setOnePriceAll(String onePriceAll) {
        this.onePriceAll = onePriceAll == null ? null : onePriceAll.trim();
    }

    public String getFactReturnFee() {
        return factReturnFee;
    }

    public void setFactReturnFee(String factReturnFee) {
        this.factReturnFee = factReturnFee == null ? null : factReturnFee.trim();
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
        FAirportTouristOrder other = (FAirportTouristOrder) that;
        return (this.getfOTId() == null ? other.getfOTId() == null : this.getfOTId().equals(other.getfOTId()))
            && (this.getfOrderId() == null ? other.getfOrderId() == null : this.getfOrderId().equals(other.getfOrderId()))
            && (this.getfTouristId() == null ? other.getfTouristId() == null : this.getfTouristId().equals(other.getfTouristId()))
            && (this.getfTouristName() == null ? other.getfTouristName() == null : this.getfTouristName().equals(other.getfTouristName()))
            && (this.getCardNum() == null ? other.getCardNum() == null : this.getCardNum().equals(other.getCardNum()))
            && (this.getReturnRefundFeeLdy() == null ? other.getReturnRefundFeeLdy() == null : this.getReturnRefundFeeLdy().equals(other.getReturnRefundFeeLdy()))
            && (this.getRefundFeeLdy() == null ? other.getRefundFeeLdy() == null : this.getRefundFeeLdy().equals(other.getRefundFeeLdy()))
            && (this.getPassengerIdLdy() == null ? other.getPassengerIdLdy() == null : this.getPassengerIdLdy().equals(other.getPassengerIdLdy()))
            && (this.getRefundCause() == null ? other.getRefundCause() == null : this.getRefundCause().equals(other.getRefundCause()))
            && (this.getOnePriceAll() == null ? other.getOnePriceAll() == null : this.getOnePriceAll().equals(other.getOnePriceAll()))
            && (this.getFactReturnFee() == null ? other.getFactReturnFee() == null : this.getFactReturnFee().equals(other.getFactReturnFee()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfOTId() == null) ? 0 : getfOTId().hashCode());
        result = prime * result + ((getfOrderId() == null) ? 0 : getfOrderId().hashCode());
        result = prime * result + ((getfTouristId() == null) ? 0 : getfTouristId().hashCode());
        result = prime * result + ((getfTouristName() == null) ? 0 : getfTouristName().hashCode());
        result = prime * result + ((getCardNum() == null) ? 0 : getCardNum().hashCode());
        result = prime * result + ((getReturnRefundFeeLdy() == null) ? 0 : getReturnRefundFeeLdy().hashCode());
        result = prime * result + ((getRefundFeeLdy() == null) ? 0 : getRefundFeeLdy().hashCode());
        result = prime * result + ((getPassengerIdLdy() == null) ? 0 : getPassengerIdLdy().hashCode());
        result = prime * result + ((getRefundCause() == null) ? 0 : getRefundCause().hashCode());
        result = prime * result + ((getOnePriceAll() == null) ? 0 : getOnePriceAll().hashCode());
        result = prime * result + ((getFactReturnFee() == null) ? 0 : getFactReturnFee().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}