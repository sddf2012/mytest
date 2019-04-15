package concurrent.threadpool;

import concurrent.threadpool.factory.ThreadFactoryBuilder;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liu peng bo
 * @date 2018/12/12
 */
public class TestScheduledPool {
    public static void main(String[] args) {
        MyJob myJob=new MyJob();
        ThreadFactoryBuilder builder=new ThreadFactoryBuilder();
        builder.setPrefix("sche");
        ScheduledExecutorService executorService=new ScheduledThreadPoolExecutor(10,builder.build());
        System.out.println(new Date());
        //executorService.schedule(myJob,5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(myJob,2,3, TimeUnit.SECONDS);
        //executorService.scheduleWithFixedDelay(myJob,2,3, TimeUnit.SECONDS);
    }
}
