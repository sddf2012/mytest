package com.persistence;

import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/10/31
 */
public class MessagePersistConsumer {
    public static void main(String[] args) throws IOException {
        Channel channel=MessagePersist.channel;
        channel.basicConsume(MessagePersist.persistQueue,false, MyUtils.defaultConsumerWithAck(channel));
    }
}
