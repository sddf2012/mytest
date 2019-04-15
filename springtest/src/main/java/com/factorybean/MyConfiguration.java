package com.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liu peng bo
 * @date 2018/5/8
 */
@ComponentScan("com.factorybean")
public class MyConfiguration {
    @Bean
    public World world(MyFactoryBean p) {
        World world = new World();
        try {
            world.setP(p.getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return world;
    }
}
