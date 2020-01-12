package com.jarvis.gmall.service;

import com.jarvis.gmall.dto.DETAIL_T_MALL_SKU;
import com.jarvis.gmall.entity.T_MALL_SKU;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-12-12 23:09
 */
public interface ItemService {

    DETAIL_T_MALL_SKU get_sku_detail(int sku_id);

    List<T_MALL_SKU> get_sku_list(int spu_id);
}
