package com.chilema.dao;

import java.util.Map;

import com.chilema.entity.User;
import com.chilema.entity.UserGroup;
import com.chilema.entity.Userinfo;

public interface UserDAO {
	/**
	 * 新增用户
	 * @param user
	 */
	void register(Map map);
	/**
	 * 用户登陆
	 * @param map
	 * @return
	 */
	User login(Map map);
	
	/**
	 * 修改用户Info表 0为假 1为真
	 * @param map
	 * @return
	 */
	int updataUserInfo(Map map);
	/**
	 * 根据ID 查询USERINFO
	 * @param map
	 * @return
	 */
	Userinfo findUserinfo(Map map);
	/**
	 * 更具loginUser查詢用戶
	 * @param map
	 * @return
	 */
	User findUser(Map map);
	/**
	 * 保存用户信息
	 * @param map
	 */
	void saveUserInfo(Map map);
	/**
	 * 增加权限 
	 */
	void savaUserGroup(Map map);
	/**
	 * 更改用户权限
	 * @param map
	 */
	void updataUserGroup(Map map);
	
	/**
	 * 更加userid查询权限
	 */
	UserGroup Getuser_group(Map map);
}
