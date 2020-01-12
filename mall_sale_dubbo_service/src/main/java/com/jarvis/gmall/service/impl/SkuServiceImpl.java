package com.jarvis.gmall.service.impl;

import com.jarvis.gmall.dto.OBJECT_T_MALL_SKU;
import com.jarvis.gmall.entity.T_MALL_SKU_ATTR_VALUE;
import com.jarvis.gmall.mapper.SkuMapper;
import com.jarvis.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.service.impl
 *
 * @author jarvis
 * @create 2019-12-08 11:24
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public List<OBJECT_T_MALL_SKU> get_sku_list_by(int flbh2) {
        List<OBJECT_T_MALL_SKU> sku_list = skuMapper.select_sku_list_by(flbh2);
        return sku_list;
    }

    @Override
    public List<OBJECT_T_MALL_SKU> get_list_by_attr(List<T_MALL_SKU_ATTR_VALUE> list_sku_av, int flbh2) {
        String querySql = "";
        if (list_sku_av != null && list_sku_av.size() > 0){
            StringBuffer sb = new StringBuffer("");
            sb.append(" AND sku.id IN ( SELECT a0.sku_id FROM ");

            for (int i = 0; i < list_sku_av.size(); i++){
                sb.append(" (SELECT sku_id from t_mall_sku_attr_value where shxm_id = " + list_sku_av.get(i).getShxm_id() + " and shxzh_id = " + list_sku_av.get(i).getShxzh_id() + ") a" + i);
                if ((i + 1) < list_sku_av.size() && list_sku_av.size() > 1){
                    sb.append(" , ");
                }
            }

            if (list_sku_av.size() > 1){
                sb.append(" WHERE ");
                for (int i = 0; i < list_sku_av.size(); i++){
                    if ((i + 1) < list_sku_av.size()){
                        sb.append(" a" + i + ".sku_id = a" + (i + 1) + ".sku_id ");
                    }

                    if (list_sku_av.size() > 2 && (i + 2) < list_sku_av.size()){
                        sb.append(" AND ");
                    }
                }
            }

            sb.append(" ) ");
            querySql = sb.toString();
        }

        HashMap<Object, Object> map = new HashMap<>();
        map.put("flbh2", flbh2);
        map.put("querySql", querySql);
        List<OBJECT_T_MALL_SKU> sku_list = skuMapper.select_list_by_attr(map);
        return sku_list;
    }
}
