package com;

import com.advice.PayBeforeAdvice;
import com.advice.introduction.PerformanceInterceptor;
import com.service.PayService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;

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

    @Bean
    @Qualifier("payService2")
    public PayService payService2(PayService payService, PerformanceInterceptor performanceInterceptor) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(payService);
        proxyFactory.addAdvice(performanceInterceptor);
        proxyFactory.setProxyTargetClass(true);
        return (PayService) proxyFactory.getProxy();
    }
}
