package com.jarvis.gmall.service;

import com.jarvis.gmall.dto.OBJECT_T_MALL_ATTR;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.service
 *
 * @author jarvis
 * @create 2019-12-08 10:53
 */
public interface AttrService {


    List<OBJECT_T_MALL_ATTR> get_attr_list_by(int flbh2);
}
