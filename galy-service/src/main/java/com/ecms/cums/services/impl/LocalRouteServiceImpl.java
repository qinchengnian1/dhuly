package com.ecms.cums.services.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.ecms.cums.core.util.GuoLvUtils;
import com.ecms.cums.dao.CityCompMapper;
import com.ecms.cums.dao.EShopMapper;
import com.ecms.cums.dao.ProductDestLocalMapper;
import com.ecms.cums.dao.ProductDestMapper;
import com.ecms.cums.dao.ProductGuolvMapper;
import com.ecms.cums.dao.ProductInfoMapper;
import com.ecms.cums.dao.ProductMapper;
import com.ecms.cums.dao.TravelInfoMapper;
import com.ecms.cums.dao.TravelTypeMapper;
import com.ecms.cums.dao.TreamDetailMapper;
import com.ecms.cums.model.EShop;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductCriteria;
import com.ecms.cums.model.ProductDest;
import com.ecms.cums.model.ProductDestCriteria;
import com.ecms.cums.model.ProductGuolv;
import com.ecms.cums.model.ProductGuolvCriteria;
import com.ecms.cums.model.ProductInfoCriteria;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.model.TreamDetailCriteria;
import com.ecms.cums.ordervo.Message;
import com.ecms.cums.services.LocalRouteService;
@Service
public class LocalRouteServiceImpl implements LocalRouteService {
	@Resource
	private ProductMapper productMapper;
	@Resource
	private ProductDestMapper productDestMapper;
	@Resource
	private TravelInfoMapper travelInfoMapper;
	@Resource
	private CityCompMapper cityCompMapper;
	@Resource
	private ProductInfoMapper productInfoMapper;
	@Resource
	private TreamDetailMapper treamDetailMapper;
	@Resource
	private TravelTypeMapper travelTypeMapper;
	@Resource
	private ProductDestLocalMapper productDestLocalMapper;
	@Resource
	private EShopMapper eShopMapper;
	@Resource
	private ProductGuolvMapper productGuoLvMapper;


	@Override
	public Message LocalByHostIsBlack(JSONObject jsonbody) {
		Message ms = new Message();
		ms.getHeader().put("resCode", "0");
		boolean systemFlag= jsonbody.containsKey("systemFlag");
		boolean cityId =jsonbody.containsKey("cityId");
		if(systemFlag==false){
			ms.getHeader().put("resMsg","参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("systemFlag"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		if(cityId==false){
			ms.getHeader().put("resMsg", "参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("cityId"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		ms.getHeader().put("resCode", "1");
		ms.getHeader().put("resMsg", "请求成功");
		return ms;
	}

	@Override
	public List<Product> findAllLocalList(JSONObject jsonbody) {
		ProductCriteria criteria = new  ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		c.andCityIdsLike("%"+jsonbody.getString("cityId")+"%");
		c.andStatusEqualTo("1");
		c.andSystemFlagEqualTo(jsonbody.getString("systemFlag"));
		List<Product> ce=productMapper.selectByExample(criteria);
	/*	Map<String,Object> map = new HashMap<String,Object>();
		map.put("cityIds", jsonbody.getString("cityId"));
		map.put("systemFlag", jsonbody.getString("systemFlag"));*/
		return ce;
	}

	@Override
	public TravelType findTravelTypeByid(Integer tId) {
		return travelTypeMapper.selectByPrimaryKey(tId);
	}


	@Override
	public Message localByPidIsBlack(JSONObject jsonbody) {
		Message ms = new Message();
		ms.getHeader().put("resCode", "0");
		boolean pId =jsonbody.containsKey("pId");
		if(pId==false){
			ms.getHeader().put("resMsg", "参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("pId"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		ms.getHeader().put("resCode", "1");
		ms.getHeader().put("resMsg", "请求成功");
		return ms;
	}
	@Override
	public List<Product> findLocalRouteByPid(int pid) {
		ProductCriteria criteria = new  ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		//c.andStatusEqualTo("1");
		c.andPIdEqualTo(pid);
		List<Product> ce=productMapper.selectByExample(criteria);
		return ce;
	}
	@Override
	public List<ProductInfoWithBLOBs> findProductInfoByPid(Integer getpId) {
		ProductInfoCriteria criteria =new ProductInfoCriteria();
		ProductInfoCriteria.Criteria c= criteria.createCriteria();
		c.andPIdEqualTo(getpId);
		List<ProductInfoWithBLOBs> ce =productInfoMapper.selectByExampleWithBLOBs(criteria);
		return ce;
	}
	@Override
	public List<TreamDetail> findTreamDetailList(Integer getiId) {
		TreamDetailCriteria criteria = new TreamDetailCriteria();
		TreamDetailCriteria.Criteria c= criteria.createCriteria();
		c.andIIdEqualTo(getiId);
		List<TreamDetail> ce =treamDetailMapper.selectByExample(criteria);
		return ce;
	}

	@Override
	public List<Product> queryEshopList(String compId, String systemFlag) {
		ProductCriteria criteria = new  ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		c.andStatusEqualTo("1");
		c.andCompIdEqualTo(Integer.parseInt(compId));
		if(!"0".equals(systemFlag)){
			c.andSystemFlagEqualTo(systemFlag);
		}
		return productMapper.selectByExample(criteria);
	}

	@Override
	public EShop selectEshopByPrimaryId(String compId) {
		return eShopMapper.selectByPrimaryKey(Integer.parseInt(compId));
	}

	@Override
	public Message findRouteAllByTidIsBlack(JSONObject jsonbody) {
		Message ms = new Message();
		ms.getHeader().put("resCode", "0");
		boolean tId =jsonbody.containsKey("tId");
		boolean systemFlag= jsonbody.containsKey("systemFlag");
		boolean cityId =jsonbody.containsKey("cityId");
		if(tId==false){
			ms.getHeader().put("resMsg", "参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("tId"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		if(systemFlag==false){
			ms.getHeader().put("resMsg","参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("systemFlag"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		if(cityId==false){
			ms.getHeader().put("resMsg", "参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("cityId"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		ms.getHeader().put("resCode", "1");
		ms.getHeader().put("resMsg", "请求成功");
		return ms;
	}
	@Override
	public List<Product> findRouteByTid(JSONObject jsonbody) {
		ProductCriteria criteria = new  ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		c.andCityIdsLike("%"+jsonbody.getString("cityId")+"%");
		c.andStatusEqualTo("1");
		c.andSystemFlagEqualTo(jsonbody.getString("systemFlag"));
		c.andTIdEqualTo(jsonbody.getInt("tId"));
		List<Product> ce=productMapper.selectByExample(criteria);
		return ce;
	}

	@Override
	public List<ProductDest> findDestBySystemFlag(JSONObject jsonbody) {
		ProductDestCriteria criteria =new ProductDestCriteria();
		ProductDestCriteria.Criteria c= criteria.createCriteria();
		if(!jsonbody.getString("systemFlag").equals("")){
			c.andSystemFlagEqualTo(jsonbody.getString("systemFlag"));
		}
		c.andStatusEqualTo("1");
		c.andDestPIdEqualTo("0");
		c.andSystemTypeLike("%"+jsonbody.getString("systemType")+"%");
		List<ProductDest> ce=productDestMapper.selectByExample(criteria);
		return ce;
	}
	@Override
	public Message findDestBySystemFlagIsBlack(JSONObject jsonbody) {
		Message ms = new Message();
		ms.getHeader().put("resCode", "0");
		boolean systemFlag= jsonbody.containsKey("systemFlag");
		boolean systemType= jsonbody.containsKey("systemType");
		if(systemFlag==false){
			ms.getHeader().put("resMsg","参数错误请联系管理员");
			return ms;
		}
		if(systemType==false){
			ms.getHeader().put("resMsg","参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("systemType"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		ms.getHeader().put("resCode", "1");
		ms.getHeader().put("resMsg", "请求成功");
		return ms;
	}

	@Override
	public Message getAllRouteTravelAndLocalListIsBlack(JSONObject jsonbody) {
		Message ms = new Message();
		ms.getHeader().put("resCode", "0");
		boolean systemFlag= jsonbody.containsKey("systemFlag");
		boolean destId= jsonbody.containsKey("destId");
		if(systemFlag==false){
			ms.getHeader().put("resMsg","参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("systemFlag"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		if(destId==false){
			ms.getHeader().put("resMsg","参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("destId"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		ms.getHeader().put("resCode", "1");
		ms.getHeader().put("resMsg", "请求成功");
		return ms;
	}

	@Override
	public Map<String, Object> getDomesticGroupRoutes(String string) {
		return null;
	}

	@Override
	public Map<String, Object> getOutboundGroupRoutes(String string) {
		return null;
	}

	@Override
	public Map<String, Object> seachOutboundFree(String string) {
		return null;
	}

	@Override
	public Map<String, Object> seachDomesticFree(String string) {
		return null;
	}

	//	@Override
//	public Map<String, Object> getDomesticGroupRoutes(String params) {
//		return GuoLvUtils.getResultApiByParams("getDomesticGroupRoutes", params);
//	}
//	@Override
//	public Map<String, Object> getOutboundGroupRoutes(String params) {
//		return GuoLvUtils.getResultApiByParams("getOutboundGroupRoutes", params);
//	}
//	@Override
//	public Map<String, Object> seachDomesticFree(String params) {
//		// TODO Auto-generated method stub
//		return GuoLvUtils.getResultApiByParams("seachDomesticFree", params);
//	}
//	@Override
//	public Map<String, Object> seachOutboundFree(String params) {
//		return GuoLvUtils.getResultApiByParams("seachOutboundFree", params);
//	}
	@Override
	public List<ProductDest> findDestPidList(String destId,JSONObject jsonbody) {
		ProductDestCriteria criteria =new ProductDestCriteria();
		ProductDestCriteria.Criteria c= criteria.createCriteria();
		c.andDestPIdEqualTo(destId);
		c.andStatusEqualTo("1");
		c.andSystemTypeLike("%"+jsonbody.getString("systemType")+"%");
		List<ProductDest> ce=productDestMapper.selectByExample(criteria);
		return ce;
	}

	@Override
	public List<ProductGuolv> queryProductGuoLvListByParams(String systemFlag) {
		ProductGuolvCriteria criteria = new ProductGuolvCriteria();
		ProductGuolvCriteria.Criteria c = criteria.createCriteria();
		if(!"0".equals(systemFlag)){
			c.andPSystemFlagEqualTo(systemFlag);
		}
		c.andPStartDestEqualTo("北京");
		return productGuoLvMapper.selectByExample(criteria);
	}


}
