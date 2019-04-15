package com.sourcecode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/10/9
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("");
        ac.getBean("");
    }
}
