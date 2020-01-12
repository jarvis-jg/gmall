package com.jarvis.gmall.util;

import com.jarvis.gmall.server.LoginServerInf;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.FactoryBean;

/**
 * gmall : com.jarvis.gmall.util
 *
 * @author jarvis
 * @create 2019-12-18 22:11
 */
public class MyWsFactoryBean implements FactoryBean<LoginServerInf> {

    private String url;
    private Class<?> tClass;

    public static LoginServerInf getWs(String url, Class<?> t) {
        JaxWsProxyFactoryBean jwfb = new JaxWsProxyFactoryBean();
        jwfb.setAddress(url);
        jwfb.setServiceClass(t);
        return (LoginServerInf) jwfb.create();
    }

    @Override
    public LoginServerInf getObject() throws Exception {
        return getWs(url,tClass);
    }

    @Override
    public Class<?> getObjectType() {
        return tClass;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Class<?> gettClass() {
        return tClass;
    }

    public void settClass(Class<?> tClass) {
        this.tClass = tClass;
    }
}
