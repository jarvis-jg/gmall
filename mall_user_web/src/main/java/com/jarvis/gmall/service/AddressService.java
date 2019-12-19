package com.jarvis.gmall.service;

import com.jarvis.gmall.entity.T_MALL_ADDRESS;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-12-17 21:21
 */
public interface AddressService {

    int save_address(T_MALL_ADDRESS address);

    T_MALL_ADDRESS get_address(T_MALL_ADDRESS address);

}
