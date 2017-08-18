package com.sweet.scheme;

import com.sweet.config.ConfigBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by weisw.shi on 2017/7/18.
 */
public class ConfigBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return ConfigBean.class;
    }



    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        String appName = element.getAttribute("appName");
        String zkAddress = element.getAttribute("zkAddress");
        String zkPort = element.getAttribute("zkPort");
        String env = element.getAttribute("env");

        builder.addPropertyValue("id",id);
        builder.addPropertyValue("appName",appName);
        builder.addPropertyValue("zkAddress",zkAddress);
        builder.addPropertyValue("zkPort",zkPort);
        builder.addPropertyValue("env",env);

        parserContext.getRegistry().registerBeanDefinition(id,builder.getBeanDefinition());

    }
}
