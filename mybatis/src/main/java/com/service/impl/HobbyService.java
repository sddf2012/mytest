package com.service.impl;

import com.entity.Hobby;
import com.init.SqlSessionUtils;
import com.mapper.AddressMapper;
import com.mapper.HobbyMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/7/25 9:33
 */
public class HobbyService {
   public int initData(){
        int i=0;
        Random random= new Random();
        SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HobbyMapper hobbyMapper = sqlSession.getMapper(HobbyMapper.class);
        for (;i<1;i++){
            int j=0;
            List<Hobby> list=new ArrayList<>();
            for(;j<1;j++){
                Hobby hobby=new Hobby();
                hobby.setHobbyUserId(random.nextInt(1000000));
                hobby.setHobbyCode(String.valueOf(random.nextInt(100000)));
                hobby.setHobbyName(/*String.valueOf(random.nextInt(200000))*/"\uD83D\uDE1F\uD83D\uDE24\uD83D\uDE22\uD83D\uDE2D\uD83D\uDE26");
                list.add(hobby);
            }
            if(!list.isEmpty())
            { hobbyMapper.batchInsert(list);}
        }
        sqlSession.commit();
        return 1;
    }
}
