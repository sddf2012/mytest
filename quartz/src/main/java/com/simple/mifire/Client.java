package com.simple.mifire;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author liu peng bo
 * @date 2018/9/28
 */
public class Client {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(JobMisFire.class).withIdentity("j1", "g1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("t1", "g1").withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1)
        .withMisfireHandlingInstructionFireNow()).build();
        scheduler.scheduleJob(jobDetail, trigger);
        //scheduler.start();
    }
}
