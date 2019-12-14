package com.jarvis.gmall.service;

import com.jarvis.gmall.entity.T_MALL_SHOPPINGCAR;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-12-14 18:33
 */
public interface CartService {

    boolean if_cart_exists(T_MALL_SHOPPINGCAR cart);

    void add_cart(T_MALL_SHOPPINGCAR cart);

    void update_cart(T_MALL_SHOPPINGCAR t_mall_shoppingcar);
}
