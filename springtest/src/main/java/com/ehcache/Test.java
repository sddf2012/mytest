package com.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.io.IOException;

/**
 * @author liu peng bo
 * @date 2018/5/10
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        //System.out.println(Test.class.getResource("/"));
        CacheManager cacheManager = CacheManager.create("springtest/src/main/resources/ehcache.xml");
        //System.out.println(cacheManager.getCacheNames().length);
        Cache myCache = cacheManager.getCache("myCache");
        String prefix="k";
        for (int i = 0; i < 10; i++) {
            Element element = new Element(prefix + i, "v" + i);
            myCache.put(element);
        }
        System.out.println("size:" + myCache.getSize());
        System.out.println("key:" + myCache.getKeysWithExpiryCheck());
        for (int i = 0; i < 10; i++) {
            String key=prefix + i;
            System.out.println(key+":"+myCache.get(key));
            System.out.println("isElementInMemory:"+myCache.isElementInMemory(key));
            System.out.println("isElementOnDisk:"+myCache.isElementOnDisk(key));
        }
        Thread.sleep(6000);
        System.out.println("---------------------");
        System.out.println(myCache.getKeysWithExpiryCheck());
        /*myCache.flush();
        System.out.println("---------------------");
        System.out.println(myCache.getKeysWithExpiryCheck());*/
        cacheManager.shutdown();
        //System.out.println(myCache.get("k1"));
        //myCache.removeAll();
        //System.out.println(myCache.getSize());
    }
}
