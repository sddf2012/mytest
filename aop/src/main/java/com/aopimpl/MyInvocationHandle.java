package com.aopimpl;

import com.service.PayService;
import com.service.PayServiceImpl;
import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/12/9 17:23
 */

public class MyInvocationHandle implements InvocationHandler {

    private Object target;

    private MethodBeforeAdviceInterceptor methodInterceptor;

    private MethodBeforeAdvice beforeAdvice;

    public MyInvocationHandle(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeAdvice.before(method,args,target);
        //System.out.println("1312");
        return method.invoke(this.target, args);
    }


    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public MethodBeforeAdviceInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodBeforeAdviceInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodBeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(MethodBeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        PayService payService = new PayServiceImpl();
        PayService proxy = (PayService) Proxy.newProxyInstance(payService.getClass().getClassLoader(), payService.getClass().getInterfaces(), new MyInvocationHandle(payService));
        proxy.pay();
        //proxy.cancel();
    }
}
