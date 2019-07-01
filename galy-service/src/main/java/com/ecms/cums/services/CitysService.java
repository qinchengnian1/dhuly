package com.ecms.cums.services;

import java.util.List;
import java.util.Map;

import com.ecms.cums.model.CityComp;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface CitysService {

	List<CityComp> queryPage(PageBounds pageBounds,Map<String, Object> searchParams);

	List<CityComp> selectCitysBykey(String remark,Integer cityId);

	void addCitys(CityComp cityComp);

	void updateCitys(CityComp cityComp);

	CityComp selectCitysByID(Integer parseInt);

	void deleteCitysByid(Integer parseInt);

	List<CityComp> selectCityCompList();


}
