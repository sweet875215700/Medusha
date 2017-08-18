package com.sweet.scheme;

import com.alibaba.fastjson.JSONObject;
import com.sweet.config.DataBean;
import com.sweet.zk.ZkClient;
import com.sweet.zk.ZkClientException;
import com.sweet.zk.listener.Listener;
import org.apache.zookeeper.Watcher;

import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by weisw.shi on 2017/7/21.
 */
public class ZkClientTest {

    public static void connect() {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 5000, 3000);
        System.out.println(zkClient.checkConnection());


        System.out.println(zkClient.exists("/myApp/dev"));

        DataBean dataBean = new DataBean();
        dataBean.setName("file");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("key","wei");
        dataBean.setMap(map);



        zkClient.setData("/myApp/dev", JSONObject.toJSON(dataBean).toString().getBytes());




    }


    public static void main(String args[]){
    connect();
    }
}
