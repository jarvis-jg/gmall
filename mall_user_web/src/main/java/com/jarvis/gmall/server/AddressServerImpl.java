package com.jarvis.gmall.server;

import com.google.gson.Gson;
import com.jarvis.gmall.entity.T_MALL_ADDRESS;
import com.jarvis.gmall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;

/**
 * gmall : com.jarvis.gmall.server
 *
 * @author jarvis
 * @create 2019-12-17 21:30
 */
public class AddressServerImpl implements AddressServerInf {

    @Autowired
    AddressService addressService;


    @Override
    @Path("/getAddress")
    @GET
    @Consumes("/application/x-www-form-urlencoded")
    @Produces("/application/json")
    public String getAddress(@BeanParam T_MALL_ADDRESS address) {
        T_MALL_ADDRESS addr = addressService.get_address(address);
        Gson gson = new Gson();
        return gson.toJson(addr);
    }

    @Override
    @Path("/addAddress")
    @GET
    @Consumes("/application/x-www-form-urlencoded")
    @Produces("/application/json")
    public String addAddress(@BeanParam T_MALL_ADDRESS address) {
        int result = addressService.save_address(address);
        return result == 1 ? "success" : "fail";
    }
}
