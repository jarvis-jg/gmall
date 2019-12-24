package com.jarvis.gmall.controller;

import com.jarvis.gmall.dto.OBJECT_T_MALL_FLOW;
import com.jarvis.gmall.dto.OBJECT_T_MALL_ORDER;
import com.jarvis.gmall.entity.T_MALL_ADDRESS;
import com.jarvis.gmall.entity.T_MALL_ORDER_INFO;
import com.jarvis.gmall.entity.T_MALL_SHOPPINGCAR;
import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;
import com.jarvis.gmall.server.AddressServerInf;
import com.jarvis.gmall.service.CartService;
import com.jarvis.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-12-23 19:28
 */
@Controller
@SessionAttributes("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

    @Autowired
    AddressServerInf addressService;

    @RequestMapping("/save_order")
    public String save_order(int address_id,HttpSession session,@ModelAttribute("order") OBJECT_T_MALL_ORDER order,ModelMap map){
        T_MALL_ADDRESS address = null;
        T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");

        try {
            address = addressService.getAddress(address_id);
        } catch (Exception e) {
            e.printStackTrace();
            return "addressError";
        }

        orderService.save_order(order,address,user);

        //同步session
        session.setAttribute("list_cart_session",cartService.get_cart_by_user(user));
        return "null";
    }

    @RequestMapping("/goto_checkOrder")
    public String goto_checkOrder(HttpSession session, ModelMap map){
        T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<>();

        if (user == null){
            return "redirect:/to_login_check.do";
        }else{
            //将选中的购物车的sku封装为order对象，以便保存订单时使用
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
            OBJECT_T_MALL_ORDER order = new OBJECT_T_MALL_ORDER();

            //1、因为set是不重复，无序的，这里就能取到去重的所有库存地址
            Set<String> kcdz_set =  new HashSet<>();
            for (T_MALL_SHOPPINGCAR cart : list_cart) {
                if (Objects.equals("1",cart.getShfxz())){
                    kcdz_set.add(cart.getKcdz());
                }
            }

            //2、根据库存地址拆单【物流拆单】
            Iterator<String> it = kcdz_set.iterator();
            List<OBJECT_T_MALL_FLOW> list_flow = new ArrayList<>();
            while (it.hasNext()){
                String kcdz = it.next();
                OBJECT_T_MALL_FLOW flow = new OBJECT_T_MALL_FLOW();
                //设置flow的信息
                flow.setYh_id(user.getId());
                flow.setMqdd("商品未出库");
                flow.setPsfsh("硅谷快递");

                List<T_MALL_ORDER_INFO> list_info = new ArrayList<>();
                for (T_MALL_SHOPPINGCAR cart : list_cart) {
                    if (Objects.equals("1",cart.getShfxz()) && Objects.equals(kcdz,cart.getKcdz())){
                        T_MALL_ORDER_INFO info = new T_MALL_ORDER_INFO();
                        //设置info的信息
                        info.setGwch_id(cart.getId());
                        info.setShp_tp(cart.getShp_tp());
                        info.setSku_id(cart.getSku_id());
                        info.setSku_jg(cart.getSku_jg());
                        info.setSku_kcdz(cart.getKcdz());
                        info.setSku_mch(cart.getSku_mch());
                        info.setSku_shl(cart.getTjshl());

                        list_info.add(info);
                    }
                }
                flow.setList_info(list_info);
                list_flow.add(flow);
            }

            List<T_MALL_ADDRESS> list_address = null;
            try {
                list_address = addressService.getAddresses(user);
            } catch (Exception e) {
                e.printStackTrace();
                return "addressError";
            }


            order.setList_flow(list_flow);
            order.setZje(get_sum(list_cart));
            map.put("order", order);
            map.put("list_address", list_address);
            map.put("hj",get_sum(list_cart));
        }
        return "checkOrder";
    }

    private BigDecimal get_sum(List<T_MALL_SHOPPINGCAR> list_cart) {
        BigDecimal sum = new BigDecimal("0");
        if (list_cart == null || list_cart.isEmpty()){
            return sum;
        }

        for (T_MALL_SHOPPINGCAR cart : list_cart) {
            if (cart.getShfxz().equals("1")){
                sum = sum.add(new BigDecimal(cart.getHj() + ""));
            }
        }
        return sum;
    }
}
