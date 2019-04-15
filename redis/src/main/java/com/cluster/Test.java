package com.cluster;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author liu peng bo
 * @date 2018/10/3
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(MyClusterConfig.class);
        CacheManager cacheManager=ac.getBean(CacheManager.class);
        Cache cache=cacheManager.getCache("test");
        cache.put("1","1");
        System.out.println(cache.get("1"));
        RedisTemplate redisTemplate=ac.getBean(RedisTemplate.class);
        ValueOperations valueOperations=redisTemplate.opsForValue();
        valueOperations.set("test","1");
        System.out.println(valueOperations.get("test"));
    }
}
