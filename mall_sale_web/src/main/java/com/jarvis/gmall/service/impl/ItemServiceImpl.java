package com.jarvis.gmall.service.impl;

import com.jarvis.gmall.dto.DETAIL_T_MALL_SKU;
import com.jarvis.gmall.entity.T_MALL_SKU;
import com.jarvis.gmall.mapper.ItemMapper;
import com.jarvis.gmall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.service.impl
 *
 * @author jarvis
 * @create 2019-12-12 23:10
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Override
    public DETAIL_T_MALL_SKU get_sku_detail(int sku_id) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("sku_id", sku_id);
        DETAIL_T_MALL_SKU detail_t_mall_sku = itemMapper.select_sku_detail(map);
        return detail_t_mall_sku;
    }

    @Override
    public List<T_MALL_SKU> get_sku_list(int spu_id) {
        return itemMapper.select_sku_list(spu_id);
    }
}
