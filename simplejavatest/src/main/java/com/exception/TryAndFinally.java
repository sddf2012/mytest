package com.exception;

/**
 * @author liu peng bo
 * @date 2018/9/25
 */
public class TryAndFinally {
    public int get() {
        try {
            return 1;
        } finally {
            System.out.println("execute finally");
        }

    }

    public static void main(String[] args) {
        TryAndFinally tryAndFinally=new TryAndFinally();
        System.out.println(tryAndFinally.get());
    }
}
