package com.ecms.cums.dao;

import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.model.TreamDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TreamDetailMapper {
    int countByExample(TreamDetailCriteria example);

    int deleteByExample(TreamDetailCriteria example);

    int deleteByPrimaryKey(Integer tId);

    int insert(TreamDetail record);

    int insertSelective(TreamDetail record);

    List<TreamDetail> selectByExample(TreamDetailCriteria example);

    TreamDetail selectByPrimaryKey(Integer tId);

    int updateByExampleSelective(@Param("record") TreamDetail record, @Param("example") TreamDetailCriteria example);

    int updateByExample(@Param("record") TreamDetail record, @Param("example") TreamDetailCriteria example);

    int updateByPrimaryKeySelective(TreamDetail record);

    int updateByPrimaryKey(TreamDetail record);

	void deleteTreamdetailByStartDate();

	void deleteTreamdetailByiID(Integer iId);

	void deleteTimeslot(@Param("iId") Integer iId,@Param("delstartDay") String delstartDay,@Param("delendDay") String delendDay);
}