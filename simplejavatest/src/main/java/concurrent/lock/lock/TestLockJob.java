package concurrent.lock.lock;

import java.util.concurrent.locks.Lock;

/**
 * @author liu peng bo
 * @date 2018/12/18
 */
public class TestLockJob extends Thread {
    private Lock lock;

    public TestLockJob(Lock lock, String name) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            //lock.lockInterruptibly();
            //System.out.println(lock.tryLock());
            //System.out.println(lock.tryLock(3, TimeUnit.SECONDS));
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
