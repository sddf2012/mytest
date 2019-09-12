package com;

import com.advice.TestBeforeAdvice;
import com.aspectj.AspectjAop;
import com.service.PayService;
import com.service.PayServiceImpl;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/9/10 15:51
 */
public class TestProxyFactory {
    static void testProxyFactory() {
        ProxyFactory proxyFactory = new ProxyFactory(new PayServiceImpl());
        proxyFactory.addAdvice(new TestBeforeAdvice());
        PayService payservice = (PayService) proxyFactory.getProxy();
        payservice.pay();
    }

    static void testAspectProxyFactory(){
        AspectJProxyFactory proxyFactory=new AspectJProxyFactory(new PayServiceImpl());
        proxyFactory.addAspect(AspectjAop.class);
        PayService payservice = proxyFactory.getProxy();
        payservice.pay();
    }

    public static void main(String[] args) {
        //testProxyFactory();
        testAspectProxyFactory();
    }
}
