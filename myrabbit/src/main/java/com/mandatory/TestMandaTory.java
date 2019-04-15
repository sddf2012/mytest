package com.mandatory;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/11/2
 */
public class TestMandaTory {
    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        channel.addReturnListener(returnMessage -> {
            System.out.println("return message:" + returnMessage.getReplyText() + " " + new String(returnMessage.getBody()));
        });

        channel.addConfirmListener((deliveryTag, multiple) -> {
            System.out.println("ack:" + deliveryTag + ";" + multiple);

        }, (deliveryTag, multiple) -> {
            System.out.println("nack:" + deliveryTag + ";" + multiple);

        });
        channel.confirmSelect();
        String exchange = "direct";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT);
        channel.queueDeclare("testImmediate", true, false, false, null);
        channel.queueBind("testImmediate", exchange, "3");
        //channel.basicPublish(exchange, "1", true, false, null, "mandatory message".getBytes());
        channel.basicPublish(exchange, "4", true, false, null, "mandatory message".getBytes());
        System.out.println("test over!");
    }
}
