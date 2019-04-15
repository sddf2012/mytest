package com.mandatory;

import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/11/2
 */
public class MandoryConsumer {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
       /* GetResponse getResponse= channel.basicGet("testImmediate",true);
        System.out.println(new String(getResponse.getBody()));*/
        //channel.queuePurge("testImmediate");
        channel.basicConsume("testImmediate",false,MyUtils.defaultConsumerWithReject(channel));
    }
}
