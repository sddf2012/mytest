package com.helloworld;

import com.rabbitmq.client.*;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/10/29
 */
public class HelloConsumer {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        channel.basicQos(1);
        channel.queueDeclare(MyUtils.HELLO_QUEUE_NAME, false, false, false, null);
        //channel.basicConsume(MyUtils.HELLO_QUEUE_NAME, false, MyUtils.defaultConsumerWithAck(channel,5000));
        channel.basicConsume(MyUtils.HELLO_QUEUE_NAME, true, MyUtils.defaultConsumer(channel,3000));

    }
}
