package com.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/5/4
 */
public class TestMail {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MailConfig.class);
        SendMail sendMail = ac.getBean(SendMail.class);
        sendMail.sendSimpleSpittleEmail("1231");
    }
}
