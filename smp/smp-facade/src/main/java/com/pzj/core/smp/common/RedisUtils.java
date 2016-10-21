/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.smp.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @author mada
 * @version $Id: RedisUtils.java, v 0.1 2016年10月18日 下午4:41:33 Administrator Exp $
 */
public class RedisUtils {
	@Autowired
	private static JedisPool jedisPool;
	// 业务平台+优先级 编号,trade_A 校验

	public static boolean platPriExist() {
		Jedis jedis = jedisPool.getResource();
		try {
			String value = jedis.get("a");
			HashSet<String> tset = (HashSet<String>) jedis.smembers("myset");
			System.out.println(tset.size());
			// jedis.lpush(key, strings)
			// jedis.rpoplpush(srckey, dstkey)
			// jedis.rpoplpush(srckey, dstkey)
			// boolean exist = jedis.sismember(key, member);
			// jedis.blpop("")
			List<String> list = new ArrayList<String>();
			System.out.println(value);
		} catch (Exception e) {
			// 释放redis对象
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// 返还到连接池
			close(jedis);
		}
		return false;
	}

	
	 public static void close(Jedis jedis) {
	        try {
	            jedisPool.returnResource(jedis);

	        } catch (Exception e) {
	            if (jedis.isConnected()) {
	                jedis.quit();
	                jedis.disconnect();
	            }
	        }
	    }
	 
	 
}
