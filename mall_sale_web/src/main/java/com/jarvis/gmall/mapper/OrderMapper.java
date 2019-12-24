package com.jarvis.gmall.mapper;

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
}
