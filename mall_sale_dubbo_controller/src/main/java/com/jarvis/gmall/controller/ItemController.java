package com.jarvis.gmall.controller;

import com.jarvis.gmall.dto.DETAIL_T_MALL_SKU;
import com.jarvis.gmall.entity.T_MALL_SKU;
import com.jarvis.gmall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-12-12 22:57
 */
@Controller
public class ItemController {

    @Autowired
    ItemService itemService;


    @RequestMapping("goto_sku_detail")
    public String goto_sku_detail(int sku_id, int spu_id, ModelMap map){

        //查询sku详情
        DETAIL_T_MALL_SKU detail_t_mall_sku = itemService.get_sku_detail(sku_id);

        //查询spu下的所有sku
        List<T_MALL_SKU> sku_list = itemService.get_sku_list(spu_id);

        map.put("detail", detail_t_mall_sku);
        map.put("sku_list", sku_list);

        return "skuDetail";
    }

}
