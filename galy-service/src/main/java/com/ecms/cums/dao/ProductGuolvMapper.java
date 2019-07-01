package com.ecms.cums.dao;

import com.ecms.cums.model.ProductGuolv;
import com.ecms.cums.model.ProductGuolvCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductGuolvMapper {
    int countByExample(ProductGuolvCriteria example);

    int deleteByExample(ProductGuolvCriteria example);

    int deleteByPrimaryKey(Integer pGId);

    int insert(ProductGuolv record);

    int insertSelective(ProductGuolv record);

    List<ProductGuolv> selectByExample(ProductGuolvCriteria example);

    ProductGuolv selectByPrimaryKey(Integer pGId);

    int updateByExampleSelective(@Param("record") ProductGuolv record, @Param("example") ProductGuolvCriteria example);

    int updateByExample(@Param("record") ProductGuolv record, @Param("example") ProductGuolvCriteria example);

    int updateByPrimaryKeySelective(ProductGuolv record);

    int updateByPrimaryKey(ProductGuolv record);
}