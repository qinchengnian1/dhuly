package com.ecms.cums.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecms.cums.cores.MySearchFilter;
import com.ecms.cums.dao.DepartmentMapper;
import com.ecms.cums.model.Department;
import com.ecms.cums.model.DepartmentCriteria;
import com.ecms.cums.services.DepartmentService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
@Service
public class DepartmentServiceImpl  implements DepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<Department> queryPage(PageBounds pageBounds, Map<String, Object> searchParams) {
		Map<String, Object> params = MySearchFilter.filter(searchParams);
		return departmentMapper.queryPage(pageBounds,params);
	}
	
	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.insertSelective(department);
	}
	
	@Override
	public List<Department> selectDepartmentByKey(String departmentKey,Long id) {
		DepartmentCriteria criteria = new DepartmentCriteria();
		DepartmentCriteria.Criteria c=criteria.createCriteria();
		c.andDepartmentKeyEqualTo(departmentKey);
		if(id!=null){
			c.andIdNotEqualTo(id);
		}
		List<Department> list=departmentMapper.selectByExample(criteria);
		return list;
	}

	@Override
	public Department selectDepartmentID(Integer id) {
		// TODO Auto-generated method stub
		return departmentMapper.selectByPrimaryKey(id.longValue());
	}
	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.updateByPrimaryKeySelective(department);
	}
	@Override
	public Department selectDepartmentByID(Integer id) {
		// TODO Auto-generated method stub
		return departmentMapper.selectByPrimaryKey(id.longValue());
	}
	@Override
	public List<Department> selectDepartmentList(Integer id) {
		DepartmentCriteria criteria = new DepartmentCriteria();
		DepartmentCriteria.Criteria c=criteria.createCriteria();
		c.andIdEqualTo(id.longValue());
		List<Department> list=departmentMapper.selectByExample(criteria);
		return list;
	}
	@Override
	public List<Department> selectDepartmentList() {
		DepartmentCriteria criteria = new DepartmentCriteria();
		DepartmentCriteria.Criteria c=criteria.createCriteria();
		c.andStatusEqualTo("1");
		List<Department> list=departmentMapper.selectByExample(criteria);
		return list;
	}
	
	@Override
	public void deleteDepartmentByid(Integer id) {
		// departmentMapper Auto-generated method stub
		departmentMapper.deleteByPrimaryKey(id.longValue());
	}
	
}
