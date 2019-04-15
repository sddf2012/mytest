package com.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author liu peng bo
 * @date 2018/11/1
 */
public class PsSend {
    static Channel channel = MyUtils.getChannel();
   static List<String> queueList=new ArrayList<>();
    static {
        try {
            channel.exchangeDeclare("fanout", BuiltinExchangeType.FANOUT);
            String q1 = channel.queueDeclare().getQueue();
            String q2 = channel.queueDeclare().getQueue();
            channel.queueBind(q1, "fanout", "");
            queueList.add(q1);
            channel.queueBind(q2, "fanout", "");
            queueList.add(q2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        channel.basicPublish("fanout", "", null, "fanout message!".getBytes());
        queueList.forEach(queue->{
            try {
                System.out.println("队列:"+queue);
                channel.basicConsume(queue,false,MyUtils.defaultConsumerWithAck(channel));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        /*channel.close();
        channel.getConnection().close();*/
    }
}
