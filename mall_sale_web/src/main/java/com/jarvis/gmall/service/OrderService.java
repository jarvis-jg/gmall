package com.jarvis.gmall.service;

import com.jarvis.gmall.dto.OBJECT_T_MALL_ORDER;
import com.jarvis.gmall.entity.T_MALL_ADDRESS;
import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;
import com.jarvis.gmall.exception.OverSaleException;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-12-24 21:02
 */
public interface OrderService {

    void save_order(OBJECT_T_MALL_ORDER order, T_MALL_ADDRESS address, T_MALL_USER_ACCOUNT user);

    void pay_success(OBJECT_T_MALL_ORDER order) throws OverSaleException;
}
