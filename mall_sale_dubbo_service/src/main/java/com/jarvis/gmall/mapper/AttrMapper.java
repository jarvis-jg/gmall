package com.jarvis.gmall.mapper;

import com.jarvis.gmall.dto.OBJECT_T_MALL_ATTR;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-12-08 10:55
 */
public interface AttrMapper {

    List<OBJECT_T_MALL_ATTR> select_attr_list_by(int flbh2);

}
