package com.callback;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2018/11/7
 */
@Component
public class MyConfirmCallBack implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private MessageConverter messageConverter;

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("confirm 消息" + correlationData + "发送exchange成功!");
        } else {
            System.out.println("confirm 消息" + correlationData + "发送exchange失败:" + cause);
        }
        if (correlationData.getReturnedMessage() != null) {
            Object object = messageConverter.fromMessage(correlationData.getReturnedMessage());
            System.out.println("confirm 消息内容:" + object.toString());
        }
    }
}
