package com.helloworld;

import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/11/1
 */
public class HelloTest {
    public static void main(String[] args) throws IOException {
        String message = "hello world ";
        Channel channel = MyUtils.getChannel();
        channel.queueDeclare(MyUtils.HELLO_QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", MyUtils.HELLO_QUEUE_NAME, null, (message + i).getBytes());
            System.out.println("send message:" + message + i);
        }
        channel.basicConsume(MyUtils.HELLO_QUEUE_NAME, true, MyUtils.defaultConsumer(channel,3000));
        //channel.basicConsume(MyUtils.HELLO_QUEUE_NAME, true, MyUtils.defaultConsumer(channel,10000));

    }
}
