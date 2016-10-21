package com.pzj.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import com.pzj.base.service.exception.SkuServiceException;

public class ValidatUtil {
	/**
	 * 验证对象类型是否为null
	 * @param object 待验证对象
	 * @param Desc 错误信息描述
	 * @param code 错误提示信息
	 * @param logger 日志输出（可选）
	 */
	public static void checkNull(Object object, String Desc, String code, 
			Logger logger) {
		if (null == object) {
			throwException(Desc, code, logger);
		}
	}
	
	/**
	 * 验证字符长度是否为空且超过最大要求长度
	 * @param exp 待验证字符
	 * @param length 最大长度
	 * @param Desc 错误信息描述
	 * @param logger 日志
	 */
	public static void checkLength(String exp, int length, String Desc
			, String code, Logger logger) {
		if (!StringUtils.isEmpty(exp)) {
			if (exp.length() > length) {
				throwException(Desc, code, logger);
			}
		}
	}
	/**
	 * 验证字符长度是否为空且超过最大要求长度
	 * @param exp 待验证字符
	 * @param maxLength 最大长度
	 * @param gtDesc 超过最大长度错误信息描述
	 * @param minLength 最小长度
	 * @param ltDesc 小于最小长度错误信息描述
	 * @param code 错误编码
	 * @param logger 日志（可选）
	 */
	public static void checkEmptyAndLength(String exp, 
			String emptyDesc, int minLength, String ltDesc,
			int maxLength, String gtDesc, String code, Logger logger) {
		if (StringUtils.isEmpty(exp)) {
			throwException(emptyDesc, code, logger);
		}
		if (exp.length() < minLength) {
			throwException(ltDesc, code, logger);
		}
		if (exp.length() > maxLength) {
			throwException(gtDesc, code, logger);
		}
	}
	/**
	 * 异常封装类
	 * @param message 错误信息
	 * @param code 错误编码
	 * @param logger 日志输出(可选)
	 */
	public static void throwException(String message, String code, 
			Logger logger) {
		if(null != logger)	logger.error(message + code);
		throw new SkuServiceException(Integer.valueOf(code), message);
	}
	/**
	 * 验证集合是否为空
	 * @param list
	 * @return
	 */
	public static boolean collectionNotNull(List<?> list) {
		if (null == list || list.size() == 0)
			return false;
		return true;
	}
	
	public static void main(String[] args){
		StringBuffer buff = new StringBuffer();
	    for(int i=1; i<301; i++){
	    	buff.append("A").append(i).append(",");
	    }
	    System.out.println("str = "+buff.toString());
	}
	
}
