package com.aopimpl.aop;

import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/12/12 15:06
 */
@Data
public class MyMethodInterceptor implements MethodInterceptor {
    private Object aop;

    private Method method;

    private Object[] args;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        method.invoke(aop, args);
        return invocation.proceed();
    }
}
