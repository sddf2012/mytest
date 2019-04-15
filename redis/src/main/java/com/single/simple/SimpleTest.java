package com.single.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author liu peng bo
 * @date 2018/11/14
 */
public class SimpleTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SimpleConfig.class);
        RedisTemplate redisTemplate = ac.getBean(RedisTemplate.class);
        ValueOperations valueOperations= redisTemplate.opsForValue();
        valueOperations.set("c","阿斯蒂");
        System.out.println(valueOperations.get("c"));
       /* HashOperations<Object,Object,Object> hashOperations=redisTemplate.opsForHash();
        hashOperations.put("map","k1","k2");
        System.out.println(hashOperations.get("map","k1"));*/
    }
}
