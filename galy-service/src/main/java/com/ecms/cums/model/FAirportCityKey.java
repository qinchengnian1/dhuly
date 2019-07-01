package com.ecms.cums.model;

import java.io.Serializable;

public class FAirportCityKey implements Serializable {
    private Integer fCId;

    private String fNation;

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
        FAirportCityKey other = (FAirportCityKey) that;
        return (this.getfCId() == null ? other.getfCId() == null : this.getfCId().equals(other.getfCId()))
            && (this.getfNation() == null ? other.getfNation() == null : this.getfNation().equals(other.getfNation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfCId() == null) ? 0 : getfCId().hashCode());
        result = prime * result + ((getfNation() == null) ? 0 : getfNation().hashCode());
        return result;
    }
}