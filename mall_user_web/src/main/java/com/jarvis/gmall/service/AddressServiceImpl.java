package com.jarvis.gmall.service;

import com.jarvis.gmall.entity.T_MALL_ADDRESS;
import com.jarvis.gmall.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-12-17 21:22
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public int save_address(T_MALL_ADDRESS address) {
        return addressMapper.insert_address(address);
    }

    @Override
    public T_MALL_ADDRESS get_address(T_MALL_ADDRESS address) {
        return addressMapper.select_address(address);
    }

}
