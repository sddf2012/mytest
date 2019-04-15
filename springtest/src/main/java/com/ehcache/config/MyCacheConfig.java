package com.ehcache.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.Properties;

/**
 * @author liu peng bo
 * @date 2018/5/11
 */
@Configuration
@ComponentScan("com.ehcache")
@EnableCaching
public class MyCacheConfig {
    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${ehcache.location:classpath:ehcache.xml}")
    private String ehcacheXml;

    @Bean
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        String yml = "classpath:application.yml";
        factoryBean.setLocation(resourceLoader.getResource(yml));
        return factoryBean;
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
        String CACHE_MANAGER_NAME = "myEhCacheManager";
        factoryBean.setCacheManagerName(CACHE_MANAGER_NAME);
        factoryBean.setShared(true);
        factoryBean.setAcceptExisting(true);
        factoryBean.setConfigLocation(resourceLoader.getResource(ehcacheXml));

        return factoryBean;
    }

    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean factoryBean) {
        return new EhCacheCacheManager(factoryBean.getObject());
    }

}
