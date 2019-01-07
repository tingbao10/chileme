package com.chilema.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chilema.api.order.IOrderService;
import com.chilema.api.shop.IShopService;
import com.chilema.api.user.IUserService;
import com.chilema.api.util.Request;
import com.chilema.util.SessionUtil;
import com.chilema.util.TimeUtils;
import com.chilema.util.UUIDUtil;
@Controller
public class OrderController {
	/**
	 * 用户下单
	 * @param httpreq
	 * @return
	 */
	@Autowired
	IOrderService iOrderService;
	
	
	@RequestMapping(value="AddOrder",method = RequestMethod.POST)
	public void userOrder(HttpServletRequest httpreq,HttpServletResponse resp){
//		String userId = httpreq.getParameter("userId");
//		String shopId = httpreq.getParameter("shopId");
		
		String OrderId = UUIDUtil.getUUID();//生成订单id
		String menuOrder = httpreq.getParameter("menuOrder");//格式  menuId:name:num:price,  menuId:name:num:price,  menuId:name:num:price, 
		Request request=new Request();
		Map<String,Object> map=SessionUtil.getUser(httpreq);
		String userId = (String) map.get("userId");
		String shopId = (String)httpreq.getSession().getAttribute("shopId");
		request.addData("userId", userId);
		request.addData("shopId", shopId);
		request.addData("orderTime", TimeUtils.getDate(TimeUtils.DEFAULT_DATE_FORMAT));
		request.addData("orderId", OrderId);
		request.addData("menuOrder", menuOrder);
		iOrderService.commitOrder(request);
		try {
			resp.getWriter().write("{'key':'1'}");
		} catch (IOException e) {
			try {
				resp.getWriter().write("{'key':'0'}");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@RequestMapping(value="Order",method = RequestMethod.GET)
	public String Order(){
		
		return "xiangqing";
		
	}
}
