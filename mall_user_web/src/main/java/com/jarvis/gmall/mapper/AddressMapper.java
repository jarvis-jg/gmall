package com.jarvis.gmall.mapper;

import com.jarvis.gmall.entity.T_MALL_ADDRESS;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-12-17 21:24
 */
public interface AddressMapper {

    int insert_address(T_MALL_ADDRESS address);

    T_MALL_ADDRESS select_address(int address_id);

    List<T_MALL_ADDRESS> select_addresses(int user_id);
}
