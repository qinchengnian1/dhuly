package com.ecms.cums.model;

import java.io.Serializable;

public class EShop implements Serializable {
    private Integer eId;

    private Integer compId;

    private String eName;

    private Integer cityId;

    private String eKey;

    private String eKeyNo;

    private String status;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String geteKey() {
        return eKey;
    }

    public void seteKey(String eKey) {
        this.eKey = eKey == null ? null : eKey.trim();
    }

    public String geteKeyNo() {
        return eKeyNo;
    }

    public void seteKeyNo(String eKeyNo) {
        this.eKeyNo = eKeyNo == null ? null : eKeyNo.trim();
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
        EShop other = (EShop) that;
        return (this.geteId() == null ? other.geteId() == null : this.geteId().equals(other.geteId()))
            && (this.getCompId() == null ? other.getCompId() == null : this.getCompId().equals(other.getCompId()))
            && (this.geteName() == null ? other.geteName() == null : this.geteName().equals(other.geteName()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.geteKey() == null ? other.geteKey() == null : this.geteKey().equals(other.geteKey()))
            && (this.geteKeyNo() == null ? other.geteKeyNo() == null : this.geteKeyNo().equals(other.geteKeyNo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((geteId() == null) ? 0 : geteId().hashCode());
        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());
        result = prime * result + ((geteName() == null) ? 0 : geteName().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((geteKey() == null) ? 0 : geteKey().hashCode());
        result = prime * result + ((geteKeyNo() == null) ? 0 : geteKeyNo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}