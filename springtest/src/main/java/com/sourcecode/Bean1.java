package com.sourcecode;

import org.springframework.beans.factory.InitializingBean;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/30 9:52
 */
public class Bean1 implements InitializingBean {
    private int i;

    private Bean2 bean2;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Bean2 getBean2() {
        return bean2;
    }

    public void setBean2(Bean2 bean2) {
        this.bean2 = bean2;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----------------"+bean2.getI());
    }
}
