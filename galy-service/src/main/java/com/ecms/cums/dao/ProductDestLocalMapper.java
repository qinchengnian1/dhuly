package com.ecms.cums.dao;

import com.ecms.cums.model.ProductDestLocal;
import com.ecms.cums.model.ProductDestLocalCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDestLocalMapper {
    int countByExample(ProductDestLocalCriteria example);

    int deleteByExample(ProductDestLocalCriteria example);

    int deleteByPrimaryKey(Integer pDId);

    int insert(ProductDestLocal record);

    int insertSelective(ProductDestLocal record);

    List<ProductDestLocal> selectByExample(ProductDestLocalCriteria example);

    ProductDestLocal selectByPrimaryKey(Integer pDId);

    int updateByExampleSelective(@Param("record") ProductDestLocal record, @Param("example") ProductDestLocalCriteria example);

    int updateByExample(@Param("record") ProductDestLocal record, @Param("example") ProductDestLocalCriteria example);

    int updateByPrimaryKeySelective(ProductDestLocal record);

    int updateByPrimaryKey(ProductDestLocal record);
}