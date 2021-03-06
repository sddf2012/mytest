package com.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/8/22 9:38
 */
//@Component
public class TestBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("TestBeforeAdvice");
        method.invoke(target, args);
    }
}
