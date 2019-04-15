package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author liu peng bo
 * @date 2018/8/2
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler invocationHandle = new MyInvocationHandle(subject);
        Subject proxy =(Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), invocationHandle);
        proxy.doSomething("123");
    }
}
