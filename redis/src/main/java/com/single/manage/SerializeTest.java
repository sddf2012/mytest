package com.single.manage;

import org.springframework.cache.Cache;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.cache.RedisCacheManager;

/**
 * @author liu peng bo
 * @date 2018/11/15
 */
public class SerializeTest {
    static void put(){

    }
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ManageConfig.class);
        RedisCacheManager cacheManager = (RedisCacheManager)ac.getBean("redisCacheManager");
        RedisCacheManager cacheManager2 = (RedisCacheManager)ac.getBean("redisCacheManager2");
        Cache cache = cacheManager.getCache("simple");
        Cache cache2 = cacheManager2.getCache("simple");
        cache.put("m1", "阿斯蒂芬123");
        System.out.println(cache.get("m1").get());

        cache2.put("m2", "阿斯蒂芬123");
        System.out.println(cache2.get("m2").get());

        TestBean testBean=new TestBean(1,"qwe");
        cache.put("a1",testBean);
        cache2.put("a2",testBean);
        testBean=cache.get("a1",TestBean.class);
        System.out.println(testBean.toString());

        testBean=cache2.get("a2",TestBean.class);
        System.out.println(testBean.toString());
    }
}
