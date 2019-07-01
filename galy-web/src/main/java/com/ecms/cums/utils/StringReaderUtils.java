package com.ecms.cums.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 字符串读取工具
 * @Title：
 * @Description：
 * @author cfl
 * @date 2015年9月10日
 * @version V1.0
 */
public class StringReaderUtils {

	public static String DEFUALT_ENCODING = "UTF-8";

	/**
	 * 从请求流中读取字符串
	 * @Title: readFromIO
	 * @Description:
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String readFromIO(InputStream is) throws IOException{
		return readFromIO(is,DEFUALT_ENCODING);
	}
	/**
	 *
	 * @Title: readFromIO
	 * @Description:
	 * @param is
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static String readFromIO(InputStream is,String encoding) throws IOException{
		StringBuffer xml = new StringBuffer();
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(is,encoding));
			String s = null;
			while ((s = br.readLine()) != null){
				xml.append(s);
			}
		}finally{
		    if (br != null) {
		        try {br.close();br = null;
		        } catch (IOException e) {
		          e.printStackTrace();
			    }
			}
		}
		return xml.toString();
	}
}
