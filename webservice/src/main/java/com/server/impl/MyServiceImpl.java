package com.server.impl;

import com.server.MyService;
import com.server.bo.RepBO;

/**
 * @author liu peng bo
 * @date 2018/9/19
 */
public class MyServiceImpl implements MyService {
    @Override
    public String hello() {
        return "hello world";
    }

    @Override
    public RepBO hello2(){
        RepBO bo=new RepBO();
        bo.setI(1);
        bo.setJ("123");
        return bo;
    }

    /*public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/myservice/hello", new MyService());
        System.out.println("success");
    }*/
}
