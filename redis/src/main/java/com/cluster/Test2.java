package com.cluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liu peng bo
 * @date 2018/10/4
 */
public class Test2 {
    public static void main(String[] args) {
        Set<HostAndPort> set = new HashSet<>();
        for (int i = 63791; i <= 63798; i++) {
            set.add(new HostAndPort("127.0.0.1", i));
        }
        JedisCluster jedisCluster = new JedisCluster(set,5);
        jedisCluster.set("b", "b");
        jedisCluster.get("b");
        // use the jedisCluster resource as if it was a normal Jedis resource

    }
}
