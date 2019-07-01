package com.ecms.cums.sysuservo;

import java.util.Date;
import java.util.List;

import com.ecms.cums.model.Department;
import com.ecms.cums.model.Role;

public class SysUserVo {
	 	private Integer id;

	    private String userCode;

	    private String userName;

	    private String sex;

	    private String status;

	    private Date createTime;
	    
	    private List<Department> departmentlist;	
	    
		private List<Role> rolelist;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUserCode() {
			return userCode;
		}
		public void setUserCode(String userCode) {
			this.userCode = userCode;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public List<Department> getDepartmentlist() {
			return departmentlist;
		}
		public void setDepartmentlist(List<Department> departmentlist) {
			this.departmentlist = departmentlist;
		}
		public List<Role> getRolelist() {
			return rolelist;
		}
		public void setRolelist(List<Role> rolelist) {
			this.rolelist = rolelist;
		}
		
}
