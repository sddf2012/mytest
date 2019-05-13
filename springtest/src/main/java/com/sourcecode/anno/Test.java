package com.sourcecode.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/5/8
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(MyConfiguration.class);
        Object o=  ac.getBean(MyFactoryBean.class);
    }
}
