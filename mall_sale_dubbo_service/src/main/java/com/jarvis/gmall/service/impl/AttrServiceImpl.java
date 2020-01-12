package com.jarvis.gmall.service.impl;

import com.jarvis.gmall.dto.OBJECT_T_MALL_ATTR;
import com.jarvis.gmall.mapper.AttrMapper;
import com.jarvis.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.service.impl
 *
 * @author jarvis
 * @create 2019-12-08 10:53
 */
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    AttrMapper attrMapper;

    @Override
    public List<OBJECT_T_MALL_ATTR> get_attr_list_by(int flbh2) {
        List<OBJECT_T_MALL_ATTR> attr_list = attrMapper.select_attr_list_by(flbh2);
        return attr_list;
    }
}
