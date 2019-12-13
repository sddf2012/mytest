package com.aopimpl;

import com.aopimpl.annotation.MyAfter;
import com.aopimpl.annotation.MyBefore;
import org.aopalliance.aop.Advice;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/12/12 10:03
 */
public class MyAop implements Advice {
    @MyBefore
    public void before(){
        System.out.println("before 1");
    }

    @MyBefore
    public void before2(){
        System.out.println("before 2");
    }

    @MyAfter
    public void after1(){
        System.out.println("after 1");
    }
}
