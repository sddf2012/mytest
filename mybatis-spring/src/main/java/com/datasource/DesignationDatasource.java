package com.datasource;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author liu peng bo
 * @date 2018/9/3
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DesignationDatasource {
     String value();
}
