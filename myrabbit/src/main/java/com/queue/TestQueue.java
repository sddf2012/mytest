package com.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.util.MyUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author liu peng bo
 * @date 2018/10/31
 */
public class TestQueue {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection con1 = MyUtils.getConnection("con1");
        Connection con2 = MyUtils.getConnection("con2");
        Channel con1Channel1 = con1.createChannel();
        Channel con2Channel1 = con2.createChannel();
        con1Channel1.queueDeclare("q1", false, false, true, null);
        con2Channel1.queueDeclare("q2", false, false, false, null);
        con2Channel1.basicPublish("", "q1", null, "message q2".getBytes());
        con1Channel1.basicConsume("q1",MyUtils.defaultConsumer(con1Channel1));

        con1Channel1.queueDelete("q1");
        con1Channel1.queueDelete("q2");
    }
}
