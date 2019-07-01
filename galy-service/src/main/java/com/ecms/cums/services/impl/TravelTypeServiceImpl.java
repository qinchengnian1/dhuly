package com.ecms.cums.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.dao.TravelTypeMapper;
import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TravelTypeCriteria;
import com.ecms.cums.services.TravelTypeService;
@Service
public class TravelTypeServiceImpl implements TravelTypeService {
	@Autowired
	private TravelTypeMapper travelTypeMapper;
	
	@Override
	public List<TravelType> queryTravelTypeList(){
		TravelTypeCriteria criteria = new TravelTypeCriteria();
		TravelTypeCriteria.Criteria c = criteria.createCriteria();
		c.andStatusEqualTo("1");
		List<TravelType> ce = travelTypeMapper.selectByExample(criteria);
		return ce;
	}
	@Override
	public TravelType selectByid(Integer tId) {
		// TODO Auto-generated method stub
		return travelTypeMapper.selectByPrimaryKey(tId);
	}

}
