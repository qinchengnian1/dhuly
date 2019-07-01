package com.ecms.cums.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ecms.cums.dao.ProductDestMapper;
import com.ecms.cums.dao.ProductGuolvMapper;
import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductDestCriteria;
import com.ecms.cums.model.ProductGuolv;
import com.ecms.cums.model.ProductGuolvCriteria;
import com.ecms.cums.services.SaveGuoLvJobService;

@Service
public class SaveGuoLvJobImpl implements SaveGuoLvJobService{

	@Resource
	private ProductDestMapper productDestMapper;

	@Resource
	private ProductGuolvMapper productGuoLvMapper;

	@Override
	public List<ProductDest> queryAllDest() {
		// TODO Auto-generated method stub
		ProductDestCriteria criteria = new ProductDestCriteria();
		ProductDestCriteria.Criteria c = criteria.createCriteria();
		c.andStatusEqualTo("1");
		c.andDestPIdNotEqualTo("0");
		return productDestMapper.selectByExample(criteria);
	}

	@Override
	public void saveGuoLvProduct(ProductGuolv guolv) {
		// TODO Auto-generated method stub
		productGuoLvMapper.insert(guolv);

	}

	@Override
	public void deleteGuolvProduct() {
		// TODO Auto-generated method stub
		ProductGuolvCriteria criteria = new ProductGuolvCriteria();
		productGuoLvMapper.deleteByExample(criteria);
	}

}
