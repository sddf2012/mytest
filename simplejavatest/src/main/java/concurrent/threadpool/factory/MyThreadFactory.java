package concurrent.threadpool.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liu peng bo
 * @date 2018/12/11
 */
public class MyThreadFactory implements ThreadFactory {
    private AtomicInteger number = new AtomicInteger(1);

    private String prefix;

    public MyThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, prefix + number.getAndIncrement());
    }
}
