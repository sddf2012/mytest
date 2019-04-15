package com.callback;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2018/11/7
 */
@Component
public class MyReturnCallBack implements RabbitTemplate.ReturnCallback {
    @Autowired
    private MessageConverter converter;

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("return 消息发送到队列失败:replyCode:" + replyCode + ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
        Object object = converter.fromMessage(message);
        System.out.println("return 消息内容:" + object.toString());
    }
}
