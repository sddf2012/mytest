package com.redis.basic;

import com.redis.config.MyRedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.Collection;

/**
 * @author liu peng bo
 * @date 2018/5/18
 */
public class Test2 {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(MyRedisConfig.class);
        RedisCacheManager  redisCacheManager= ac.getBean(RedisCacheManager.class);
        Collection collection= redisCacheManager.getCacheNames();
        collection.forEach(
                it->{
                    System.out.println(it);
                }
        );
        BasicOpsService service=  ac.getBean(BasicOpsService.class);
        service.add("1");
        service.add("2");
        System.out.println(service.get("1"));
        Collection collection2= redisCacheManager.getCacheNames();
        collection2.forEach(
                it->{
                    System.out.println(it);
                }
        );
    }
}
