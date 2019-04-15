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
        User user = new User("3", "3", "1");
        User user2 = new User("4", "4", "1");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        //userMapper.save(user);
        //userMapper.multipleSave(list);
        User result = userMapper.getById("3");
        /*List resultList = userMapper.findByName("1");
        resultList.forEach(
                l -> {
                    System.out.println(l.toString());
                }
        );*/
        sqlSession.commit();
         System.out.println(result.toString());
    }
}
