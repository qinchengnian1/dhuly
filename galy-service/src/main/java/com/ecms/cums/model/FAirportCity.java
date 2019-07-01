package com.ecms.cums.model;

import java.io.Serializable;

public class FAirportCity implements Serializable {
    private Integer fCId;

    private String fNation;

    private String fNationName;

    private String fCityName;

    private String fAirportName;

    private String fAirportNamePy;

    private String fSanziCode;

    private String fSanziCityCode;

    private String fIfHot;

    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getfCId() {
        return fCId;
    }

    public void setfCId(Integer fCId) {
        this.fCId = fCId;
    }

    public String getfNation() {
        return fNation;
    }

    public void setfNation(String fNation) {
        this.fNation = fNation == null ? null : fNation.trim();
    }

    public String getfNationName() {
        return fNationName;
    }

    public void setfNationName(String fNationName) {
        this.fNationName = fNationName == null ? null : fNationName.trim();
    }

    public String getfCityName() {
        return fCityName;
    }

    public void setfCityName(String fCityName) {
        this.fCityName = fCityName == null ? null : fCityName.trim();
    }

    public String getfAirportName() {
        return fAirportName;
    }

    public void setfAirportName(String fAirportName) {
        this.fAirportName = fAirportName == null ? null : fAirportName.trim();
    }

    public String getfAirportNamePy() {
        return fAirportNamePy;
    }

    public void setfAirportNamePy(String fAirportNamePy) {
        this.fAirportNamePy = fAirportNamePy == null ? null : fAirportNamePy.trim();
    }

    public String getfSanziCode() {
        return fSanziCode;
    }

    public void setfSanziCode(String fSanziCode) {
        this.fSanziCode = fSanziCode == null ? null : fSanziCode.trim();
    }

    public String getfSanziCityCode() {
        return fSanziCityCode;
    }

    public void setfSanziCityCode(String fSanziCityCode) {
        this.fSanziCityCode = fSanziCityCode == null ? null : fSanziCityCode.trim();
    }

    public String getfIfHot() {
        return fIfHot;
    }

    public void setfIfHot(String fIfHot) {
        this.fIfHot = fIfHot == null ? null : fIfHot.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        FAirportCity other = (FAirportCity) that;
        return (this.getfCId() == null ? other.getfCId() == null : this.getfCId().equals(other.getfCId()))
            && (this.getfNation() == null ? other.getfNation() == null : this.getfNation().equals(other.getfNation()))
            && (this.getfNationName() == null ? other.getfNationName() == null : this.getfNationName().equals(other.getfNationName()))
            && (this.getfCityName() == null ? other.getfCityName() == null : this.getfCityName().equals(other.getfCityName()))
            && (this.getfAirportName() == null ? other.getfAirportName() == null : this.getfAirportName().equals(other.getfAirportName()))
            && (this.getfAirportNamePy() == null ? other.getfAirportNamePy() == null : this.getfAirportNamePy().equals(other.getfAirportNamePy()))
            && (this.getfSanziCode() == null ? other.getfSanziCode() == null : this.getfSanziCode().equals(other.getfSanziCode()))
            && (this.getfSanziCityCode() == null ? other.getfSanziCityCode() == null : this.getfSanziCityCode().equals(other.getfSanziCityCode()))
            && (this.getfIfHot() == null ? other.getfIfHot() == null : this.getfIfHot().equals(other.getfIfHot()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfCId() == null) ? 0 : getfCId().hashCode());
        result = prime * result + ((getfNation() == null) ? 0 : getfNation().hashCode());
        result = prime * result + ((getfNationName() == null) ? 0 : getfNationName().hashCode());
        result = prime * result + ((getfCityName() == null) ? 0 : getfCityName().hashCode());
        result = prime * result + ((getfAirportName() == null) ? 0 : getfAirportName().hashCode());
        result = prime * result + ((getfAirportNamePy() == null) ? 0 : getfAirportNamePy().hashCode());
        result = prime * result + ((getfSanziCode() == null) ? 0 : getfSanziCode().hashCode());
        result = prime * result + ((getfSanziCityCode() == null) ? 0 : getfSanziCityCode().hashCode());
        result = prime * result + ((getfIfHot() == null) ? 0 : getfIfHot().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}