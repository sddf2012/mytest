package com.abstractinject;

import org.springframework.stereotype.Component;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019-1-10 16:43
 */
@Component
public class Base extends AbstractBase {
    @Override
    void base2() {
        person.get();
    }
}
