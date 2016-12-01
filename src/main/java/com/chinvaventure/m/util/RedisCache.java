/**
 * 
 */
package com.chinvaventure.m.util;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import redis.clients.jedis.exceptions.JedisConnectionException;



/**
 * @描述： redis使用第三方內存數據庫作為Redis的二級緩存
 * 
 * @作者： Rock
 * @創建時間：2016-08-04
 */
public class RedisCache implements Cache {

	//日誌
	private static final Logger log = Logger.getLogger(RedisCache.class);
	//創建連接工場
	private static JedisConnectionFactory jedisConnectionFactory;
	//私有化ID
	private static String id;
	//創建讀寫鎖
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
    public RedisCache(final String id) {
	    if (id == null) {
	            throw new IllegalArgumentException("Cache instances require an ID");
	        }
	        log.debug("MybatisRedisCache:id=" + id);
	        this.id = id;
	}
   
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		log.debug("--------getId-----------");
		return this.id;
		
	}

	@Override
	public void putObject(Object key, Object value) {
		// TODO Auto-generated method stub
		JedisConnection jedisConnection = null;
		try {
			jedisConnection = jedisConnectionFactory.getConnection();
			RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
			jedisConnection.set(serializer.serialize(key), serializer.serialize(value));
		} catch (JedisConnectionException e) {
			log.debug("------------------putObject------------------"+e);
		}finally{
			if (jedisConnection != null) {
				jedisConnection.close();
			}
		}
	}

	@Override
	public Object getObject(Object key) {
		// TODO Auto-generated method stub
		Object result = null;
		JedisConnection jedisConnection = null;
		try {
			jedisConnection = jedisConnectionFactory.getConnection();
			RedisSerializer< Object> serilizer = new JdkSerializationRedisSerializer();
			result = serilizer.deserialize(jedisConnection.get(serilizer.serialize(key)));
		} catch (JedisConnectionException e) {
			log.debug("---------------------getObject---------------"+e);
		}finally{
			if (jedisConnection != null) {
				jedisConnection.close();
			}
		}
		return result;
	}

	@Override
	public Object removeObject(Object key) {
		// TODO Auto-generated method stub
		JedisConnection jedisConnection = null;
		Object result = null;
		try {
			jedisConnection = jedisConnectionFactory.getConnection();
			RedisSerializer< Object> seralizer = new JdkSerializationRedisSerializer();
			result = jedisConnection.expire(seralizer.serialize(key), 0);
		} catch (JedisConnectionException e) {
			log.debug("-------------removeObject------------"+e);
		}finally{
			if(jedisConnection != null){
				jedisConnection.close();
			}
		}
		return result;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		JedisConnection jedisConnection = null;
		try {
			jedisConnection = jedisConnectionFactory.getConnection();
			jedisConnection.flushDb();
			jedisConnection.flushAll();
			
		} catch (JedisConnectionException e) {
			// TODO: handle exception
			log.debug("--------------clear-----------"+e);
		}finally{
			if (jedisConnection != null) {
				jedisConnection.close();
			}
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int result = 0;
		JedisConnection jedisConnection = null;
		try {
			jedisConnection = jedisConnectionFactory.getConnection();
			result = Integer.valueOf(jedisConnection.dbSize().toString());
		} catch (JedisConnectionException e) {
			// TODO: handle exception
			log.debug("------------------getSize-----------------------"+e);
		}finally{
			if (jedisConnection != null) {
				jedisConnection.close();
			}
		}
		return result;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		log.debug("------------------getReadWriteLock-----------------------");
		return this.readWriteLock;
	}
	public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }

}
