package com.ecms.cums.services;

import java.util.List;
import java.util.Map;

import com.ecms.cums.model.Department;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface DepartmentService  {

	List<Department> queryPage(PageBounds pageBounds, Map<String, Object> searchParams);

	void addDepartment(Department department);

	Department selectDepartmentID(Integer parseInt);

	void updateDepartment(Department department);

	List<Department> selectDepartmentByKey(String departmentKey, Long id);

	Department selectDepartmentByID(Integer parseInt);
	
	List<Department> selectDepartmentList(Integer id);

	List<Department> selectDepartmentList();

	void deleteDepartmentByid(Integer id);


}
