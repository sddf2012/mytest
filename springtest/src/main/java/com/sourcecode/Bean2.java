package com.sourcecode;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/30 9:53
 */
public class Bean2 implements BeanNameAware, SmartInitializingSingleton {
    private int i = 1;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    void initMethod(){
        System.out.println("bean2 init method");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("beanName:" + name);
    }

    @Override
    public void afterSingletonsInstantiated() {
        this.i = 2;
    }
}
