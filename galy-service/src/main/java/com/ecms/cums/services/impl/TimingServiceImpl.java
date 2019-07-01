package com.ecms.cums.services.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.core.util.GuoLvUtils;
import com.ecms.cums.dao.ProductDestMapper;
import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductDestCriteria;
import com.ecms.cums.services.TimingService;
@Service
public class TimingServiceImpl implements TimingService {
	
	@Autowired
	private ProductDestMapper productDestMapper;

	@Override
	public Map<String, Object> getProductDest(String string) {
		return null;
	}

	//	@Override
//	public Map<String, Object> getProductDest(String params) {
//		return GuoLvUtils.getResultApiByParams("getProductDest", params);
//	}
	@Override
	public void saveProductDest(ProductDest productDest) {
		productDestMapper.insert(productDest);
	}
	@Override
	public List<ProductDest> getProductDestOne(String dest_id) {
		ProductDestCriteria criteria = new ProductDestCriteria();
		ProductDestCriteria.Criteria c = criteria.createCriteria();
		c.andDestIdEqualTo(dest_id);
		List<ProductDest> ce = productDestMapper.selectByExample(criteria);
		return ce;
	}
	@Override
	public void deleteProductDest() {
		ProductDestCriteria criteria = new ProductDestCriteria();
		ProductDestCriteria.Criteria c = criteria.createCriteria();
		c.andStatusEqualTo("1");
		productDestMapper.deleteByExample(criteria);
	}

}
