package com.ecms.cums.services;

import java.util.List;

import com.ecms.cums.model.TravelType;

public interface TravelTypeService {

	List<TravelType> queryTravelTypeList();

	TravelType selectByid(Integer gettId);

}
