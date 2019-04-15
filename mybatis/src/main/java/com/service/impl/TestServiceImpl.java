package com.service.impl;

import com.entity.Test;
import com.init.SqlSessionUtils;
import com.mapper.TestMapper;
import com.service.TestService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author liu peng bo
 * @date 2019/4/11
 */
public class TestServiceImpl implements TestService {
    SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSessionFactory();


    @Override
    public int updateAIncr(int id) {
        long begin = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        int a = testMapper.updateAIncr(id);
        sqlSession.commit();
        System.out.println(Thread.currentThread().getName() + " 耗时:" + (System.currentTimeMillis() - begin));
        return a;
    }

    @Override
    public int updateA(int id) {
        long begin = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectA(id);
        int a = testMapper.updateA(test.getA() + 1, id);
        sqlSession.commit();
        System.out.println(Thread.currentThread().getName() + " 耗时:" + (System.currentTimeMillis() - begin));

        return a;
    }

    @Override
    public int updateAVersion(int id) {
        long begin = System.currentTimeMillis();
        int a = 0;
        SqlSession sqlSession;
        while (a == 0) {
            sqlSession = sqlSessionFactory.openSession();
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            Test test = testMapper.selectA(id);
            int oldValue = test.getA();
            int newValue = test.getA() + 1;
            a = testMapper.updateAVersion(newValue, oldValue, id);
            sqlSession.commit();
        }
        System.out.println(Thread.currentThread().getName() + " 耗时:" + (System.currentTimeMillis() - begin));

        return a;
    }

    @Override
    public int selectAForUpdate(int id) {
        long begin = System.currentTimeMillis();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectAForUpdate(id);
        int a = testMapper.updateA(test.getA() + 1, id);
        sqlSession.commit();
        System.out.println(Thread.currentThread().getName() + " 耗时:" + (System.currentTimeMillis() - begin));

        return a;
    }

    @Override
    public Test selectById(int id) {
        long begin = System.currentTimeMillis();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectA(id);
        sqlSession.commit();
        System.out.println(Thread.currentThread().getName() + " 耗时:" + (System.currentTimeMillis() - begin));

        return test;
    }

    @Override
    public void update(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        testMapper.updateA(1, id);
        sqlSession.commit();
    }
}
