package com.direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author liu peng bo
 * @date 2018/11/1
 */
public class DirectSend {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = MyUtils.getChannel();
        String exchange = "direct";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT);
        channel.basicPublish(exchange, "info", null, "info message".getBytes());
        /*channel.basicPublish(exchange, "error", null, "error message".getBytes());
        channel.basicPublish(exchange, "123", null, "123 message".getBytes());*/
        /*channel.close();
        channel.getConnection().close();*/
    }
}
