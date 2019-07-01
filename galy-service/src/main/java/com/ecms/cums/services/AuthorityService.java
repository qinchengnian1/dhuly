package com.ecms.cums.services;

import java.util.List;
import java.util.Map;

import com.ecms.cums.model.Authority;
import com.ecms.cums.sysuservo.MenuChildVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface AuthorityService {

	List<Authority> queryPage(PageBounds pageBounds, Map<String, Object> searchParams);

	void addAuthority(Authority authority);

	List<Authority> selectAuthorityByKey(String menuCode, Long id);

	Authority selectAuthorityID(Integer id);

	void updateAuthority(Authority authority);

	void deleteAuthorityByid(Integer id);
	/**
	 * 获取菜单中父级的列表
	 * @return
	 */
	List<Authority> queryByParentMenucode();

	List<Authority> queryByProerties(String menuCode);

	List<MenuChildVo> getMenuChildList();

}
