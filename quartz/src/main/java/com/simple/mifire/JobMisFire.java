package com.simple.mifire;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2018/9/28
 */
@DisallowConcurrentExecution
public class JobMisFire implements Job {
    private static int i = 1;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println("job begin execute " + i + " " + new Date());
        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.err.println("job execute " + i + " over " + new Date());

        i++;
    }
}
