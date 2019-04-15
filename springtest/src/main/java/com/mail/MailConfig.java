package com.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author liu peng bo
 * @date 2018/5/4
 */
@Configuration
@ComponentScan("com.mail")
public class MailConfig {
    @Bean
    public MailSender mailSender(){
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(587);
        mailSender.setUsername("1085636515@qq.com");
        mailSender.setPassword("yvmmdkhwvdejibjc");

       /* mailSender.setHost("smtp.hoperun.com");
        mailSender.setPort(25);
        mailSender.setUsername("liu_pengbo@hoperun.com");
        mailSender.setPassword("sh54410");*/
        return mailSender;
    }
}
