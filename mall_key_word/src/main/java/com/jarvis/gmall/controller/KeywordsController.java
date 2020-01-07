package com.jarvis.gmall.controller;

import com.jarvis.gmall.dto.Keywords_T_MALL_SKU;
import com.jarvis.gmall.util.MySolrUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2020-01-07 22:04
 */
@Controller
public class KeywordsController {

    @RequestMapping("/keywords")
    @ResponseBody
    public List<Keywords_T_MALL_SKU> keywords(String keywords){
        String condition = "copy_item:" + keywords;
        List<Keywords_T_MALL_SKU> list = MySolrUtil.query(condition, Keywords_T_MALL_SKU.class);
        return list;
    }

}
