package com.example.quartz.config;

import com.example.quartz.utils.TaskUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Arrays;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午5:00 26/10/18
 * @Modified by:
 */
@DisallowConcurrentExecution
@Slf4j
public class QuartzFactory implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            ExportTask task = (ExportTask) jobExecutionContext.getJobDetail().getJobDataMap().get("scheduleJob");
            log.info("定时任务开始:" + task.getJobName());
            if(!TaskUtils.invokeMethod(task)){
                log.error("方法："+ task.getBeanClass() + "." + task.getExecuteMethod() +"("+ Arrays.toString(task.getExecuteParam()) +")调用失败");
            }
            log.info("定时任务结束:" + task.getJobName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
