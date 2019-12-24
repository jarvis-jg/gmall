package com.jarvis.gmall.dto;

import com.jarvis.gmall.entity.T_MALL_FLOW;
import com.jarvis.gmall.entity.T_MALL_ORDER_INFO;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.dto
 *
 * @author jarvis
 * @create 2019-12-23 20:14
 */
public class OBJECT_T_MALL_FLOW extends T_MALL_FLOW {

    private List<T_MALL_ORDER_INFO> list_info;

    public List<T_MALL_ORDER_INFO> getList_info() {
        return list_info;
    }

    public void setList_info(List<T_MALL_ORDER_INFO> list_info) {
        this.list_info = list_info;
    }
}
