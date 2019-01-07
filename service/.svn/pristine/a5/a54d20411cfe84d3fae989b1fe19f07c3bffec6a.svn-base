package com.chilema.service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chilema.api.order.IOrderService;
import com.chilema.api.util.Request;
import com.chilema.api.util.Results;
import com.chilema.dao.OrderDAO;
import com.chilema.entity.Order;

@Service
public class OrderService implements IOrderService{
	@Autowired
	private OrderDAO orderDAO;
	@Override
	public Results commitOrder(Request r) {
		Results results=new  Results();
		orderDAO.AddOrder(r.getDataAll());
		return results;

	}




	@Override
	public Results findOrder(Request r) {
		Order order = orderDAO.GetOrder(r.getDataAll());
		Results results=new  Results();
		try {
			results.setRequestObject(results);
			results.setCode(200);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}


}
