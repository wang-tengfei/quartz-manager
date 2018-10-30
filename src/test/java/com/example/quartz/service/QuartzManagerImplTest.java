package com.example.quartz.service;

import com.example.DemoApplication;
import com.example.quartz.domain.ScheduleJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午5:12 26/10/18
 * @Modified by:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class QuartzManagerImplTest {

    @Autowired
    private IScheduleJobService IQuartzManager;

    @Test
    public void addJob() {
        ScheduleJob exportTask = new ScheduleJob();

        exportTask.setJobId("1");
        exportTask.setJobName("test");
        exportTask.setCronExpression("5 * * * * ? *");
        exportTask.setJobGroup("WTF");
        exportTask.setCreateTime(new Date());
        exportTask.setExecuteClass("com.example.job.ExecuteTask");
        exportTask.setExecuteMethod("hello");
        exportTask.setExecuteParam(new Object[]{});

        boolean job = IQuartzManager.addJob(exportTask);
        if(job){
            IQuartzManager.executeJob(exportTask);
        }else {
            System.out.println("》》》》》》》》》》》执行失败》》》》》》》》》》》》");
        }
    }

    @Test
    public void removeJob() {
    }
}