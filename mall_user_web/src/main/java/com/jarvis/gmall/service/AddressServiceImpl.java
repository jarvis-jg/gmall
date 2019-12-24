package com.jarvis.gmall.service;

import com.jarvis.gmall.entity.T_MALL_ADDRESS;
import com.jarvis.gmall.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<T_MALL_ADDRESS> getAddresses(int user_id) {
        return addressMapper.select_addresses(user_id);
    }

    @Override
    public T_MALL_ADDRESS getAddress(int address_id) {
        return addressMapper.select_address(address_id);
    }


}
