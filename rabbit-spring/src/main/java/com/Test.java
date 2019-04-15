package com;

import com.message.MyMessage;
import com.util.MessageSendUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/11/7
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("rabbit.xml");
        //多个容器
        //MessageListenerContainer listenerContainer= ac.getBean(MessageListenerContainer.class);
        MyMessage message ;
        for (int i = 0; i < 1000; i++) {
            message = new MyMessage(String.valueOf(i), "name"+i);
            MessageSendUtils.send("direct1", "1", message);
        }
        System.out.println("over!");
    }
}
