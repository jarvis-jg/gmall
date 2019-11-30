package com.jarvis.gmall.service;

import com.jarvis.gmall.entity.T_MALL_SKU;
import com.jarvis.gmall.entity.T_MALL_SKU_ATTR_VALUE;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-11-30 22:42
 */
public interface SkuService {


    void save_sku(T_MALL_SKU sku);

    void save_sku_attr_value(int id, List<T_MALL_SKU_ATTR_VALUE> list_sku_av);
}
