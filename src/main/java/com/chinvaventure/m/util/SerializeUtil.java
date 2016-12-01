/**
 * 
 */
package com.chinvaventure.m.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

/**
 * 序列化工具類
 * 
 * @author rock
 * @創建時間 2016-08-04
 *
 */
public class SerializeUtil {

	//log日誌
	private static Logger log = Logger.getLogger(SerializeUtil.class);
	
	//序列化
	public static byte[] serialize(Object obj){
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos =null;
		//序列化
		try {
			log.info("-------序列化開始-----");
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			
			byte[] bytes = baos.toByteArray();
			return bytes;
			
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	//反序列化
	public static Object unserialize(byte[] bytes){
		ByteArrayInputStream bais = null;
		try {
			log.info("--------反序列化開始----------");
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
			
		} catch (Exception e) {
			log.error(e);
			
		}
		
		return null;
		
	}
}
