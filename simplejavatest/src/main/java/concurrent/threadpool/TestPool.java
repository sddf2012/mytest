package concurrent.threadpool;

import concurrent.threadpool.factory.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author liu peng bo
 * @date 2018/12/11
 */
public class TestPool {
    private int i = 10000;


    public void withoutPool() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(i);
        MyJob myJob = new MyJob(countDownLatch);
        long start = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            Thread thread = new Thread(myJob);
            thread.start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public void withPool() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(i);
        MyJob myJob = new MyJob(countDownLatch);
        ThreadFactoryBuilder builder = new ThreadFactoryBuilder().setPrefix("withPool");
        ThreadFactory factory = builder.build();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(i, i, 0L, TimeUnit.MINUTES, new LinkedBlockingDeque<>(), factory);
        long start = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            poolExecutor.execute(myJob);
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) throws InterruptedException {
        TestPool testPool = new TestPool();
        testPool.withoutPool();
        testPool.withPool();

    }
}
