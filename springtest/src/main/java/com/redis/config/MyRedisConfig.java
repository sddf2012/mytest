package com.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Properties;

/**
 * @author liu peng bo
 * @date 2018/5/15
 */
@Configuration
@ComponentScan({"com.autoconfig", "com.redis"})
@EnableCaching
public class MyRedisConfig {
    @Autowired
    private Properties properties;

    @Bean
    public RedisConnectionFactory connectionFactory() {
        String host = properties.getProperty("myCache.redis.host");
        String port = properties.getProperty("myCache.redis.port");
        return new LettuceConnectionFactory(host, Integer.parseInt(port));
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheWriter cacheWriter = RedisCacheWriter.lockingRedisCacheWriter(redisTemplate.getConnectionFactory());
        RedisCacheConfiguration defaultConfig=RedisCacheConfiguration.defaultCacheConfig();
        RedisCacheConfiguration config=defaultConfig.prefixKeysWith("key");
        //config= defaultConfig.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
        RedisCacheManager redisCacheManager = new RedisCacheManager(cacheWriter, config,true, "t1","t2");

        return redisCacheManager;
    }
}
