package com.simple.persist;

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
        JobDetail job = JobBuilder.newJob().usingJobData(Job2.a, 1).withIdentity("j1", "g1").ofType(Job2.class)
                .build();
        Trigger trigger = TriggerBuilder.newTrigger().startNow().withIdentity("t1", "t").withSchedule(
                SimpleScheduleBuilder.repeatSecondlyForTotalCount(5, 5)
        ).build();
        scheduler.scheduleJob(job,trigger);
        scheduler.start();
    }
}
