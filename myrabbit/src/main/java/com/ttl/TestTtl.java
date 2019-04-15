package com.ttl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu peng bo
 * @date 2018/11/30
 */
public class TestTtl {
    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = MyUtils.getChannel();
       Map map=new HashMap<>();
        map.put("x-dead-letter-exchange", "e2");

        channel.exchangeDeclare("e1", BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare("e2", BuiltinExchangeType.DIRECT);
        channel.queueDeclare("ttlq1", false, false, true, map);
        channel.queueBind("ttlq1","e1","1");

        channel.queueDeclare("acq1", false, false, true, null);
        channel.queueBind("acq1","e2","1");

        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .expiration("5000")
                .build();
        channel.basicPublish("e1", "1", properties, "hello".getBytes());
        System.out.println(new Date());
        //Thread.sleep(3000);

        properties = new AMQP.BasicProperties.Builder()
                .expiration("10000")
                .build();
        channel.basicPublish("e1", "1", properties, "hello2".getBytes());
        System.out.println(new Date());

    }
}
