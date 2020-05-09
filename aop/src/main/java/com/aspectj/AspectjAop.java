package com.aspectj;

import com.domain.PayBo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/8/22 9:34
 */
@Aspect
@Component
public class AspectjAop {
    @Pointcut("execution(* com.*.*Service*.*(..))")
    public void pointcut() {
    }

    @Pointcut("execution(* com.*.*Service*.*(..))&&@annotation(TestAround)")
    public void pointcut2() {
    }

    /*@AfterReturning("pointcut()&&@annotation(testAnnotation)")
    public void afterReturn(JoinPoint joinpoint, TestAnnotation testAnnotation) {
        System.out.println("after return:" + new Date());
    }

    @AfterThrowing("pointcut()&&@annotation(testAnnotation)")
    public void afterThrow(JoinPoint joinpoint, TestAnnotation testAnnotation) {
        System.out.println("after throw:" + new Date());
    }*/

    @After(value = "pointcut()&&@annotation(testAnnotation)")
    public void after(JoinPoint joinpoint, TestAnnotation testAnnotation) {
        System.out.println("after:" + new Date());
    }

   /* @Before("pointcut()&&@annotation(testAnnotation)")
    public void before(JoinPoint joinpoint, TestAnnotation testAnnotation) {
        System.out.println("aspectj before");
    }

    @Around("pointcut2()&&@annotation(testAround)")
    public Object around(ProceedingJoinPoint pjp,TestAround testAround) throws Throwable {
        Signature signature= pjp.getSignature();
       Object[] args= pjp.getArgs();
       int i=(int)args[0];
        PayBo payBo=(PayBo)args[1];
        System.out.println(i);
        System.out.println(payBo);
        System.out.println(testAround.test());
        return pjp.proceed();
    }*/
}
