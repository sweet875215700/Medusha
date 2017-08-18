package com.sweet.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sweet.ConfigBeanRegister;
import com.sweet.config.DataBean;
import com.sweet.zk.ZkClientException;
import com.sweet.zk.listener.Listener;
import org.apache.zookeeper.Watcher;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.net.SocketException;
import java.util.Map;

/**
 * Created by weisw.shi on 2017/7/26.
 */

@Service
public class DataListener implements Listener {

    public void listen(String path, Watcher.Event.EventType eventType, byte[] data) throws ZkClientException,SocketException {
        String value = new String(data);
        DataBean dataBean = JSONObject.parseObject(value,DataBean.class);
        Method method = ConfigBeanRegister.getMethod(dataBean.getName());
        Object bean = ConfigBeanRegister.getBean(dataBean.getName());
        try{
            method.invoke(bean,dataBean.getMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(path + " " + eventType.name() + " " + String.valueOf(data));
    }
}
