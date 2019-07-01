package com.ecms.cums.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Tourist implements Serializable {
    private Integer touristId;

    private Integer userId;

    private Integer orderId;

    private String touristName;

    private String touristNamePy;

    private String rouristBirthday;

    private String rouristRegPlace;

    private String touristEmail;

    private String touristNationId;

    private String sex;

    private String cardType;

    private String cardNo;

    private String telephone;

    private String pasgType;

    private String state;
  
    private Date createTime;

    private String remark;

    private Date updatTime;

    private static final long serialVersionUID = 1L;

    public Integer getTouristId() {
        return touristId;
    }

    public void setTouristId(Integer touristId) {
        this.touristId = touristId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName == null ? null : touristName.trim();
    }

    public String getTouristNamePy() {
        return touristNamePy;
    }

    public void setTouristNamePy(String touristNamePy) {
        this.touristNamePy = touristNamePy == null ? null : touristNamePy.trim();
    }

    public String getRouristBirthday() {
        return rouristBirthday;
    }

    public void setRouristBirthday(String rouristBirthday) {
        this.rouristBirthday = rouristBirthday == null ? null : rouristBirthday.trim();
    }

    public String getRouristRegPlace() {
        return rouristRegPlace;
    }

    public void setRouristRegPlace(String rouristRegPlace) {
        this.rouristRegPlace = rouristRegPlace == null ? null : rouristRegPlace.trim();
    }

    public String getTouristEmail() {
        return touristEmail;
    }

    public void setTouristEmail(String touristEmail) {
        this.touristEmail = touristEmail == null ? null : touristEmail.trim();
    }

    public String getTouristNationId() {
        return touristNationId;
    }

    public void setTouristNationId(String touristNationId) {
        this.touristNationId = touristNationId == null ? null : touristNationId.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPasgType() {
        return pasgType;
    }

    public void setPasgType(String pasgType) {
        this.pasgType = pasgType == null ? null : pasgType.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8") 
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getUpdatTime() {
        return updatTime;
    }

    public void setUpdatTime(Date updatTime) {
        this.updatTime = updatTime;
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
        Tourist other = (Tourist) that;
        return (this.getTouristId() == null ? other.getTouristId() == null : this.getTouristId().equals(other.getTouristId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getTouristName() == null ? other.getTouristName() == null : this.getTouristName().equals(other.getTouristName()))
            && (this.getTouristNamePy() == null ? other.getTouristNamePy() == null : this.getTouristNamePy().equals(other.getTouristNamePy()))
            && (this.getRouristBirthday() == null ? other.getRouristBirthday() == null : this.getRouristBirthday().equals(other.getRouristBirthday()))
            && (this.getRouristRegPlace() == null ? other.getRouristRegPlace() == null : this.getRouristRegPlace().equals(other.getRouristRegPlace()))
            && (this.getTouristEmail() == null ? other.getTouristEmail() == null : this.getTouristEmail().equals(other.getTouristEmail()))
            && (this.getTouristNationId() == null ? other.getTouristNationId() == null : this.getTouristNationId().equals(other.getTouristNationId()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getPasgType() == null ? other.getPasgType() == null : this.getPasgType().equals(other.getPasgType()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUpdatTime() == null ? other.getUpdatTime() == null : this.getUpdatTime().equals(other.getUpdatTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTouristId() == null) ? 0 : getTouristId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getTouristName() == null) ? 0 : getTouristName().hashCode());
        result = prime * result + ((getTouristNamePy() == null) ? 0 : getTouristNamePy().hashCode());
        result = prime * result + ((getRouristBirthday() == null) ? 0 : getRouristBirthday().hashCode());
        result = prime * result + ((getRouristRegPlace() == null) ? 0 : getRouristRegPlace().hashCode());
        result = prime * result + ((getTouristEmail() == null) ? 0 : getTouristEmail().hashCode());
        result = prime * result + ((getTouristNationId() == null) ? 0 : getTouristNationId().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getPasgType() == null) ? 0 : getPasgType().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUpdatTime() == null) ? 0 : getUpdatTime().hashCode());
        return result;
    }
}