package concurrent.threadpool.factory;

import java.util.concurrent.ThreadFactory;

/**
 * @author liu peng bo
 * @date 2018/12/11
 */
public class ThreadFactoryBuilder {
    private String namePrefix;

    public ThreadFactoryBuilder setPrefix(String namePrefix) {
        this.namePrefix = namePrefix;
        return this;
    }

    public ThreadFactory build() {
       return new MyThreadFactory(this.namePrefix);
    }
}
