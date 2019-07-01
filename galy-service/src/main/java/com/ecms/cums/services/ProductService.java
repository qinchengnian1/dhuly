package com.ecms.cums.services;

import java.util.List;
import java.util.Map;

import com.ecms.cums.model.CityComp;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TreamDetail;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface ProductService {

	List<Product> queryPage(PageBounds pageBounds, Map<String, Object> searchParams);

	List<CityComp> selectCityCompList(String citycompid);

	void addProduct(Product product);

	void addProductInfo(ProductInfoWithBLOBs productInfoWithBLOBs);

	List<Product>  queryProductByName(String ptNo);

	void addTreamDetail(TreamDetail treamDetail);

	List<ProductInfoWithBLOBs> queryProductByPID(String pId);

	Product selectProductByID(int parseInt);

	List<TreamDetail> selectTreamDetailByIid(Integer getiId);

	void updateProduct(Product product);

	ProductInfoWithBLOBs selectProductInfoByID(Integer iID);

	void updateProductInfo(ProductInfoWithBLOBs productInfoWithBLOBs);

	void updateTreamDetail(TreamDetail treamDetail);

	List<TreamDetail> getTreamDetail(String string,Integer iID);


	void deleteBydata(String tdId);

	List<Product> selectProductList();

	void deleteByIid(Integer iId);

	void deleteTimeslot(Integer iId, String delstartDay, String delendDay);


}
