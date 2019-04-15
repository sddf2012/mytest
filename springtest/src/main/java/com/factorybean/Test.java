package com.factorybean;

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
        Person p=  ac.getBean(Person.class);
        World w=  ac.getBean(World.class);
        System.out.println(o.getClass());
        System.out.println(p.getName());
        System.out.println(w.getP().getName());
    }
}
