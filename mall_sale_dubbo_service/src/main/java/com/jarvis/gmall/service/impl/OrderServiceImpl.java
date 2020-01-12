package com.jarvis.gmall.service.impl;

import com.jarvis.gmall.dto.OBJECT_T_MALL_FLOW;
import com.jarvis.gmall.dto.OBJECT_T_MALL_ORDER;
import com.jarvis.gmall.entity.T_MALL_ADDRESS;
import com.jarvis.gmall.entity.T_MALL_ORDER_INFO;
import com.jarvis.gmall.entity.T_MALL_USER_ACCOUNT;
import com.jarvis.gmall.exception.OverSaleException;
import com.jarvis.gmall.mapper.OrderMapper;
import com.jarvis.gmall.service.OrderService;
import com.jarvis.gmall.util.MyDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        //删除对应购物车信息
        orderMapper.delete_carts(list_cart_id);
    }

    @Override
    public void pay_success(OBJECT_T_MALL_ORDER order) throws OverSaleException {
        //1、修改订单状态、信息
        order.setJdh(2);
        orderMapper.update_order(order);

        List<OBJECT_T_MALL_FLOW> list_flow = order.getList_flow();
        for (OBJECT_T_MALL_FLOW flow : list_flow) {
            //2、修改物流信息
            flow.setPsshj(MyDateUtil.getDate(Calendar.DATE,1));
            flow.setPsmsh("商品正在出库");
            flow.setYwy("老佟");
            flow.setLxfsh("13413413413");
            orderMapper.update_flow(flow);

            List<T_MALL_ORDER_INFO> list_info = flow.getList_info();
            for (T_MALL_ORDER_INFO info : list_info) {

                Map<Object, Object> map = new HashMap<>();
                map.put("sku_id", info.getSku_id());
                map.put("limit", 10);
                int count = orderMapper.select_count_kc(map);

                long kc = getKc(info.getSku_id(), count);

                if (kc >= info.getSku_shl()){
                    //正常购买
                    //3、减库存（修改sku数量和销量等信息）
                    Map<Object, Object> sku_map = new HashMap<>();
                    sku_map.put("sku_id", info.getSku_id());
                    sku_map.put("sku_shl", info.getSku_shl());
                    orderMapper.update_sku(sku_map);
                }else {
                    throw new OverSaleException("over sale");
                }

            }
        }

        //4、修改订单状态--》出库
        order.setJdh(3);
        order.setYjsdshj(MyDateUtil.getDate(Calendar.DATE,5));
        orderMapper.update_order(order);
    }

    private long getKc(long sku_id, int count) {
        long kc;
        Map map = new HashMap<>();
        map.put("sku_id", sku_id);
        map.put("count", count);

        kc = orderMapper.select_kc(map);
//        if (count == 0){
//            //带锁
//            kc = orderMapper.select_kc_lock(info.getSku_id());
//        }else {
//            //不带锁【库存还多】
//            kc = orderMapper.select_kc(info.getSku_id());
//        }
        return kc;
    }
}
