package com.sweet.scheme;

import com.sweet.ConfigBeanRegister;
import com.sweet.annotation.Config;
import com.sweet.listener.DataListener;
import com.sweet.zk.ZkClient;
import com.sweet.config.ConfigBean;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by weisw.shi on 2017/7/19.
 */
@Component
public class ConfigContextAware implements ApplicationContextAware{

    private  static ApplicationContext applicationContext;



    @Resource
    private DataListener dataListener;

    @Autowired
    private ConfigBean configBean;


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init(){
        ZkClient zkClient = new ZkClient(configBean.getZkAddress()+":"+configBean.getZkPort());
        String path = "/" + configBean.getAppName() +"/" + configBean.getEnv() ;
        boolean isExistsParent = zkClient.exists("/" + configBean.getAppName());
        if(!isExistsParent){
            zkClient.create("/" + configBean.getAppName(), CreateMode.PERSISTENT);
        }
        boolean isExists = zkClient.exists(path);
        if(!isExists){
            zkClient.create(path,CreateMode.PERSISTENT);
        }
        zkClient.listenData(path,dataListener);
        Map<String,Object> beans = applicationContext.getBeansWithAnnotation(Component.class);
        for(Object bean:beans.values()){
            Method[] methods = bean.getClass().getMethods();
            for (Method method:methods) {
                if(method.isAnnotationPresent(Config.class)){
                    Config config = method.getAnnotation(Config.class);
                    String name = config.name();
                    ConfigBeanRegister.registerMethod(name,method);
                    ConfigBeanRegister.registerBean(name,bean);
                }
            }
            System.err.println(bean==null?"null":bean.getClass().getName());
        }

    }




}
