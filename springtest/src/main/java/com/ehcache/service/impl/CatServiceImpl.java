package com.ehcache.service.impl;

import com.ehcache.service.CatService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author liu peng bo
 * @date 2018/5/11
 */
@Service
@CacheConfig
public class CatServiceImpl implements CatService {
    @Override
    public String get() {
        return null;
    }

    @Override
    public void save(String name) {
        System.out.println("执行save方法");
    }

    @Override
    @CacheEvict(value = "myCache",key="'find'+#name")
    public void delete(String name) {
        System.out.println("执行delete方法");

    }

    @Override
    @Cacheable(value = "myCache", key = "'find'+#name")
    public String find(String name) {
        System.out.println("执行find方法");
        return "1";
    }
}
