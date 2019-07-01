package com.ecms.cums.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.dao.TreamDetailMapper;
import com.ecms.cums.services.TreamDetailService;
@Service
public class TreamDetailServiceImpl implements TreamDetailService{
	@Autowired
	private TreamDetailMapper treamDetailMapper;
	@Override
	public void deleteTreamdetailByStartDate() {
		treamDetailMapper.deleteTreamdetailByStartDate();
	}

}
