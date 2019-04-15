package concurrent.lock.locksupport;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author liu peng bo
 * @date 2018/12/9
 */
public class FIFOLock {
    private static final AtomicBoolean LOCK_STATE = new AtomicBoolean(false);
    private static final Queue<Thread> QUEUE = new LinkedBlockingQueue<>();

    public static void lock() {
        Thread thread = Thread.currentThread();
        System.out.println("要获取锁的线程为:" + thread.getName() + " " + new Date());
        QUEUE.add(thread);
        MyBlock myBlock = new MyBlock("");
        while (QUEUE.peek() != thread || !LOCK_STATE.compareAndSet(false, true)) {
            if (QUEUE.peek() != thread) {
                myBlock.setReason("阻塞队列头非当前线程!");
            } else {
                myBlock.setReason("获取锁失败!");
            }
            System.out.println(myBlock.getReason());
            System.out.println("线程" + thread.getName() + "开始等待!" + " " + new Date() /*+ " " + "原因为:" +
                    ((MyBlock) LockSupport.getBlocker(thread)).getReason()*/);
            LockSupport.parkUntil(/*myBlock,*/ System.currentTimeMillis() + 2000);
            //LockSupport.parkNanos(3000000000L);
            //LockSupport.park();
            System.out.println("线程" + thread.getName() + "等待结束!" + " " + new Date());
        }
        System.out.println("线程" + thread.getName() + "获取到锁!" + " " + new Date());
        QUEUE.remove();
    }

    public static void unLock() {
        System.out.println("线程" + Thread.currentThread().getName() + "释放锁!" + " " + new Date());
        LOCK_STATE.set(false);
        LockSupport.unpark(QUEUE.peek());
    }
}
