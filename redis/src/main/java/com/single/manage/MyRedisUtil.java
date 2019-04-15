package com.single.manage;

import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;
import java.util.Set;

/**
 * @author liu peng bo
 * @date 2018/11/15
 */
public class MyRedisUtil {
    private static RedisCacheManager cacheManager() {
        return SpringContext.getBean(RedisCacheManager.class);
    }

    private static RedisTemplate redisTemplate() {
        return SpringContext.getBean(RedisTemplate.class);
    }

    public static <K, V> void put(String cacheName, K key, V value) {
        Objects.requireNonNull(cacheManager().getCache(cacheName)).put(key, value);
    }

    public static <K> Object get(String cacheName, K key) {
        return Objects.requireNonNull(Objects.requireNonNull(cacheManager().getCache(cacheName)).get(key)).get();
    }

    public static <K, V> V getV(String cacheName, K key, Class<V> vClass) {
        return Objects.requireNonNull(Objects.requireNonNull(cacheManager().getCache(cacheName)).get(key, vClass));
    }

    public static Set set(String key) {
        return redisTemplate().boundSetOps(key).members();
    }
}
