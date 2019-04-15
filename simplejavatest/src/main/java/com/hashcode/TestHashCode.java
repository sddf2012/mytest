package com.hashcode;

/**
 * @author liu peng bo
 * @date 2018/10/17
 */
public class TestHashCode {
    public static void main(String[] args) {
        String a="1";
        System.out.println(a.hashCode());
        String b="abcdefg";
        byte[] bytes=b.getBytes();
        for (int i = 0; i <bytes.length ; i++) {
            System.out.println(bytes[i]);
        }
    }
}
