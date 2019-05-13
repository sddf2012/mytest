package com.abstractinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/24 10:11
 */
@Component
public class TestStatic {
    void get(){
        StaticInject.get();
    }

    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(AiConfig.class);
        TestStatic testStatic= ac.getBean(TestStatic.class);
        testStatic.get();
    }
}
