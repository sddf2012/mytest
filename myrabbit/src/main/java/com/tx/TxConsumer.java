package com.tx;

import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/11/2
 */
public class TxConsumer {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        channel.queueDeclare(TxSend.queue, false, false, false, null);
        channel.basicConsume(TxSend.queue, false, MyUtils.defaultConsumerWithReject(channel));
    }
}
