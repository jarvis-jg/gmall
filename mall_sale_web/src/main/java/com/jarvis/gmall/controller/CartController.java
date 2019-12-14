package com.jarvis.gmall.controller;

import com.jarvis.gmall.entity.T_MALL_SHOPPINGCAR;
import com.jarvis.gmall.service.CartService;
import com.jarvis.gmall.util.MyJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-12-13 22:16
 */
@Controller
public class CartController {

    @Autowired
    CartService cartService;

    /**
     * 1、浏览器本地购物车数据
     *      用户未登录时针对cookie操作
     *      list_cart_cookie
     *
     * 2、服务器持久层购物车数据
     *      用户登陆时针对db操作
     *      list_cart_db
     *
     * 3、服务器缓存中的购物车数据
     *      用户登陆时购物车查询，使用缓存{redis/session}
     *      list_cart_session
     *
     * @param cart
     * @param map
     * @return
     */
    @RequestMapping("/add_cart")
    public String add_cart(HttpSession session, HttpServletResponse response, @CookieValue(value="list_cart_cookie",required = false) String cart_cookie, T_MALL_SHOPPINGCAR cart, ModelMap map){

       List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<>();

        int yh_id = cart.getYh_id();
        if (yh_id == 0){
            //未登录
            if (StringUtils.isEmpty(cart_cookie)){
                list_cart.add(cart);

            }else {
                list_cart = MyJsonUtil.json_to_list(cart_cookie, T_MALL_SHOPPINGCAR.class);

                boolean b = if_new_cart(cart, list_cart);
                if (b){
                    list_cart.add(cart);
                }else {
                    for (int i = 0; i < list_cart.size(); i++){
                        T_MALL_SHOPPINGCAR tmp_cart = list_cart.get(i);
                        //如果购物车有该商品
                        if (tmp_cart.getSku_id() == cart.getSku_id()){
                            tmp_cart.setTjshl(tmp_cart.getTjshl() + 1);
                            tmp_cart.setHj(tmp_cart.getSku_jg() * tmp_cart.getTjshl());
                        }
                    }
                }
            }

            String list_cart_cookie = MyJsonUtil.list_to_json(list_cart);
            Cookie cookie = new Cookie("list_cart_cookie",list_cart_cookie);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);

        }else {
            //已登陆【正常思路把上面的cookie改成session】
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");

            //1、查询数据库中有没有该cart
            boolean b = cartService.if_cart_exists(cart);
            if (!b){
                //2、没有就添加
                cartService.add_cart(cart);
                if (list_cart == null || list_cart.isEmpty()){
                    list_cart = new ArrayList<>();
                    list_cart.add(cart);
                    session.setAttribute("list_cart_session",list_cart);
                }else {
                    list_cart.add(cart);
                }
            }else {

                for (int i = 0; i < list_cart.size(); i++){
                    T_MALL_SHOPPINGCAR tmp_cart = list_cart.get(i);
                    //3、有就更新
                    if (tmp_cart.getSku_id() == cart.getSku_id()){
                        tmp_cart.setTjshl(tmp_cart.getTjshl() + 1);
                        tmp_cart.setHj(tmp_cart.getSku_jg() * tmp_cart.getTjshl());
                        cartService.update_cart(list_cart.get(i));
                    }
                }
            }
        }

        return "redirect:/cart_success.do";
    }

    private boolean if_new_cart(T_MALL_SHOPPINGCAR cart, List<T_MALL_SHOPPINGCAR> list_cart) {
        for (T_MALL_SHOPPINGCAR tmp_cart : list_cart) {
            if (tmp_cart.getSku_id() == cart.getSku_id()){
                return false;
            }
        }
        return true;
    }

    @RequestMapping("/cart_success")
    public String cart_success(){

        return "cartSuccess";
    }
}
