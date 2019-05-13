package concurrent.completefuture;

import java.util.concurrent.CompletableFuture;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/13 14:53
 */
public class TestHisMethods {
    static String threadName() {
        return Thread.currentThread().getName();
    }

    static void delay(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static CompletableFuture test1() {
        return CompletableFuture.supplyAsync(() -> {
            delay(3);
            return "complete";
        });
    }

    static CompletableFuture test2() {
        return CompletableFuture.supplyAsync(() -> {
            delay(2);
            return "task1";
        }).thenCombineAsync(CompletableFuture.supplyAsync(() -> {
            delay(3);
            return "task2";
        }), (s, t) -> s + " " + t);
    }

    public static void main(String[] args) {
        CompletableFuture future;
        long start = System.currentTimeMillis();

        //test1
        future=test1();
        System.out.println("获取future耗时:"+(System.currentTimeMillis()-start));
        System.out.println(future.join());
        System.out.println("获取结果耗时:"+(System.currentTimeMillis()-start));

        //test2
        /* future = test2();
        System.out.println(future.join());
        System.out.println(System.currentTimeMillis() - start);*/
    }
}
