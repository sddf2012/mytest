package concurrent.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu peng bo
 * @date 2018/12/12
 */
public class TestLock {
    Lock lock=new ReentrantLock(true);

    private void testLock() throws Exception {
        lock.lock();
        //lock.lock();
        Thread child1=new TestLockJob(lock,"child1");
        Thread child2=new TestLockJob(lock,"child2");
        Thread child3=new TestLockJob(lock,"child3");

        child1.start();
        child2.start();
        child3.start();

        Thread.sleep(2000);

        lock.unlock();

        /*child1.interrupt();
        child2.interrupt();
        child3.interrupt();*/

        System.out.println("main over");
    }

    public static void main(String[] args) throws Exception {
        TestLock testLock=new TestLock();
        testLock.testLock();
    }
}
