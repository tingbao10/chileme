package com.chilema.dao;

import java.util.List;
import java.util.Map;

import com.chilema.api.util.Request;
import com.chilema.api.util.Results;
import com.chilema.entity.Menu;
import com.chilema.entity.Order;
import com.chilema.entity.Shop;
import com.chilema.entity.Userinfo;

public interface BusinessDAO {

	/**
	 * 注册为商家
	 * 
	 * @param shop
	 *            商家实体
	 */
	void business(Map map);

	/**
	 * 修改商店名字
	 * 
	 * @param shopName
	 *            商店名字
	 * @return
	 */
	int updateShopName(Map map);

	/**
	 * 修改商标名字
	 * 
	 * @param shopName
	 *            商标名字
	 * @return
	 */
	int updataTrademark(Map map);

	/**
	 * 登录 根据商家
	 * 
	 * @param map
	 *            账号和密码
	 * @return
	 */
	int login(Map map);

	/**
	 * 根据ID 查询出订单
	 * 
	 * @return
	 */
	Order selectOrder(Map map);

	/**
	 * 随机查询出 商家 放入首页
	 * 
	 * @param map
	 * @return
	 */
	List<Shop> findShopssss();

	/**
	 * 根据商店ID 查询出所有的菜品
	 * 
	 * @param map
	 * @return
	 */
	List<Menu> findMenuList(Map map);
	
	
	
	/**
	 * 根据菜单 删除菜品
	 * @param r
	 * @return
	 */
	int delectMenuId(Map map);
	
	
	/**
	 * 分页:  查询出一共有多少条记录
	 * @param map
	 * @return
	 */
	int count();
	
	/**
	 *  开始分页
	 * @param map
	 * @return
	 */
	
	List<Shop> findStartPage(Map map);
	
	
	/**
	 * 商家上传订单 保存到数据库
	 * @param r
	 * @return
	 */
	int addmenu(Map map);
	
	
	/**
	 * 中间表添加数据 商家上传订单
	 * @param r
	 * @return
	 */
	int Intermediate(Map map);
	
	
	
	/**
	 * 根据用户ID 查询出商店ID
	 * @param r
	 * @return
	 */
	Shop userId(Map map);
	
	
	/**
	 * 根据商店ID 查询出此店铺所有订单
	 * @param r
	 * @return
	 */
	List<Order> findShopId(Map map);
	
	
	/**
	 * 根据用户ID 查询出此用户的基本信息   配送地址等
	 * @param r
	 * @return
	 */
	Userinfo findUserIdAjax(Map map);
	
	
	/**
	 * 修改用户订单  确认收货
	 * @param r
	 * @return
	 */
	int updateUserOrder(Map map);
	
	
	/**
	 * 修改用户订单 删除
	 * @param r
	 * @return
	 */
	int delectUserOrder(Map map);
	
	/**
	 * 根据用户ID 查询是商家还是用户
	 * @param r
	 * @return
	 */
	int findUserOrShop(Map map);

}
