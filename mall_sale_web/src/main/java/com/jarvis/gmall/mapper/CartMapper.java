package com.jarvis.gmall.mapper;

import com.jarvis.gmall.entity.T_MALL_SHOPPINGCAR;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-12-14 18:44
 */
public interface CartMapper {

    int select_cart_exists(T_MALL_SHOPPINGCAR cart);

    void insert_cart(T_MALL_SHOPPINGCAR cart);

    void update_cart(T_MALL_SHOPPINGCAR t_mall_shoppingcar);
}
