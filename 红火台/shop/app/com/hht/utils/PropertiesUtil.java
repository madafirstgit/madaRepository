package com.hht.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author panghui
 * @version 1.0
 * @since 2016-11-30
 */
public class PropertiesUtil {

    /**
     * 根据Key获取serverconfig.properties 中的值
     *
     * @param key
     * @return
     * @throws IOException
     */
    public static String getValueByKey(String key){
        InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("message.properties");
        Properties properties = new Properties();
        try{
            properties.load(new InputStreamReader(inputStream,"utf-8"));
        }catch (IOException e){
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }

}
