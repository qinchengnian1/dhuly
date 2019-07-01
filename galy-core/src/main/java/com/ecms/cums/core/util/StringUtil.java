package com.ecms.cums.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StringUtil {

	/**
	 * 通过配置文件的key获取值
	 *
	 * @author 宋士恩 2014-10-30
	 * @param key
	 * @return
	 */
	public String getPropertieValue(String fileName, String key) {
		String value = "";
		try {
			Properties properties = new Properties();
			InputStream in = getClass().getResourceAsStream("/" + fileName);
			properties.load(in);
			value = properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
