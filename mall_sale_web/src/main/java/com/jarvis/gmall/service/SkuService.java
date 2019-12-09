package com.jarvis.gmall.service;

import com.jarvis.gmall.dto.OBJECT_T_MALL_SKU;
import com.jarvis.gmall.entity.T_MALL_SKU_ATTR_VALUE;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-12-08 11:24
 */
public interface SkuService {

    List<OBJECT_T_MALL_SKU> get_sku_list_by(int flbh2);

    List<OBJECT_T_MALL_SKU> get_list_by_attr(List<T_MALL_SKU_ATTR_VALUE> list_sku_av, int flbh2);
}
