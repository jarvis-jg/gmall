package com.jarvis.gmall.server;

/**
 * gmall : com.jarvis.gmall.server
 *
 * @author jarvis
 * @create 2019-12-15 22:39
 */
public class TestServerImpl implements TestServerInf {

    @Override
    public String ping(String hello) {
        System.out.println("cxf调用：" + hello);
        return "pong";
    }
}
