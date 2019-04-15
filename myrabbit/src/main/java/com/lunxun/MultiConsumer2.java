package com.lunxun;

import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2019/3/7
 */
public class MultiConsumer2 {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        //channel.basicQos(1);
        channel.basicConsume("multiQueue",false,MyUtils.defaultConsumerWithAck(channel,5000));
    }
}
