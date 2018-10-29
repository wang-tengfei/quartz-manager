package com.example.quartz.service;

import com.example.quartz.config.ExportTask;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午5:05 26/10/18
 * @Modified by:
 */
public interface QuartzManager {


    /**
     * 向容器中添加任务
     *
     * @param task
     * @return
     */
    boolean addJob(ExportTask task);

    /**
     * 修改任务
     *
     * @param task
     */
    void editJob(ExportTask task);

    /**
     * 执行定时任务
     *
     * @param scheduleJob
     */
    void executeJob(ExportTask scheduleJob);

    /**
     * 从容器中删除任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    boolean removeJob(String jobName, String jobGroup);
}
