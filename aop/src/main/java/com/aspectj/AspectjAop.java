package com.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
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
    @Pointcut("execution(* com.*Service.*(..))")
    public void pointcut() {
    }

    @AfterReturning("pointcut()&&@annotation(testAnnotation)")
    public void afterReturn(JoinPoint joinpoint, TestAnnotation testAnnotation) {
        System.out.println("after return:" + new Date());
    }

    @AfterThrowing("pointcut()&&@annotation(testAnnotation)")
    public void afterThrow(JoinPoint joinpoint, TestAnnotation testAnnotation) {
        System.out.println("after throw:" + new Date());
    }

    @After("pointcut()&&@annotation(testAnnotation)")
    public void after(JoinPoint joinpoint, TestAnnotation testAnnotation) {
        System.out.println("after:" + new Date());
    }
}
