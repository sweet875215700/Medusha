package com.sweet.config;

/**
 * Created by weisw.shi on 2017/7/18.
 */
public class ConfigBean {

    private String id;
    private String appName;
    private String zkAddress;
    private String zkPort;
    private String env;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getZkAddress() {
        return zkAddress;
    }

    public void setZkAddress(String zkAddress) {
        this.zkAddress = zkAddress;
    }

    public String getZkPort() {
        return zkPort;
    }

    public void setZkPort(String zkPort) {
        this.zkPort = zkPort;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    @Override
    public String toString() {
        return "ConfigBean{" +
                "id='" + id + '\'' +
                ", appName='" + appName + '\'' +
                ", zkAddress='" + zkAddress + '\'' +
                ", zkPort='" + zkPort + '\'' +
                ", env='" + env + '\'' +
                '}';
    }
}
