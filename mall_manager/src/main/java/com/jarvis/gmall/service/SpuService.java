package com.jarvis.gmall.service;

import com.jarvis.gmall.entity.T_MALL_PRODUCT;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-11-23 19:01
 */
public interface SpuService {

    void save_spu(List<String> image_list, T_MALL_PRODUCT product, int fm_id);
}
