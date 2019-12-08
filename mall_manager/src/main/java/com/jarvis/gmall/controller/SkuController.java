package com.jarvis.gmall.controller;

import com.jarvis.gmall.dto.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.jarvis.gmall.dto.OBJECT_T_MALL_ATTR;
import com.jarvis.gmall.entity.T_MALL_PRODUCT;
import com.jarvis.gmall.entity.T_MALL_SKU;
import com.jarvis.gmall.service.AttrService;
import com.jarvis.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-11-30 20:15
 */
@Controller
public class SkuController {

    @Autowired
    private AttrService attrService;

    @Autowired
    private SkuService skuService;

    @RequestMapping("/sku_add")
    public ModelAndView sku_add(T_MALL_PRODUCT product, T_MALL_SKU sku, MODEL_T_MALL_SKU_ATTR_VALUE sku_av){

        sku.setShp_id(product.getId());
        skuService.save_sku(sku);

        skuService.save_sku_attr_value(sku.getId(),sku_av.getList_sku_av());

        ModelAndView model = new ModelAndView("redirect:/goto_sku_add.do");
        model.addObject("flbh1",product.getFlbh1());
        model.addObject("flbh2", product.getFlbh2());
        return model;
    }

    @RequestMapping("/goto_sku_add")
    public String goto_sku_add(int flbh1, int flbh2, ModelMap map) {

        List<OBJECT_T_MALL_ATTR> attr_list = attrService.get_attr_list(flbh2);
        map.put("flbh1", flbh1);
        map.put("flbh2", flbh2);
        map.put("attr_list", attr_list);

        return "skuAdd";
    }
}
