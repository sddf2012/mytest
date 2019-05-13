package com.sourcecode;

import com.sourcecode.anno.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2018/5/8
 */
public class XmlFactoryBean implements FactoryBean<Person>{
    @Nullable
    @Override
    public Person getObject() {
        Person p = new Person();
        p.setName("test");
        return p;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

}
