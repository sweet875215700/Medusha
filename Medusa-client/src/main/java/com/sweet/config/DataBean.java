package com.sweet.config;

import java.util.Map;

/**
 * Created by weisw.shi on 2017/7/26.
 */
public class DataBean {

    private String name;

    private Map<String,Object> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
