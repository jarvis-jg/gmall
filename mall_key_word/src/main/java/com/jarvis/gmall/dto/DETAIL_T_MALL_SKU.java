package com.jarvis.gmall.dto;

import com.jarvis.gmall.entity.T_MALL_PRODUCT;
import com.jarvis.gmall.entity.T_MALL_PRODUCT_IMAGE;
import com.jarvis.gmall.entity.T_MALL_SKU;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.dto
 *
 * @author jarvis
 * @create 2019-12-12 22:59
 */
public class DETAIL_T_MALL_SKU extends T_MALL_SKU {

    private T_MALL_PRODUCT spu;
    private List<T_MALL_PRODUCT_IMAGE> list_image;
    private List<OBJECT_AV_NAME> object_av_list;

    public T_MALL_PRODUCT getSpu() {
        return spu;
    }

    public void setSpu(T_MALL_PRODUCT spu) {
        this.spu = spu;
    }

    public List<T_MALL_PRODUCT_IMAGE> getList_image() {
        return list_image;
    }

    public void setList_image(List<T_MALL_PRODUCT_IMAGE> list_image) {
        this.list_image = list_image;
    }

    public List<OBJECT_AV_NAME> getObject_av_list() {
        return object_av_list;
    }

    public void setObject_av_list(List<OBJECT_AV_NAME> object_av_list) {
        this.object_av_list = object_av_list;
    }
}
