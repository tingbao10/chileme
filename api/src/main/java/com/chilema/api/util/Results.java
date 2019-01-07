package com.chilema.api.util;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chilema.util.MapToBeanUtil;
import com.google.gson.Gson;

/**
 * 返回结果封装
 * @author Administrator
 *
 */
public class Results implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2177675154773575201L;
	/**
	 * 状态吗
	 */
	private Integer code;
	/**
	 * 消息
	 */
	private String msg;
	/**
	 * 数据
	 */
	private Map<String,Object> dataMap;
	public Results(){
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
	public void addList(String name,List obj) throws IllegalAccessException, InvocationTargetException, IntrospectionException{
		List<Map<String,Object>> l=new ArrayList<Map<String,Object>>();
		for(Object o:obj){
			l.add(MapToBeanUtil.convertBean(o));
		}
		dataMap.put(name, l);
		
	}
	/**
	 * 清空數據
	 */
	public void clean(){
		dataMap.clear();
	}
	/**
	 * 将数据转换为json
	 * @return
	 */
	public String toJson(){
		Gson gson=new Gson();
		return gson.toJson(this);
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}


}
