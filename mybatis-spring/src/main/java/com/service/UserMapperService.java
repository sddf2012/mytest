package com.service;

import com.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/9/4
 */
public interface UserMapperService {
    User getById(String id);
    void save(User user);
    List<User> findByName(String name);
    void test(String id);
    void test2(String id);
    PageInfo<User> testFenye(String name, int page, int pagesize);
    PageInfo<User> testFenye2(String name, int page, int pagesize);

}
