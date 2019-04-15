package com.mirror;

import com.rabbitmq.client.Channel;
import com.util.MyUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu peng bo
 * @date 2018/11/12
 */
public class MirrorQueueTest {
    public static void main(String[] args) throws IOException {
        Channel channel= MyUtils.getChannel();
        Map map=new HashMap<>();
        map.put("x-ha-policy", "all");
        channel.queueDeclare("exact.mirror1",false,false,false,null);
    }
}
