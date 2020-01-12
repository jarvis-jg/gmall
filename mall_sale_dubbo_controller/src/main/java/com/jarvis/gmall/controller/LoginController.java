package com.jarvis.gmall.controller;

import com.jarvis.gmall.entity.T_MALL_SHOPPINGCAR;
import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;
import com.jarvis.gmall.server.LoginServerInf;
import com.jarvis.gmall.server.TestServerInf;
import com.jarvis.gmall.service.CartService;
import com.jarvis.gmall.util.MyJsonUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-12-04 21:48
 */
@Controller
public class LoginController {

//    @Autowired
//    UserAccountMapper userAccountMapper;

    @Autowired
    CartService cartService;

    @Autowired
    LoginServerInf loginService;

    @Autowired
    TestServerInf testService;

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ActiveMQQueue queueDestination;

    @RequestMapping("/goto_logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/to_login.do";
    }




    @RequestMapping("/login")
    public String login(@CookieValue(value="list_cart_cookie",required = false) String cart_cookie, T_MALL_USER_ACCOUNT user_account, String datasource_type, @RequestParam(value = "redirect_url",required = false) String redirect_url, HttpSession session, HttpServletResponse response){

//        JaxWsProxyFactoryBean jwfb = new JaxWsProxyFactoryBean();
//        jwfb.setAddress(MyPropertyUtil.getProperty("ws.properties","login_url"));
//        jwfb.setServiceClass(LoginServerInf.class);
//
//        LoginServerInf loginService = (LoginServerInf) jwfb.create();
//        String user_json = loginService.login(user_account);
        String user_json = "";
        if ("1".equals(datasource_type)){
            user_json = loginService.login(user_account);
        }else if ("2".equals(datasource_type)){
            user_json = loginService.login2(user_account);
        }
        testService.ping("hello");
        T_MALL_USER_ACCOUNT select_user = MyJsonUtil.json_to_object(user_json, T_MALL_USER_ACCOUNT.class);

//        T_MALL_USER_ACCOUNT select_user = userAccountMapper.select_user(user_account);
        if (select_user == null) {
            return "redirect:to_login.do";
        }else {

            try {
                //发送日志消息
                final String message = select_user.getId() + "|" + select_user.getYh_mch() + "|" + "|登陆";
                jmsTemplate.send(queueDestination, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage(message);
                    }
                });
            } catch (JmsException e) {
                e.printStackTrace();
            }

            try {
                session.setAttribute("user",select_user);
                Cookie cookie = new Cookie("yh_mch", URLEncoder.encode(select_user.getYh_mch(),"UTF-8"));
                cookie.setPath("/");
                cookie.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // 同步购物车
            combine_cart(select_user,session,response,cart_cookie);

        }

        if (redirect_url != null){
            return "redirect:/" + redirect_url;
        }else{
            return "redirect:/index.do";
        }
    }

    private void combine_cart(T_MALL_USER_ACCOUNT select_user, HttpSession session, HttpServletResponse response, String cart_cookie) {
        List<T_MALL_SHOPPINGCAR> list_cart_cookie = new ArrayList<>();

        if (StringUtils.isEmpty(cart_cookie)){
            //直接就结束了
        }else {
            list_cart_cookie = MyJsonUtil.json_to_list(cart_cookie, T_MALL_SHOPPINGCAR.class);
            List<T_MALL_SHOPPINGCAR> list_cart_db = cartService.get_cart_by_user(select_user);
            //如果db的购物车为空，则添加
//            if (list_cart_db == null || list_cart_db.isEmpty()){
//                for (int i = 0; i < list_cart_cookie.size(); i++) {
//                    list_cart_cookie.get(i).setYh_id(select_user.getId());
//                    cartService.add_cart(list_cart_cookie.get(i));
//                }
//            }else {
//                for (int i = 0; i < list_cart_cookie.size(); i++) {
//                    boolean b = if_new_cart(list_cart_cookie.get(i), list_cart_db);
//                    if (b){
//                        //如果没有与db的cart重复，就添加
//                        list_cart_cookie.get(i).setYh_id(select_user.getId());
//                        cartService.add_cart(list_cart_cookie.get(i));
//                    }else {
//                        //重复就更新
//                        T_MALL_SHOPPINGCAR cart = list_cart_cookie.get(i);
//                        for (int j = 0; j < list_cart_db.size(); j++) {
//                            if (cart.getSku_id() == list_cart_db.get(j).getSku_id()){
//                                list_cart_db.get(j).setTjshl(cart.getTjshl() + list_cart_db.get(j).getTjshl());
//                                list_cart_db.get(j).setHj(list_cart_db.get(j).getTjshl() * list_cart_db.get(j).getSku_jg());
//                                cartService.update_cart(list_cart_db.get(j));
//                            }
//                        }
//                    }
//                }
//            }
            //优化后代码
            for (int i = 0; i < list_cart_cookie.size(); i++) {
                T_MALL_SHOPPINGCAR cart = list_cart_cookie.get(i);
                boolean b = cartService.if_cart_exists(cart);
                if (!b){
                    //db的cart中没有，就添加
                    list_cart_cookie.get(i).setYh_id(select_user.getId());
                    cartService.add_cart(list_cart_cookie.get(i));
                }else {
                    for (int j = 0; j < list_cart_db.size(); j++) {
                        if (cart.getSku_id() == list_cart_db.get(j).getSku_id()){
                            list_cart_db.get(j).setTjshl(cart.getTjshl() + list_cart_db.get(j).getTjshl());
                            list_cart_db.get(j).setHj(list_cart_db.get(j).getTjshl() * list_cart_db.get(j).getSku_jg());
                            cartService.update_cart(list_cart_db.get(j));
                        }
                    }
                }
            }
        }
        //清空cookie，更新session
        Cookie cookie = new Cookie("list_cart_cookie", "");
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        session.setAttribute("list_cart_session",cartService.get_cart_by_user(select_user));

    }

    private boolean if_new_cart(T_MALL_SHOPPINGCAR cart, List<T_MALL_SHOPPINGCAR> list_cart) {
        for (T_MALL_SHOPPINGCAR tmp_cart : list_cart) {
            if (tmp_cart.getSku_id() == cart.getSku_id()){
                return false;
            }
        }
        return true;
    }
}
