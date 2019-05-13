package com.abstractinject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/24 9:45
 */
@Component
public class StaticInject {
    private static StaticInject staticInject;
    @Autowired
    private  Person person;

    /*@PostConstruct
    public void a() {
        staticInject=this;
        //person=this.person;
    }*/

    public StaticInject() {
        staticInject=this;
    }

    public static void get(){
        staticInject.person.get();
    }
}
