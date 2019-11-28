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
 * @create 2019-11-27 21:35
 */
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private AttrMapper attrMapper;

    @Override
    public void save_attrs(int flbh2, List<OBJECT_T_MALL_ATTR> attr_list) {
        for (OBJECT_T_MALL_ATTR attr : attr_list) {
            attrMapper.insert_attr(flbh2,attr);

            attrMapper.insert_values(attr.getId(),attr.getValue_list());
        }

    }
}
