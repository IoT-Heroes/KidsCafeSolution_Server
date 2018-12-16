package com.heroes.temp;

import java.util.UUID;
import org.quartz.Scheduler;
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

	/**
	 * @param jobName
	 * @param expression
	 *            배치 스케줄링 표현식
	 * @return
	 */
	public int registBatch(String jobName, String expression, Object targetInst, String targetMethond,
			Object[] arguments) throws Exception {

		// get the quartzFactory bean
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

		Scheduler scheduler = (Scheduler) context.getBean("JobScheduler");

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
		UUID uuid = UUID.randomUUID();
		cronTrigger.setBeanName(uuid.toString());

		cronTrigger.setCronExpression(expression);
		cronTrigger.afterPropertiesSet();

		scheduler.scheduleJob(jobDetail.getObject(), cronTrigger.getObject());
		return 0;

	}
}
