package suanfa.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liu peng bo
 * @date 2018/10/23
 */
public class TestCas {
    static AtomicInteger i = new AtomicInteger(0);

    static int i2;

    static void increment() {
        i.getAndIncrement();
        i2++;
    }


    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 20; j++) {
            new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
                    increment();
                }
            }).start();
        }
        Thread.sleep(2000);
        /*while (Thread.activeCount() > 1) {
            Thread.yield();
        }*/
        System.out.println(i);
        System.out.println(i2);

        /*ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();*/
    }
}
