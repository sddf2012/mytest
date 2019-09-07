package com.test;

import com.entity.Address;
import com.entity.Hobby;
import com.entity.HobbyVo2;
import com.init.SqlSessionUtils;
import com.mapper.AddressMapper;
import com.mapper.HobbyMapper;
import com.mapper.UserMapper;
import com.service.impl.HobbyService;
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
        //HobbyService hobbyService=new HobbyService();
        //hobbyService.initData();

        SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HobbyMapper hobbyMapper = sqlSession.getMapper(HobbyMapper.class);
        List<HobbyVo2> list= hobbyMapper.selectHobbyVo2();
        System.out.println(1);

    }
}
