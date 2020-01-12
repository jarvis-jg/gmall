package com.jarvis.gmall.server;

import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;

import javax.jws.WebService;

/**
 * gmall : com.jarvis.gmall.server
 *
 * @author jarvis
 * @create 2019-12-17 20:36
 */
@WebService
public interface LoginServerInf {

    String login(T_MALL_USER_ACCOUNT user);

    String login2(T_MALL_USER_ACCOUNT user);

    String register(T_MALL_USER_ACCOUNT user);
}
