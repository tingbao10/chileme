package com.chilema.entity;
/**
 * 权限分组中间表
 * @author Administrator
 *
 */
public class RoleGroup {
    private String roleId;

    private String groupId;

    public String getroleId() {
        return roleId;
    }

    public void setroleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getgroupId() {
        return groupId;
    }

    public void setgroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }
}