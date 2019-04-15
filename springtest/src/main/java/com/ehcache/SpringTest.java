package com.ehcache;

import com.ehcache.config.MyCacheConfig;
import com.ehcache.service.CatService;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/5/11
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyCacheConfig.class);
        EhCacheCacheManager cacheManager = ac.getBean(EhCacheCacheManager.class);
        EhCacheCache ehcache = (EhCacheCache) cacheManager.getCache("myCache");
        //ehcache.put("k1","v1");
        //System.out.println(ehcache.get("k1").get());
        CatService catService = ac.getBean(CatService.class);
        System.out.println(catService.find("a"));
        System.out.println(catService.find("a"));
        catService.delete("a");
        System.out.println(catService.find("a"));

    }
}
