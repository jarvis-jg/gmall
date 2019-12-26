package com.jarvis.gmall.mapper;

import com.jarvis.gmall.dto.OBJECT_T_MALL_FLOW;
import com.jarvis.gmall.dto.OBJECT_T_MALL_ORDER;
import com.jarvis.gmall.entity.T_MALL_FLOW;
import com.jarvis.gmall.entity.T_MALL_ORDER;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-12-24 21:25
 */
public interface OrderMapper {

    void insert_order(T_MALL_ORDER order);

    void insert_flow(T_MALL_FLOW flow);

    void insert_infos(Map<Object, Object> map);

    void delete_carts(@Param("list_cart_id") List<Integer> list_cart_id);

    long select_kc_lock(int sku_id);

    long select_kc(int sku_id);

    int select_count_kc(Map<Object, Object> map);

    void update_order(OBJECT_T_MALL_ORDER order);

    void update_flow(OBJECT_T_MALL_FLOW flow);

    void update_sku(Map<Object, Object> sku_map);
}
