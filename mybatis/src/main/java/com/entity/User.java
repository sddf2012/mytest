package com.entity;

import lombok.Data;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/8/29
 */
@Data
public class User {
    private long userId;
    private String code;
    private String name;
    private String country;
    private String pwd;
    private Address address;
    private List<Hobby> hobbys;
    private List<String> hobbyNames;

    public User() {
    }

    public User(Long userId) {
        this.userId = userId;
    }

    public User(long userId, String code, String name) {
        this.userId = userId;
        this.code = code;
        this.name = name;
    }

}
