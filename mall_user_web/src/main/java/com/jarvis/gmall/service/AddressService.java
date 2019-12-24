package com.jarvis.gmall.service;

import com.jarvis.gmall.entity.T_MALL_ADDRESS;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-12-17 21:21
 */
public interface AddressService {

    int save_address(T_MALL_ADDRESS address);

    List<T_MALL_ADDRESS> getAddresses(int id);

    T_MALL_ADDRESS getAddress(int address_id);
}
