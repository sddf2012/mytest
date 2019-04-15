package com;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2018/9/4
 */
@Aspect
@Component
public class TestAop {
    @Pointcut("execution(* com.*Service.*(..))")
    public void pointcut() {
    }

    @AfterReturning("pointcut()&&@annotation(testAnnotation)")
    public void afterReturn(JoinPoint joinpoint,TestAnnotation testAnnotation) {
        System.out.println("after return:" + new Date());
        //System.out.println(joinpoint.getSignature().getClass());
        //System.out.println(testAnnotation.value());
    }

    @AfterThrowing("pointcut()&&@annotation(testAnnotation)")
    public void afterThrow(JoinPoint joinpoint,TestAnnotation testAnnotation) {
        System.out.println("after throw:" + new Date());
        //System.out.println(joinpoint.getSignature().getClass());
        //System.out.println(testAnnotation.value());
        //AnnotationUtils.getAnnotation(object.getClass())
    }

    @After("pointcut()&&@annotation(testAnnotation)")
    public void after(JoinPoint joinpoint,TestAnnotation testAnnotation) {
        System.out.println("after:" + new Date());
        System.out.println(this.getClass().getName());
        //System.out.println(joinpoint.getSignature().getClass());
        //System.out.println(testAnnotation.value());
        //AnnotationUtils.getAnnotation(object.getClass())
    }
}
