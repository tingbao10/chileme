package com.chilema.api.util;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.chilema.util.MapToBeanUtil;
import com.google.gson.Gson;

/**
 * 请求封装
 * @author Administrator
 *
 */
public class Request implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3391365720611331655L;
	//消息集合
	private Map<String,Object> dataMap;
	
	public Request(){
		dataMap=new HashMap<String,Object>();
	}
	/**
	 * 更具name获取数据
	 * @param name
	 * @return
	 */
	public Object getData(String name){
		return dataMap.get(name);
	}
	/**
	 * 更具name删除一条数据
	 * @param name
	 */
	public void removeData(String name){
		dataMap.remove(name);
	}
	/**
	 * 添加一条数据
	 */
	public void addData(String name,Object data){
		dataMap.put(name, data);
	}
	/**
	 * 获取所有数据
	 * @return
	 */
	public Map<String, Object> getDataAll() {
		return dataMap;
	}
	/**
	 * 添加数据集
	 * @param dataMap
	 */
	public void addDataMap(Map<String, Object> dataMap) {
		this.dataMap.putAll(dataMap);
	}
	/**
	 * 添加一个对象
	 * @param obj
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	public void setRequestObject(Object obj) throws IllegalAccessException, InvocationTargetException, IntrospectionException{
		dataMap.putAll(MapToBeanUtil.convertBean(obj));
	}
	/**
	 * 将所有数据转换成一个对象
	 * @param c
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	public Object getRequestObject(Class c) throws IllegalAccessException, InstantiationException, InvocationTargetException, IntrospectionException{
		return MapToBeanUtil.convertMap(c, dataMap);
	}
	/**
	 * 将数据转换为json
	 * @return
	 */
	public String toJson(){
		Gson gson=new Gson();
		return gson.toJson(this);
	}
	
}
