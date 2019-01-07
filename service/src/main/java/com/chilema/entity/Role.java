package com.chilema.entity;
/**
 * 权限
 * @author Administrator
 *
 */
public class Role {
    private String roleId;

    private String role;

    private String effect;

    private String category;

    public String getroleId() {
        return roleId;
    }

    public void setroleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect == null ? null : effect.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}