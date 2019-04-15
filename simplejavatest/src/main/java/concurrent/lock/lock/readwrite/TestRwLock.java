package concurrent.lock.lock.readwrite;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liu peng bo
 * @date 2018/12/18
 */
public class TestRwLock {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock().lock();
        System.out.println("read 1");
        lock.writeLock().lock();
        //lock.readLock().unlock();
        /*for (int i = 0; i < 1; i++) {
            RwThread thread = new RwThread("rw" + i, lock);
            thread.start();
        }*/
        CountDownLatch countDownLatch = new CountDownLatch(1);
        RwThread thread1 = new RwThread("rw1", lock);
        RwThread thread2 = new RwThread("rw2", lock);
        thread1.start();
        thread2.start();
        System.out.println("-----------");
    }
}
