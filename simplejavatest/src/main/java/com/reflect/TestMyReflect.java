package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author liu peng bo
 * @date 2018/10/11
 */
public class TestMyReflect {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        MyReflect myReflect = new MyReflect();
        Class<MyReflect> myReflectClass = MyReflect.class;
        Field field = myReflectClass.getDeclaredField("i");
        if (!Modifier.isPublic(field.getModifiers())) {
            field.setAccessible(true);
        }
        field.set(myReflect,3);
        System.out.println(field.get(myReflect));
    }
}
