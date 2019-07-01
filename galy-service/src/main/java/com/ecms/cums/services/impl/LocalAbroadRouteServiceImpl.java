package com.ecms.cums.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.ecms.cums.dao.CityCompMapper;
import com.ecms.cums.dao.ProductDestLocalMapper;
import com.ecms.cums.dao.ProductDestMapper;
import com.ecms.cums.dao.ProductGuolvMapper;
import com.ecms.cums.dao.ProductInfoMapper;
import com.ecms.cums.dao.ProductMapper;
import com.ecms.cums.dao.TravelInfoMapper;
import com.ecms.cums.dao.TravelTypeMapper;
import com.ecms.cums.dao.TreamDetailMapper;
import com.ecms.cums.model.Product;
import com.ecms.cums.model.ProductCriteria;
import com.ecms.cums.model.ProductDestLocal;
import com.ecms.cums.model.ProductDestLocalCriteria;
import com.ecms.cums.model.ProductGuolv;
import com.ecms.cums.model.ProductGuolvCriteria;
import com.ecms.cums.model.ProductInfoCriteria;
import com.ecms.cums.model.ProductInfoWithBLOBs;
import com.ecms.cums.model.TravelType;
import com.ecms.cums.model.TreamDetail;
import com.ecms.cums.model.TreamDetailCriteria;
import com.ecms.cums.ordervo.Message;
import com.ecms.cums.services.LocalAbroadRouteService;

import net.sf.json.JSONObject;

@Service
public class LocalAbroadRouteServiceImpl  implements LocalAbroadRouteService{
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
	private ProductGuolvMapper productGuoLvMapper;

	@Override
	public Message AbroadIsBlack(JSONObject jsonbody) {
		Message ms = new Message();
		ms.getHeader().put("resCode", "0");
		boolean systemFlag= jsonbody.containsKey("systemFlag");
		boolean hotDest =jsonbody.containsKey("hotDest");
		if(systemFlag==false){
			ms.getHeader().put("resMsg","参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("systemFlag"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		if(hotDest==false){
			ms.getHeader().put("resMsg", "参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("hotDest"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		ms.getHeader().put("resCode", "1");
		ms.getHeader().put("resMsg", "请求成功");
		return ms;
	}

	@Override
	public List<ProductDestLocal> findLocalAbroadOriginList(JSONObject jsonbody) {
		ProductDestLocalCriteria criteria = new  ProductDestLocalCriteria();
		ProductDestLocalCriteria.Criteria c = criteria.createCriteria();
		c.andSystemFlagEqualTo(jsonbody.getString("systemFlag"));
		c.andHotDestEqualTo(jsonbody.getString("hotDest"));
		c.andStatusEqualTo("1");
		List<ProductDestLocal> ce=productDestLocalMapper.selectByExample(criteria);
		return ce;
	}

	@Override
	public Message AbroadAllIsBlack(JSONObject jsonbody) {
		Message ms = new Message();
		ms.getHeader().put("resCode", "0");
		boolean systemFlag= jsonbody.containsKey("systemFlag");
		if(systemFlag==false){
			ms.getHeader().put("resMsg","参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("systemFlag"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		ms.getHeader().put("resCode", "1");
		ms.getHeader().put("resMsg", "请求成功");
		return ms;
	}

	@Override
	public List<ProductDestLocal> findLocalAbroadOriginAllList(JSONObject jsonbody) {
		ProductDestLocalCriteria criteria = new  ProductDestLocalCriteria();
		ProductDestLocalCriteria.Criteria c = criteria.createCriteria();
		c.andSystemFlagEqualTo(jsonbody.getString("systemFlag"));
		c.andStatusEqualTo("1");
		c.andDestPIdLike("%DEST%");
		List<ProductDestLocal> ce=productDestLocalMapper.selectByExample(criteria);
		return ce;
	}

	@Override
	public Message AbroadByIDIsBlack(JSONObject jsonbody) {
		Message ms = new Message();
		ms.getHeader().put("resCode", "0");
		boolean cityId= jsonbody.containsKey("cityId");
		boolean destId =jsonbody.containsKey("destId");
		if(cityId==false){
			ms.getHeader().put("resMsg","参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("cityId"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		if(destId==false){
			ms.getHeader().put("resMsg", "参数错误请联系管理员");
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
	public List<Product> findLocalAbroadRouteDetailList(JSONObject jsonbody) {
		ProductCriteria criteria = new  ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		c.andDestPlaceIdEqualTo(jsonbody.getString("destId"));
		//CityComp city = cityCompMapper.selectByPrimaryKey(jsonbody.getInt("cityId"));
		c.andCityIdsLike("%"+jsonbody.getString("cityId")+"%");
		c.andStatusEqualTo("1");
		List<Product> ce=productMapper.selectByExample(criteria);
		return ce;
	}

	@Override
	public Message AbroadByHostIsBlack(JSONObject jsonbody) {
		Message ms = new Message();
		ms.getHeader().put("resCode", "0");
		boolean cityId= jsonbody.containsKey("cityId");
		//boolean agentType =jsonbody.containsKey("agentType");
		if(cityId==false){
			ms.getHeader().put("resMsg","参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("cityId"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}
		/*if(agentType==false){
			ms.getHeader().put("resMsg", "参数错误请联系管理员");
			return ms;
		}else{
			if(StringUtils.isBlank(jsonbody.getString("agentType"))){
				ms.getHeader().put("resMsg", "参数不能为空");
				return ms;
			}
		}*/
		ms.getHeader().put("resCode", "1");
		ms.getHeader().put("resMsg", "请求成功");
		return ms;
	}

	@Override
	public List<Product> findLocalAbroadList(JSONObject jsonbody) {
		ProductCriteria criteria = new  ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		c.andAgentTypeEqualTo(jsonbody.getString("agentType"));
		c.andCityIdsLike("%"+jsonbody.getString("cityId")+"%");
		c.andStatusEqualTo("1");
		c.andSystemFlagEqualTo("2");
		List<Product> ce=productMapper.selectByExample(criteria);
		return ce;
	}

	@Override
	public List<Product> findLocalAbroadAllList(JSONObject jsonbody) {
		ProductCriteria criteria = new  ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		//c.andAgentTypeEqualTo(jsonbody.getString("agentType"));
		c.andCityIdsLike("%"+jsonbody.getString("cityId")+"%");
		c.andStatusEqualTo("1");
		c.andSystemFlagEqualTo("2");
		List<Product> ce=productMapper.selectByExample(criteria);
		return ce;
	}

	@Override
	public Message AbroadByPidIsBlack(JSONObject jsonbody) {
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
	public List<Product> findRouteById(int pId) {
		ProductCriteria criteria = new  ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		//c.andStatusEqualTo("1");
		c.andPIdEqualTo(pId);
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
	public List<ProductDestLocal> findDestPidList(String destId) {
		ProductDestLocalCriteria criteria = new  ProductDestLocalCriteria();
		ProductDestLocalCriteria.Criteria c = criteria.createCriteria();
		c.andDestPIdEqualTo(destId);
		c.andStatusEqualTo("1");
		List<ProductDestLocal> ce=productDestLocalMapper.selectByExample(criteria);
		return ce;
	}



	@Override
	public TravelType findTravelTypeByid(Integer tId) {
		// TODO Auto-generated method stub
		return travelTypeMapper.selectByPrimaryKey(tId);

	}

	@Override
	public List<Product> searchProductListByParams(String routeMain) {
		// TODO Auto-generated method stub
		ProductCriteria criteria = new ProductCriteria();
		ProductCriteria.Criteria c = criteria.createCriteria();
		c.andRouteMainLike("%"+ routeMain + "%");
		c.andStatusEqualTo("1");
		return productMapper.selectByExample(criteria);
	}

	@Override
	public List<ProductGuolv> searchProductGuoLvListByParams(String routeMain) {
		// TODO Auto-generated method stub
		ProductGuolvCriteria criteria = new ProductGuolvCriteria();
		ProductGuolvCriteria.Criteria c = criteria.createCriteria();
		c.andPRouteMainLike("%"+routeMain+"%");
		c.andPStartDestEqualTo("北京");
		return productGuoLvMapper.selectByExample(criteria);
	}



}
