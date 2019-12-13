package com.aopimpl.aop;

import lombok.Data;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/12/12 15:07
 */
@Data
public class MyMethodInvocation implements MethodInvocation {
    private Object target;

    private Method method;

    private Object[] args;

    private List<MyMethodInterceptor> interceptors;

    private int currentInterceptor = -1;

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return new Object[0];
    }

    @Override
    public Object proceed() throws Throwable {
        if (CollectionUtils.isEmpty(interceptors) || interceptors.size() - 1 == currentInterceptor) {
            return invokeJoinPoint();
        }
        MyMethodInterceptor myMethodInterceptor = interceptors.get(++currentInterceptor);
        return myMethodInterceptor.invoke(this);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return getMethod();
    }

    private Object invokeJoinPoint() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, args);
    }
}
