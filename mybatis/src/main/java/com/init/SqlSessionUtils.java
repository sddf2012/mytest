package com.init;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author liu peng bo
 * @date 2018/8/29
 */
public class SqlSessionUtils {
    private static class Inner {
        private static final SqlSessionFactory SQLSESSIONFACTORY = getSessionFactory();

        private static SqlSessionFactory getSessionFactory() {
            InputStream is = null;

            try {
                is=ClassLoader.getSystemResourceAsStream("mybatis.xml");
                //is=Resources.getResourceAsStream("D:\\workspace\\mytest\\mybatis\\src\\main\\resources\\mybatis.xml");
            } catch (Exception e) {
                e.printStackTrace();
            }
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            return builder.build(is);
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return Inner.SQLSESSIONFACTORY;
    }
}
