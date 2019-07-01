package com.ecms.cums.model;

import java.io.Serializable;

public class OrderLogWithBLOBs extends OrderLog implements Serializable {
    private String reasonText;

    private String reqJson;

    private static final long serialVersionUID = 1L;

    public String getReasonText() {
        return reasonText;
    }

    public void setReasonText(String reasonText) {
        this.reasonText = reasonText == null ? null : reasonText.trim();
    }

    public String getReqJson() {
        return reqJson;
    }

    public void setReqJson(String reqJson) {
        this.reqJson = reqJson == null ? null : reqJson.trim();
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
        OrderLogWithBLOBs other = (OrderLogWithBLOBs) that;
        return (this.getoLogId() == null ? other.getoLogId() == null : this.getoLogId().equals(other.getoLogId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getLogType() == null ? other.getLogType() == null : this.getLogType().equals(other.getLogType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getReasonText() == null ? other.getReasonText() == null : this.getReasonText().equals(other.getReasonText()))
            && (this.getReqJson() == null ? other.getReqJson() == null : this.getReqJson().equals(other.getReqJson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getoLogId() == null) ? 0 : getoLogId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getLogType() == null) ? 0 : getLogType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getReasonText() == null) ? 0 : getReasonText().hashCode());
        result = prime * result + ((getReqJson() == null) ? 0 : getReqJson().hashCode());
        return result;
    }
}