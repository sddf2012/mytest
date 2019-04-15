package com.string;

/**
 * @author liu peng bo
 * @date 2019/3/11
 */
public class StringLocationEx {
    public static void main(String[] args) {
       /* String s1 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(s1.intern() == s1);
        String s10="java";
        System.out.println(s1==s10);*/

        String s0 = new StringBuilder().append("q").append("a").toString();
        System.out.println(s0.intern() == s0);
        String s00="qa";
        System.out.println(s0==s00);
    }
}
