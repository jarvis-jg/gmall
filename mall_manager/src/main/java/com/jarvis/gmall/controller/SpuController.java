package com.jarvis.gmall.controller;

import com.jarvis.gmall.entity.T_MALL_PRODUCT;
import com.jarvis.gmall.service.SpuService;
import com.jarvis.gmall.util.MyFileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * gmall : com.jarvis.gmall.controller
 *
 * @author jarvis
 * @create 2019-11-22 20:18
 */
@Controller
public class SpuController {

    @Autowired
    SpuService spuService;

    @RequestMapping("/get_shp_list")
    @ResponseBody
    public List<T_MALL_PRODUCT> get_shp_list(int flbh2,int pp_id){
        List<T_MALL_PRODUCT> shp_list = spuService.get_shp_list(flbh2, pp_id);
        return shp_list;
    }

    @RequestMapping("/spu_add")
    public String spu_add(@RequestParam("files") MultipartFile[] files, T_MALL_PRODUCT product, int fm_id){

        // 1、上传文件
        List<String> image_list = MyFileUploadUtil.update_files(files);

        //2、写入数据库
        spuService.save_spu(image_list,product,fm_id);

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
