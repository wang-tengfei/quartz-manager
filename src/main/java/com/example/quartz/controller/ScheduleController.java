package com.example.quartz.controller;

import com.example.quartz.domain.ScheduleJob;
import com.example.quartz.service.IScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午7:01 28/10/18
 * @Modified by:
 */
@RestController
public class ScheduleController {

    @Autowired
    private IScheduleJobService jobService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public boolean addTask(@RequestBody ScheduleJob task){

        return jobService.addJob(task);
    }

    @RequestMapping(value = "/test", method = RequestMethod.DELETE)
    public boolean removeTask(@RequestParam("jobName")String jobName,
                              @RequestParam(value = "jobGroup", required = false,defaultValue = "DEFAULT")String jobGroup){

        return jobService.removeJob(jobName, jobGroup);
    }

}
