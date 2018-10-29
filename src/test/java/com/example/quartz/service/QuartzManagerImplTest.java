package com.example.quartz.service;

import com.example.demo.DemoApplication;
import com.example.quartz.config.ExportTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午5:12 26/10/18
 * @Modified by:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class QuartzManagerImplTest {

    private List<ExportTask> tasks = new ArrayList<>();

    @Autowired
    private QuartzManager quartzManager;

    @Test
    public void addJob() {
        ExportTask exportTask = new ExportTask();

        exportTask.setJobId(1);
        exportTask.setJobName("test");
        exportTask.setCronExpression("5 * * * * ? *");
        exportTask.setJobGroup("WTF");
        exportTask.setCreateTime("2018/10/26 17:50:05");
        exportTask.setBeanClass("com.example.quartz.job.ExecuteTask");
        exportTask.setExecuteMethod("hello");

        boolean job = quartzManager.addJob(exportTask);
        if(job){
            quartzManager.executeJob(exportTask);
        }else {
            System.out.println("》》》》》》》》》》》执行失败》》》》》》》》》》》》");
        }
    }

    @Test
    public void removeJob() {
    }
}