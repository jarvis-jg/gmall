package com.jarvis.gmall.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * gmall : com.jarvis.gmall.util
 *
 * @author jarvis
 * @create 2019-11-23 19:48
 */
public class MyPropertyUtil {

    public static String getProperty(String propertyFile, String key) {
        Properties properties = new Properties();
        InputStream inputStream = MyPropertyUtil.class.getClassLoader().getResourceAsStream(propertyFile);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
