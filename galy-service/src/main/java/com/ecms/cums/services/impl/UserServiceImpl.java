package com.ecms.cums.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecms.cums.cores.MySearchFilter;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.dao.UserMapper;
import com.ecms.cums.model.User;
import com.ecms.cums.model.UserCriteria;
import com.ecms.cums.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public Integer checkUserLogin(String telephone) {
		// TODO Auto-generated method stub
		UserCriteria criteria = new UserCriteria();
		UserCriteria.Criteria c = criteria.createCriteria();
		c.andTelphoneEqualTo(telephone);
		List<User> user = userMapper.selectByExample(criteria);
		if(null!=user && user.size()>0){
			return user.get(0).getUserId();
		}
		return 0;
	}

	@Override
	public Integer checkUserLoginByOpenId(String openId) {
		UserCriteria criteria = new UserCriteria();
		UserCriteria.Criteria c = criteria.createCriteria();
		c.andOpenIdEqualTo(openId);
		List<User> user = userMapper.selectByExample(criteria);
		if(null!=user && user.size()>0){
			return user.get(0).getUserId();
		}
		return 0;
	}

	@Override
	public Integer insertUserTelephone(String telephone) {
		// TODO Auto-generated method stub
		UserCriteria criteria = new UserCriteria();
		UserCriteria.Criteria c = criteria.createCriteria();
		c.andTelphoneEqualTo(telephone);
		User user = new User();
		user.setTelphone(telephone);
		user.setCreateTime(new Date());
		user.setCreateName("门店");
		return userMapper.insert(user);
	}

	@Override
	public Integer insertUser(User user) {
		user.setCreateTime(new Date());
		user.setCreateName("门店");
		return userMapper.insert(user);
	}

	@Override
	public Boolean updateUserInfo(User user) {
		// TODO Auto-generated method stub
		User oldUser = userMapper.selectByPrimaryKey(user.getUserId());
		oldUser.setNickName(user.getNickName());
		oldUser.setUserName(user.getUserName());
		oldUser.setSex(user.getSex());
		oldUser.setCardType(user.getCardType());
		oldUser.setIdcard(user.getIdcard());
		oldUser.setEmail(user.getEmail());
		oldUser.setAddress(user.getAddress());
		oldUser.setUpdateTime(new Date());
		userMapper.updateByPrimaryKey(oldUser);
		return true;
	}

	@Override
	public User getUserInfoByPrimaryKey(Integer flag) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(flag);
	}

	@Override
	public Map<String, Object> builderInfoMap(User user) {
		Map<String, Object> map2 = new HashMap<>();
		map2.put("userId", user.getUserId());
		map2.put("nickName", user.getNickName());
		map2.put("userName", user.getUserName());
		map2.put("sex", user.getSex());
		map2.put("cardType", user.getCardType());
		map2.put("idCard", user.getIdcard());
		map2.put("email", user.getEmail());
		map2.put("address", user.getAddress());
		map2.put("openId", user.getOpenId());
		return map2;
	}

	@Override
	public List<User> queryPage(PageBounds pageBounds, Map<String, Object> searchParams) {
		Map<String, Object> params = MySearchFilter.filter(searchParams);
		return userMapper.queryPage(pageBounds,params);	}

}
