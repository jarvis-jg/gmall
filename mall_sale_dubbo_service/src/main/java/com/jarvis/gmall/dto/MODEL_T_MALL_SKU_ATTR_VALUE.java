package com.jarvis.gmall.dto;

import com.jarvis.gmall.entity.T_MALL_SKU_ATTR_VALUE;

import java.io.Serializable;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.dto
 *
 * @author jarvis
 * @create 2019-11-30 21:41
 */
public class MODEL_T_MALL_SKU_ATTR_VALUE implements Serializable {

    List<T_MALL_SKU_ATTR_VALUE> list_sku_av;

    public List<T_MALL_SKU_ATTR_VALUE> getList_sku_av() {
        return list_sku_av;
    }

    public void setList_sku_av(List<T_MALL_SKU_ATTR_VALUE> list_sku_av) {
        this.list_sku_av = list_sku_av;
    }
}
