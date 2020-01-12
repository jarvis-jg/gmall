package com.jarvis.gmall.dto;

import java.io.Serializable;

/**
 * gmall : com.jarvis.gmall.dto
 *
 * @author jarvis
 * @create 2019-12-12 23:01
 */
public class OBJECT_AV_NAME implements Serializable {

    private String shxm_mch;
    private String shxzh_mch;

    public String getShxm_mch() {
        return shxm_mch;
    }

    public void setShxm_mch(String shxm_mch) {
        this.shxm_mch = shxm_mch;
    }

    public String getShxzh_mch() {
        return shxzh_mch;
    }

    public void setShxzh_mch(String shxzh_mch) {
        this.shxzh_mch = shxzh_mch;
    }
}
