package com.jarvis.gmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-11-22 20:10
 */
@Controller
public class IndexController {

    @RequestMapping("/goto_sku")
    public String goto_sku(){
        return "sku";
    }

    @RequestMapping("/goto_attr")
    public String goto_attr(){
        return "attr";
    }

    @RequestMapping("/goto_spu")
    public String goto_spu(){
        return "spu";
    }

    @RequestMapping("/index")
    public String index(@RequestParam(value = "tabs_json",defaultValue = "") String tabs_json, ModelMap map){
        map.put("tabs_json", tabs_json);
        return "main";
    }
}
