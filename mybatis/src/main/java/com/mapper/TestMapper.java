package com.mapper;

import com.entity.Test;
import org.apache.ibatis.annotations.Param;

/**
 * @author liu peng bo
 * @date 2018/8/29
 */
public interface TestMapper {
    int updateAIncr(@Param("id") int id);

    int updateA(@Param("a") int a,@Param("id") int id);

    int updateAVersion(@Param("newValue") int newValue,@Param("oldValue") int oldValue,@Param("id") int id);

    Test selectAForUpdate(@Param("id") int id);

    Test selectA(@Param("id") int id);

}
