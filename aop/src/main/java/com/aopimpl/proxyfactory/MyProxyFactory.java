package com.aopimpl.proxyfactory;

import com.aopimpl.MyInvocationHandle2;
import com.aopimpl.annotation.MyAfter;
import com.aopimpl.annotation.MyBefore;
import com.aopimpl.MyAop;
import com.aopimpl.aop.MyMethodInterceptor;
import com.aopimpl.aop.MyMethodInvocation;
import com.domain.PayBo;
import com.service.PayService;
import com.service.PayServiceImpl;
import org.aopalliance.aop.Advice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/12/9 17:01
 */
public class MyProxyFactory {

    private Object target;

    private List<Advice> adviceList = new ArrayList<>();

    public MyProxyFactory(Object traget) {
        this.target = traget;
        //methodInvocation.setTarget(target);
    }

    private List<MyMethodInterceptor> interceptors = new ArrayList<>();

    private MyMethodInvocation methodInvocation = new MyMethodInvocation();

    public void addAdvice(Advice advice) {
        adviceList.add(advice);
        Method[] methods = advice.getClass().getDeclaredMethods();

        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(MyBefore.class)) {
                    MyMethodInterceptor interceptor = new MyMethodInterceptor();
                    interceptor.setAop(advice);
                    interceptor.setMethod(method);
                    interceptors.add(interceptor);
                }
                /*if (annotation.annotationType().equals(MyAfter.class)) {
                    afters.add(method);
                }*/
            }
        }

        //methodInvocation.setInterceptors(interceptors);
    }

    private Object getProxy2() {
        MyInvocationHandle2 invocationHandler = new MyInvocationHandle2();
        //invocationHandler.setMethodInvocation(methodInvocation);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocationHandler);
    }

    public static void main(String[] args) {
        PayService payService = new PayServiceImpl();
        MyProxyFactory myProxyFactory = new MyProxyFactory(payService);
        myProxyFactory.addAdvice(new MyAop());
        PayService proxy = (PayService) myProxyFactory.getProxy2();
        proxy.pay();

        proxy.pay(new PayBo());
    }
}
