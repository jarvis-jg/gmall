package com.jarvis.gmall.mapper;

import com.jarvis.gmall.dto.DETAIL_T_MALL_SKU;
import com.jarvis.gmall.entity.T_MALL_SKU;

import java.util.HashMap;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-12-12 23:12
 */
public interface ItemMapper {

    DETAIL_T_MALL_SKU select_sku_detail(HashMap<Object, Object> map);

    List<T_MALL_SKU> select_sku_list(int spu_id);
}
