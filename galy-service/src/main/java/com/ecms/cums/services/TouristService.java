package com.ecms.cums.services;

import java.util.List;

import com.ecms.cums.model.Tourist;

public interface TouristService {

	Tourist selectTourist(Integer touristId);

	List<Tourist> checkTouristList(Integer userId);

	void touristSubmit(Tourist tourist);

	void updateTourist(Tourist tourist);

	Tourist delectTourist(int parseInt);


	

}
