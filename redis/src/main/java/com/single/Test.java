package com.single;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author liu peng bo
 * @date 2018/10/4
 */
public class Test {
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        //jedis.set("a", "a");
        System.out.println(jedis.get("a"));
    }
}
