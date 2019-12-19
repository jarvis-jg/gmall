package com.jarvis.gmall.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * gmall : com.jarvis.gmall.util
 *
 * @author jarvis
 * @create 2019-12-18 23:11
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    private static ThreadLocal<String> contextDatasource = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return contextDatasource.get();
    }

    public static void setKey(String key){
        contextDatasource.set(key);
    }

    public static Object getKey(){
        return contextDatasource.get();
    }
}
