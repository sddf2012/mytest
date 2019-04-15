package com.mapper;

import com.entity.Address;
import org.apache.ibatis.annotations.Param;

/**
 * 整个代码文件描述
 *
 * @author 创建者中文名
 * date: 2019-1-10 16:43
 */
public interface AddressMapper {
    Address selectByUserId(@Param("userId") long userId);
}
