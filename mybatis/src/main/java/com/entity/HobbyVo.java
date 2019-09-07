package com.entity;

import lombok.Data;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/7/1 11:57
 */
@Data
public class HobbyVo {
    private long hobbyId;
    private long userId;
    private String hobbyCode;
    private String hobbyName;
}
