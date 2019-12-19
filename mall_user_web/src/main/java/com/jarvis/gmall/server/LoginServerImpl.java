package com.jarvis.gmall.server;

import com.google.gson.Gson;
import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;
import com.jarvis.gmall.service.LoginService;
import com.jarvis.gmall.util.MyRoutingDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;

/**
 * gmall : com.jarvis.gmall.server
 *
 * @author jarvis
 * @create 2019-12-17 20:36
 */
public class LoginServerImpl implements LoginServerInf {

    @Autowired
    LoginService loginService;

    @Override
    @Path("/login")
    @GET
    @Consumes("/application/x-www-form-urlencoded")
    @Produces("/application/json")
    public String login(@BeanParam T_MALL_USER_ACCOUNT user) {
        MyRoutingDataSource.setKey("1");
        T_MALL_USER_ACCOUNT select_user = loginService.login(user);
        Gson gson = new Gson();
        return gson.toJson(select_user);
    }

    @Override
    @Path("/login2")
    @GET
    @Consumes("/application/x-www-form-urlencoded")
    @Produces("/application/json")
    public String login2(@BeanParam T_MALL_USER_ACCOUNT user) {
        MyRoutingDataSource.setKey("2");
        T_MALL_USER_ACCOUNT select_user = loginService.login(user);
        Gson gson = new Gson();
        return gson.toJson(select_user);
    }


    @Override
    @Path("/register")
    @GET
    @Consumes("/application/x-www-form-urlencoded")
    @Produces("/application/json")
    public String register(@BeanParam T_MALL_USER_ACCOUNT user){
        int result = loginService.save_user(user);
        return result == 1 ? "success" : "fail";
    }
}
