package com.bootautoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liu peng bo
 * @date 2018/5/18
 */
//@Component
@ConfigurationProperties(prefix = "test")
public class MyProperties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
