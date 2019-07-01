package com.ecms.cums.services;

import java.util.List;
import java.util.Map;

import com.ecms.cums.model.ProductDest;

public interface TimingService {

	Map<String, Object> getProductDest(String string);

	void saveProductDest(ProductDest productDest);

	List<ProductDest> getProductDestOne(String dest_id);

	void deleteProductDest();


	
	
	

}
