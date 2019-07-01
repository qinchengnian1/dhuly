package com.ecms.cums.model;

import java.io.Serializable;

public class TravelInfo implements Serializable {
    private Integer tId;

    private Integer pIId;

    private String roomType;

    private String roomTypeName;

    private String roomMemo;

    private String breakfastFlg;

    private String breakfastTypeName;

    private String breakfastType;

    private String breakfastMemo;

    private String lunchFlg;

    private String lunchTypeName;

    private String lunchType;

    private String lunchMemo;

    private String supperFlg;

    private String supperTypeName;

    private String supperType;

    private String supperMemo;

    private String pocPath;

    private String trafficNo;

    private Integer fromCityId;

    private String fromCityName;

    private String arriveCityId;

    private String arriveCityName;

    private String trafficType;

    private String cityType;

    private String airComp;

    private String airName;

    private String memo;

    private String startTime;

    private String arrivalTime;

    private String timeLength;

    private String distance;

    private String flightNum;

    private String cityNames;

    private String viewpointId;

    private String viewpointName;

    private String daodaoId;

    private String sord;

    private String fromDaodaoId;

    private String arriveDaodaoId;

    private String fromDaodaoName;

    private String arriveDaodaoName;

    private String travelContent;

    private static final long serialVersionUID = 1L;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getpIId() {
        return pIId;
    }

    public void setpIId(Integer pIId) {
        this.pIId = pIId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName == null ? null : roomTypeName.trim();
    }

    public String getRoomMemo() {
        return roomMemo;
    }

    public void setRoomMemo(String roomMemo) {
        this.roomMemo = roomMemo == null ? null : roomMemo.trim();
    }

    public String getBreakfastFlg() {
        return breakfastFlg;
    }

    public void setBreakfastFlg(String breakfastFlg) {
        this.breakfastFlg = breakfastFlg == null ? null : breakfastFlg.trim();
    }

    public String getBreakfastTypeName() {
        return breakfastTypeName;
    }

    public void setBreakfastTypeName(String breakfastTypeName) {
        this.breakfastTypeName = breakfastTypeName == null ? null : breakfastTypeName.trim();
    }

    public String getBreakfastType() {
        return breakfastType;
    }

    public void setBreakfastType(String breakfastType) {
        this.breakfastType = breakfastType == null ? null : breakfastType.trim();
    }

    public String getBreakfastMemo() {
        return breakfastMemo;
    }

    public void setBreakfastMemo(String breakfastMemo) {
        this.breakfastMemo = breakfastMemo == null ? null : breakfastMemo.trim();
    }

    public String getLunchFlg() {
        return lunchFlg;
    }

    public void setLunchFlg(String lunchFlg) {
        this.lunchFlg = lunchFlg == null ? null : lunchFlg.trim();
    }

    public String getLunchTypeName() {
        return lunchTypeName;
    }

    public void setLunchTypeName(String lunchTypeName) {
        this.lunchTypeName = lunchTypeName == null ? null : lunchTypeName.trim();
    }

    public String getLunchType() {
        return lunchType;
    }

    public void setLunchType(String lunchType) {
        this.lunchType = lunchType == null ? null : lunchType.trim();
    }

    public String getLunchMemo() {
        return lunchMemo;
    }

    public void setLunchMemo(String lunchMemo) {
        this.lunchMemo = lunchMemo == null ? null : lunchMemo.trim();
    }

    public String getSupperFlg() {
        return supperFlg;
    }

    public void setSupperFlg(String supperFlg) {
        this.supperFlg = supperFlg == null ? null : supperFlg.trim();
    }

    public String getSupperTypeName() {
        return supperTypeName;
    }

    public void setSupperTypeName(String supperTypeName) {
        this.supperTypeName = supperTypeName == null ? null : supperTypeName.trim();
    }

    public String getSupperType() {
        return supperType;
    }

    public void setSupperType(String supperType) {
        this.supperType = supperType == null ? null : supperType.trim();
    }

    public String getSupperMemo() {
        return supperMemo;
    }

    public void setSupperMemo(String supperMemo) {
        this.supperMemo = supperMemo == null ? null : supperMemo.trim();
    }

    public String getPocPath() {
        return pocPath;
    }

    public void setPocPath(String pocPath) {
        this.pocPath = pocPath == null ? null : pocPath.trim();
    }

    public String getTrafficNo() {
        return trafficNo;
    }

    public void setTrafficNo(String trafficNo) {
        this.trafficNo = trafficNo == null ? null : trafficNo.trim();
    }

    public Integer getFromCityId() {
        return fromCityId;
    }

    public void setFromCityId(Integer fromCityId) {
        this.fromCityId = fromCityId;
    }

    public String getFromCityName() {
        return fromCityName;
    }

    public void setFromCityName(String fromCityName) {
        this.fromCityName = fromCityName == null ? null : fromCityName.trim();
    }

    public String getArriveCityId() {
        return arriveCityId;
    }

    public void setArriveCityId(String arriveCityId) {
        this.arriveCityId = arriveCityId == null ? null : arriveCityId.trim();
    }

    public String getArriveCityName() {
        return arriveCityName;
    }

    public void setArriveCityName(String arriveCityName) {
        this.arriveCityName = arriveCityName == null ? null : arriveCityName.trim();
    }

    public String getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(String trafficType) {
        this.trafficType = trafficType == null ? null : trafficType.trim();
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType == null ? null : cityType.trim();
    }

    public String getAirComp() {
        return airComp;
    }

    public void setAirComp(String airComp) {
        this.airComp = airComp == null ? null : airComp.trim();
    }

    public String getAirName() {
        return airName;
    }

    public void setAirName(String airName) {
        this.airName = airName == null ? null : airName.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime == null ? null : arrivalTime.trim();
    }

    public String getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(String timeLength) {
        this.timeLength = timeLength == null ? null : timeLength.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum == null ? null : flightNum.trim();
    }

    public String getCityNames() {
        return cityNames;
    }

    public void setCityNames(String cityNames) {
        this.cityNames = cityNames == null ? null : cityNames.trim();
    }

    public String getViewpointId() {
        return viewpointId;
    }

    public void setViewpointId(String viewpointId) {
        this.viewpointId = viewpointId == null ? null : viewpointId.trim();
    }

    public String getViewpointName() {
        return viewpointName;
    }

    public void setViewpointName(String viewpointName) {
        this.viewpointName = viewpointName == null ? null : viewpointName.trim();
    }

    public String getDaodaoId() {
        return daodaoId;
    }

    public void setDaodaoId(String daodaoId) {
        this.daodaoId = daodaoId == null ? null : daodaoId.trim();
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord == null ? null : sord.trim();
    }

    public String getFromDaodaoId() {
        return fromDaodaoId;
    }

    public void setFromDaodaoId(String fromDaodaoId) {
        this.fromDaodaoId = fromDaodaoId == null ? null : fromDaodaoId.trim();
    }

    public String getArriveDaodaoId() {
        return arriveDaodaoId;
    }

    public void setArriveDaodaoId(String arriveDaodaoId) {
        this.arriveDaodaoId = arriveDaodaoId == null ? null : arriveDaodaoId.trim();
    }

    public String getFromDaodaoName() {
        return fromDaodaoName;
    }

    public void setFromDaodaoName(String fromDaodaoName) {
        this.fromDaodaoName = fromDaodaoName == null ? null : fromDaodaoName.trim();
    }

    public String getArriveDaodaoName() {
        return arriveDaodaoName;
    }

    public void setArriveDaodaoName(String arriveDaodaoName) {
        this.arriveDaodaoName = arriveDaodaoName == null ? null : arriveDaodaoName.trim();
    }

    public String getTravelContent() {
        return travelContent;
    }

    public void setTravelContent(String travelContent) {
        this.travelContent = travelContent == null ? null : travelContent.trim();
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
        TravelInfo other = (TravelInfo) that;
        return (this.gettId() == null ? other.gettId() == null : this.gettId().equals(other.gettId()))
            && (this.getpIId() == null ? other.getpIId() == null : this.getpIId().equals(other.getpIId()))
            && (this.getRoomType() == null ? other.getRoomType() == null : this.getRoomType().equals(other.getRoomType()))
            && (this.getRoomTypeName() == null ? other.getRoomTypeName() == null : this.getRoomTypeName().equals(other.getRoomTypeName()))
            && (this.getRoomMemo() == null ? other.getRoomMemo() == null : this.getRoomMemo().equals(other.getRoomMemo()))
            && (this.getBreakfastFlg() == null ? other.getBreakfastFlg() == null : this.getBreakfastFlg().equals(other.getBreakfastFlg()))
            && (this.getBreakfastTypeName() == null ? other.getBreakfastTypeName() == null : this.getBreakfastTypeName().equals(other.getBreakfastTypeName()))
            && (this.getBreakfastType() == null ? other.getBreakfastType() == null : this.getBreakfastType().equals(other.getBreakfastType()))
            && (this.getBreakfastMemo() == null ? other.getBreakfastMemo() == null : this.getBreakfastMemo().equals(other.getBreakfastMemo()))
            && (this.getLunchFlg() == null ? other.getLunchFlg() == null : this.getLunchFlg().equals(other.getLunchFlg()))
            && (this.getLunchTypeName() == null ? other.getLunchTypeName() == null : this.getLunchTypeName().equals(other.getLunchTypeName()))
            && (this.getLunchType() == null ? other.getLunchType() == null : this.getLunchType().equals(other.getLunchType()))
            && (this.getLunchMemo() == null ? other.getLunchMemo() == null : this.getLunchMemo().equals(other.getLunchMemo()))
            && (this.getSupperFlg() == null ? other.getSupperFlg() == null : this.getSupperFlg().equals(other.getSupperFlg()))
            && (this.getSupperTypeName() == null ? other.getSupperTypeName() == null : this.getSupperTypeName().equals(other.getSupperTypeName()))
            && (this.getSupperType() == null ? other.getSupperType() == null : this.getSupperType().equals(other.getSupperType()))
            && (this.getSupperMemo() == null ? other.getSupperMemo() == null : this.getSupperMemo().equals(other.getSupperMemo()))
            && (this.getPocPath() == null ? other.getPocPath() == null : this.getPocPath().equals(other.getPocPath()))
            && (this.getTrafficNo() == null ? other.getTrafficNo() == null : this.getTrafficNo().equals(other.getTrafficNo()))
            && (this.getFromCityId() == null ? other.getFromCityId() == null : this.getFromCityId().equals(other.getFromCityId()))
            && (this.getFromCityName() == null ? other.getFromCityName() == null : this.getFromCityName().equals(other.getFromCityName()))
            && (this.getArriveCityId() == null ? other.getArriveCityId() == null : this.getArriveCityId().equals(other.getArriveCityId()))
            && (this.getArriveCityName() == null ? other.getArriveCityName() == null : this.getArriveCityName().equals(other.getArriveCityName()))
            && (this.getTrafficType() == null ? other.getTrafficType() == null : this.getTrafficType().equals(other.getTrafficType()))
            && (this.getCityType() == null ? other.getCityType() == null : this.getCityType().equals(other.getCityType()))
            && (this.getAirComp() == null ? other.getAirComp() == null : this.getAirComp().equals(other.getAirComp()))
            && (this.getAirName() == null ? other.getAirName() == null : this.getAirName().equals(other.getAirName()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getArrivalTime() == null ? other.getArrivalTime() == null : this.getArrivalTime().equals(other.getArrivalTime()))
            && (this.getTimeLength() == null ? other.getTimeLength() == null : this.getTimeLength().equals(other.getTimeLength()))
            && (this.getDistance() == null ? other.getDistance() == null : this.getDistance().equals(other.getDistance()))
            && (this.getFlightNum() == null ? other.getFlightNum() == null : this.getFlightNum().equals(other.getFlightNum()))
            && (this.getCityNames() == null ? other.getCityNames() == null : this.getCityNames().equals(other.getCityNames()))
            && (this.getViewpointId() == null ? other.getViewpointId() == null : this.getViewpointId().equals(other.getViewpointId()))
            && (this.getViewpointName() == null ? other.getViewpointName() == null : this.getViewpointName().equals(other.getViewpointName()))
            && (this.getDaodaoId() == null ? other.getDaodaoId() == null : this.getDaodaoId().equals(other.getDaodaoId()))
            && (this.getSord() == null ? other.getSord() == null : this.getSord().equals(other.getSord()))
            && (this.getFromDaodaoId() == null ? other.getFromDaodaoId() == null : this.getFromDaodaoId().equals(other.getFromDaodaoId()))
            && (this.getArriveDaodaoId() == null ? other.getArriveDaodaoId() == null : this.getArriveDaodaoId().equals(other.getArriveDaodaoId()))
            && (this.getFromDaodaoName() == null ? other.getFromDaodaoName() == null : this.getFromDaodaoName().equals(other.getFromDaodaoName()))
            && (this.getArriveDaodaoName() == null ? other.getArriveDaodaoName() == null : this.getArriveDaodaoName().equals(other.getArriveDaodaoName()))
            && (this.getTravelContent() == null ? other.getTravelContent() == null : this.getTravelContent().equals(other.getTravelContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gettId() == null) ? 0 : gettId().hashCode());
        result = prime * result + ((getpIId() == null) ? 0 : getpIId().hashCode());
        result = prime * result + ((getRoomType() == null) ? 0 : getRoomType().hashCode());
        result = prime * result + ((getRoomTypeName() == null) ? 0 : getRoomTypeName().hashCode());
        result = prime * result + ((getRoomMemo() == null) ? 0 : getRoomMemo().hashCode());
        result = prime * result + ((getBreakfastFlg() == null) ? 0 : getBreakfastFlg().hashCode());
        result = prime * result + ((getBreakfastTypeName() == null) ? 0 : getBreakfastTypeName().hashCode());
        result = prime * result + ((getBreakfastType() == null) ? 0 : getBreakfastType().hashCode());
        result = prime * result + ((getBreakfastMemo() == null) ? 0 : getBreakfastMemo().hashCode());
        result = prime * result + ((getLunchFlg() == null) ? 0 : getLunchFlg().hashCode());
        result = prime * result + ((getLunchTypeName() == null) ? 0 : getLunchTypeName().hashCode());
        result = prime * result + ((getLunchType() == null) ? 0 : getLunchType().hashCode());
        result = prime * result + ((getLunchMemo() == null) ? 0 : getLunchMemo().hashCode());
        result = prime * result + ((getSupperFlg() == null) ? 0 : getSupperFlg().hashCode());
        result = prime * result + ((getSupperTypeName() == null) ? 0 : getSupperTypeName().hashCode());
        result = prime * result + ((getSupperType() == null) ? 0 : getSupperType().hashCode());
        result = prime * result + ((getSupperMemo() == null) ? 0 : getSupperMemo().hashCode());
        result = prime * result + ((getPocPath() == null) ? 0 : getPocPath().hashCode());
        result = prime * result + ((getTrafficNo() == null) ? 0 : getTrafficNo().hashCode());
        result = prime * result + ((getFromCityId() == null) ? 0 : getFromCityId().hashCode());
        result = prime * result + ((getFromCityName() == null) ? 0 : getFromCityName().hashCode());
        result = prime * result + ((getArriveCityId() == null) ? 0 : getArriveCityId().hashCode());
        result = prime * result + ((getArriveCityName() == null) ? 0 : getArriveCityName().hashCode());
        result = prime * result + ((getTrafficType() == null) ? 0 : getTrafficType().hashCode());
        result = prime * result + ((getCityType() == null) ? 0 : getCityType().hashCode());
        result = prime * result + ((getAirComp() == null) ? 0 : getAirComp().hashCode());
        result = prime * result + ((getAirName() == null) ? 0 : getAirName().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getArrivalTime() == null) ? 0 : getArrivalTime().hashCode());
        result = prime * result + ((getTimeLength() == null) ? 0 : getTimeLength().hashCode());
        result = prime * result + ((getDistance() == null) ? 0 : getDistance().hashCode());
        result = prime * result + ((getFlightNum() == null) ? 0 : getFlightNum().hashCode());
        result = prime * result + ((getCityNames() == null) ? 0 : getCityNames().hashCode());
        result = prime * result + ((getViewpointId() == null) ? 0 : getViewpointId().hashCode());
        result = prime * result + ((getViewpointName() == null) ? 0 : getViewpointName().hashCode());
        result = prime * result + ((getDaodaoId() == null) ? 0 : getDaodaoId().hashCode());
        result = prime * result + ((getSord() == null) ? 0 : getSord().hashCode());
        result = prime * result + ((getFromDaodaoId() == null) ? 0 : getFromDaodaoId().hashCode());
        result = prime * result + ((getArriveDaodaoId() == null) ? 0 : getArriveDaodaoId().hashCode());
        result = prime * result + ((getFromDaodaoName() == null) ? 0 : getFromDaodaoName().hashCode());
        result = prime * result + ((getArriveDaodaoName() == null) ? 0 : getArriveDaodaoName().hashCode());
        result = prime * result + ((getTravelContent() == null) ? 0 : getTravelContent().hashCode());
        return result;
    }
}