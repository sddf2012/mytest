package com.workqueues;

import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/10/31
 */
public class HelloConsumer2 {
    static String queue=MyUtils.HELLO_QUEUE_NAME;
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        //channel.basicQos(1);
        channel.queueDeclare(queue, false, false, false, null);
        //channel.basicConsume(queue,false,MyUtils.defaultConsumerWithAck(channel,9000));
        channel.basicConsume(MyUtils.HELLO_QUEUE_NAME, true, MyUtils.defaultConsumer(channel,10000));

    }
}
