package com.jarvis.gmall.controller;

import com.jarvis.gmall.dto.Model_T_MALL_ATTR;
import com.jarvis.gmall.dto.OBJECT_T_MALL_ATTR;
import com.jarvis.gmall.service.AttrService;
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
 * @create 2019-11-27 21:00
 */
@Controller
public class AttrController {

    @Autowired
    private AttrService attrService;

    @RequestMapping("/get_attr_list")
    public String get_attr_list(int flbh2,ModelMap map){

        List<OBJECT_T_MALL_ATTR> attr_list = attrService.get_attr_list(flbh2);

        map.put("attr_list", attr_list);
        map.put("flbh2", flbh2);
        return "attrListInner";
    }

    @RequestMapping("/goto_attr_add")
    public String goto_attr_add(int flbh2, ModelMap map){

        map.put("flbh2", flbh2);
        return "attrAdd";
    }

    @RequestMapping("/attr_add")
    public ModelAndView attr_add(int flbh2, Model_T_MALL_ATTR attr){

        attrService.save_attrs(flbh2,attr.getAttr_list());

        ModelAndView modelAndView = new ModelAndView("redirect:/goto_attr_add.do");
        modelAndView.addObject("flbh2", flbh2);
        return modelAndView;
    }
}
