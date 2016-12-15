package com.hht.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JsonUtil {
	
	/**
	 * 传入对象，转换JSON
	 * 
	 * @param obj
	 * @return
	 */
	public static String objectToJson(Object obj){
		return JSON.toJSONString(obj);
	}
	
	
	/**
	 * json字符串转换Map
	 * 
	 * @param json
	 * @return
	 */
	public static <T> Map<String,T> jsonToMap(String json) {

		Map<String,T> map = JSON.parseObject(json,HashMap.class);
		
		return map;
	}

	/**
	 * Json字符串转换LinkedList
	 *
	 * @param json
	 * @return
	 */
	public static LinkedList<String> jsonToLinkedList(String json){
		return JSON.parseObject(json,LinkedList.class);
	}

	/**
	 * Json 转换List
	 *
	 * @param json
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> jsonToList(String json,Class<T> clazz){
		return JSON.parseArray(json,clazz);

	}
	
}
