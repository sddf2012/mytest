package com.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2018/5/4
 */
@Component
public class SendMail {
    @Autowired
    private MailSender mailSender;

    public void sendSimpleSpittleEmail(String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1085636515@qq.com");
        message.setTo("liu_pengbo@hoperun.com");
       /* message.setFrom("liu_pengbo@hoperun.com");
        message.setTo("1085636515@qq.com");*/
        message.setSubject("验证码");
        message.setText(text);
        mailSender.send(message);

    }
}
