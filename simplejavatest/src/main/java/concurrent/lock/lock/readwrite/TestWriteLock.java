package concurrent.lock.lock.readwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liu peng bo
 * @date 2018/12/19
 */
public class TestWriteLock {
    public static void main(String[] args) {
        ReadWriteLock lock=new ReentrantReadWriteLock();
        lock.writeLock().lock();
        lock.writeLock().unlock();
    }
}
