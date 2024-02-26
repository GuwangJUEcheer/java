package cn.itcast.mp.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.itcast.mp.utils.JobUtils;

@Configuration
public class QuartzConfig {

	@Bean
	public JobDetail jobDetail() {
		
		return JobBuilder.newJob(JobUtils.class)//绑定具体的class
				.storeDurably()//持久化
				.withIdentity("jobdetail","group")
				.usingJobData("count",1)//共享数据
				.build();
	}
	
	@Bean
	public Trigger trigger() {
		//时间cron表达式
		return TriggerBuilder.newTrigger().withIdentity("trigger", "group")//			
				.forJob(jobDetail())//触发器肯定要和jobdetail关联的 ioc容器的bean名字
				.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
	}
}
