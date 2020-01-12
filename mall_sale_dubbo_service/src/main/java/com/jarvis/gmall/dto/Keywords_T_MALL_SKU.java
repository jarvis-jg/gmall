package com.jarvis.gmall.dto;

import com.jarvis.gmall.entity.T_MALL_SKU;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * gmall : com.jarvis.gmall.dto
 *
 * @author jarvis
 * @create 2019-12-08 11:18
 */
public class Keywords_T_MALL_SKU extends T_MALL_SKU implements Serializable {

    @Field("shp_tp")
    private String shp_tp;

    public String getShp_tp() {
        return shp_tp;
    }

    public void setShp_tp(String shp_tp) {
        this.shp_tp = shp_tp;
    }
}
