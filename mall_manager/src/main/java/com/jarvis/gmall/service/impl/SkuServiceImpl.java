package com.jarvis.gmall.service.impl;

import com.jarvis.gmall.entity.T_MALL_SKU;
import com.jarvis.gmall.entity.T_MALL_SKU_ATTR_VALUE;
import com.jarvis.gmall.mapper.SkuMapper;
import com.jarvis.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * gmall : com.jarvis.gmall.service.impl
 *
 * @author jarvis
 * @create 2019-11-30 22:44
 */
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuMapper skuMapper;

    @Override
    public void save_sku(T_MALL_SKU sku) {
        skuMapper.insert_sku(sku);
    }

    @Override
    public void save_sku_attr_value(int sku_id, List<T_MALL_SKU_ATTR_VALUE> list_sku_av) {
        //过滤list_sku_av，去掉空值
        Iterator<T_MALL_SKU_ATTR_VALUE> iterator = list_sku_av.iterator();
        while (iterator.hasNext()){
            T_MALL_SKU_ATTR_VALUE sku_av = iterator.next();
            if (sku_av.getShxm_id() == 0){
               iterator.remove();
            }
        }

        Map<Object, Object> map = new HashMap<>();
        map.put("sku_id", sku_id);
        map.put("list_sku_av", list_sku_av);
        skuMapper.insert_sku_attr_value(map);
    }
}
