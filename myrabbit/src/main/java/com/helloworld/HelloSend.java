package com.helloworld;

import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author liu peng bo
 * @date 2018/10/29
 */
public class HelloSend {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        String message = "hello world ";
        Channel channel = MyUtils.getChannel();
        channel.queueDeclare(MyUtils.HELLO_QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", MyUtils.HELLO_QUEUE_NAME, null, (message + i).getBytes());
            System.out.println("send message:" + message + i);
            //Thread.sleep(2000);
        }
        channel.close();
        channel.getConnection().close();
    }
}
