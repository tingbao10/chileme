package com.chilema.entity;
/**
 * 商店菜单中间表
 * @author Administrator
 *
 */
public class ShopMenu {
    private String shopId;

    private String menuId;

    public String getshopId() {
        return shopId;
    }

    public void setshopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getmenuId() {
        return menuId;
    }

    public void setmenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}