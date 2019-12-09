package com.jarvis.gmall.controller;

import com.jarvis.gmall.dto.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.jarvis.gmall.dto.OBJECT_T_MALL_SKU;
import com.jarvis.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-12-09 19:37
 */
@Controller
public class SkuController {

    @Autowired
    SkuService skuService;

//    @RequestMapping("/get_list_by_attr")
//    数组传参ajax会转发参数，并在后面加上[],如：array_str[]
//    public String get_list_by_attr(@RequestParam("array_str[]") String[] array){
//        return "skuList";
//    }

    @RequestMapping("/get_list_by_attr")
    public String get_list_by_attr(MODEL_T_MALL_SKU_ATTR_VALUE list_sku_av, int flbh2, ModelMap map){
        List<OBJECT_T_MALL_SKU> sku_list = skuService.get_list_by_attr(list_sku_av.getList_sku_av(), flbh2);

        map.put("sku_list", sku_list);
        return "skuList";
    }
}
