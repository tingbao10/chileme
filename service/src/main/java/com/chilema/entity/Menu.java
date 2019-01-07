package com.chilema.entity;

import java.io.Serializable;

/**
 * 菜单
 * @author Administrator
 *
 */
public class Menu implements Serializable{
    private String menuId;

    private String name;

    private Float price;

    private String img;

    public String getmenuId() {
        return menuId;
    }

    public void setmenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}