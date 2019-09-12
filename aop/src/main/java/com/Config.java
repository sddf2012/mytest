package com;

import com.advice.TestBeforeAdvice;
import com.advice.introduction.PerformanceInterceptor;
import com.service.CallbackService;
import com.service.CallbackServiceImpl;
import com.service.PayService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author liu peng bo
 * @date 2018/9/4
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com")
public class Config {
    /*@Bean
    @Primary
    public PayService payServiceProxy(PayService payService, PayBeforeAdvice payBeforeAdvice) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(payService);
        proxyFactory.addAdvice(payBeforeAdvice);
        return (PayService) proxyFactory.getProxy();
    }*/

    /*@Bean
    @Qualifier("payService2")
    public PayService payService2(PayService payService, PerformanceInterceptor performanceInterceptor) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(payService);
        proxyFactory.addAdvice(performanceInterceptor);
        proxyFactory.setProxyTargetClass(true);
        return (PayService) proxyFactory.getProxy();
    }*/

    @Bean
    public CallbackService payService2() {
        CallbackService callbackService=new CallbackServiceImpl();
        TestBeforeAdvice testBeforeAdvice=new TestBeforeAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(callbackService);
        proxyFactory.addAdvice(testBeforeAdvice);
        return (CallbackService) proxyFactory.getProxy();
    }
}
