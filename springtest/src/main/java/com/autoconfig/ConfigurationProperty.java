package com.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;

/**
 * @author liu peng bo
 * @date 2018/5/4
 */
//@ConfigurationProperties
@Configuration
public class ConfigurationProperty {
    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    @Primary
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        String yml = "classpath:my.properties";
        factoryBean.setLocation(resourceLoader.getResource(yml));
        return factoryBean;
    }
}
