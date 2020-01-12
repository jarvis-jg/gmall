package com.jarvis.gmall.controller;

import com.jarvis.gmall.dto.Keywords_T_MALL_SKU;
import com.jarvis.gmall.dto.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.jarvis.gmall.dto.OBJECT_T_MALL_ATTR;
import com.jarvis.gmall.dto.OBJECT_T_MALL_SKU;
import com.jarvis.gmall.entity.T_MALL_SKU_ATTR_VALUE;
import com.jarvis.gmall.service.AttrService;
import com.jarvis.gmall.service.SkuService;
import com.jarvis.gmall.util.MyCacheUtil;
import com.jarvis.gmall.util.MyHttpGetUtil;
import com.jarvis.gmall.util.MyJsonUtil;
import com.jarvis.gmall.util.MyPropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Autowired
    AttrService attrService;

    @RequestMapping("/keywords")
    public String keywords(String keywords,ModelMap map){
        //调用keywords服务
        String url = MyPropertyUtil.getProperty("ws.properties", "keywords_url") + "?keywords=" + keywords;
        String result_json = "";
        try {
            result_json = MyHttpGetUtil.doGet(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Keywords_T_MALL_SKU> sku_list = MyJsonUtil.json_to_list(result_json, Keywords_T_MALL_SKU.class);

        map.put("sku_list", sku_list);
        map.put("keywords", keywords);
        return "search";
    }


    @RequestMapping("/goto_list")
    public String goto_list(int flbh2, ModelMap map){

        //查出属性列表集合
        List<OBJECT_T_MALL_ATTR> attr_list = attrService.get_attr_list_by(flbh2);

        //缓存检索
        String key = "class_2_" + flbh2;
        List<OBJECT_T_MALL_SKU> sku_list = MyCacheUtil.getList(key, OBJECT_T_MALL_SKU.class);

        if (sku_list == null || sku_list.isEmpty()){
            //查出spu集合
            sku_list = skuService.get_sku_list_by(flbh2);
            MyCacheUtil.setKey(key,sku_list);
        }

        map.put("attr_list", attr_list);
        map.put("sku_list", sku_list);
        map.put("flbh2", flbh2);

        return "list";
    }

//    @RequestMapping("/get_list_by_attr")
//    数组传参ajax会转发参数，并在后面加上[],如：array_str[]
//    public String get_list_by_attr(@RequestParam("array_str[]") String[] array){
//        return "skuList";
//    }

    @RequestMapping("/get_list_by_attr")
    public String get_list_by_attr(MODEL_T_MALL_SKU_ATTR_VALUE list_sku_av, int flbh2, ModelMap map){
        List<OBJECT_T_MALL_SKU> sku_list = new ArrayList<>();
        //缓存检索
        List<T_MALL_SKU_ATTR_VALUE> sku_av_list = list_sku_av.getList_sku_av();
        String[] keys = new String[sku_av_list.size()];
        for (int i = 0; i < sku_av_list.size(); i++) {
            T_MALL_SKU_ATTR_VALUE sku_av = sku_av_list.get(i);
            int shxm_id = sku_av.getShxm_id();
            int shxzh_id = sku_av.getShxzh_id();
            keys[i] = "attr_" + flbh2 + "_" + shxm_id + "_" + shxzh_id;
        }
        String interKey = MyCacheUtil.interKeys(keys);
        sku_list = MyCacheUtil.getList(interKey, OBJECT_T_MALL_SKU.class);

        //mysql检索
        if (sku_list == null || sku_list.isEmpty()){
            sku_list = skuService.get_list_by_attr(list_sku_av.getList_sku_av(), flbh2);
            for (int i = 0; i < sku_av_list.size(); i++) {
                boolean b = MyCacheUtil.if_key(keys[i]);
                if (!b){
                    T_MALL_SKU_ATTR_VALUE sku_av = sku_av_list.get(i);
                    List<OBJECT_T_MALL_SKU> skuList = skuService.get_list_by_attr(new ArrayList<T_MALL_SKU_ATTR_VALUE>(Arrays.asList(sku_av)), flbh2);
                    MyCacheUtil.setKey(keys[i], skuList);
                }
            }
        }

        map.put("sku_list", sku_list);
        return "skuList";
    }
}
