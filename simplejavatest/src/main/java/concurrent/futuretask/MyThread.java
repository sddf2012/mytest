package concurrent.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liu peng bo
 * @date 2019/1/15
 */
public class MyThread extends Thread{
    private FutureTask futureTask;

    public MyThread(FutureTask futureTask) {
        super();
        this.futureTask = futureTask;
    }

    @Override
    public void run(){
        try {
            futureTask.run();
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
