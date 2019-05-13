package com.abstractinject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/24 9:56
 */
@Component
public class SpringContext implements ApplicationContextAware {
    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    public <T> T getBean(Class<T> tClass) {
        return ac.getBean(tClass);
    }
}
