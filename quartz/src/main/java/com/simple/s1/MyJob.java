package com.simple.s1;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2018/9/18
 */
//@DisallowConcurrentExecution
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread name "+Thread.currentThread().getId()+" "+Thread.currentThread().getName()+" job name:" + context.getJobDetail().getKey() + ",trigger:" + context.getTrigger().getKey() + ",调用时间" + context.getFireTime() + ",执行时间" + new Date() + ",下次调用时间" + context.getNextFireTime());
    }
}
