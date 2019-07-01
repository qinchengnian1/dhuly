package com.ecms.cums.dao;

import com.ecms.cums.model.ProductInfo;
import com.ecms.cums.model.ProductInfoCriteria;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductInfoMapper {
    int countByExample(ProductInfoCriteria example);

    int deleteByExample(ProductInfoCriteria example);

    int deleteByPrimaryKey(Integer iId);

    int insert(ProductInfoWithBLOBs record);

    int insertSelective(ProductInfoWithBLOBs record);

    List<ProductInfoWithBLOBs> selectByExampleWithBLOBs(ProductInfoCriteria example);

    List<ProductInfo> selectByExample(ProductInfoCriteria example);

    ProductInfoWithBLOBs selectByPrimaryKey(Integer iId);

    int updateByExampleSelective(@Param("record") ProductInfoWithBLOBs record, @Param("example") ProductInfoCriteria example);

    int updateByExampleWithBLOBs(@Param("record") ProductInfoWithBLOBs record, @Param("example") ProductInfoCriteria example);

    int updateByExample(@Param("record") ProductInfo record, @Param("example") ProductInfoCriteria example);

    int updateByPrimaryKeySelective(ProductInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProductInfoWithBLOBs record);

    int updateByPrimaryKey(ProductInfo record);
}