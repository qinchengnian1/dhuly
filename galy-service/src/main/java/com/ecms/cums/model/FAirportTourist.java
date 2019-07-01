package com.ecms.cums.model;

import java.io.Serializable;

public class FAirportTourist implements Serializable {
    private Integer fTouristId;

    private Integer userId;

    private String fTouristName;

    private String fTouristNamePy;

    private String fAgeType;

    private String fTelephone;

    private String fBirthday;

    private String cardNum;

    private String cardType;

    private String sex;

    private static final long serialVersionUID = 1L;

    public Integer getfTouristId() {
        return fTouristId;
    }

    public void setfTouristId(Integer fTouristId) {
        this.fTouristId = fTouristId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getfTouristName() {
        return fTouristName;
    }

    public void setfTouristName(String fTouristName) {
        this.fTouristName = fTouristName == null ? null : fTouristName.trim();
    }

    public String getfTouristNamePy() {
        return fTouristNamePy;
    }

    public void setfTouristNamePy(String fTouristNamePy) {
        this.fTouristNamePy = fTouristNamePy == null ? null : fTouristNamePy.trim();
    }

    public String getfAgeType() {
        return fAgeType;
    }

    public void setfAgeType(String fAgeType) {
        this.fAgeType = fAgeType == null ? null : fAgeType.trim();
    }

    public String getfTelephone() {
        return fTelephone;
    }

    public void setfTelephone(String fTelephone) {
        this.fTelephone = fTelephone == null ? null : fTelephone.trim();
    }

    public String getfBirthday() {
        return fBirthday;
    }

    public void setfBirthday(String fBirthday) {
        this.fBirthday = fBirthday == null ? null : fBirthday.trim();
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
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
        FAirportTourist other = (FAirportTourist) that;
        return (this.getfTouristId() == null ? other.getfTouristId() == null : this.getfTouristId().equals(other.getfTouristId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getfTouristName() == null ? other.getfTouristName() == null : this.getfTouristName().equals(other.getfTouristName()))
            && (this.getfTouristNamePy() == null ? other.getfTouristNamePy() == null : this.getfTouristNamePy().equals(other.getfTouristNamePy()))
            && (this.getfAgeType() == null ? other.getfAgeType() == null : this.getfAgeType().equals(other.getfAgeType()))
            && (this.getfTelephone() == null ? other.getfTelephone() == null : this.getfTelephone().equals(other.getfTelephone()))
            && (this.getfBirthday() == null ? other.getfBirthday() == null : this.getfBirthday().equals(other.getfBirthday()))
            && (this.getCardNum() == null ? other.getCardNum() == null : this.getCardNum().equals(other.getCardNum()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfTouristId() == null) ? 0 : getfTouristId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getfTouristName() == null) ? 0 : getfTouristName().hashCode());
        result = prime * result + ((getfTouristNamePy() == null) ? 0 : getfTouristNamePy().hashCode());
        result = prime * result + ((getfAgeType() == null) ? 0 : getfAgeType().hashCode());
        result = prime * result + ((getfTelephone() == null) ? 0 : getfTelephone().hashCode());
        result = prime * result + ((getfBirthday() == null) ? 0 : getfBirthday().hashCode());
        result = prime * result + ((getCardNum() == null) ? 0 : getCardNum().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        return result;
    }
}