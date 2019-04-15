package com.single.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2018/12/6
 */
@Component
public class AnnotationService {

    @Cacheable(value = "test",cacheManager = "redisCacheManager")
    public  String get(String key){
        System.out.println("invoke method get!");
        return "test annotation";
    }
}
