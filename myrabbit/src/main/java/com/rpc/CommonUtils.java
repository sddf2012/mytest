package com.rpc;

/**
 * @author liu peng bo
 * @date 2018/11/1
 */
public class CommonUtils {
    public static String serverQueue = "rpcServer";

    public static String replyQueue = "replyQueue";

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
