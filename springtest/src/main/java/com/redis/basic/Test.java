package com.redis.basic;

import com.redis.config.MyRedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author liu peng bo
 * @date 2018/5/16
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyRedisConfig.class);
        RedisTemplate redisTemplate = ac.getBean(RedisTemplate.class);
        BoundValueOperations boundValueOps= redisTemplate.boundValueOps("a");
        boundValueOps.set("123");
        System.out.println(boundValueOps.get());
        ValueOperations valueOperations= redisTemplate.opsForValue();
        valueOperations.getAndSet("a","234");
        System.out.println(valueOperations.get("a"));
        ListOperations listOperations= redisTemplate.opsForList();
        listOperations.leftPushAll("mylist",new String[]{"a","b","c"});
        System.out.println(listOperations.size("mylist"));
        System.out.println(listOperations.range("mylist",0,-1));

    }
}
