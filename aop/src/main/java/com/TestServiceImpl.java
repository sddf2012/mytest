package com;

import org.springframework.stereotype.Service;

/**
 * @author liu peng bo
 * @date 2018/9/4
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    @TestAnnotation
    public void test() {
        //int i=1/0;
        System.out.println("test.........");
        System.out.println(this.getClass().getName());
    }
}
