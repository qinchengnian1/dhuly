package com.ecms.cums.dao;

import com.ecms.cums.model.Provider;
import com.ecms.cums.model.ProviderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProviderMapper {
    int countByExample(ProviderCriteria example);

    int deleteByExample(ProviderCriteria example);

    int deleteByPrimaryKey(Integer compId);

    int insert(Provider record);

    int insertSelective(Provider record);

    List<Provider> selectByExample(ProviderCriteria example);

    Provider selectByPrimaryKey(Integer compId);

    int updateByExampleSelective(@Param("record") Provider record, @Param("example") ProviderCriteria example);

    int updateByExample(@Param("record") Provider record, @Param("example") ProviderCriteria example);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);
}