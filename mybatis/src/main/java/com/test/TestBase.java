package com.test;

import com.entity.User;
import com.init.SqlSessionUtils;
import com.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/8/29
 */
public class TestBase {
    public static void main(String[] args) {

        SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //List<User> list = userMapper.findByName("张");

        //userMapper.save(user);
        //userMapper.multipleSave(list);
        //User result = userMapper.getById("3");
        List resultList ;
        //resultList= userMapper.findByName("张三");
        resultList= userMapper.findAll();
        sqlSession.commit();

        resultList.forEach(
                l -> {
                    System.out.println(l.toString());
                }
        );
    }
}
