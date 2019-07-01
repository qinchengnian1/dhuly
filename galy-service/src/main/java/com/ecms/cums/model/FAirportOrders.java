package com.ecms.cums.model;

import java.io.Serializable;
import java.util.Date;

public class FAirportOrders implements Serializable {
    private Integer fOrderId;

    private String fCityNo;

    private Integer fUserId;

    private String fOrderGroupId;

    private String fOrderNoPt;

    private String cardCouponId;

    private String outTradeNo;

    private String transactionId;

    private String payplatform;

    private String jipiaoType;

    private String tradeState;

    private Date payTime;

    private Date notifyTime;

    private String totalPrice;

    private String couponPrice;

    private String ldyOrderNo;

    private String ldyPnr;

    private String ldyOrderId;

    private String statusName;

    private String status;

    private Date createTime;

    private Date updateTime;

    private String remark;

    private String fenrunOutTradeNo;

    private String fenrunTotalPrice;

    private static final long serialVersionUID = 1L;

    public Integer getfOrderId() {
        return fOrderId;
    }

    public void setfOrderId(Integer fOrderId) {
        this.fOrderId = fOrderId;
    }

    public String getfCityNo() {
        return fCityNo;
    }

    public void setfCityNo(String fCityNo) {
        this.fCityNo = fCityNo == null ? null : fCityNo.trim();
    }

    public Integer getfUserId() {
        return fUserId;
    }

    public void setfUserId(Integer fUserId) {
        this.fUserId = fUserId;
    }

    public String getfOrderGroupId() {
        return fOrderGroupId;
    }

    public void setfOrderGroupId(String fOrderGroupId) {
        this.fOrderGroupId = fOrderGroupId == null ? null : fOrderGroupId.trim();
    }

    public String getfOrderNoPt() {
        return fOrderNoPt;
    }

    public void setfOrderNoPt(String fOrderNoPt) {
        this.fOrderNoPt = fOrderNoPt == null ? null : fOrderNoPt.trim();
    }

    public String getCardCouponId() {
        return cardCouponId;
    }

    public void setCardCouponId(String cardCouponId) {
        this.cardCouponId = cardCouponId == null ? null : cardCouponId.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public String getPayplatform() {
        return payplatform;
    }

    public void setPayplatform(String payplatform) {
        this.payplatform = payplatform == null ? null : payplatform.trim();
    }

    public String getJipiaoType() {
        return jipiaoType;
    }

    public void setJipiaoType(String jipiaoType) {
        this.jipiaoType = jipiaoType == null ? null : jipiaoType.trim();
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState == null ? null : tradeState.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice == null ? null : totalPrice.trim();
    }

    public String getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(String couponPrice) {
        this.couponPrice = couponPrice == null ? null : couponPrice.trim();
    }

    public String getLdyOrderNo() {
        return ldyOrderNo;
    }

    public void setLdyOrderNo(String ldyOrderNo) {
        this.ldyOrderNo = ldyOrderNo == null ? null : ldyOrderNo.trim();
    }

    public String getLdyPnr() {
        return ldyPnr;
    }

    public void setLdyPnr(String ldyPnr) {
        this.ldyPnr = ldyPnr == null ? null : ldyPnr.trim();
    }

    public String getLdyOrderId() {
        return ldyOrderId;
    }

    public void setLdyOrderId(String ldyOrderId) {
        this.ldyOrderId = ldyOrderId == null ? null : ldyOrderId.trim();
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFenrunOutTradeNo() {
        return fenrunOutTradeNo;
    }

    public void setFenrunOutTradeNo(String fenrunOutTradeNo) {
        this.fenrunOutTradeNo = fenrunOutTradeNo == null ? null : fenrunOutTradeNo.trim();
    }

    public String getFenrunTotalPrice() {
        return fenrunTotalPrice;
    }

    public void setFenrunTotalPrice(String fenrunTotalPrice) {
        this.fenrunTotalPrice = fenrunTotalPrice == null ? null : fenrunTotalPrice.trim();
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
        FAirportOrders other = (FAirportOrders) that;
        return (this.getfOrderId() == null ? other.getfOrderId() == null : this.getfOrderId().equals(other.getfOrderId()))
            && (this.getfCityNo() == null ? other.getfCityNo() == null : this.getfCityNo().equals(other.getfCityNo()))
            && (this.getfUserId() == null ? other.getfUserId() == null : this.getfUserId().equals(other.getfUserId()))
            && (this.getfOrderGroupId() == null ? other.getfOrderGroupId() == null : this.getfOrderGroupId().equals(other.getfOrderGroupId()))
            && (this.getfOrderNoPt() == null ? other.getfOrderNoPt() == null : this.getfOrderNoPt().equals(other.getfOrderNoPt()))
            && (this.getCardCouponId() == null ? other.getCardCouponId() == null : this.getCardCouponId().equals(other.getCardCouponId()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getTransactionId() == null ? other.getTransactionId() == null : this.getTransactionId().equals(other.getTransactionId()))
            && (this.getPayplatform() == null ? other.getPayplatform() == null : this.getPayplatform().equals(other.getPayplatform()))
            && (this.getJipiaoType() == null ? other.getJipiaoType() == null : this.getJipiaoType().equals(other.getJipiaoType()))
            && (this.getTradeState() == null ? other.getTradeState() == null : this.getTradeState().equals(other.getTradeState()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getNotifyTime() == null ? other.getNotifyTime() == null : this.getNotifyTime().equals(other.getNotifyTime()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getCouponPrice() == null ? other.getCouponPrice() == null : this.getCouponPrice().equals(other.getCouponPrice()))
            && (this.getLdyOrderNo() == null ? other.getLdyOrderNo() == null : this.getLdyOrderNo().equals(other.getLdyOrderNo()))
            && (this.getLdyPnr() == null ? other.getLdyPnr() == null : this.getLdyPnr().equals(other.getLdyPnr()))
            && (this.getLdyOrderId() == null ? other.getLdyOrderId() == null : this.getLdyOrderId().equals(other.getLdyOrderId()))
            && (this.getStatusName() == null ? other.getStatusName() == null : this.getStatusName().equals(other.getStatusName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getFenrunOutTradeNo() == null ? other.getFenrunOutTradeNo() == null : this.getFenrunOutTradeNo().equals(other.getFenrunOutTradeNo()))
            && (this.getFenrunTotalPrice() == null ? other.getFenrunTotalPrice() == null : this.getFenrunTotalPrice().equals(other.getFenrunTotalPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfOrderId() == null) ? 0 : getfOrderId().hashCode());
        result = prime * result + ((getfCityNo() == null) ? 0 : getfCityNo().hashCode());
        result = prime * result + ((getfUserId() == null) ? 0 : getfUserId().hashCode());
        result = prime * result + ((getfOrderGroupId() == null) ? 0 : getfOrderGroupId().hashCode());
        result = prime * result + ((getfOrderNoPt() == null) ? 0 : getfOrderNoPt().hashCode());
        result = prime * result + ((getCardCouponId() == null) ? 0 : getCardCouponId().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getTransactionId() == null) ? 0 : getTransactionId().hashCode());
        result = prime * result + ((getPayplatform() == null) ? 0 : getPayplatform().hashCode());
        result = prime * result + ((getJipiaoType() == null) ? 0 : getJipiaoType().hashCode());
        result = prime * result + ((getTradeState() == null) ? 0 : getTradeState().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getNotifyTime() == null) ? 0 : getNotifyTime().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getCouponPrice() == null) ? 0 : getCouponPrice().hashCode());
        result = prime * result + ((getLdyOrderNo() == null) ? 0 : getLdyOrderNo().hashCode());
        result = prime * result + ((getLdyPnr() == null) ? 0 : getLdyPnr().hashCode());
        result = prime * result + ((getLdyOrderId() == null) ? 0 : getLdyOrderId().hashCode());
        result = prime * result + ((getStatusName() == null) ? 0 : getStatusName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getFenrunOutTradeNo() == null) ? 0 : getFenrunOutTradeNo().hashCode());
        result = prime * result + ((getFenrunTotalPrice() == null) ? 0 : getFenrunTotalPrice().hashCode());
        return result;
    }
}