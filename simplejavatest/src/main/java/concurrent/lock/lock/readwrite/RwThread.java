package concurrent.lock.lock.readwrite;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author liu peng bo
 * @date 2018/12/19
 */
public class RwThread extends Thread {
    private ReadWriteLock lock;

    public RwThread(String name, ReadWriteLock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.readLock().lock();
    }
}
