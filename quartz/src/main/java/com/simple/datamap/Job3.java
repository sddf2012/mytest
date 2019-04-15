package com.simple.datamap;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author liu peng bo
 * @date 2018/9/27
 */
public class Job3 implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap=context.getMergedJobDataMap();
        dataMap.forEach((key,value)->{
            System.err.println("~~~~~~~~~~:"+key+"--"+value);
        });
        System.err.println("over");
    }
}
