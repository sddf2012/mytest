package com.simple.spring;

import com.simple.mifire.JobMisFire;
import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/9/28
 */
public class Test {
    public static void main(String[] args) throws SchedulerException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        Scheduler scheduler = ac.getBean(Scheduler.class);
        JobDetail jobDetail = JobBuilder.newJob(JobMisFire.class).withIdentity("j1", "g1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("t1", "g1").withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1)
                .withMisfireHandlingInstructionFireNow()).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
