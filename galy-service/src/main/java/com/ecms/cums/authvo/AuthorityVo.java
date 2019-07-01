package com.ecms.cums.authvo;

import java.util.Date;
import java.util.List;

import com.ecms.cums.model.Authority;

public class AuthorityVo {
	 	private Long id;

	    private String dataUrl;

	    private String menuClass;

	    private String menuCode;

	    private String menuName;

	    private String parentMenucode;

	    private Long sequence;

	    private Date createTime;

	    private Date updateTime;

	    private String createPerson;

	    private String updatePerson;

	    private String status;
	    
	    private List<Authority>  authorityEntity;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDataUrl() {
			return dataUrl;
		}

		public void setDataUrl(String dataUrl) {
			this.dataUrl = dataUrl;
		}

		public String getMenuClass() {
			return menuClass;
		}

		public void setMenuClass(String menuClass) {
			this.menuClass = menuClass;
		}

		public String getMenuCode() {
			return menuCode;
		}

		public void setMenuCode(String menuCode) {
			this.menuCode = menuCode;
		}

		public String getMenuName() {
			return menuName;
		}

		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}

		public String getParentMenucode() {
			return parentMenucode;
		}

		public void setParentMenucode(String parentMenucode) {
			this.parentMenucode = parentMenucode;
		}

		public Long getSequence() {
			return sequence;
		}

		public void setSequence(Long sequence) {
			this.sequence = sequence;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public Date getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}

		public String getCreatePerson() {
			return createPerson;
		}

		public void setCreatePerson(String createPerson) {
			this.createPerson = createPerson;
		}

		public String getUpdatePerson() {
			return updatePerson;
		}

		public void setUpdatePerson(String updatePerson) {
			this.updatePerson = updatePerson;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<Authority> getAuthorityEntity() {
			return authorityEntity;
		}

		public void setAuthorityEntity(List<Authority> authorityEntity) {
			this.authorityEntity = authorityEntity;
		}


}
