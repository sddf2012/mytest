package com.rpc;

import com.rabbitmq.client.*;
import com.util.MyUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liu peng bo
 * @date 2018/11/1
 */
public class RpcServer {

    private static Consumer consumer(Channel channel) {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String resp = "";
                try {
                    DateFormat format = new SimpleDateFormat("hh:mm:ss");
                    System.out.println(format.format(new Date()) + " receiver message:" + new String(body));
                    String message = new String(body);
                    int i = Integer.parseInt(message);
                    int result = CommonUtils.fib(i);
                    resp = String.valueOf(result);
                    System.out.println(format.format(new Date()) + " handle over!");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    AMQP.BasicProperties replyProp = new AMQP.BasicProperties.Builder().correlationId(properties.getCorrelationId()).build();
                    channel.basicPublish("", properties.getReplyTo(), replyProp, resp.getBytes());
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
    }


    public static void main(String[] args) throws IOException {
        Channel channel = MyUtils.getChannel();
        channel.basicQos(1);
        channel.queueDeclare(CommonUtils.serverQueue, false, false, false, null);
        channel.basicConsume(CommonUtils.serverQueue, false, consumer(channel));
    }
}
