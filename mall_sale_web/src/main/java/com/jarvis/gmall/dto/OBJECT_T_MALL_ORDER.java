package com.jarvis.gmall.dto;

import com.jarvis.gmall.entity.T_MALL_ORDER;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.dto
 *
 * @author jarvis
 * @create 2019-12-23 20:13
 */
public class OBJECT_T_MALL_ORDER extends T_MALL_ORDER {

    private List<OBJECT_T_MALL_FLOW> list_flow;

    public List<OBJECT_T_MALL_FLOW> getList_flow() {
        return list_flow;
    }

    public void setList_flow(List<OBJECT_T_MALL_FLOW> list_flow) {
        this.list_flow = list_flow;
    }

}
