package com.jarvis.gmall.controller;

import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-12-09 21:58
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(T_MALL_USER_ACCOUNT user){

        return "success";
    }
}
