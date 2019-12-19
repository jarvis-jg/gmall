package com.jarvis.gmall.test;

import javax.jws.WebService;

/**
 * gmall : com.jarvis.gmall.test
 *
 * @author jarvis
 * @create 2019-12-15 21:38
 */
@WebService
public class TestServiceImpl implements TestServiceInf {

    @Override
    public String ping(String hello) {
        System.out.println("接口调用：" + hello);
        return "pong";
    }
}
