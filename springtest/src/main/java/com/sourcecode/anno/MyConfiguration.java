package com.sourcecode.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liu peng bo
 * @date 2018/5/8
 */
@Configuration
@ComponentScan("com.sourcecode.anno")
public class MyConfiguration {
    /*@Bean
    public World world(MyFactoryBean p) {
        World world = new World();
        try {
            world.setP(p.getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return world;
    }*/
}
