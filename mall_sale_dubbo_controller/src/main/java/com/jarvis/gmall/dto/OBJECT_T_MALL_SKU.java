package com.jarvis.gmall.dto;

import com.jarvis.gmall.entity.T_MALL_PRODUCT;
import com.jarvis.gmall.entity.T_MALL_SKU;
import com.jarvis.gmall.entity.T_MALL_TRADE_MARK;

import java.io.Serializable;

/**
 * gmall : com.jarvis.gmall.dto
 *
 * @author jarvis
 * @create 2019-12-08 11:18
 */
public class OBJECT_T_MALL_SKU extends T_MALL_SKU implements Serializable {

    private T_MALL_PRODUCT product;
    private T_MALL_TRADE_MARK tm;

    public T_MALL_PRODUCT getProduct() {
        return product;
    }

    public void setProduct(T_MALL_PRODUCT product) {
        this.product = product;
    }

    public T_MALL_TRADE_MARK getTm() {
        return tm;
    }

    public void setTm(T_MALL_TRADE_MARK tm) {
        this.tm = tm;
    }
}
