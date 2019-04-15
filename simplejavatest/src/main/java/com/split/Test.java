package com.split;

/**
 * @author liu peng bo
 * @date 2018/5/23
 */
public class Test {
    public static void main(String[] args) {
        /*String a = "a";
        String[] ss = a.split("\\.");
        for (String s : ss) {
            System.out.println(s);
        }*/

        String a = "a|b||";
        String[] ss = a.split("\\|",4);
        System.out.println(ss.length);
        for (String s : ss) {
            System.out.println(s==null);
        }


    }
}
