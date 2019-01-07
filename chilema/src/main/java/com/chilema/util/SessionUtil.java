package com.chilema.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
	private static final String USER="user";
	private static final String GROUP="groupId";
	/**
	 * 保存用户到session
	 */
	public static void saveUser(HttpServletRequest req,Map<String,Object> user){
		HttpSession session=req.getSession();
		session.setAttribute(USER, user);
	}
	/***
	 * 删除用户
	 * @param req
	 */
	public static void reomveUser(HttpServletRequest req){
		HttpSession session=req.getSession();
		session.setAttribute(USER, null);
	}
	/**
	 * 获取一个用户
	 * @param req
	 * @return
	 */
	public static Map<String,Object> getUser(HttpServletRequest req){
		HttpSession session=req.getSession();
		return (Map<String, Object>) session.getAttribute(USER);
	}
	/**
	 * 保存用户分组
	 * @param req
	 * @param group
	 */
	public static void saveGroup(HttpServletRequest req,String group){
		Map<String, Object> map= getUser(req);
		map.put(GROUP, group);
		saveUser(req,map);
	}
	/**
	 * 删除用户分组
	 */
	public static void removeGroup(HttpServletRequest req){
		saveGroup(req,null);
	}
}
