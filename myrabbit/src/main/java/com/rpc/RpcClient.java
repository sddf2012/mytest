package com.rpc;

import com.rabbitmq.client.*;
import com.util.MyUtils;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author liu peng bo
 * @date 2018/11/1
 */
public class RpcClient {
    static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);

    static Consumer consumer(Channel channel, String id) {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                boolean handle = false;
                try {
                    if (id.equals(properties.getCorrelationId())) {
                        handle = true;
                        blockingQueue.offer(Integer.parseInt(new String(body)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = MyUtils.getChannel();
        channel.queueDeclare(CommonUtils.replyQueue, false, false, false, null);
        String correlationId = UUID.randomUUID().toString();
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder().replyTo(CommonUtils.replyQueue).correlationId(correlationId).build();
        String a = "9";
        channel.basicPublish("", CommonUtils.serverQueue, properties, a.getBytes());
        String tag = channel.basicConsume(CommonUtils.replyQueue, true, consumer(channel, correlationId));
        int result = blockingQueue.take();
        System.out.println("fib(" + a + ")=" + result);
        //channel.basicCancel(tag);
    }
}
