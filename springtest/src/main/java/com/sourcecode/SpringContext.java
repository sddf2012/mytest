package com.sourcecode;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/30 11:56
 */
public class SpringContext implements ApplicationContextAware {
    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    public static Object getBean(String name) {
        return ac.getBean(name);
    }
}
