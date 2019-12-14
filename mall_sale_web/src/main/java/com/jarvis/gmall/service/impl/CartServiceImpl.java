package com.jarvis.gmall.service.impl;

import com.jarvis.gmall.entity.T_MALL_SHOPPINGCAR;
import com.jarvis.gmall.mapper.CartMapper;
import com.jarvis.gmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * gmall : com.jarvis.gmall.service.impl
 *
 * @author jarvis
 * @create 2019-12-14 18:39
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public boolean if_cart_exists(T_MALL_SHOPPINGCAR cart) {
        int count = cartMapper.select_cart_exists(cart);
        return count != 0;
    }

    @Override
    public void add_cart(T_MALL_SHOPPINGCAR cart) {
        cartMapper.insert_cart(cart);
    }

    @Override
    public void update_cart(T_MALL_SHOPPINGCAR t_mall_shoppingcar) {
        cartMapper.update_cart(t_mall_shoppingcar);
    }
}
