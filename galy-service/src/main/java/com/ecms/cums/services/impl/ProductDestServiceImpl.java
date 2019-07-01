package com.ecms.cums.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.dao.ProductDestMapper;
import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductDestCriteria;
import com.ecms.cums.services.ProductDestService;

@Service
public class ProductDestServiceImpl implements ProductDestService{
	@Autowired
	private ProductDestMapper productDestMapper;
	
	@Override
	public List<ProductDest> queryProductDestLsit(){
		ProductDestCriteria criteria = new ProductDestCriteria();
		ProductDestCriteria.Criteria c=criteria.createCriteria();
		c.andStatusEqualTo("1");
		List<ProductDest> ce = productDestMapper.selectByExample(criteria);
		return ce;
	}
	
}
