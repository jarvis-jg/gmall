package com.jarvis.gmall.util;

import com.jarvis.gmall.server.TestServerInf;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;

/**
 * gmall : com.jarvis.gmall.util
 *
 * @author jarvis
 * @create 2019-12-18 22:11
 */
public class TestServerFactoryBean implements FactoryBean<TestServerInf> {

    private String url;
    private Class<?> tClass;

    public static TestServerInf getWs(String url, Class<?> t) {
        JaxWsProxyFactoryBean jwfb = new JaxWsProxyFactoryBean();
        jwfb.setAddress(url);
        jwfb.setServiceClass(t);
        //加入安全协议，鉴权的信息
        HashMap<String, Object> map = new HashMap<>();
        map.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        map.put(WSHandlerConstants.PASSWORD_TYPE, "PasswordText");
        map.put("user", "username");
        map.put(WSHandlerConstants.PW_CALLBACK_CLASS, MyCallback.class.getName());
        //加入安全协议，鉴权的信息
        WSS4JOutInterceptor out = new WSS4JOutInterceptor(map);
        jwfb.getOutInterceptors().add(out);
        return (TestServerInf) jwfb.create();
    }

    @Override
    public TestServerInf getObject() throws Exception {
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
