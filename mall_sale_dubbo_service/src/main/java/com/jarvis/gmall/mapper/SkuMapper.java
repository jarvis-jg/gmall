package com.jarvis.gmall.mapper;

import com.jarvis.gmall.dto.OBJECT_T_MALL_SKU;

import java.util.List;
import java.util.Map;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-12-08 11:26
 */
public interface SkuMapper {

    List<OBJECT_T_MALL_SKU> select_sku_list_by(int flbh2);

    List<OBJECT_T_MALL_SKU> select_list_by_attr(Map<Object,Object> map);
}
