package com.dynamicproxy;

/**
 * @author liu peng bo
 * @date 2018/8/2
 */
public class RealSubject implements Subject{
    @Override
    public void doSomething(String str) {
        System.out.println("do something "+str);
    }
}
