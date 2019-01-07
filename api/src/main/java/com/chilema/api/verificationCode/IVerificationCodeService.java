package com.chilema.api.verificationCode;

import com.chilema.api.util.Request;
import com.chilema.api.util.Results;

public interface IVerificationCodeService {
	/**
	 * 获取验证码
	 * @param request
	 * @return
	 */
	 Results getVerificationCode(Request request);
	/**
	 * 	短信接口. 返回1为发送成功 其他则失败
	 * @param VerificationCode  验证码  需要发送的验证码. 可以随机数 可中文 英文 数字
	 * @param recipient 接收人的号码
	 * @return 返回1为发送成功 返回其他则失败
	 */
	int SMS(String VerificationCode,String recipient);
}
