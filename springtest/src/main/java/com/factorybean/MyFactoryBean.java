package com.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2018/5/8
 */
@Component
public class MyFactoryBean implements FactoryBean<Person>,InitializingBean{
    @Nullable
    @Override
    public Person getObject() throws Exception {
        Person p=new Person();
        p.setName("test");
        return p;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

/*@PostConstruct
    public void setup(){

    }*/
}
