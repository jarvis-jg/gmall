package com.jarvis.gmall.util;

import com.google.gson.Gson;
import net.sf.json.JSONArray;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.util
 *
 * @author jarvis
 * @create 2019-12-14 10:52
 */
public class MyJsonUtil {

    public static <T> String object_to_json(T t){
        Gson gson = new Gson();
        String json = gson.toJson(t);

        try {
            json = URLEncoder.encode(json, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static <T> T json_to_object(String json,Class<T> t){

        try {
            json = URLDecoder.decode(json, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        T fromJson = gson.fromJson(json, t);

        return fromJson;
    }


    public static <T> List<T> json_to_list(String json, Class<T> t){
        String decode = "";
        if (StringUtils.isEmpty(json)){
            return null;
        }else{
            try {
                decode = URLDecoder.decode(json, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            JSONArray formObj = JSONArray.fromObject(decode);
            List<T> list = (List<T>) JSONArray.toCollection(formObj, t);
            return list;
        }
    }

    public static <T> String list_to_json(List<T> list){

        Gson gson = new Gson();
        String json = gson.toJson(list);

        try {
            json = URLEncoder.encode(json, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
