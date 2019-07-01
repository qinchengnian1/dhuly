package com.ecms.cums.services;

import com.ecms.cums.model.SysUser;
import com.ecms.cums.model.User;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;

public interface UserService {

	/**
	 * @Title: checkUserLogin
	 * @Description: 验证用户是否登录
	 * @return
	 * @return: int
	 */
	public Integer checkUserLogin(String telephone);

	/**
	 * @Title: checkUserLogin
	 * @Description: 验证用户是否登录
	 * @return
	 * @return: int
	 */
	public Integer checkUserLoginByOpenId(String openId);

	/**
	 * @Title: insertUserTelephone
	 * @Description: 插入数据库用户手机号
	 * @param telephone
	 * @return: void
	 */
	public Integer insertUserTelephone(String telephone);

	/**
	 * @Title:
	 * @Description: 插入数据库用户
	 * @return: void
	 */
	public Integer insertUser(User uset);

	/**
	 * @Title: insertUserInfo
	 * @Description: 更新用户信息
	 * @param user
	 * @return
	 * @return: Integer
	 */
	public Boolean updateUserInfo(User user);

	public User getUserInfoByPrimaryKey(Integer flag);

	Map<String, Object> builderInfoMap(User user);

	public List<User> queryPage(PageBounds pageBounds, Map<String, Object> searchParams);

}
