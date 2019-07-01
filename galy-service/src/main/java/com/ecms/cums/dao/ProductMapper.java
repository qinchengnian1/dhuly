package com.ecms.cums.dao;

import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductCriteria;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductCriteria example);

    int deleteByExample(ProductCriteria example);

    int deleteByPrimaryKey(Integer pId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductCriteria example);

    Product selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductCriteria example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductCriteria example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> queryPage(PageBounds pageBounds, Map<String, Object> map);

	List<Product> findAllLocalproductList(Map<String, Object> map);




}