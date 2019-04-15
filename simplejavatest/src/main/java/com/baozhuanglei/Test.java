package com.baozhuanglei;

import org.springframework.util.ClassUtils;

/**
 * @author liu peng bo
 * @date 2018/10/11
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Boolean.class==boolean.class);
        System.out.println(ClassUtils.isAssignable(Boolean.class,boolean.class));
        System.out.println(ClassUtils.isAssignable(boolean.class,Boolean.class));
    }
}
