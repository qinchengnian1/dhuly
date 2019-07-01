package com.ecms.cums.services;

import java.util.List;

import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductDestLocal;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.ordervo.Message;

import net.sf.json.JSONObject;

public interface LocalDomesticRouteService {
		/**
		 * 获取推荐国内目的地列表
		 */
		List<ProductDestLocal> findLocalDomesticOriginList(JSONObject jsonbody);
		/**
		 * 验证推荐国内目的地接口参数
		 */
		Message DomesticIsBlack(JSONObject jsonbody);
		/**
		 *验证国内所有目的地接口参数
		 */
		Message DomesticAllIsBlack(JSONObject jsonbody);
		/**
		 * 获取国内所有目的地列表
		 */
		List<ProductDestLocal> findLocalDomesticOriginAllList(JSONObject jsonbody);
		/**
		 * 验证根据目的地id（dest_id）进行查询得到所有包含这个目的地的产品列表接口参数
		 */
		Message DomesticByIDIsBlack(JSONObject jsonbody);
		
		/**
		 * 根据目的地id（dest_id）进行查询获取所有包含这个目的地的产品列表
		 */
		List<Product> findLocalDomesticRouteDetailList(JSONObject jsonbody);
		/**
		 *验证获取国内首页推荐接口参数 
		 */
		Message DomesticByHostIsBlack(JSONObject jsonbody);
		/**
		 * 获取国内首页推荐列表
		 */
		List<Product> findLocalDomesticList(JSONObject jsonbody);
		/**
		 * 验证根据产品列表的id（p_id）进行查询得到线路的详细信息
		 */
		Message DomesticByPidIsBlack(JSONObject jsonbody);
		
		List<Product>  findRouteById(Integer string);
		
		List<ProductInfoWithBLOBs> findProductInfoByPid(Integer getpId);
		
		List<TreamDetail> findTreamDetailList(Integer getiId);
		
		TravelType findTravelTypeByid(Integer gettId);
		List<ProductDestLocal> findDestPidList(String destId);
		/**
		 * 获取国内所有的数据
		 */
		List<Product> findLocalDomesticAllList(JSONObject jsonbody);
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 获取国内推荐目的地列表
	 * @param string
	 * @return
	 *//*
	List<ProductDest> findLocalDomesticOriginList(String string);
	*//**
	 * 获取国外推荐目的地列表
	 * @param string
	 * @return
	 *//*
	List<ProductDest> findLocalAbroadOriginList(String string);
	*//**
	 * 获取所有国内目的地列表
	 * @param string
	 * @return
	 *//*
	List<ProductDest> findLocalDomesticOriginAllList(String string);
	*//**
	 * 获取所有国外目的地列表
	 * @param string
	 * @return
	 *//*
	List<ProductDest> findLocalAbroadOriginAllList(String string);

	*//**
	 * 根据目的地id进行查询得到列表
	 *//*
	List<Product> findLocalDomesticRouteDetailList(String destId,String cityId);
	*//**
	 * 获取国内推荐路线列表
	 * @param string
	 * @return
	 *//*
	List<Product> findLocalDomesticList(String string);
	*//**
	 * 获取国外推荐路线列表
	 * @param string
	 * @return
	 *//*
	List<Product> findLocalAbroadList(String string);


	
	List<Product> findRouteDetail(String string);
	List<TravelInfo> findTravelInfoList(Integer getpId);
	List<TreamDetail> findTreamDetailList(Integer getiId);
	List<ProductInfo> findproductInfoList(Integer getpId);
*/


}
