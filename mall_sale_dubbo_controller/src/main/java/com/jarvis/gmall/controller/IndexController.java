package com.jarvis.gmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * gmall : gmall.controller
 *
 * @author jarvis
 * @create 2019-12-04 23:19
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){

        return "index";
    }

    @RequestMapping("/to_login")
    public String to_login(){
        return "login";
    }

    @RequestMapping("/to_login_check")
    public String to_login_check(){
        return "loginOrder";
    }
}
