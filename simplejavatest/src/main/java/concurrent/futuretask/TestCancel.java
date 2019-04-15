package concurrent.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liu peng bo
 * @date 2019/1/15
 */
public class TestCancel {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyTask());
        Thread thread = new Thread(futureTask);
        thread.start();
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        //System.out.println(futureTask.isDone());
        Thread.sleep(1000);
        //futureTask.cancel(true);
        Thread.sleep(6000);
        /*System.out.println(futureTask.get());
        System.out.println(futureTask.isDone());*/
    }
}
