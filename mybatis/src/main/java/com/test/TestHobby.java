package com.test;

import com.entity.Address;
import com.entity.Hobby;
import com.init.SqlSessionUtils;
import com.mapper.AddressMapper;
import com.mapper.HobbyMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

/**
 * 整个代码文件描述
 *
 * @author 创建者中文名
 * date: 2019-1-10 16:43
 */
public class TestHobby {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HobbyMapper hobbyMapper = sqlSession.getMapper(HobbyMapper.class);
        List<Hobby> hobbies= hobbyMapper.selectByUserId(1);
        System.out.println(hobbies.size());

    }
}
