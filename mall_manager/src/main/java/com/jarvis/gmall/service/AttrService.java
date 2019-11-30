package com.jarvis.gmall.service;

import com.jarvis.gmall.dto.OBJECT_T_MALL_ATTR;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-11-27 21:34
 */
public interface AttrService {

    void save_attrs(int flbh2, List<OBJECT_T_MALL_ATTR> attr_list);


    List<OBJECT_T_MALL_ATTR> get_attr_list(int flbh2);
}
