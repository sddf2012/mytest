package com.dlx;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2019/3/7
 */
public class DlxComsumer {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        String exchange = "dlx";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT);
        String q = channel.queueDeclare().getQueue();
        channel.queueBind(q, "dlx", "buffer");
        channel.basicConsume(q, false, MyUtils.defaultConsumerWithAck(channel));
    }
}
