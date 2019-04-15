package com.config;

import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

/**
 * @author liu peng bo
 * @date 2018/10/1
 */
@Configuration
public class SpringConfig {
    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(resourceLoader.getResource("ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);
        ehCacheManagerFactoryBean.setCacheManagerName("my");
        return ehCacheManagerFactoryBean;
    }

    @Bean
    public EhCacheCacheManager ehCacheCacheManager(CacheManager cacheManager) {
        return new EhCacheCacheManager(cacheManager);
    }
}
