package com.mapper;

import com.entity.Address;
import com.entity.Hobby;
import com.entity.HobbyVo2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author 创建者中文名
 * date: 2019-1-10 16:43
 */
public interface HobbyMapper {
    List<Hobby> selectByUserId(@Param("userId") long userId);

    int batchInsert(@Param("hobbies") List<Hobby> hobbies);

    List<HobbyVo2> selectHobbyVo2();

}
