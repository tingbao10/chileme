package com.chilema.service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chilema.api.shop.IShopService;
import com.chilema.api.util.Request;
import com.chilema.api.util.Results;
import com.chilema.dao.BusinessDAO;
import com.chilema.dao.UserDAO;
import com.chilema.entity.Menu;
import com.chilema.entity.Order;
import com.chilema.entity.Shop;
import com.chilema.entity.Userinfo;

@Service
public class ShopService implements IShopService{
	@Autowired
	private BusinessDAO businessDAO;
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Results findShop(Request r) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Results updataTrademark(Request r) {
		int i= businessDAO.updataTrademark(r.getDataAll());
		Results results=new Results();
		results.setCode(200);
		results.addData("updata", i);
		return results;
	}

	@Override
	public Results updateShopName(Request r) {
		int i= businessDAO.updateShopName(r.getDataAll());
		Results results=new Results();
		results.setCode(200);
		results.addData("updata", i);
		return results;
	}

	@Override
	public Results selectOrder(Request r) {
		Order order= businessDAO.selectOrder(r.getDataAll());
		Results results=new Results();
		results.setCode(200);
		try {
			results.getRequestObject(order.getClass());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
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

	@Override
	public Results shopIdselect(Request r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results TopMenu(Request r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results findMenu(Request r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results updataMenu(Request r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results findShops(Request r) {
		// TODO Auto-generated method stub
		List<Shop> shopssss = businessDAO.findShopssss();
		Results results=new Results();
		if(shopssss!=null){
				try {
					results.addList("list",shopssss);
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
		}
		return results;
	}

	@Override
	public Results findMenuList(Request r) {
		List<Menu> MenuList  = businessDAO.findMenuList(r.getDataAll());
		Results results=new Results();
		if(MenuList!=null){
			try {
				results.addList("list", MenuList);
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
		}
		return results;
	}

	@Override
	public Results delectMenuId(Request r) {
		int num = businessDAO.delectMenuId(r.getDataAll());
		Results results=new Results();
		if(num>0){
			results.addData("code", "200");
		}else{
			results.addData("code", "-1");
			results.addData("erro", "订单删除错误");
		}
		return results;
	}

	@Override
	public Results count(Request r) {
		int num = businessDAO.count();
		Results results=new Results();
		results.addData("count", num);
		return results;
	}

	@Override
	public Results findStartPage(Request r) {
		List<Shop> list = businessDAO.findStartPage(r.getDataAll());
		Results results=new Results();
		try {
			results.addList("list", list);
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

	@Override
	public Results userToShop(Request r) {
		r.addData("groupId", "2");
		userDAO.updataUserGroup(r.getDataAll());
		businessDAO.business(r.getDataAll());
		Results results=new Results();
		results.setCode(200);
		return results;
	}


	@Override
	public Results addmenu(Request r) {
		int num = businessDAO.addmenu(r.getDataAll());
		Results results=new Results();
		results.addData("num", num);
		return results;
	}


	@Override
	public Results Intermediate(Request r) {
		int num = businessDAO.Intermediate(r.getDataAll());
		Results results=new Results();
		results.addData("num", num);
		return results;
	}


	@Override
	public Results userId(Request r) {
		Shop num = businessDAO.userId(r.getDataAll());
		Results results=new Results();
		try {
			results.setRequestObject(num);
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


	@Override
	public Results findShopId(Request r) {
		List<Order> list = businessDAO.findShopId(r.getDataAll());
		Results results=new Results();
			try {
				results.addList("list", list);
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


	@Override
	public Results findUserIdAjax(Request r) {
		Userinfo userinfo = businessDAO.findUserIdAjax(r.getDataAll());
		Results results=new Results();
		results.addData("num", userinfo);
		return results;
	}


	@Override
	public Results updateUserOrder(Request r) {
		int num = businessDAO.updateUserOrder(r.getDataAll());
		Results results=new Results();
		results.addData("num", num);
		return results;
	}


	@Override
	public Results delectUserOrder(Request r) {
		int num = businessDAO.delectUserOrder(r.getDataAll());
		Results results=new Results();
		results.addData("num", num);
		return results;
	}


	@Override
	public Results findUserOrShop(Request r) {
		int  num  = businessDAO.findUserOrShop(r.getDataAll());
		Results results=new Results();
		results.addData("num", num);
		return results;
	}


	
	/*@Override
	public Results ListOrder(Request r) {
		List<Order> lsit = businessDAO.ListOrder(r.getDataAll());
		Map map = new HashMap();
		map.put("list", lsit);
		
		Results results=new Results();
		results.setCode(200);
		try {
			results.getRequestObject(map.getClass());
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException
				| IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
*/
}
