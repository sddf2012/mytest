package com.single.manage;

import com.config.MyRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu peng bo
 * @date 2018/11/14
 */
@Configuration
@ComponentScan({"com.config", "com.single.manage", "com.single.service"})
@EnableTransactionManagement
@EnableCaching
public class ManageConfig {
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //poolConfig.setMaxTotal(100);
        return poolConfig;
    }

    @Bean
    RedisConnectionFactory redisConnectionFactory(JedisPoolConfig poolConfig) {
        JedisClientConfiguration clientConfiguration = JedisClientConfiguration.builder().usePooling().poolConfig(poolConfig).build();
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("localhost", 6379);
        return new JedisConnectionFactory(configuration, clientConfiguration);
    }


    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
    }

    /*@Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        //configuration = configuration.disableKeyPrefix();
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return RedisCacheManager.RedisCacheManagerBuilder.fromCacheWriter(RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory)).cacheDefaults(configuration).build();
    }*/

    /*@Bean
    public RedisCacheManager redisCacheManager2(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.disableKeyPrefix();
        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory).cacheDefaults(configuration).build();
    }*/
    @Bean
    public RedisCacheManager redisCacheManager(MyRedisConfig myRedisConfig, RedisConnectionFactory connectionFactory) {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(connectionFactory);
        if (myRedisConfig.isEnableTransaction()) {
            builder.transactionAware();
        }
        if (!myRedisConfig.isAllowInFlightCacheCreation()) {
            builder.disableCreateOnMissingCache();
        }
        if (myRedisConfig.getDefaultCache() != null) {
            builder.cacheDefaults(myRedisConfig.getDefaultCache().trans2RedisConfiguration());
        }
        if (!CollectionUtils.isEmpty(myRedisConfig.getCaches())) {
            Map<String, RedisCacheConfiguration> map = new HashMap<>(16);
            myRedisConfig.getCaches().forEach((key, value) -> {
                map.put(key, value.trans2RedisConfiguration());
            });
            builder.withInitialCacheConfigurations(map);
        }
        return builder.build();
    }
}
