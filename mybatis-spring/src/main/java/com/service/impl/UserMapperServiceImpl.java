package com.service.impl;

import com.datasource.DesignationDatasource;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UserMapper;
import com.service.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/9/4
 */
@Service
public class UserMapperServiceImpl implements UserMapperService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @DesignationDatasource("d1")
    public User getById(String id) {
        return userMapper.getById(id);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    @DesignationDatasource("d2")
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DesignationDatasource("d1")
    public void test(String id) {
        User user1 = userMapper.getById(id);
        User user = new User(id);
        user.setCode(id);
        user.setName(id);
        userMapper.save(user);
        System.out.println(user1.toString());
    }

    @Override
    @DesignationDatasource("d1")
    public void test2(String id) {
        User user = userMapper.getById(id);
        user.setCode("test");
        User user1=userMapper.getById(id);
        System.out.println(user1);
    }

    @Override
    @DesignationDatasource("d2")
    public PageInfo<User> testFenye(String name,int page,int pagesize) {
        PageHelper.startPage(page,pagesize);
        List<User> list= findByName(name);
        PageInfo<User> pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    @DesignationDatasource("d2")
    public PageInfo<User> testFenye2(String name, int page, int pagesize) {
        PageHelper.startPage(page,pagesize);
        List<User> list= findByName(name);
        PageInfo<User> pageInfo=new PageInfo(list);
        return pageInfo;
    }
}
