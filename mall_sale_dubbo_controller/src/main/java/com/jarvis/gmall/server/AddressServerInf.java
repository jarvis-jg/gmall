package com.jarvis.gmall.server;

import com.jarvis.gmall.entity.T_MALL_ADDRESS;
import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;

import javax.jws.WebService;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.server
 *
 * @author jarvis
 * @create 2019-12-17 21:29
 */
@WebService
public interface AddressServerInf {

    List<T_MALL_ADDRESS> getAddresses(T_MALL_USER_ACCOUNT user);

    T_MALL_ADDRESS getAddress(int address_id);

    String addAddress(T_MALL_ADDRESS address);
}
