package concurrent.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu peng bo
 * @date 2018/12/12
 */
public class TestCondition {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        MyConditionJob job = new MyConditionJob();
        job.setLock(lock);
        job.setCondition(condition);
        job.start();
        //System.out.println(lock.tryLock(2, TimeUnit.SECONDS));

        MyConditionJob job2 = new MyConditionJob();
        job2.setLock(lock);
        job2.setCondition(condition);
        job2.start();

        //Thread.sleep(3000);
        //job.interrupt();
        //Thread.sleep(1000);
        //System.out.println(lock.tryLock(3, TimeUnit.SECONDS));

        //job2.interrupt();
        Thread.sleep(3000);

        lock.lock();
        condition.signalAll();
        lock.unlock();

    }
}
