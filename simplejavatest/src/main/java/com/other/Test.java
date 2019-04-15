package com.other;

/**
 * @author liu peng bo
 * @date 2018/9/5
 */
public class Test {
    public static long get(int n) {
        long result = 0;
        long a=1,b=1;
        if (n == 1 || n == 2) {
            return a;
        } else {
            for (int i = 3; i <=n ; i++) {
                result=a+b;
                a=b;
                b=result;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(get(7));
    }
}
