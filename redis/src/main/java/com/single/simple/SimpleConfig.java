package com.single.simple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author liu peng bo
 * @date 2018/11/14
 */
@Configuration
public class SimpleConfig {
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //poolConfig.setMaxTotal(100);
        return poolConfig;
    }

    @Bean
    RedisConnectionFactory redisConnectionFactory(JedisPoolConfig poolConfig) {
        JedisClientConfiguration clientConfiguration = JedisClientConfiguration.builder().usePooling().poolConfig(poolConfig).build();
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("localhost", 7379);
        return new JedisConnectionFactory(configuration, clientConfiguration);
    }


    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
