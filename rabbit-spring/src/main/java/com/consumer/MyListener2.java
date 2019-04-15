package com.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2018/11/7
 */
@Component
public class MyListener2 implements ChannelAwareMessageListener {
    @Autowired
    private MessageConverter messageConverter;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Object object = messageConverter.fromMessage(message);
        System.out.println("MyListener2 "+Thread.currentThread().getId()+" 消费失败,拒绝此消息:" + object.toString());
        channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);

    }
}
