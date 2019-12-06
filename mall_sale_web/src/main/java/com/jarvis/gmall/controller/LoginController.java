package com.jarvis.gmall.controller;

import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;
import com.jarvis.gmall.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-12-04 21:48
 */
@Controller
public class LoginController {

    @Autowired
    UserAccountMapper userAccountMapper;


    @RequestMapping("/login")
    public String login(T_MALL_USER_ACCOUNT user_account,HttpSession session, HttpServletResponse response){
        T_MALL_USER_ACCOUNT select_user = userAccountMapper.select_user(user_account);
        if (select_user == null) {

            return "redirect:to_login.do";
        }else {
            session.setAttribute("user",select_user);
            Cookie cookie = new Cookie("yh_mch",select_user.getYh_mch());
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
        }
        return "redirect:/index.do";
    }
}
