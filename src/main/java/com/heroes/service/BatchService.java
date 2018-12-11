package com.heroes.service;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@Configuration
@ComponentScan("com.heroes.service")
@Service
public class BatchService {
  @Autowired
  private CafeVisitingRecordService cafeVisitingRecordService;

  /**
   * @param jobName
   * @param expression 배치 스케줄링 표현식
   * @return
   */
  public int registBatch(String jobName, String expression, Object targetInst, String targetMethond, Object[] arguments) {


    // get the quartzFactory bean
    WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

    Scheduler scheduler = (Scheduler) context.getBean("JobScheduler");;

    try {
      // create JOB
      MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
      jobDetail.setTargetObject(targetInst);
      jobDetail.setTargetMethod(targetMethond);
      jobDetail.setArguments(arguments);
      jobDetail.setName(jobName);
      jobDetail.setConcurrent(false);
      jobDetail.afterPropertiesSet();


      // create CRON Trigger
      CronTriggerFactoryBean cronTrigger = new CronTriggerFactoryBean();
      cronTrigger.setBeanName("HEROES");

      cronTrigger.setCronExpression(expression);
      cronTrigger.afterPropertiesSet();

      scheduler.scheduleJob(jobDetail.getObject(), cronTrigger.getObject());

    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;

  }
}
