package com.chilema.service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chilema.api.user.IUserService;
import com.chilema.api.util.Request;
import com.chilema.api.util.Results;
import com.chilema.dao.UserDAO;
import com.chilema.entity.User;
import com.chilema.entity.UserGroup;
import com.chilema.entity.Userinfo;
import com.chilema.util.MD5Util;
import com.chilema.util.UUIDUtil;

import redis.clients.jedis.Jedis;
@Service
public class UserService implements IUserService{
	@Autowired
	private UserDAO userdao;
	@Override
	public Results login(Request r) {
		encryptingPassword(r);
		User num = userdao.login(r.getDataAll());
		Results ret=new Results();
		if(num!=null){
			ret.setCode(200);
			try {
				ret.setRequestObject(num);
				UserGroup getuser_group = userdao.Getuser_group(ret.getDataAll());//查询权限
				ret.addData("groupId", getuser_group.getgroupId());
				ret.addData("token", MD5Util.encrypt32(num.getloginUser()+num.getPassword()));
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
		return ret;
	}

	@Override
	public Results register(Request r) {
		String loginUser=(String) r.getData("loginUser");
		Jedis jedis=new Jedis();
		String verificationCode=jedis.get(loginUser);
		String rVerificationCode=(String) r.getData("verificationCode");
		if(verificationCode==null||rVerificationCode==null||!verificationCode.equals(rVerificationCode)){
			Results results=new  Results();
			results.setCode(-1);
			results.setMsg("验证码错误");
			return results;
		}
		jedis.del(loginUser);
		Results results= findUser(r);
		String userId=(String) results.getData("userId");
		if(userId==null||"".equals(userId)){
			encryptingPassword(r);
			r.addData("userId", UUIDUtil.getUUID());
			userdao.register(r.getDataAll());
			userdao.saveUserInfo(r.getDataAll());
			r.addData("groupId", "1");
			userdao.savaUserGroup(r.getDataAll());
			results.clean();
			results.setCode(200);
			return results;
		}
		results.setCode(-1);
		results.setMsg("用戶已經存在");
		return results;
	}

	@Override
	public Results updataUserHead(Request r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results updataUserInfo(Request r) {
		int updataUserInfo = userdao.updataUserInfo(r.getDataAll());
		Results findUserinfo=new Results();
		if(updataUserInfo==1){
			
			findUserinfo = findUserinfo(r);
			findUserinfo.setCode(200);
		}
		
		return findUserinfo;
	}

	@Override
	public Results findUser(Request r) {
		User user= userdao.findUser(r.getDataAll());
		Results results=new Results();
		if(user!=null){
			try {
				results.setRequestObject(user);
			} catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return results;
	}

	@Override
	public Results findUserinfo(Request r) {
		Userinfo info = userdao.findUserinfo(r.getDataAll());
	
		Results ret=new Results();
		try {
			ret.setRequestObject(info);
			ret.setCode(200);
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
		return ret;
	}
	/**
	 * 密碼加密
	 * @param r
	 */
	private void encryptingPassword(Request r){
		String password=MD5Util.encrypt16((String) r.getData("password"));
		r.addData("password", password);
	}

	@Override
	public Results saveUserInfo(Request r) {
		// TODO Auto-generated method stub
		return null;
	}
}
