package com.sweet.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweet.test.config.ConfigTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by weisw.shi on 2017/7/19.
 */

@Controller
public class TestController {

    @Resource
    private ConfigTest configTest;


    @RequestMapping("/test")
    @ResponseBody
    public String test(){

        Map<String,Object> map = configTest.getMap();
        String json = JSONObject.toJSONString(map);
        return json;

    }
}
