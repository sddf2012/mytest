package com.advice.introduction;

import com.Config;
import com.service.PayService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/8/22 9:49
 */
//@Component
public class PerformanceInterceptor extends DelegatingIntroductionInterceptor implements PerformanceMinor {

    ThreadLocal<Boolean> threadLocal = new ThreadLocal<Boolean>();

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object object;
        if (isOpen()) {
            long begin = System.currentTimeMillis();
            object = super.invoke(mi);
            long end = System.currentTimeMillis();
            System.out.println(mi.getThis().getClass().getName() + "." + mi.getMethod().getName() + " 耗时" + (end - begin));
        } else {
            object = super.invoke(mi);
        }
        return object;
    }

    @Override
    public void setOpen(boolean open) {
        threadLocal.set(open);
    }

    @Override
    public boolean isOpen() {
        return threadLocal.get() == null ? false : threadLocal.get();
    }

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        PayService payService = (PayService)ac.getBean("payService2");
        ((PerformanceMinor)payService).setOpen(true);
        payService.pay();
    }
}
