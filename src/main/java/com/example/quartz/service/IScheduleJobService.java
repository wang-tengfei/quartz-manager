package com.example.quartz.service;

import com.example.quartz.domain.ScheduleJob;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午5:05 26/10/18
 * @Modified by:
 */
public interface IScheduleJobService {


    /**
     * 向容器中添加任务
     *
     * @param task
     * @return
     */
    boolean addJob(ScheduleJob task);

    /**
     * 修改任务
     *
     * @param task
     */
    void editJob(ScheduleJob task);

    /**
     * 执行定时任务
     *
     * @param scheduleJob
     */
    void executeJob(ScheduleJob scheduleJob);

    /**
     * 从容器中删除任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    boolean removeJob(String jobName, String jobGroup);
}
