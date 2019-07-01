package com.ecms.cums.dao;

import com.ecms.cums.model.EShop;
import com.ecms.cums.model.EShopCriteria;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EShopMapper {
    long countByExample(EShopCriteria example);

    int deleteByExample(EShopCriteria example);

    int deleteByPrimaryKey(Integer eId);

    int insert(EShop record);

    int insertSelective(EShop record);

    List<EShop> selectByExample(EShopCriteria example);

    EShop selectByPrimaryKey(Integer eId);

    int updateByExampleSelective(@Param("record") EShop record, @Param("example") EShopCriteria example);

    int updateByExample(@Param("record") EShop record, @Param("example") EShopCriteria example);

    int updateByPrimaryKeySelective(EShop record);

    int updateByPrimaryKey(EShop record);

	List<EShop> queryPage(PageBounds pageBounds, Map<String, Object> params);
}