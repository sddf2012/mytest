package com.lunxun;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2019/3/7
 */
public class MultiSend {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        //channel.basicQos(2);
        String exchange = "multiFanout";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.FANOUT);
        String queue = channel.queueDeclare("multiQueue",true,false,false,null).getQueue();
        channel.queueBind(queue, "multiFanout", "info");
        //channel.basicQos(1);
        for (int i = 0; i < 30; i++) {
            channel.basicPublish(exchange, "info", null, ("info message " + i).getBytes());
        }
    }
}
