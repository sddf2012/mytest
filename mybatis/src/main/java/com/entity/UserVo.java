package com.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/7/1 11:57
 */
@Data
@ToString
public class UserVo {
    private long userId;
    private Integer field;
    private String code;
    private String name;
    private String country;
    private String pwd;
    private Address address;
    private List<Hobby> hobbys;


}
