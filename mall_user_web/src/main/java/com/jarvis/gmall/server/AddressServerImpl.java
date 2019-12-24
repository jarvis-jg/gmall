package com.jarvis.gmall.server;

import com.jarvis.gmall.entity.T_MALL_ADDRESS;
import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;
import com.jarvis.gmall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
    @Path("/getAddresses")
    @GET
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public List<T_MALL_ADDRESS> getAddresses(@BeanParam T_MALL_USER_ACCOUNT user) {
        return addressService.getAddresses(user.getId());
    }

    @Override
    @Path("/getAddress")
    @GET
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public T_MALL_ADDRESS getAddress(@QueryParam("address_id") int address_id) {
        return addressService.getAddress(address_id);
    }

    @Override
    @Path("/addAddress")
    @GET
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public String addAddress(@BeanParam T_MALL_ADDRESS address) {
        int result = addressService.save_address(address);
        return result == 1 ? "success" : "fail";
    }
}
