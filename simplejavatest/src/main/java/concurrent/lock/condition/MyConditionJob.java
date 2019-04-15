package concurrent.lock.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author liu peng bo
 * @date 2018/12/12
 */
public class MyConditionJob extends Thread {
    private Condition condition;
    private Lock lock;

    public MyConditionJob() {
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 开始等待！");
            condition.await(6, TimeUnit.SECONDS);
            //System.out.println(TimeUnit.SECONDS.toNanos(9));
            System.out.println(Thread.currentThread().getName() + " 等待结束！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
