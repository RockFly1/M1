/**
 * 
 */
package com.chinvaventure.m.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @描述：静态注入中间类
 * 
 * @作者： Rock 
 * 
 * @创建时间：2016-08-05
 *
 */
public class RedisCacheTransfer {

	@Autowired
	public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory){
		RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
	}
}
