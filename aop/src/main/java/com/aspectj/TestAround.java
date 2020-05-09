package com.aspectj;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author liu peng bo
 * date: 2020/3/6 15:25
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAround {
    String test() default "11qqq";
}
