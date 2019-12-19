package com.jarvis.gmall.mapper;

import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-11-27 21:38
 */
public interface UserAccountMapper {

    T_MALL_USER_ACCOUNT select_user(T_MALL_USER_ACCOUNT user_account);

    int insert_user(T_MALL_USER_ACCOUNT user);
}
