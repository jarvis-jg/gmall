package com.jarvis.gmall.controller;

import com.jarvis.gmall.entity.T_MALL_PRODUCT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-11-22 20:18
 */
@Controller
public class SpuController {


    @RequestMapping("spu_add")
    public String spu_add(T_MALL_PRODUCT product){


        return "redirect:/goto_spu_add.do" +
                "?flbh1=" + product.getFlbh1() +
                "&flbh2=" + product.getFlbh2() +
                "&pp_id=" + product.getPp_id();
    }

    @RequestMapping("/goto_spu_add")
    public String goto_spu_add(T_MALL_PRODUCT product, Map model){
        model.put("spu", product);
        return "spuAdd";
    }
}
