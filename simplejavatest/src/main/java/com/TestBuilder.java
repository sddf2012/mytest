package com;

/**
 * @author liu peng bo
 * @date 2018/10/10
 */
public class TestBuilder {
    static <T> Test<T> get(T t){
        Test<T> tTest=new Test<T>();
        tTest.setT(t);
        return tTest;
    }
}
