package com.ecms.cums.model;

import java.io.Serializable;

public class ProductInfoWithBLOBs extends ProductInfo implements Serializable {
    private String ownAddMemo;

    private String featuresDescription;

    private String picPath;

    private String quoteContent;

    private String quoteNoContent;

    private String visaReq;

    private String memo;

    private String note;

    private String trvaelEdute;

    private static final long serialVersionUID = 1L;

    public String getOwnAddMemo() {
        return ownAddMemo;
    }

    public void setOwnAddMemo(String ownAddMemo) {
        this.ownAddMemo = ownAddMemo == null ? null : ownAddMemo.trim();
    }

    public String getFeaturesDescription() {
        return featuresDescription;
    }

    public void setFeaturesDescription(String featuresDescription) {
        this.featuresDescription = featuresDescription == null ? null : featuresDescription.trim();
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public String getQuoteContent() {
        return quoteContent;
    }

    public void setQuoteContent(String quoteContent) {
        this.quoteContent = quoteContent == null ? null : quoteContent.trim();
    }

    public String getQuoteNoContent() {
        return quoteNoContent;
    }

    public void setQuoteNoContent(String quoteNoContent) {
        this.quoteNoContent = quoteNoContent == null ? null : quoteNoContent.trim();
    }

    public String getVisaReq() {
        return visaReq;
    }

    public void setVisaReq(String visaReq) {
        this.visaReq = visaReq == null ? null : visaReq.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getTrvaelEdute() {
        return trvaelEdute;
    }

    public void setTrvaelEdute(String trvaelEdute) {
        this.trvaelEdute = trvaelEdute == null ? null : trvaelEdute.trim();
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
        ProductInfoWithBLOBs other = (ProductInfoWithBLOBs) that;
        return (this.getiId() == null ? other.getiId() == null : this.getiId().equals(other.getiId()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getJnyDays() == null ? other.getJnyDays() == null : this.getJnyDays().equals(other.getJnyDays()))
            && (this.getOwnFlg() == null ? other.getOwnFlg() == null : this.getOwnFlg().equals(other.getOwnFlg()))
            && (this.getIfEdute() == null ? other.getIfEdute() == null : this.getIfEdute().equals(other.getIfEdute()))
            && (this.getIfPriceStart() == null ? other.getIfPriceStart() == null : this.getIfPriceStart().equals(other.getIfPriceStart()))
            && (this.getPriceRemark() == null ? other.getPriceRemark() == null : this.getPriceRemark().equals(other.getPriceRemark()))
            && (this.getAdultPrice() == null ? other.getAdultPrice() == null : this.getAdultPrice().equals(other.getAdultPrice()))
            && (this.getChildPrice() == null ? other.getChildPrice() == null : this.getChildPrice().equals(other.getChildPrice()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreatePerson() == null ? other.getCreatePerson() == null : this.getCreatePerson().equals(other.getCreatePerson()))
            && (this.getUpdatePerson() == null ? other.getUpdatePerson() == null : this.getUpdatePerson().equals(other.getUpdatePerson()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getOwnAddMemo() == null ? other.getOwnAddMemo() == null : this.getOwnAddMemo().equals(other.getOwnAddMemo()))
            && (this.getFeaturesDescription() == null ? other.getFeaturesDescription() == null : this.getFeaturesDescription().equals(other.getFeaturesDescription()))
            && (this.getPicPath() == null ? other.getPicPath() == null : this.getPicPath().equals(other.getPicPath()))
            && (this.getQuoteContent() == null ? other.getQuoteContent() == null : this.getQuoteContent().equals(other.getQuoteContent()))
            && (this.getQuoteNoContent() == null ? other.getQuoteNoContent() == null : this.getQuoteNoContent().equals(other.getQuoteNoContent()))
            && (this.getVisaReq() == null ? other.getVisaReq() == null : this.getVisaReq().equals(other.getVisaReq()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getTrvaelEdute() == null ? other.getTrvaelEdute() == null : this.getTrvaelEdute().equals(other.getTrvaelEdute()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getiId() == null) ? 0 : getiId().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getJnyDays() == null) ? 0 : getJnyDays().hashCode());
        result = prime * result + ((getOwnFlg() == null) ? 0 : getOwnFlg().hashCode());
        result = prime * result + ((getIfEdute() == null) ? 0 : getIfEdute().hashCode());
        result = prime * result + ((getIfPriceStart() == null) ? 0 : getIfPriceStart().hashCode());
        result = prime * result + ((getPriceRemark() == null) ? 0 : getPriceRemark().hashCode());
        result = prime * result + ((getAdultPrice() == null) ? 0 : getAdultPrice().hashCode());
        result = prime * result + ((getChildPrice() == null) ? 0 : getChildPrice().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreatePerson() == null) ? 0 : getCreatePerson().hashCode());
        result = prime * result + ((getUpdatePerson() == null) ? 0 : getUpdatePerson().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getOwnAddMemo() == null) ? 0 : getOwnAddMemo().hashCode());
        result = prime * result + ((getFeaturesDescription() == null) ? 0 : getFeaturesDescription().hashCode());
        result = prime * result + ((getPicPath() == null) ? 0 : getPicPath().hashCode());
        result = prime * result + ((getQuoteContent() == null) ? 0 : getQuoteContent().hashCode());
        result = prime * result + ((getQuoteNoContent() == null) ? 0 : getQuoteNoContent().hashCode());
        result = prime * result + ((getVisaReq() == null) ? 0 : getVisaReq().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getTrvaelEdute() == null) ? 0 : getTrvaelEdute().hashCode());
        return result;
    }
}