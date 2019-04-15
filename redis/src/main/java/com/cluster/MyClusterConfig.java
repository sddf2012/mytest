package com.cluster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/10/3
 */
@Configuration
public class MyClusterConfig {
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //poolConfig.setMaxTotal(100);
        return poolConfig;
    }

    @Bean
    RedisConnectionFactory redisConnectionFactory(JedisPoolConfig poolConfig) throws IOException {
        PropertySource propertySource = new ResourcePropertySource("classpath:rediscluster.properties");
        RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration(propertySource);
        return new JedisConnectionFactory(clusterConfiguration, poolConfig);
    }


    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory).build();
    }
}
