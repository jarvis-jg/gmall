package com.jarvis.gmall.server;

import javax.jws.WebService;

/**
 * gmall : com.jarvis.gmall.server
 *
 * @author jarvis
 * @create 2019-12-15 22:39
 */
@WebService
public interface TestServerInf {

    String ping(String hello);
}
