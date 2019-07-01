package com.ecms.cums.model;

import java.io.Serializable;

public class SysUserRoleKey implements Serializable {
    private Long sysuserId;

    private Long roleId;

    private static final long serialVersionUID = 1L;

    public Long getSysuserId() {
        return sysuserId;
    }

    public void setSysuserId(Long sysuserId) {
        this.sysuserId = sysuserId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysUserRoleKey other = (SysUserRoleKey) that;
        return (this.getSysuserId() == null ? other.getSysuserId() == null : this.getSysuserId().equals(other.getSysuserId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSysuserId() == null) ? 0 : getSysuserId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        return result;
    }
}