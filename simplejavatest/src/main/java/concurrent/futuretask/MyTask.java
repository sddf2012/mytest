package concurrent.futuretask;

import java.util.concurrent.Callable;

/**
 * @author liu peng bo
 * @date 2019/1/15
 */
public class MyTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " enter method,begin sleep");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " sleep over");
        return 1;
    }
}
