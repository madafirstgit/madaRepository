package com.pzj.util.productConvertUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.service.exception.SkuParamConvertException;
import com.pzj.base.service.exception.SkuServiceException;
import com.pzj.framework.context.Result;
import com.pzj.product.vo.ListObject;
import com.pzj.product.vo.MapObject;
import com.pzj.util.MFBeanCopier;

public class CommonConvert {
	private static Logger logger = LoggerFactory.getLogger(CommonConvert.class);

	public static <T extends Object> List<T> intersectionList(
			List<T> list1, List<T> list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		List<T> result = new ArrayList<T>();
		Set<T> set = new HashSet<T>(list2);
		for (T t1 : list1) {
			if (set.contains(t1)) {
				result.add(t1);
			}
		}
		return result;
	}
	
	public static List<List<Long>>  splitIdList(List<Long> ids, int len){
		if(CollectionUtils.isEmpty(ids)){
			return null;
		}
		List<List<Long>> result = new ArrayList<List<Long>>();
	    for(int i=0; i<ids.size(); i=i+len){
	    	int end = i+len;
	    	if(i+len > ids.size()){
	    		end = ids.size();
	    	}
		  List<Long> subIds = ids.subList(i, end);
		  result.add(subIds);
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
//					PropertyUtils.copyProperties(target, source);
					MFBeanCopier.copyProperties(target, source);
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
			//PropertyUtils.copyProperties(target, source);
			MFBeanCopier.copyProperties(target,source);
		} catch (Throwable throwable) {
			logger.error(throwable.getMessage(), throwable);
			throw new SkuParamConvertException(throwable.getMessage(),
					throwable);
		}
	}

	public static void copyProperties2(Object target, Object source) {
		try {
			BeanUtils.copyProperties(target, source);
		} catch (Throwable throwable) {
			logger.error(throwable.getMessage(), throwable);
			throw new SkuParamConvertException(throwable.getMessage(),
					throwable);
		}
	}


	public void setProduct(ProductInfo info) {
		if (info == null) {
			info = new ProductInfo();
			System.out.println("创建对象");
		}
	}

	public ProductInfo getProduct() {
		ProductInfo info = null;
		setProduct(info);
		return info;
	}

	public static <T extends Serializable> void combinationTResult(
			Result<T> result, SkuServiceException ex) {
		result.setErrorCode(ex.getErrorCode());
		result.setErrorMsg(ex.getMessage());

	}

	public static void main(String[] args) {
		CommonConvert con = new CommonConvert();
		if (con.getProduct() == null) {
			System.out.println("输出为空");
		}
	}

	public static <K,V, T extends MapObject<K,V>> Map<K, V> convertToMap(List<T> dataList){
		if (CollectionUtils.isEmpty(dataList))
			return null;

		Map<K, V> dataMap = new HashedMap(dataList.size());
		for (T data : dataList){
			K key = data.key();
			V value = data.value();
			dataMap.put(key, value);
		}
		return dataMap;
	}



	public static <T> void addToList(ListObject<T> listObject, T data){
		List<T> dataList = listObject.dataList();

		if (dataList == null) {
			dataList = new LinkedList<>();
			listObject.dataList(dataList);
		}

		dataList.add(data);
	}
}
