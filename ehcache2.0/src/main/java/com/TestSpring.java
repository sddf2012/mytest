package com;

import com.config.SpringConfig;
import net.sf.ehcache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/10/1
 */
public class TestSpring {
    public static void main(String[] args) {
        CacheManager c1=  CacheManager.create();
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
        CacheManager s=ac.getBean(CacheManager.class);
        CacheManager c2=  CacheManager.create();
        System.out.println("111");
    }
}
