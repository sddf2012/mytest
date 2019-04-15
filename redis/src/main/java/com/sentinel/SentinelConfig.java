package com.sentinel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author liu peng bo
 * @date 2018/11/19
 */
@Configuration
public class SentinelConfig {
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //poolConfig.setMaxTotal(100);
        return poolConfig;
    }

    @Bean
    RedisConnectionFactory redisConnectionFactory(JedisPoolConfig poolConfig) {
        JedisClientConfiguration clientConfiguration = JedisClientConfiguration.builder().usePooling().poolConfig(poolConfig).build();
        RedisSentinelConfiguration configuration=new RedisSentinelConfiguration().master("mymaster").sentinel("localhost",6381)
                .sentinel("localhost",6382);
        return new JedisConnectionFactory(configuration, clientConfiguration);
    }
}
