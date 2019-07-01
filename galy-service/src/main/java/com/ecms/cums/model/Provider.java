package com.ecms.cums.model;

import java.io.Serializable;

public class Provider implements Serializable {
    private Integer compId;

    private String compName;

    private String compNo;

    private String status;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    public String getCompNo() {
        return compNo;
    }

    public void setCompNo(String compNo) {
        this.compNo = compNo == null ? null : compNo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        Provider other = (Provider) that;
        return (this.getCompId() == null ? other.getCompId() == null : this.getCompId().equals(other.getCompId()))
            && (this.getCompName() == null ? other.getCompName() == null : this.getCompName().equals(other.getCompName()))
            && (this.getCompNo() == null ? other.getCompNo() == null : this.getCompNo().equals(other.getCompNo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());
        result = prime * result + ((getCompName() == null) ? 0 : getCompName().hashCode());
        result = prime * result + ((getCompNo() == null) ? 0 : getCompNo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}