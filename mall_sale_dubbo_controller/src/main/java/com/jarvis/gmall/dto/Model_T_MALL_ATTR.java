package com.jarvis.gmall.dto;

import java.io.Serializable;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.dto
 *
 * @author jarvis
 * @create 2019-11-27 21:30
 */
public class Model_T_MALL_ATTR implements Serializable {

    private List<OBJECT_T_MALL_ATTR> attr_list;

    public List<OBJECT_T_MALL_ATTR> getAttr_list() {
        return attr_list;
    }

    public void setAttr_list(List<OBJECT_T_MALL_ATTR> attr_list) {
        this.attr_list = attr_list;
    }
}
