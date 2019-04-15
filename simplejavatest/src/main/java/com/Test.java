package com;

/**
 * @author liu peng bo
 * @date 2018/10/10
 */
public class Test<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static <T> Test<T> get(T t) {
        Test<T> tTest = new Test<T>();
        tTest.setT(t);
        return tTest;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = a + (a >> 2);
        System.out.println(16>>4);
        System.out.println(1<<4);
        System.out.println(32>>>3);
    }
}
