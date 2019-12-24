package com.jarvis.gmall.service.impl;

import com.jarvis.gmall.dto.OBJECT_T_MALL_FLOW;
import com.jarvis.gmall.dto.OBJECT_T_MALL_ORDER;
import com.jarvis.gmall.entity.T_MALL_ADDRESS;
import com.jarvis.gmall.entity.T_MALL_ORDER_INFO;
import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;
import com.jarvis.gmall.mapper.OrderMapper;
import com.jarvis.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.service.impl
 *
 * @author jarvis
 * @create 2019-12-24 21:20
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;



    public void delete_carts(List<T_MALL_ORDER_INFO> list_info) {

    }

    @Override
    public void save_order(OBJECT_T_MALL_ORDER order, T_MALL_ADDRESS address, T_MALL_USER_ACCOUNT user) {
        //1、保存订单
        order.setYh_id(user.getId());
        order.setDzh_id(address.getId());
        order.setDzh_mch(address.getDz_mch());
        order.setJdh(1);
        order.setShhr(address.getShjr());
        orderMapper.insert_order(order);

        List<OBJECT_T_MALL_FLOW> list_flow = order.getList_flow();
        List<Integer> list_cart_id = new ArrayList<>();
        for (OBJECT_T_MALL_FLOW flow : list_flow) {
            //2、保存物流
            flow.setDd_id(order.getId());
            flow.setMdd(address.getDz_mch());
            orderMapper.insert_flow(flow);

            //3、保存订单详情
            List<T_MALL_ORDER_INFO> list_info = flow.getList_info();
            HashMap<Object, Object> map = new HashMap<>();
            map.put("dd_id", order.getId());
            map.put("list_info", list_info);
            map.put("flow_id", flow.getId());
            orderMapper.insert_infos(map);


            for (T_MALL_ORDER_INFO info : list_info) {
                list_cart_id.add(info.getGwch_id());
            }
        }
        orderMapper.delete_carts(list_cart_id);
    }
}
