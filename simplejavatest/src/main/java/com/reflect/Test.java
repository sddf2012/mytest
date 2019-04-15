package com.reflect;

import java.lang.reflect.Method;

/**
 * @author liu peng bo
 * @date 2018/10/8
 */
public class Test {
    public static void main(String[] args) {
        Class<Son> sonClass = Son.class;
        Method[] declaredMethods = sonClass.getDeclaredMethods();
        Method[] methods = sonClass.getMethods();
        System.out.println(1);
    }
}
