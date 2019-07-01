package com.ecms.cums.utils;

import java.util.Properties;

import org.springside.modules.utils.PropertiesLoader;

/**
 * @ClassName: ResourceUtils
 * @Description: TODO
 * @author: zJin
 * @date: 2018年6月15日 下午3:51:32
 */
public class ResourceUtils {

	protected static PropertiesLoader propertiesLoader = new PropertiesLoader("classpath:/config.properties");



	/**
	 * 得到整个properties
	 * @Title: getProperties
	 * @Description:
	 * @return
	 */
	public Properties getProperties() {
		return propertiesLoader.getProperties();
	}

	/**
	 * 获取String类型值
	 * @Title: getProperty
	 * @Description:
	 * @param key
	 * @return
	 */
	public static final String getProperty(String key) {
		return propertiesLoader.getProperty(key,"");
	}

	/**
	 * 获取Boolean类型值
	 * @Title: getBoolean
	 * @Description:
	 * @param key
	 * @return
	 */
	public static final Boolean getBoolean(String key){

		return propertiesLoader.getBoolean(key);
	}

	/**
	 * 获取Integer类型值
	 * @Title: getInteger
	 * @Description:
	 * @param key
	 * @return
	 */
	public static final Integer getInteger(String key){

		return propertiesLoader.getInteger(key);
	}

	/**
	 * 获取Double类型值
	 * @Title: getDouble
	 * @Description:
	 * @param key
	 * @return
	 */
	public static final Double getDouble(String key){

		return propertiesLoader.getDouble(key);
	}

	public static String getSystempPath() {
		return System.getProperty("java.io.tmpdir");
	}

	public static String getSeparator() {
		return System.getProperty("file.separator");
	}


	public static void main(String[] args){

	}

}
