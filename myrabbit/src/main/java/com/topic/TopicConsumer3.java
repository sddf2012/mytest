package com.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/11/1
 */
public class TopicConsumer3 {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        String exchange = "topic";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC);
        String q = channel.queueDeclare().getQueue();
        channel.queueBind(q, exchange, "#cat");
        channel.basicConsume(q, false, MyUtils.defaultConsumerWithAck(channel));
    }
}
