package com.chilema.api.user;

import com.chilema.api.util.Request;
import com.chilema.api.util.Results;

public interface IUserService {
	/**
	 * 用户登录
	 * @param r
	 * @return
	 */
	Results login(Request r);
	/**
	 * ע用户注册
	 * @param r
	 * @return
	 */
	Results register(Request r);
	/**
	 * 修改用户信息
	 * @param r
	 * @return
	 */
	Results updataUserInfo(Request r);
	/**
	 * 修改用户头像
	 * @param r
	 * @return
	 */
	Results updataUserHead(Request r);
	/**
	 * 查找用户
	 * @param r
	 * @return
	 */
	Results findUser(Request r);
	/**
	 * 根据ID查找用户信息
	 * @param r
	 * @return
	 */
	Results findUserinfo(Request r);
	/**
	 * 添加用户信息
	 * @param r
	 * @return
	 */
	Results saveUserInfo(Request r);
}
