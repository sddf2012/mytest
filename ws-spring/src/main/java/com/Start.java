package com;

import com.config.WSConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/9/19
 */
public class Start {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(WSConfig.class);

    }
}
