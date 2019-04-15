package com.direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/11/1
 */
public class DirectConsumer {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        String exchange = "direct";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT);
        String q = channel.queueDeclare().getQueue();
        channel.queueBind(q, "direct", "info");
        channel.basicConsume(q, false, MyUtils.defaultConsumerWithAck(channel));
    }
}
