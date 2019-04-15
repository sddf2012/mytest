package com.simple.s1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2018/9/18
 */
public class Client {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").withDescription("").build();
        Date date = DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND);
        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(date).withPriority(1)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(2)).build();
        /*Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1").startAt(date).withPriority(1)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(3).withIntervalInSeconds(5)).forJob(jobDetail)
                .withPriority(2).build();*/
        scheduler.scheduleJob(jobDetail,trigger1);
        //scheduler.scheduleJob(trigger2);
        System.out.println("已执行的job:"+scheduler.getMetaData().getNumberOfJobsExecuted());
        System.out.println("开始执行!");
        scheduler.start();
        /*Thread.sleep(15*1000);
        System.out.println("15s后已执行的job:"+scheduler.getMetaData().getNumberOfJobsExecuted());
        Thread.sleep(30*1000);
        System.out.println("40s后已执行的job:"+scheduler.getMetaData().getNumberOfJobsExecuted());*/
        //scheduler.shutdown();
    }
}
