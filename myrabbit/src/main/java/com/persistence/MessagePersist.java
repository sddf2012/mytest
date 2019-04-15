package com.persistence;

import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/10/31
 */
public class MessagePersist {
    static String persistQueue = "persistQueue";
    public static Channel channel;

    static {
        channel = MyUtils.getChannel();
        try {
            channel.queueDeclare(persistQueue, true, false, false, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
