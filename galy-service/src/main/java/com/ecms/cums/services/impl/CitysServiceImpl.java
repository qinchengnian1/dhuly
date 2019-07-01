package com.ecms.cums.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.cores.MySearchFilter;
import com.ecms.cums.dao.CityCompMapper;
import com.ecms.cums.model.CityComp;
import com.ecms.cums.model.CityCompCriteria;
import com.ecms.cums.services.CitysService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
@Service
public class CitysServiceImpl implements CitysService{
	@Autowired
	private CityCompMapper cityCompMapper;

	@Override
	public List<CityComp> queryPage(PageBounds pageBounds,
			Map<String, Object> searchParams) {
		Map<String, Object> params = MySearchFilter.filter(searchParams);
		return cityCompMapper.queryPage(pageBounds,params);
	}

	@Override
	public List<CityComp> selectCitysBykey(String remark,Integer cityId) {
		CityCompCriteria cityCompCriteria = new CityCompCriteria();
		CityCompCriteria.Criteria c= cityCompCriteria.createCriteria();
		c.andRemarkEqualTo(remark);
		if(cityId!=null){
			c.andCityIdNotEqualTo(cityId);
		}
		List<CityComp> list = cityCompMapper.selectByExample(cityCompCriteria);
		return list;
	}

	@Override
	public void addCitys(CityComp cityComp) {
		cityCompMapper.insertSelective(cityComp);
	}

	@Override
	public void updateCitys(CityComp cityComp) {
		cityCompMapper.updateByPrimaryKeySelective(cityComp);
	}

	@Override
	public CityComp selectCitysByID(Integer cityId) {
		return cityCompMapper.selectByPrimaryKey(cityId);
	}
	@Override
	public void deleteCitysByid(Integer cityId) {
		cityCompMapper.deleteByPrimaryKey(cityId);
	}
	@Override
	public List<CityComp> selectCityCompList() {
		CityCompCriteria cityCompCriteria = new CityCompCriteria();
		CityCompCriteria.Criteria c= cityCompCriteria.createCriteria();
		c.andStatusEqualTo("1");
		List<CityComp> list = cityCompMapper.selectByExample(cityCompCriteria);
		return list;
	}
}
