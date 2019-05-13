package com.mapper;

import com.entity.User;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/8/29
 */
public interface UserMapper {
    User getById(String id);

    void save(User user);

    void multipleSave(List<User> list);

    List<User> findByName(String name);

    List<User> findAll();

}
