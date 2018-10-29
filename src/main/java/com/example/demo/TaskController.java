package com.example.demo;

import com.example.quartz.config.ExportTask;
import com.example.quartz.service.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午7:01 28/10/18
 * @Modified by:
 */
@RestController
public class TaskController {

    @Autowired
    private QuartzManager quartzManager;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public boolean addTask(@RequestBody ExportTask task){

        return quartzManager.addJob(task);
    }

    @RequestMapping(value = "/test", method = RequestMethod.DELETE)
    public boolean removeTask(@RequestParam("jobName")String jobName,
                              @RequestParam(value = "jobGroup", required = false,defaultValue = "DEFAULT")String jobGroup){

        return quartzManager.removeJob(jobName, jobGroup);
    }

}
