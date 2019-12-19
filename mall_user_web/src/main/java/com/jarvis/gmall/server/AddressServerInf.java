package com.jarvis.gmall.server;

import com.jarvis.gmall.entity.T_MALL_ADDRESS;

import javax.jws.WebService;

/**
 * gmall : com.jarvis.gmall.server
 *
 * @author jarvis
 * @create 2019-12-17 21:29
 */
@WebService
public interface AddressServerInf {

    String getAddress(T_MALL_ADDRESS address);

    String addAddress(T_MALL_ADDRESS address);
}
