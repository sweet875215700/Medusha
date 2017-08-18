package com.sweet.scheme;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by weisw.shi on 2017/7/18.
 */
public class ConfigHandler extends NamespaceHandlerSupport{


    public void init() {
        registerBeanDefinitionParser("config",new ConfigBeanDefinitionParser());
    }
}
