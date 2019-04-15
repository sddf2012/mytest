package com.dlx;

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
public class TestDlx {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        String exchange = "direct";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT);
        //dlx
        channel.exchangeDeclare("dlx", BuiltinExchangeType.DIRECT);
        //缓冲队列
        Map<String, Object> map = new HashMap<>();
        map.put("x-message-ttl", 10 * 1000);
        map.put("x-dead-letter-exchange", "dlx");
        map.put("x-dead-letter-routing-key", "info");

        channel.queueDeclare("bufferQueue", true, false, false, map);
        channel.queueBind("bufferQueue",exchange,"buffer");

        System.out.println(new Date());
        channel.basicPublish(exchange, "buffer", null, "info message".getBytes());

    }
}
