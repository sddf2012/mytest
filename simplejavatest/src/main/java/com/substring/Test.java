package com.substring;

/**
 * @author liu peng bo
 * @date 2018/7/17
 */
public class Test {
    public static void main(String[] args) {
        String a="asd123";
        System.out.println(a.substring(0,5));
        System.out.println(a.substring(0, 1).toUpperCase() + a.substring(1, a.length()));
    }
}
