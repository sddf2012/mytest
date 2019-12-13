package com.aopimpl;

import com.aopimpl.aop.MyMethodInvocation;
import com.service.PayService;
import com.service.PayServiceImpl;
import lombok.Data;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/12/9 17:23
 */
@Data
public class MyInvocationHandle2 implements InvocationHandler {

    private Object target;

    private MyMethodInvocation methodInvocation;

    public MyInvocationHandle2() {
    }


    public MyInvocationHandle2(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        methodInvocation.setMethod(method);
        methodInvocation.setArgs(args);
        return methodInvocation.proceed();
    }

}
