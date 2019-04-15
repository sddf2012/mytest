package com.bootautoconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/5/18
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(TestConfig.class);
        MyProperties my=ac.getBean(MyProperties.class);
        System.out.println(my.getName());
        TestConfig testConfig=ac.getBean(TestConfig.class);
        System.out.println(testConfig.get());
        System.out.println(ac.getBean(TestConfig2.class));
    }
}
