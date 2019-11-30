package com.jarvis.gmall.mapper;

import com.jarvis.gmall.entity.T_MALL_PRODUCT;

import java.util.List;
import java.util.Map;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-11-23 19:08
 */
public interface SpuMapper {

    void insert_spu(T_MALL_PRODUCT product);

    void insert_images(Map<String, Object> map);

    List<T_MALL_PRODUCT> select_shp_list(Map<Object, Object> map);
}
