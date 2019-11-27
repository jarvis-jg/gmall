package com.jarvis.gmall.service.impl;

import com.jarvis.gmall.entity.T_MALL_PRODUCT;
import com.jarvis.gmall.mapper.SpuMapper;
import com.jarvis.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * gmall : com.jarvis.gmall.service.impl
 *
 * @author jarvis
 * @create 2019-11-23 19:02
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    SpuMapper spuMapper;


    @Override
    public void save_spu(List<String> image_list, T_MALL_PRODUCT product, int fm_id) {
        product.setShp_tp(image_list.get(fm_id));
        spuMapper.insert_spu(product);

        Map<String, Object> map = new HashMap<>();
        map.put("shp_id", product.getId());
        map.put("image_list", image_list);
        spuMapper.insert_images(map);
    }
}
