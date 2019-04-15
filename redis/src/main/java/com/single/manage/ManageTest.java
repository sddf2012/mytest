package com.single.manage;

import org.springframework.cache.Cache;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.cache.RedisCacheManager;

/**
 * @author liu peng bo
 * @date 2018/11/15
 */
public class ManageTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ManageConfig.class);
        RedisCacheManager cacheManager = ac.getBean(RedisCacheManager.class);
        Cache cache = cacheManager.getCache("simple");
        /*cache.put("m1", "阿斯蒂芬");
        System.out.println(cache.get("m1").get());*/
        TestBean testBean=new TestBean(1,"qwe");
        cache.put("m2",testBean);
        testBean=cache.get("m2",TestBean.class);
        System.out.println(testBean.toString());
        /*Set<String> set = new HashSet<>();
        set.add("爱的方式");
        set.add("qerwe");*/
        /*cache.put("set1", set);
        Set result = cache.get("set1", Set.class);
        result.forEach(a -> {
            System.out.println(a);
        });*/
        /*Set result = MyRedisUtil.set("simple::set1");
        result.forEach(a -> {
            System.out.println(a);
        });*/
    }
}
