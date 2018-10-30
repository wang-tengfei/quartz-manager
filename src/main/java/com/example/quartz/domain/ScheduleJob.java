package com.example.quartz.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午4:58 26/10/18
 * @Modified by:
 */
@Document(collection = "schedule_job")
@Data
@ToString
public class ScheduleJob {

    /**
     * 任务id
     */
    @Id
    private String jobId;

    /**
     * 任务名称
     */
    @Field("job_name")
    private String jobName;

    /**
     * 任务分组
     */
    @Field("job_group")
    private String jobGroup;

    /**
     * 任务状态 0创建 1启用 2禁用 3删除
     */
    @Field("job_status")
    private Integer jobStatus;

    /**
     * 任务运行时间表达式
     */
    @Field("cron")
    private String cronExpression;

    /**
     * 任务执行类
     */
    @Field("execute_class")
    private String executeClass;

    /**
     * 任务执行方法
     */
    @Field("execute_method")
    private String executeMethod;

    /**
     * 任务执行参数
     */
    @Field("execute_param")
    private Object[] executeParam;

    /**
     * 任务创建时间
     */
    @Field("create_time")
    private Date createTime;

    /**
     * 任务更新时间
     */
    @Field("update_time")
    private Date updateTime;

    /**
     * 任务描述
     */
    @Field("job_desc")
    private String jobDesc;
}
