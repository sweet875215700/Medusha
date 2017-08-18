package com.sweet.scheme;

import com.sweet.config.ConfigBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by weisw.shi on 2017/7/19.
 */
public class ConfigTest {

    public static void main(String args[]){
        ClassPathXmlApplicationContext bf = new ClassPathXmlApplicationContext("ShemeTest.xml");
        bf.start();
        ConfigBean configBean = (ConfigBean) bf.getBean("me");
    }
}
