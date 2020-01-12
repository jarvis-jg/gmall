package com.jarvis.gmall.service;

import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;
import com.jarvis.gmall.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-12-17 20:40
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserAccountMapper userAccountMapper;

    @Override
    public T_MALL_USER_ACCOUNT login(T_MALL_USER_ACCOUNT user) {
//        MyRoutingDataSource.setKey("1");
        return userAccountMapper.select_user(user);
    }

    @Override
    public T_MALL_USER_ACCOUNT login2(T_MALL_USER_ACCOUNT user) {
//        MyRoutingDataSource.setKey("1");
        return userAccountMapper.select_user(user);
    }

    @Override
    public int save_user(T_MALL_USER_ACCOUNT user) {
        return userAccountMapper.insert_user(user);
    }
}
