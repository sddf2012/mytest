package com.redis.basic.impl;

import com.redis.basic.BasicOpsService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author liu peng bo
 * @date 2018/5/18
 */
@Service
@CacheConfig(cacheNames="test")
public class BasicOpsServiceImpl implements BasicOpsService {
    @Override
    @Cacheable(key = "#a")
    public String get(String a) {
        System.out.println("从数据库获取");
        return a + 1;
    }

    @Override
    @CachePut(key = "#a")
    public String add(String a) {
        System.out.println("新增");
        return a + "1";
    }

    @Override
    @CacheEvict(key = "#a")
    public void delete(String a) {
        System.out.println("删除");
    }
}
