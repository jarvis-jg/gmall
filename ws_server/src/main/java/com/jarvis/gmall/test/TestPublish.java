package com.jarvis.gmall.test;

import javax.xml.ws.Endpoint;

/**
 * gmall : com.jarvis.gmall.test
 *
 * @author jarvis
 * @create 2019-12-15 21:44
 */
public class TestPublish {

    public static void main(String[] args) {
        TestServiceInf ws = new TestServiceImpl();
        Endpoint.publish("http://192.168.1.10:1234/ws", ws);
    }
}
