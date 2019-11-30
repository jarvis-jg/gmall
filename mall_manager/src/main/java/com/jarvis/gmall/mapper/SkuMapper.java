package com.jarvis.gmall.mapper;

import com.jarvis.gmall.entity.T_MALL_SKU;

import java.util.Map;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-11-30 22:45
 */
public interface SkuMapper {

    void insert_sku(T_MALL_SKU sku);

    void insert_sku_attr_value(Map<Object, Object> map);
}
