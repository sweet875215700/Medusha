package com.sweet.test.config;

import com.sweet.annotation.Config;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by weisw.shi on 2017/7/26.
 */
@Component
public class ConfigTest {

    private static Map<String,Object> map ;

    @Config(name = "file")
    public void load (Map<String,Object> map){
         this.map = map;
    }

    public Map<String,Object> getMap(){
        return map;
    }
}
