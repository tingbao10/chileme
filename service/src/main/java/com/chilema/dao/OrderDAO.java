package com.chilema.dao;

import java.util.Map;

import com.chilema.entity.Order;

public interface OrderDAO {
	/**
	 * 新增订单
	 * @param map
	 */
	void AddOrder(Map map);
	/**
	 * 查询订单
	 * @param map
	 * @return
	 */
	Order GetOrder(Map map);
}
