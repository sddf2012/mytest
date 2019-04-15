package concurrent.futuretask;

import java.util.concurrent.FutureTask;

/**
 * @author liu peng bo
 * @date 2019/1/15
 */
public class TestCode {
    public static void main(String[] args) throws InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyTask());
        MyThread thread1 = new MyThread(futureTask);
        MyThread thread2 = new MyThread(futureTask);
        MyThread thread3 = new MyThread(futureTask);
        thread1.start();
        Thread.sleep(2000);
        thread2.start();
        thread3.start();
        System.out.println(futureTask.isDone());
        /*LockSupport.unpark(thread1);
        LockSupport.unpark(thread2);*/
    }
}
