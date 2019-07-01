package com.ecms.cums.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.dao.TouristMapper;
import com.ecms.cums.model.Tourist;
import com.ecms.cums.model.TouristCriteria;
import com.ecms.cums.services.TouristService;
@Service
public class TouristServiceImpl implements TouristService{
	@Autowired
	TouristMapper touristMapper;

	@Override
	public Tourist selectTourist(Integer touristId)    {
		return touristMapper.selectByPrimaryKey(touristId);
	}
	
	@Override
	public void touristSubmit(Tourist tourist) {
		// TODO Auto-generated method stub
		touristMapper.insert(tourist);
	}

	@Override
	public List<Tourist> checkTouristList(Integer userId) {
		// TODO Auto-generated method stub
		TouristCriteria criteria = new TouristCriteria();
		TouristCriteria.Criteria c = criteria.createCriteria();
		c.andStateEqualTo("1");
		c.andUserIdEqualTo(userId);
		List<Tourist> ce = touristMapper.selectByExample(criteria);
		return ce ;
	}

	@Override
	public void updateTourist(Tourist tourist) {
		touristMapper.updateByPrimaryKey(tourist);
	}
	
	@Override
	public Tourist delectTourist(int touristId) {
		touristMapper.deleteByPrimaryKey(touristId);
		return null;
	}

}
