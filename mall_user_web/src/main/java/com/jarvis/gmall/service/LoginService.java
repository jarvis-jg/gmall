package com.jarvis.gmall.service;

import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-12-17 20:39
 */
public interface LoginService {

    T_MALL_USER_ACCOUNT login(T_MALL_USER_ACCOUNT user);

    int save_user(T_MALL_USER_ACCOUNT user);
}
