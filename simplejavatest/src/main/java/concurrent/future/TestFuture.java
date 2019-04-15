package concurrent.future;

import concurrent.threadpool.factory.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author liu peng bo
 * @date 2018/12/9
 */
public class TestFuture {
    public static void main(String[] args) {
        ThreadFactoryBuilder builder = new ThreadFactoryBuilder().setPrefix("future");
        ThreadFactory factory = builder.build();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0, 100, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(), factory);
        MyCallableJob callableJob = new MyCallableJob();
        List<Future> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(poolExecutor.submit(callableJob));
        }

        list.forEach(l ->
        {
            try {
                System.out.println(l.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
