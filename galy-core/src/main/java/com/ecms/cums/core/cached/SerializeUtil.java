package com.ecms.cums.core.cached;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @Title：
 * @Description：序列化公共类
 * @Package com.zucp.core.cached
 * @ClassName SerializeUtil
 * @author zJin
 * @date 2018年03月02日
 * @version V1.0
 */
public class SerializeUtil {

	private static Logger logger = LoggerFactory.getLogger(SerializeUtil.class);
	/**
	 *
	 * @Title: serialize
	 * @Description: TODO(序列化)
	 * @param @param object
	 * @param @return设定文件
	 * @return byte[]返回类型
	 * @throws
	 */
	public static byte[] serialize(Object object) {
		if(object==null){
			return null;
		}
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 *
	 * @Title: unserialize
	 * @Description: TODO(反序列化)
	 * @param @param bytes
	 * @param @return设定文件
	 * @return Object返回类型
	 * @throws
	 */
	public static Object unserialize(byte[] bytes) {
		if(bytes==null){
			return null;
		}
		ByteArrayInputStream bais = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		}
		return null;
	}
}
