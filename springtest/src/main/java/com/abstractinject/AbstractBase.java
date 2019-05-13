package com.abstractinject;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019-1-10 16:43
 */
public abstract class AbstractBase {
    @Autowired
    protected Person person;

    void base() {
        person.get();
    }

    abstract void base2();
}
