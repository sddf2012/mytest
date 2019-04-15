package com;

import java.lang.annotation.*;

/**
 * @author liu peng bo
 * @date 2018/9/4
 */
@Documented
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    boolean value() default false;
}
