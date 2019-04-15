package com.simple.persist;

import org.quartz.*;

/**
 * @author liu peng bo
 * @date 2018/9/27
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class Job2 implements Job {
    public static String a = "a";

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        context.getMergedJobDataMap();
        int i= dataMap.getInt(a);
        System.err.println("-------------"+i);
        dataMap.put(a,++i);
    }
}
