package com.ecms.cums.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.cores.MySearchFilter;
import com.ecms.cums.dao.EShopMapper;
import com.ecms.cums.model.EShop;
import com.ecms.cums.services.EshopService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
@Service
public class EshopServiceImpl implements EshopService{
		@Autowired
		private EShopMapper eShopMapper;
		@Override
		public List<EShop> queryPage(PageBounds pageBounds,Map<String, Object> searchParams) {
			Map<String, Object> params = MySearchFilter.filter(searchParams);
			return eShopMapper.queryPage(pageBounds,params);
		}

		@Override
		public void addEshop(EShop eShop) {
			eShopMapper.insertSelective(eShop);
		}

		@Override
		public void updateEshop(EShop eShop) {
			eShopMapper.updateByPrimaryKeySelective(eShop);
		}

		@Override
		public EShop selectEShopByID(Integer eid) {
		return eShopMapper.selectByPrimaryKey(eid);
		}

		@Override
		public void deleteCitysByid(Integer eId) {
			eShopMapper.deleteByPrimaryKey(eId);
		}
}
