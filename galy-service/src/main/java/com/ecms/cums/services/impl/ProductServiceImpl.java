package com.ecms.cums.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.cores.MySearchFilter;
import com.ecms.cums.dao.CityCompMapper;
import com.ecms.cums.dao.EShopMapper;
import com.ecms.cums.dao.ProductInfoMapper;
import com.ecms.cums.dao.ProductMapper;
import com.ecms.cums.dao.TreamDetailMapper;
import com.ecms.cums.model.CityComp;
import com.ecms.cums.model.CityCompCriteria;
import com.ecms.cums.model.EShopCriteria;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductCriteria;
import com.ecms.cums.model.ProductInfoCriteria;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.model.TreamDetailCriteria;
import com.ecms.cums.services.ProductService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private CityCompMapper cityCompMapper;

	@Autowired
	private EShopMapper eShopMapper;
	@Autowired
	private ProductInfoMapper productInfoMapper;
	@Autowired
	private TreamDetailMapper treamDetailMapper;

	@Override
	public List<Product> queryPage(PageBounds pageBounds,Map<String, Object> searchParams) {
		// TODO Auto-generated method stub
		Map<String, Object> params = MySearchFilter.filter(searchParams);
		return productMapper.queryPage(pageBounds,params);
	}

	@Override
	public List<CityComp> selectCityCompList(String citycompid) {
		// TODO Auto-generated method stub
		CityCompCriteria criteria = new CityCompCriteria();
		CityCompCriteria.Criteria c = criteria.createCriteria();
		c.andStatusEqualTo("1");
		c.andCityIdEqualTo(Integer.parseInt(citycompid));
		List<CityComp> city = cityCompMapper.selectByExample(criteria);
		for(CityComp co:city){
			EShopCriteria eShopCriteria = new EShopCriteria();
			EShopCriteria.Criteria eShopC = eShopCriteria.createCriteria();
			eShopC.andStatusEqualTo("1");
			eShopC.andCityIdEqualTo(Integer.parseInt(citycompid));
			co.seteShop(eShopMapper.selectByExample(eShopCriteria));
		}
		return city;
	}
	@Override
	public void addProduct(Product product) {
		productMapper.insertSelective(product);

	}

	@Override
	public void addProductInfo(ProductInfoWithBLOBs productInfoWithBLOBs) {
		productInfoMapper.insert(productInfoWithBLOBs);

	}
	@Override
	public List<Product>  queryProductByName(String ptNo) {
		ProductCriteria criteria = new ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		c.andPtNoEqualTo(ptNo);
		List<Product> list = productMapper.selectByExample(criteria);
		return list;
	}
	@Override
	public void addTreamDetail(TreamDetail treamDetail) {
		treamDetailMapper.insert(treamDetail);
	}

	@Override
	public List<ProductInfoWithBLOBs> queryProductByPID(String pId) {
		ProductInfoCriteria criteria = new ProductInfoCriteria();
		ProductInfoCriteria.Criteria c = criteria.createCriteria();
		c.andPIdEqualTo(Integer.parseInt(pId));
		List<ProductInfoWithBLOBs> list = productInfoMapper.selectByExampleWithBLOBs(criteria);
		return list;
	}
	@Override
	public Product selectProductByID(int id) {
		return productMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<TreamDetail> selectTreamDetailByIid(Integer getiId) {
		TreamDetailCriteria criteria = new TreamDetailCriteria();
		TreamDetailCriteria.Criteria c= criteria.createCriteria();
		c.andIIdEqualTo(getiId);
		List<TreamDetail> list = treamDetailMapper.selectByExample(criteria);
		return list;
	}

	@Override
	public void updateProduct(Product product) {
		productMapper.updateByPrimaryKey(product);
	}
	@Override
	public ProductInfoWithBLOBs selectProductInfoByID(Integer iID) {
		return productInfoMapper.selectByPrimaryKey(iID);
	}
	@Override
	public void updateProductInfo(ProductInfoWithBLOBs productInfoWithBLOBs) {
		productInfoMapper.updateByPrimaryKeySelective(productInfoWithBLOBs);
	}

	@Override
	public void updateTreamDetail(TreamDetail treamDetail) {
		treamDetailMapper.updateByPrimaryKeySelective(treamDetail);

	}
	@Override
	public List<TreamDetail> getTreamDetail(String data,Integer iID) {
		TreamDetailCriteria criteria = new TreamDetailCriteria();
		TreamDetailCriteria.Criteria c= criteria.createCriteria();
		c.andStartDateEqualTo(data);
		c.andIIdEqualTo(iID);
		List<TreamDetail> list = treamDetailMapper.selectByExample(criteria);
		return list;
	}

	@Override
	public void deleteBydata(String tdId) {
		treamDetailMapper.deleteByPrimaryKey(Integer.parseInt(tdId));

	}

	@Override
	public List<Product> selectProductList() {
		ProductCriteria criteria = new ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		c.andStatusEqualTo("1");
		List<Product> list = productMapper.selectByExample(criteria);
		return list;
	}

	@Override
	public void deleteByIid(Integer iId) {
		treamDetailMapper.deleteTreamdetailByiID(iId);
	}

	@Override
	public void deleteTimeslot(Integer iId, String delstartDay, String delendDay) {
		treamDetailMapper.deleteTimeslot(iId,delstartDay,delendDay);
	}
}
