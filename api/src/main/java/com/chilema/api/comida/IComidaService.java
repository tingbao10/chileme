package com.chilema.api.comida;

import com.chilema.api.util.Request;
import com.chilema.api.util.Results;

public interface IComidaService {
	/**
	 * 查找菜品
	 * @param r
	 * @return
	 */
	Results findComida(Request r);
	/**
	 * 修改菜品信息
	 * @param r
	 * @return
	 */
	Results updataComidaInfo(Request r);
	/**
	 * 修改菜品图片
	 * @param r
	 * @return
	 */
	Results updataComidaImg(Request r);
}
