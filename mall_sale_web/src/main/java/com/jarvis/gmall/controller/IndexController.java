package com.jarvis.gmall.controller;

import com.jarvis.gmall.dto.OBJECT_T_MALL_ATTR;
import com.jarvis.gmall.dto.OBJECT_T_MALL_SKU;
import com.jarvis.gmall.service.AttrService;
import com.jarvis.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * gmall : gmall.controller
 *
 * @author jarvis
 * @create 2019-12-04 23:19
 */
@Controller
public class IndexController {

    @Autowired
    AttrService attrService;

    @Autowired
    SkuService skuService;

    @RequestMapping("/goto_list")
    public String goto_list(int flbh2, ModelMap map){

        //查出属性列表集合
        List<OBJECT_T_MALL_ATTR> attr_list = attrService.get_attr_list_by(flbh2);

        //查出spu集合
        List<OBJECT_T_MALL_SKU> sku_list = skuService.get_sku_list_by(flbh2);

        map.put("attr_list", attr_list);
        map.put("sku_list", sku_list);
        map.put("flbh2", flbh2);

        return "list";
    }

    @RequestMapping("/index")
    public String index(){

        return "index";
    }

    @RequestMapping("/to_login")
    public String to_login(){
        return "login";
    }
}
