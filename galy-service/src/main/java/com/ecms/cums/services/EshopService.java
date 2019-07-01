package com.ecms.cums.services;

import java.util.List;
import java.util.Map;

import com.ecms.cums.model.EShop;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface EshopService {

	List<EShop> queryPage(PageBounds pageBounds,Map<String, Object> searchParams);

	void addEshop(EShop eShop);

	void updateEshop(EShop eShop);

	EShop selectEShopByID(Integer eid);

	void deleteCitysByid(Integer parseInt);

}
