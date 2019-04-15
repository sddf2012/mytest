package com.aop;

import com.datasource.DatasourceContext;
import com.datasource.DesignationDatasource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author liu peng bo
 * @date 2018/9/3
 */
@Aspect
@Component
public class DatasourceAop {
    @Pointcut("execution(* com.service..*.*(..))&&@annotation(com.datasource.DesignationDatasource)")
    public void handleDatasource() {
    }

    @Before("handleDatasource() && @annotation(designationDatasource)")
    public void setDatasource(JoinPoint joinPoint, DesignationDatasource designationDatasource) {
        String value = designationDatasource.value();
        if (!StringUtils.hasText(value)) {
            value = "d1";
        }
        System.out.println("datasource:" + value);
        DatasourceContext.setDatasource(value);
    }

    @After("handleDatasource()")
    public void after() {
        System.out.println("after remove!");
        DatasourceContext.remove();
    }
}
