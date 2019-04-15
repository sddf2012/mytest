package com.ttl;

import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/11/30
 */
public class TtlConsumer {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        channel.queueDeclare("acq1", false, false, true, null);
        channel.basicConsume("acq1",true, MyUtils.defaultConsumer(channel));
    }
}
