package com.bootautoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liu peng bo
 * @date 2018/5/18
 */
@Configuration
@EnableConfigurationProperties(MyProperties.class)
@ComponentScan("com.bootautoconfig")
//@Component
public class TestConfig {
    @Autowired
    private MyProperties myProperties;

    public String get() {
        return myProperties.getName();
    }
}
