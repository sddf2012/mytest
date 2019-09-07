package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.datasource.MultipleDatasource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu peng bo
 * @date 2018/8/30
 */
@Configuration
@ComponentScan("com")
@MapperScan("com.mapper")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {
    @Bean
    @Qualifier("dataSourceMap")
    public Map<Object, Object> dataSourceMap() {
        Map<Object, Object> map = new HashMap<>();
        DruidDataSource dataSource1 = new DruidDataSource();
        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8");
        dataSource1.setUsername("root");
        dataSource1.setPassword("root");

        DruidDataSource dataSource2 = new DruidDataSource();
        dataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource2.setUrl("jdbc:mysql://localhost:3306/test2?serverTimezone=GMT%2B8");
        dataSource2.setUsername("root");
        dataSource2.setPassword("root");

        map.put("d1", dataSource1);
        map.put("d2", dataSource2);
        return map;
    }

    @Bean
    public DataSource dataSource(@Qualifier("dataSourceMap") Map<Object, Object> dataSourceMap) {
        MultipleDatasource dataSource = new MultipleDatasource();
        dataSource.setTargetDataSources(dataSourceMap);
        //dataSource.setDefaultTargetDataSource(dataSourceMap.get("d1"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setConfigLocation(new ClassPathResource("mybatis.xml"));
        factoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*Mapper.xml"));
        return factoryBean;
    }
}
