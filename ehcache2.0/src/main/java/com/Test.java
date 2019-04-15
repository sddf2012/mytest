package com;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * @author liu peng bo
 * @date 2018/9/30
 */
public class Test {

    static Cache cache;

    static {
        URL url = Thread.currentThread().getContextClassLoader().getResource("ehcache.xml");
        CacheManager cacheManager = CacheManager.create(url);
        Test.cache = cacheManager.getCache("Test");
    }

    static void get(String key) {
        Element element = cache.get(key);
        if (element == null) {
            System.err.println("缓存中无数据,读取其他数据");
        } else {
            System.out.println("过期时间" + new Date(element.getExpirationTime()));
            System.err.println("从缓存中获取数据:" + element.getObjectValue());
        }
    }

    static void getAllKey() {
        System.out.println("全部key:" + cache.getKeys());
    }

    static void getAllUnExpiredKey() {
        System.out.println("全部未过期key:" + cache.getKeysWithExpiryCheck());
    }

    static void getExpireTime(Element element) {
        if (element == null) {
            return;
        }
        System.out.println(element.getObjectKey() + " 创建时间:" + new Date(element.getCreationTime()) + ";过期时间" + new Date(element.getExpirationTime()));
    }

    static void getAllExpireTime(Collection<String> collection) {
        collection.forEach(key -> {
            Element element = cache.get(key);
            if (element == null) {
                System.out.println(key + "不存在");
            }
            getExpireTime(element);
        });
    }

    static void getAll(Collection<String> collection) {
        collection.forEach(key -> {
            Element element = cache.get(key);
            if (element == null) {
                System.out.println(key + "不存在");
            } else {
                System.out.println(element.toString());
                getSingleStore(key);
            }

        });
    }

    static void getSingleStore(String key) {
        System.out.println(key + " in memmory " + cache.isElementInMemory(key));
        System.out.println(key + " in offheap " + cache.isElementOffHeap(key));
        System.out.println(key + " in disk " + cache.isElementOnDisk(key));
        System.out.println("``````````````");
    }

    static void getStore(Collection<String> collection) {
        collection.forEach(key -> {
            System.out.println(key + " in memmory " + cache.isElementInMemory(key));
            System.out.println(key + " in offheap " + cache.isElementOffHeap(key));
            System.out.println(key + " in disk " + cache.isElementOnDisk(key));
            System.out.println("``````````````");
        });
    }

    static void testExpire() throws InterruptedException {
        Element element = new Element("1", "1");
        cache.put(element);

        System.out.println("当前时间" + new Date());
        getExpireTime(element);

        Thread.sleep(3000);
        System.out.println("3s后");
        Test.getAllKey();
        Test.get("1");

        Thread.sleep(11 * 1000);
        System.out.println("11s后");
        Test.getAllKey();
        Test.get("1");
        Thread.sleep(5 * 1000);
    }

    static void testDisk() throws InterruptedException {

        Element element = new Element("5", "1");
        Element element2 = new Element("6", "2");
        Element element3 = new Element("7", "3");
        Element element4 = new Element("8", "4");
        //String[] keys = new String[]{"1", "2", "3", "4"};
        String[] keys = new String[]{"5", "6", "7", "8"};
        //getAllExpireTime(Arrays.asList(keys));
        System.out.println("----------------");


        cache.put(element);
        cache.put(element2);
        cache.put(element3);
        getAll(Arrays.asList(keys));
        //getAllExpireTime(Arrays.asList(keys));
        System.out.println("----------------");

        Thread.sleep(10000);
        getAll(Arrays.asList(keys));
        //getAllExpireTime(Arrays.asList(keys));
        System.out.println("----------------");

    }

    public static void main(String[] args) throws InterruptedException {

    }
}
