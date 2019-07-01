package com.ecms.cums.dao;

import com.ecms.cums.model.fAirportCoupon;
import com.ecms.cums.model.fAirportCouponCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface fAirportCouponMapper {
    int countByExample(fAirportCouponCriteria example);

    int deleteByExample(fAirportCouponCriteria example);

    int deleteByPrimaryKey(Integer fCardId);

    int insert(fAirportCoupon record);

    int insertSelective(fAirportCoupon record);

    List<fAirportCoupon> selectByExample(fAirportCouponCriteria example);

    fAirportCoupon selectByPrimaryKey(Integer fCardId);

    int updateByExampleSelective(@Param("record") fAirportCoupon record, @Param("example") fAirportCouponCriteria example);

    int updateByExample(@Param("record") fAirportCoupon record, @Param("example") fAirportCouponCriteria example);

    int updateByPrimaryKeySelective(fAirportCoupon record);

    int updateByPrimaryKey(fAirportCoupon record);
}