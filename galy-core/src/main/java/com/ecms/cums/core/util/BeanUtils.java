package com.ecms.cums.core.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/6/5.
 */
public class BeanUtils
{
    private static Logger logger = LogManager.getLogger(BeanUtils.class);

    public static Map<String, String> getMap(Object obj)
    {
        if (obj == null)
        {
            return null;
        }
        else
        {
            try
            {
                Field[] field = obj.getClass().getDeclaredFields();

                if (field != null && field.length > 0)
                {
                    Map<String, String> map = new HashMap<String, String>();
                    for (int i = 0; i < field.length; i++)
                    {
                        String key = field[i].getName();
                        field[i].setAccessible(true);
                        String value = null;
                        if (field[i].get(obj) != null)
                        {
                            value = field[i].get(obj) + "";
                        }
                        map.put(key, value);
                    }
                    return map;
                }
                else
                {
                    logger.info("字段列表为空");
                    return null;
                }
            }
            catch (Exception e)
            {
                logger.error("解析对象出现错误", e);
                return null;
            }
        }
    }


    public static <T> T convertMap(Class<T> type, Map<String, String> map) throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException
    {
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        T t = type.newInstance();   // 创建 JavaBean 对象

        // 给 JavaBean 对象的属性赋值
        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors())
        {
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName))
            {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                descriptor.getWriteMethod().invoke(t, map.get(propertyName));
            }
        }
        return t;
    }

}
