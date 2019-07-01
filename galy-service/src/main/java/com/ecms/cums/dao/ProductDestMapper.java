package com.ecms.cums.dao;

import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductDestCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDestMapper {
    long countByExample(ProductDestCriteria example);

    int deleteByExample(ProductDestCriteria example);

    int deleteByPrimaryKey(Integer pDId);

    int insert(ProductDest record);

    int insertSelective(ProductDest record);

    List<ProductDest> selectByExample(ProductDestCriteria example);

    ProductDest selectByPrimaryKey(Integer pDId);

    int updateByExampleSelective(@Param("record") ProductDest record, @Param("example") ProductDestCriteria example);

    int updateByExample(@Param("record") ProductDest record, @Param("example") ProductDestCriteria example);

    int updateByPrimaryKeySelective(ProductDest record);

    int updateByPrimaryKey(ProductDest record);
}