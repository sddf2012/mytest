package com.ehcache.service;

/**
 * @author liu peng bo
 * @date 2018/5/11
 */
public interface CatService {
    String get();

    void save(String name);

    void delete(String name);

    String find(String name);
}
