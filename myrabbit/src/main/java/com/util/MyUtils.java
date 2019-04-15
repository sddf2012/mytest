package com.util;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liu peng bo
 * @date 2018/10/29
 */
public class MyUtils {
    public static String HELLO_QUEUE_NAME = "hello";

    public static Connection getConnection(String name) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Channel getChannel() {
        Connection connection = getConnection("localhost");
        Channel channel = null;
        try {
            channel = connection.createChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channel;
    }

    public static Consumer defaultConsumer(Channel channel) {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) {
                System.out.println("receiver message:" + new Date() + ":" + new String(body));
            }
        };
    }

    public static Consumer defaultConsumer(Channel channel, long time) {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) {
                DateFormat format = new SimpleDateFormat("hh:mm:ss");
                System.out.println(format.format(new Date()) + " receiver message:" + new String(body));
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(format.format(new Date()) + " handle over!");
            }
        };
    }

    public static Consumer defaultConsumerWithAck(Channel channel) {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                //String name = Thread.currentThread().getName();
                try {
                    //Thread.sleep(500);
                    System.out.println(new Date() + " receiver message:" + new String(body));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(new Date() + " message ack!");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
    }


    public static Consumer defaultConsumerWithReject(Channel channel) {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                try {
                    System.out.println("receiver message:" + new String(body));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("message reject!");
                    channel.basicReject(envelope.getDeliveryTag(), false);
                }
            }
        };
    }

    public static Consumer defaultConsumerWithAck(Channel channel, long time) {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                DateFormat format = new SimpleDateFormat("hh:mm:ss");
                try {
                    Thread.sleep(time);
                    System.out.println(format.format(new Date()) + " receiver message:" + new String(body));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
    }
}
