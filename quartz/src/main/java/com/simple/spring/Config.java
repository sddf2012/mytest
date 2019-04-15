package com.simple.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author liu peng bo
 * @date 2018/9/28
 */
@Configuration
public class Config {
    @Bean
    public SchedulerFactoryBean scheduler() {
        return new SchedulerFactoryBean();
    }
}
