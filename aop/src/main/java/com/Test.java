package com;

import com.service.PayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/9/4
 */
public class Test {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        PayService payService =(PayService)ac.getBean("payService2");
        payService.pay();
    }
}
