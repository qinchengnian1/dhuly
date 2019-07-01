package com.ecms.cums.services;

import java.util.List;

import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductGuolv;

public interface SaveGuoLvJobService {

	List<ProductDest> queryAllDest();

	void saveGuoLvProduct(ProductGuolv guolv);

	void deleteGuolvProduct();
}
