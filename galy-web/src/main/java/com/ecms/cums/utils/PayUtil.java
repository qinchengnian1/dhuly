package com.ecms.cums.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class PayUtil {
	/**
	 * bean转map<String,Object>
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> ConvertObjToMap(Object obj) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		if (obj == null)
			return null;
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				try {
					Field f = obj.getClass().getDeclaredField(
							fields[i].getName());
					f.setAccessible(true);
					Object o = f.get(obj);
					reMap.put(fields[i].getName(), o);
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return reMap;
	}

	/**
	 * bean转map<k,v>
	 * @param javaBean
	 * @return
	 */
	public static <K, V> Map<K, V> bean2Map(Object javaBean) {
        Map<K, V> ret = new HashMap<K, V>();
        try {
            Method[] methods = javaBean.getClass().getDeclaredMethods();
            for (Method method : methods) {

                if (method.getName().startsWith("get")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("get") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    Object value = method.invoke(javaBean, (Object[]) null);
                    if(value !=null && !"sign".equals(field)){
                    	ret.put((K) field, (V) (null == value ? "" : value));
                    }

                }
            }
        } catch (Exception e) {
        }
        return ret;
    }

	/**
	 * bean转map<k,v>
	 * @param javaBean
	 * @return
	 */
	public static <K, V> Map<K, V> bean2MapWithSing(Object javaBean) {
        Map<K, V> ret = new HashMap<K, V>();
        try {
            Method[] methods = javaBean.getClass().getDeclaredMethods();
            for (Method method : methods) {

                if (method.getName().startsWith("get")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("get") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    Object value = method.invoke(javaBean, (Object[]) null);
                    if(value !=null){
                    	ret.put((K) field, (V) (null == value ? "" : value));
                    }

                }
            }
        } catch (Exception e) {
        }
        return ret;
    }

	/**
	 * map排序
	 * @param map
	 * @return
	 */
	public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj1.compareTo(obj2);
                    }});
        sortMap.putAll(map);
        return sortMap;
    }

	/**
	 * 获取签名(带合作码)
	 * @param map
	 * @return
	 */
	public static String getSign(String cooperationCode, Map<String, String> map) {
		StringBuilder paras = new StringBuilder();
		paras.append(cooperationCode);
		Map<String,String> sortMap = PayUtil.sortMapByKey(map);
		int i = 0;
		for (Entry<String, String> entry : sortMap.entrySet()) {
			if(entry.getValue() != null && !"".equals(entry.getValue()) && !"checkValue".equals(entry.getKey())){
				if(i==0){
					paras.append(entry.getKey()+"="+entry.getValue());
				}else{
					paras.append("&"+entry.getKey()+"="+entry.getValue());
				}
				i++;
			}
        }
		String sign = PayUtil.MD5(paras.toString()).toLowerCase();
		return sign;
	}

	/**
	 * 获取签名
	 * @param map
	 * @return
	 */
	public static String getSign(Map<String, String> map) {
		StringBuilder paras = new StringBuilder();
		Map<String,String> sortMap = PayUtil.sortMapByKey(map);
		int i = 0;
		for (Entry<String, String> entry : sortMap.entrySet()) {
			if(entry.getValue() != null && !"".equals(entry.getValue()) && !"checkValue".equals(entry.getKey())){
				if(i==0){
					paras.append(entry.getKey()+"="+entry.getValue());
				}else{
					paras.append("&"+entry.getKey()+"="+entry.getValue());
				}
				i++;
			}
		}
		String sign = PayUtil.MD5(paras.toString()).toLowerCase();
		return sign;
	}

	/**
	 * 获取支付宝签名
	 * @param map
	 * @return
	 */
	public static String getSign4ZFB(String key, Map<String, String> map) {
		StringBuilder paras = new StringBuilder();
		Map<String,String> sortMap = PayUtil.sortMapByKey(map);
		int i = 0;
		for (Entry<String, String> entry : sortMap.entrySet()) {
			if(entry.getValue() != null && !"".equals(entry.getValue()) && !"sign".equals(entry.getKey()) && !"sign_type".equals(entry.getKey())){
				if(i==0){
					paras.append(entry.getKey()+"="+entry.getValue());
				}else{
					paras.append("&"+entry.getKey()+"="+entry.getValue());
				}
			}
			i++;
        }
		paras.append(key);
		String sign = PayUtil.MD5(paras.toString()).toLowerCase();
		return sign;
	}

	/**
	 * MD5加密
	 * @param s
	 * @return
	 */
	public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

}
