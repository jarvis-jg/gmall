package com.jarvis.gmall.util;

import com.jarvis.gmall.server.AddressServerInf;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.FactoryBean;

/**
 * gmall : com.jarvis.gmall.util
 *
 * @author jarvis
 * @create 2019-12-23 22:27
 */
public class AddressServerFactoryBean implements FactoryBean<AddressServerInf> {
    private String url;
    private Class<?> tClass;

    public static AddressServerInf getWs(String url, Class<?> t) {
        JaxWsProxyFactoryBean jwfb = new JaxWsProxyFactoryBean();
        jwfb.setAddress(url);
        jwfb.setServiceClass(t);
        return (AddressServerInf) jwfb.create();
    }

    @Override
    public AddressServerInf getObject() throws Exception {
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
