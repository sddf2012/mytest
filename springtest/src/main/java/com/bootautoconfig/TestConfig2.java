package com.bootautoconfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2018/5/18
 */
@EnableConfigurationProperties(MyProperties.class)
@Component
public class TestConfig2 {
}
