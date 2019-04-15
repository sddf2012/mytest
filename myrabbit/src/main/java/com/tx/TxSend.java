package com.tx;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/11/2
 */
public class TxSend {
    public static String queue = "txQueue";
    public static String exchange = "txExchange";

    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        channel.queueDeclare(queue, false, false, false, null);
        channel.exchangeDeclare(exchange, BuiltinExchangeType.FANOUT);
        channel.queueBind(queue, exchange, "");
        channel.basicPublish(exchange, queue, null, "tx message!".getBytes());
    }
}
