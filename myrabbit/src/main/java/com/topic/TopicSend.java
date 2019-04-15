package com.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/11/1
 */
public class TopicSend {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        String exchange = "topic";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC);
        channel.basicPublish(exchange, "abccat", null, "abccat".getBytes());
        channel.basicPublish(exchange, "abc cat", null, "abc cat".getBytes());
        channel.basicPublish(exchange, "orange.cat", null, "orange.cat".getBytes());
        channel.basicPublish(exchange, "cat", null, "cat".getBytes());
        channel.basicPublish(exchange, "orange.dog", null, "orange.dog".getBytes());
        channel.basicPublish(exchange, "orange.a.b.c", null, "orange.a.b.c".getBytes());
    }
}
