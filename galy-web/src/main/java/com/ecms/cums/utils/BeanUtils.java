package com.ecms.cums.utils;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtilsBean;

/**
 * @ClassName: BeanUtils
 * @Description: 实体bean工具类
 * @author: zJin
 * @date: 2018年3月12日 下午6:11:29
 */
public class BeanUtils {

	 /**
	  * @Title: beanToMap
	  * @Description: 实体bean转map
	  * @param obj
	  * @return
	  * @return: Map<String,Object>
	  */
	 public static Map<String, Object> beanToMap(Object obj) {
         Map<String, Object> params = new HashMap<String, Object>(0);
         try {
             PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
             PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
             for (int i = 0; i < descriptors.length; i++) {
                 String name = descriptors[i].getName();
                 if (!"class".equals(name)) {
                     params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return params;
 }
}
