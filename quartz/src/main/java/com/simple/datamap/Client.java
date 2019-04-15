package com.simple.datamap;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author liu peng bo
 * @date 2018/9/27
 */
public class Client {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDataMap dataMap1=new JobDataMap();
        dataMap1.put("a","1");
        dataMap1.put("b","2");
        JobDetail job = JobBuilder.newJob(Job3.class).usingJobData(dataMap1).withIdentity("j1", "g1")
                .build();

        JobDataMap dataMap2=new JobDataMap();
        dataMap2.put("c","3");
        dataMap2.put("d","4");
        dataMap2.put("a","5");
        Trigger trigger = TriggerBuilder.newTrigger().startNow().withIdentity("t1", "t").usingJobData(dataMap2)
                .build();
        scheduler.scheduleJob(job,trigger);
        scheduler.start();
    }
}
