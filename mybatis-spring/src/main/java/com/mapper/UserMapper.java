package com.mapper;

import com.datasource.DesignationDatasource;
import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/8/29
 */
public interface UserMapper {
    @DesignationDatasource("d1")
    User getById(String id);

    void save(User user);

    void multipleSave(List<User> list);

    List<User> findByName(String name);

    List<User> findByName2(String name, @Param("pageNum") int pageNum, @Param("pageSize")int pageSize);
}
