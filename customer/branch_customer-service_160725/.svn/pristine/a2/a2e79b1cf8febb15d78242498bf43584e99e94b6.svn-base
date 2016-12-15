package com.pzj.service.Impl.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.base.common.BaseEntity;
import com.pzj.product.vo.MapObject;

public class CommonConvert {
	private static Logger logger = LoggerFactory.getLogger(CommonConvert.class);

	

	public static <T extends Object> List<T> intersectionList(
			Collection<T> list1, Collection<T> list2) {
		if (list1 == null)
			return null;
		if (list2 == null)
			return null;
		List<T> result = new ArrayList<T>();
		Set<T> set = new HashSet<T>(list2);
		for (T t1 : list1) {
			if (set.contains(t1)) {
				result.add(t1);
			}
		}
		return result;
	}
	
	public static <T extends Object> List<T> intersectionList(
			Collection<T> list1, T t) {
		if (list1 == null)
			return null;
		List<T> result = new ArrayList<T>();
		Set<T> set = new HashSet<T>(list1);
		for (T t1 : list1) {
			if (set.contains(t1)) {
				result.add(t1);
			}
		}
		return result;
	}
	

	/**
	 * 获取list1中没有list2的数据
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static <T extends Object> List<T> notInList(
			List<T> list1, List<T> list2) {
		if (list1 == null)
			return null;
		if (list2 == null)
			return list1;
		List<T> result = new ArrayList<T>();
		Set<T> set = new HashSet<T>(list2);
		for (T t1 : list1) {
			if (!set.contains(t1)) {
				result.add(t1);
			}
		}
		return result;
	}
	
	/**
	 * 获取list1中没有t2的数据
	 * @param list1
	 * @param t2
	 * @return
	 */
	public static <T extends Object> List<T> notInList(
			T t2,List<T> list1) {
		if (list1 == null)
			return null;
		if (t2 == null)
			return list1;

		Set<T> set = new HashSet<T>(list1);
	    if(set.contains(t2)){
	    	set.remove(t2);
	    }
		return new ArrayList<T>(set);
	}

	public static <C extends Collection<T>, T extends BaseEntity> Map<Long, T> map(
			C entityList) {
		if (CollectionUtils.isEmpty(entityList))
			return null;
		Map<Long, T> entityMap = new HashMap<>(entityList.size());
		for (T enityt : entityList) {
			entityMap.put(enityt.getId(), enityt);
		}
		return entityMap;
	}

	public static <C extends Collection<T>, T extends BaseEntity> List<Long> getIdList(
			C tList) {
		if (tList == null)
			return null;
		Set<Long> set = new HashSet<Long>();
		for (T t : tList) {
			if (t.getId() == null)
				continue;
			set.add(t.getId());
		}
		return new ArrayList<Long>(set);

	}

	public static <T> List<T> convertList(List<?> list, Class<T> clazz) {
		List<T> result = null;
		try {
			if (CollectionUtils.isNotEmpty(list)) {
				result = new ArrayList<>(list.size());
				for (Object source : list) {
					T target = clazz.newInstance();
					PropertyUtils.copyProperties(target, source);
					result.add(target);
				}
			}
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		return result;
	}

	public static <T extends BaseEntity> Map<Long, T> convertListTMap(
			List<T> list) {
		Map<Long, T> result = null;
		;
		try {
			if (CollectionUtils.isNotEmpty(list)) {
				result = new HashMap<Long, T>(list.size());
				for (T t : list) {
					result.put(t.getId(), t);
				}

			}
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		return result;
	}

	public static <T extends BaseEntity> Map<String, T> convertListTMapS(
			List<T> list) {
		Map<String, T> result = null;
		;
		try {
			if (CollectionUtils.isNotEmpty(list)) {
				result = new HashMap<String, T>(list.size());
				for (T t : list) {
					Long id = t.getId();
					if (id == null)
						continue;
					result.put(t.getId().toString(), t);
				}

			}
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		return result;
	}

	public static void copyProperties(Object target, Object source) {
		try {
			PropertyUtils.copyProperties(target, source);
		} catch (Throwable throwable) {
			logger.error(throwable.getMessage(), throwable);
			throw new RuntimeException(throwable.getMessage(),
					throwable);
		}
	}

	public static <K,V, T extends MapObject<K,V>> Map<K, V> convertToMap(List<T> dataList){
		if (CollectionUtils.isEmpty(dataList))
			return null;

		Map<K, V> dataMap = new HashedMap(dataList.size());
		for (T data : dataList){
			if (data == null)
				continue;
			K key = data.key();
			V value = data.value();
			dataMap.put(key, value);
		}
		return dataMap;
	}

}
