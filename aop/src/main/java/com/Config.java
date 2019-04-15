package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author liu peng bo
 * @date 2018/9/4
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com")
public class Config {

}
