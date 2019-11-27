package com.jarvis.gmall.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * gmall : com.jarvis.gmall.util
 *
 * @author jarvis
 * @create 2019-11-23 18:59
 */
public class MyFileUploadUtil {

    public static List<String> update_files(MultipartFile[] files) {

        String path = MyPropertyUtil.getProperty("myUpload.properties", "macos_path");
        List<String> image_list = new ArrayList<>();

        for (MultipartFile file : files) {

            if (!file.isEmpty()){
                String filename = file.getOriginalFilename();

                String name = System.currentTimeMillis() + filename;
                String upload_file = path + "/" + name;
                try {
                    file.transferTo(new File(upload_file));
                    image_list.add(name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return image_list;
    }
}
