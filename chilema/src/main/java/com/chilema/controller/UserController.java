package com.chilema.controller;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.patterns.IVerificationRequired;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chilema.api.shop.IShopService;
import com.chilema.api.user.IUserService;
import com.chilema.api.util.Request;
import com.chilema.api.util.Results;
import com.chilema.api.verificationCode.IVerificationCodeService;
import com.chilema.util.SessionUtil;




/**
 * 测试不要动
 * @author Administrator
 *
 */
@Controller
public class UserController {
	@Autowired
	IUserService userService; 
	@Autowired
	IVerificationCodeService codeService;
	@Autowired
	IShopService iShopService; 
	
	/**
	 * 转入登陆界面
	 * @return
	 */
	@RequestMapping(value="userLogin",method = RequestMethod.GET)
	public String userLogin(){
		return "userLogin";
	}
	/**
	 * 请求转入主界面    -------
	 * @param req
	 * @return
	 */
	@RequestMapping(value="homo",method = RequestMethod.GET)
	public String home(HttpServletRequest req){
		Request request=new Request();
		//Results findShopssss = iShopService.findShops(request);
		//req.setAttribute("shop",findShopssss.getData("list"));
		return "homo";
	}
	/**
	 * 转入注册界面
	 * @param req
	 * @return
	 */
	@RequestMapping(value="register",method = RequestMethod.GET)
	public String register(HttpServletRequest req){
		return "register";
	}
	
	/**
	 * 验证登陆并转入主界面
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "userLogin", method = RequestMethod.POST)
	public void userLogins( HttpServletRequest httpreq,HttpServletResponse resp) throws IOException{
		String loginUser = httpreq.getParameter("loginUser");
		String password = httpreq.getParameter("password");
		Request request=new Request();
		request.addData("loginUser", loginUser);
		request.addData("password", password);
		Results remap = userService.login(request); //返回结果判断是否登陆成功
		if(remap.getCode()!=null&&remap.getCode()==200){ //成立则登陆成功 
			Results findUserinfo = userService.findUserinfo(request);  
			findUserinfo.addData("groupId", remap.getData("groupId"));
			SessionUtil.saveUser(httpreq,findUserinfo.getDataAll());
		}
		resp.getWriter().write(remap.toJson());
	}
	/**
	 * 获取验证码
	 * @param map
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "getVerificationCode")
	public void getVerificationCode(@RequestParam("phone") String phone,HttpServletResponse value){
		Request request=new Request();
		request.addData("loginUser", phone);
		Results results = codeService.getVerificationCode(request);
		try {
			value.getWriter().println(results.toJson());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 注销登陆
	 * @param req
	 * @return
	 */
	@RequestMapping(value="zhuxiao",method = RequestMethod.GET)
	public String zhuxiao(HttpServletRequest req){
		SessionUtil.reomveUser(req);
		Request request=new Request();
		Results results = iShopService.findShops(request);
		req.setAttribute("shop",results.getData("list"));
		return "homo";
	}
	
	/**
	 * 注册功能
	 * @param httpreq
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping(value ="register", method = RequestMethod.POST)
	public void register( HttpServletRequest httpreq,HttpServletResponse resp) throws IOException{
		String password = httpreq.getParameter("password");
		String phone = httpreq.getParameter("phone");
		String verificationCode = httpreq.getParameter("verificationCode");
		Request request=new Request();
		request.addData("loginUser", phone);
		request.addData("password", password);
		request.addData("verificationCode", verificationCode);
		Results register = userService.register(request);
		resp.getWriter().write(register.toJson());
	}
	
	/**
	 * 进入用户修改个人信息的网址
	 */
	@RequestMapping(value = "userinfo")
	public String userinfo(){
		return "userinfo";
	}
	/**
	 * 用户修改个人信息post请求
	 * @throws IOException 
	 */
	@RequestMapping(value = "userinfo" , method = RequestMethod.POST)
	public void userinfo2( HttpServletRequest httpreq,HttpServletResponse resp) throws IOException{
		String phone = httpreq.getParameter("phone");
		String nickName = httpreq.getParameter("nickName");
		nickName.getBytes("UTF-8");
		String userName = httpreq.getParameter("userName");
		String email = httpreq.getParameter("email");
		String roomAddress = httpreq.getParameter("roomAddress");
		Request request=new Request();
		request.addData("nickName", nickName);
		request.addData("userName", userName);
		request.addData("email", email);
		request.addData("roomAddress", roomAddress);
		request.addData("phone", phone);
		Results register = userService.updataUserInfo(request);
		resp.setContentType("text/xml;charset=utf-8");
		resp.getWriter().write(register.toJson());
		httpreq.getSession().setAttribute("str",register.getDataAll());
	}
}
