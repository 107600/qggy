package cn.itcast.jk.config;

import java.util.Map;

/**
 * Created by jy on 2018/5/29.
 */
public class UploadConfig {
    private Map<String,String> uploadImgConfigMap;

    public void setUploadImgConfigMap(Map uploadImgConfigMap) {
        this.uploadImgConfigMap = uploadImgConfigMap;
    }

    public Map getUploadImgConfigMap() {
        return uploadImgConfigMap;
    }
}
