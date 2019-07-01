package com.ecms.cums.utils.account;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppKeyProperties {

    private static final String path = "appKey.properties";
    private static String absolutePath = path;
    private static Properties p;
    static{
        if (p == null){
            p = new Properties();
        }
        absolutePath =  AppKeyProperties.class.getClassLoader().getResource(path).getPath();
        //转换成流
        InputStream inputStream = AppKeyProperties.class.getClassLoader().getResourceAsStream(path);
        try {
            //从输入流中读取属性列表（键和元素对）
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取
     * @param key
     * @return
     */
    public static String get(String key) {
        return p.getProperty(key);
    }

    /**
     * 修改或者新增key
     *
     * @param key
     * @param value
     */
    public static void update(String key, String value) {
        p.setProperty(key, value);
        FileOutputStream oFile = null;
        try {
            oFile = new FileOutputStream(absolutePath);
            //将Properties中的属性列表（键和元素对）写入输出流
            p.store(oFile, "");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
