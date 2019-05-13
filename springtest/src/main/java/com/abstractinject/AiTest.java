package com.abstractinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019-1-10 16:43
 */
public class AiTest {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(AiConfig.class);
        /*Base base= ac.getBean(Base.class);
        base.base();
        base.base2();*/
        StaticInject staticInject= ac.getBean(StaticInject.class);
        StaticInject.get();
    }
}
