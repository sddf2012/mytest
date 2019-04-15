package com.string;

/**
 * @author liu peng bo
 * @date 2018/8/16
 */
public class Test {
    static void string() {
        long begin = System.currentTimeMillis();
        String a = "qwe";
        for (int i = 0; i < 10; i++) {
            a += "ewrwe";
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    static void stringBuffer() {
        long begin = System.currentTimeMillis();
        StringBuffer a = new StringBuffer("qwe");
        for (int i = 0; i < 10; i++) {
            a = a.append("ewrwe");
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    static void stringBuilder() {
        long begin = System.currentTimeMillis();
        StringBuilder a = new StringBuilder("qwe");
        for (int i = 0; i < 10; i++) {
            a = a.append("ewrwe");
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    public static void main(String[] args) {
        string();
        stringBuffer();
        stringBuilder();
    }
}
