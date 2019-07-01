package com.ecms.cums.services;

import java.util.List;

import net.sf.json.JSONObject;

import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductDestLocal;
import com.ecms.cums.model.ProductGuolv;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.ordervo.Message;

public interface LocalAbroadRouteService {
	/**
	 *验证获取推荐国外目的地列表接口参数
	 */
	Message AbroadIsBlack(JSONObject jsonbody);

	/**
	 * 获取推荐国外目的地列表
	 */
	List<ProductDestLocal> findLocalAbroadOriginList(JSONObject jsonbody);
	/**
	 * 验证获取国外所有目的地列表接口参数
	 */
	Message AbroadAllIsBlack(JSONObject jsonbody);
	/**
	 * 获取国外所有目的地列表s
	 */
	List<ProductDestLocal> findLocalAbroadOriginAllList(JSONObject jsonbody);
	/**
	 * 验证根据目的地id（dest_id）进行查询得到所有包含这个目的地的产品列表参数
	 * @param jsonbody
	 * @return
	 */
	Message AbroadByIDIsBlack(JSONObject jsonbody);
	/**
	 * 根据目的地id（dest_id）进行查询得到所有包含这个目的地的产品列表
	 * @param jsonbody
	 * @return
	 */
	List<Product> findLocalAbroadRouteDetailList(JSONObject jsonbody);
	/**
	 * 验证获取国内首页推荐列表接口参数
	 * @param jsonbody
	 * @return
	 */
	Message AbroadByHostIsBlack(JSONObject jsonbody);
	/**
	 * 获取国内首页推荐列表
	 * @param jsonbody
	 * @return
	 */
	List<Product> findLocalAbroadList(JSONObject jsonbody);

	Message AbroadByPidIsBlack(JSONObject jsonbody);

	List<Product> findRouteById(int int1);

	List<ProductInfoWithBLOBs> findProductInfoByPid(Integer getpId);

	List<TreamDetail> findTreamDetailList(Integer getiId);

	TravelType findTravelTypeByid(Integer gettId);

	List<ProductDestLocal> findDestPidList(String destId);
	/**
	 * @Title: searchProductListByParams
	 * @Description: 根据请求线路名称查询产品信息
	 * @param routeMain
	 * @return
	 * @return: List<Product>
	 */
	List<Product> searchProductListByParams(String routeMain);
	/**
	 * 获取国内所有数据
	 * @param jsonbody
	 * @return
	 */
	List<Product> findLocalAbroadAllList(JSONObject jsonbody);

	List<ProductGuolv> searchProductGuoLvListByParams(String routeMain);


}
