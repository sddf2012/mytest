package com.initialize;

/**
 * @author liu peng bo
 * @date 2018/5/30
 */
public class Test {
    static {
        System.out.println("静态块");
    }

    {
        System.out.println("非静态块");
    }

    static class Inner {
        static {
            System.out.println("内部静态块");
        }

        {
            System.out.println("内部非静态块");
        }
        static int i=1;

    }

    public static void get() {
        int a=Inner.i;
    }

    public static void main(String[] args) {
        Test.get();
    }
}
