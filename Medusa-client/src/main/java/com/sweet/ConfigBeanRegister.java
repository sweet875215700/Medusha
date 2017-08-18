package com.sweet;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by weisw.shi on 2017/7/26.
 */
public class ConfigBeanRegister {

    public static Map<String,Method> methodFactory = new HashMap<String, Method>();
    public static Map<String,Object> beanFactory = new HashMap<String, Object>();


    public static void registerMethod(String key,Method method){
        methodFactory.put(key,method);
    }

    public static void registerBean(String key,Object bean){
        beanFactory.put(key, bean);
    }

    public static Method getMethod(String key){
        return methodFactory.get(key);
    }

    public static Object getBean(String key){
        return beanFactory.get(key);
    }
}
