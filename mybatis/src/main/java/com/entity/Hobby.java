package com.entity;

import lombok.Data;

/**
 * 整个代码文件描述
 *
 * @author 创建者中文名
 * date: 2019-1-10 16:43
 */
@Data
public class Hobby {
    private long hobbyId;
    private long hobbyUserId;
    private String hobbyCode;
    private String hobbyName;

}
