package com.chilema.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chilema.api.shop.IShopService;
import com.chilema.api.user.IUserService;
import com.chilema.api.util.Request;
import com.chilema.api.util.Results;
import com.chilema.api.verificationCode.IVerificationCodeService;
import com.chilema.util.FTPUtil;
import com.chilema.util.ImgUtil;
import com.chilema.util.SessionUtil;
import com.chilema.util.TimeUtils;
import com.chilema.util.UUIDUtil;
import com.google.gson.Gson;

@Controller
public class BusinessController {

	public static final int totalPage = 20;// 分页 每页显示20个商品 写死

	@Autowired
	IShopService iShopService;
	/**
	 * 主页. 所有商家
	 * 
	 * @return
	 */
	@RequestMapping(value = "xiangqing", method = RequestMethod.GET)
	public String userLogin(HttpServletRequest req, HttpServletResponse resp, String shopId) {
		// shopId="003ebc8226e8444dbc992d39b62172aa";//测试写死
		Request request = new Request();
		Map map = new HashMap();
		map.put("shopId", shopId);
		request.addDataMap(map);
		Results findMenuList = iShopService.findMenuList(request);
		req.setAttribute("findMenuList", findMenuList.getData("list"));
		req.getSession().setAttribute("shopId", shopId);
		return "xiangqing";
	}

	/**
	 * 主页 test 分页
	 * 
	 * @throws IOException
	 */

	@RequestMapping(value = "startPage", method = RequestMethod.POST)
	public @ResponseBody void startPage(HttpServletRequest req, HttpServletResponse resp, int page) throws IOException {

		/*		Request r = new Request();
		Map map2 = new HashMap();
		r.addDataMap(map2);
		Results coun = iShopService.count(r);
		int num = (Integer) coun.getData("count");// 一共多少页
		 */		
		if (page < 0) {// 每页的页面 写死 默认第一页
			page = 1;
		} else {
			page = page + 1 + totalPage;
		}
		req.getSession().setAttribute("page", page);
		Request request = new Request();
		Map map = new HashMap();
		map.put("currentPage", page);// 当前
		map.put("totalPage", totalPage);// 每页显示的数量
		request.addDataMap(map);
		Results findStartPage = iShopService.findStartPage(request);
		findStartPage.addData("yeshu", page);
		resp.setCharacterEncoding("UTF-8");
		try {
			req.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			/* out.write(findStartPage.toJson()); */
			Gson gs = new Gson();
			String te = gs.toJson(findStartPage);
			out.write(te);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 商家确认发货
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateUserOrder", method = RequestMethod.GET)
	public String updateUserOrder(HttpServletRequest req, HttpServletResponse resp, String orderId) {
		Request request = new Request();
		Map map = new HashMap();
		map.put("orderId", orderId);// 当前
		map.put("overTime", TimeUtils.getCurrentTimeInString());
		request.addDataMap(map);
		iShopService.updateUserOrder(request);

		return "redirect:ShopPersonal";
	}

	/**
	 * 商家确认取消订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "delectUserOrder", method = RequestMethod.GET)
	public String delectUserOrder(HttpServletRequest req, HttpServletResponse resp, String orderId) {
		Request request = new Request();
		Map map = new HashMap();
		map.put("orderId", orderId);// 当前
		request.addDataMap(map);
		iShopService.delectUserOrder(request);

		return "redirect:ShopPersonal";
	}





	/**
	 * 主页. 所有商家
	 * 
	 * @return
	 */
	@RequestMapping(value = "top", method = RequestMethod.GET)
	public String top(HttpServletRequest req, HttpServletResponse resp, String shopId) {

		return "top";
	}

	/**
	 * 商家上传菜品
	 * 
	 * @param req
	 * @param resp
	 * @param page
	 * @throws IOException
	 */
	@RequestMapping(value = "shoptop", method = RequestMethod.POST)
	public @ResponseBody void shoptop(@RequestParam("files") MultipartFile[] files, HttpServletRequest request,HttpServletResponse resp, String biaoti,
			String miaoshu) {
		System.out.println("用户输入的标题为:" + biaoti + miaoshu);
		saveImgs(files, request, resp);

	}


	/**
	 * 上传之后 回显示图片
	 * 
	 * @return
	 */
	@RequestMapping(value = "Echo", method = RequestMethod.GET)
	public void huixian(HttpServletRequest req, HttpServletResponse resp, String imgName) {
		InputStream in=null;
		try {
			in=FTPUtil.downloadFtpFile(imgName);
			int len=-1;
			byte[] b=new byte[1024];
			OutputStream out= resp.getOutputStream();
			while((len=in.read(b))!=-1){
				out.write(b,0,len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	@RequestMapping(value = "userToShop", method = RequestMethod.GET)
	public String upload(HttpServletRequest req, HttpServletResponse resp, String shopId) {
		return "upload";
	}

	@RequestMapping(value = "shopUp", method = RequestMethod.GET)
	public String shopUp(HttpServletRequest req, HttpServletResponse resp) {
		return "shopUp";
	}

	@RequestMapping(value = "ShopPersonal", method = RequestMethod.GET)
	public String ShopPersonal(HttpServletRequest req, HttpServletResponse resp) {
		Map map =SessionUtil.getUser(req);//拿到登录用户的ID
		/********************根据登录ID查询出商家ID****************************/
		Request getshopId = new Request();
		Map shopMap = new HashMap();
		shopMap.put("userId", map.get("userId"));
		getshopId.addDataMap(shopMap);
		Results sb = iShopService.userId(getshopId);
		/********************根据登录ID查询出商家ID****************************/
		Request reqsb = new Request();
		Map orderuMap = new HashMap();
		orderuMap.put("shopId", sb.getData("shopId"));//根据商家ID 查询出所有订单
		reqsb.addDataMap(orderuMap);
		Results findShopId = iShopService.findShopId(reqsb);
		List<Map<String,Object>> list=(List<Map<String, Object>>) findShopId.getData("list");


		List<Map<String,Object>> ll=new ArrayList<Map<String,Object>>(); 
		for(Map <String,Object> p: list){
			String s= (String) p.get("menuorder");
			String [] ss=s.split(",");
			for (int i = 0; i < ss.length; i++) {
				Map<String,Object> m=new HashMap<String,Object>();
				String[] tt= ss[i].split(":");
				m.put("name", tt[1]);
				m.put("num", tt[2]);
				m.put("price", tt[3]);
				ll.add(m);
			}
			req.setAttribute("listaksdhjasd", ll);


		}//拿到所有订单	

		/*		Map echoOrder = (Map) findShopId.getData("list");
		System.out.println(echoOrder.get("menuOrder"));*/

		req.setAttribute("Order", findShopId.getData("list"));

		return "ShopPersonal";
	}

	/**
	 *  使用ajax 根据用户ID 查询出用户基本信息 ==== 配送地址等....
	 * @param req
	 * @param resp
	 * @param value
	 * @throws IOException 
	 */
	@RequestMapping(value="userId",method=RequestMethod.POST)
	public void userIdAjax (HttpServletRequest req, HttpServletResponse resp,String value) throws IOException{

		System.out.println(value);
		//userId
		Request findUserIdAjax = new Request();
		Map map = new HashMap();
		map.put("userId", value);
		findUserIdAjax.addDataMap(map);
		Results findUserIdAjax2 = iShopService.findUserIdAjax(findUserIdAjax);
		//开始使用ajax
		resp.setCharacterEncoding("UTF-8");
		PrintWriter output = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		try {
			req.setCharacterEncoding("UTF-8");
			Gson gs = new Gson();
			System.out.println(gs.toJson(findUserIdAjax2));
			output.write(gs.toJson(findUserIdAjax2));

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 	商家上传菜品
	 * @param req
	 * @param resp
	 * @param shopName
	 * @param shopPice
	 */
	@RequestMapping(value="shopUpAJAX",method=RequestMethod.POST)
	public void shopUpAjax(@RequestParam("files") MultipartFile[] files,HttpServletRequest req, HttpServletResponse resp,String shopName , String shopPice){
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				System.out.println("正在调用保存方法");
				if (!file.isEmpty()) {
					try {
						String fileName=file.getOriginalFilename();
						FTPUtil.uploadFile(fileName,file.getInputStream());
						Map<String, Object> map =SessionUtil.getUser(req);
						Request request = new Request();
						String shopId=UUIDUtil.getUUID();
						float f=Float.parseFloat(shopPice);
						float jg = Math.round(f);
						request.addData("menuId",shopId);//菜单ID
						request.addData("name",shopName);//菜品名字
						request.addData("price",jg);//价格
						request.addData("img", fileName);//图片
						iShopService.addmenu(request);
						Request getshopId = new Request();
						Map shopMap = new HashMap();
						shopMap.put("userId", map.get("userId"));
						getshopId.addDataMap(shopMap);
						Results sb = iShopService.userId(getshopId);
						Map datamap = (Map) sb.getData("num");
						System.out.println("商店ID = "+ datamap.get("shopId"));
						//上传成功之后 中间表添加数据
						Request reqsbb = new Request();
						Map m= new HashMap();
						m.put("shopId", datamap.get("shopId"));//商店ID
						m.put("menuId", shopId);//菜单ID
						reqsbb.addDataMap(m);
						iShopService.Intermediate(reqsbb);
						resp.setCharacterEncoding("UTF-8");
						PrintWriter output = resp.getWriter();
						/* out.write(findStartPage.toJson()); */
						String imgpath="/Echo?imgName="+file.getOriginalFilename();
						resp.setCharacterEncoding("UTF-8");
						try {
							req.setCharacterEncoding("UTF-8");
							output.write(imgpath);
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}



	}




	/**
	 * 用户成为商家
	 * @param files
	 * @param request
	 * @param resp
	 * @param shopName
	 */
	@RequestMapping(value="userToShop",method=RequestMethod.POST)
	public void userToShop(@RequestParam("files") MultipartFile files, HttpServletRequest request,HttpServletResponse resp,String shopName){
		String fileName=files.getOriginalFilename();
		try {
			FTPUtil.uploadFile(fileName, files.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Request r=new Request();
		Results results=null;
		Map<String,Object> map=SessionUtil.getUser(request);
		if(map==null){
			results=new Results();
			results.setCode(-1);
			results.setMsg("用户未登陆");
		}else{
			r.addData("shopName", shopName);
			r.addData("trademark",fileName);
			r.addData("userId", map.get("userId"));
			r.addData("shopId", UUIDUtil.getUUID());
			results=iShopService.userToShop(r);
			SessionUtil.saveGroup(request, "2");
		}
		try {
			resp.getWriter().write(results.toJson());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	private void saveImgs(MultipartFile[] files, HttpServletRequest request,HttpServletResponse resp){
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				if (!file.isEmpty()) {
					try {
						InputStream in = file.getInputStream();
						String filename=file.getOriginalFilename();
						FTPUtil.uploadFile(filename, in);
						Map<String, Object> map = SessionUtil.getUser(request);
						resp.setCharacterEncoding("UTF-8");
						PrintWriter output = resp.getWriter();
						String imgpath="/Echo?imgName="+file.getOriginalFilename();
						resp.setCharacterEncoding("UTF-8");
						try {
							request.setCharacterEncoding("UTF-8");

							output.write(imgpath);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}