package com.sourcecode.anno;

import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2018/5/8
 */
@Component
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
