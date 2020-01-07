package com.jarvis.gmall.dto;

import com.jarvis.gmall.entity.T_MALL_ATTR;
import com.jarvis.gmall.entity.T_MALL_VALUE;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.dto
 *
 * @author jarvis
 * @create 2019-11-27 21:12
 */
public class OBJECT_T_MALL_ATTR extends T_MALL_ATTR {

    private List<T_MALL_VALUE> value_list;

    public List<T_MALL_VALUE> getValue_list() {
        return value_list;
    }

    public void setValue_list(List<T_MALL_VALUE> value_list) {
        this.value_list = value_list;
    }
}
