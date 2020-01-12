package com.jarvis.mall.log.controller;

import com.jarvis.mall.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * gmall : com.jarvis.mall.log.controller
 *
 * @author jarvis
 * @create 2020-01-12 15:45
 */
@Controller
public class IndexController {

    @Autowired
    LogService logService;

    @RequestMapping("/index")
    public String index(@RequestParam(value = "message", defaultValue = "测试") String message) {
        logService.log(message);
        return "";
    }

}
