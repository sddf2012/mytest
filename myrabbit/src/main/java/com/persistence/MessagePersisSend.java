package com.persistence;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/10/31
 */
public class MessagePersisSend {
    public static void main(String[] args) throws IOException {
       Channel channel= MessagePersist.channel;
        channel.basicPublish("",MessagePersist.persistQueue, MessageProperties.PERSISTENT_TEXT_PLAIN,"persist message".getBytes());
    }
}
