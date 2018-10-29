package com.example.quartz.config;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午4:58 26/10/18
 * @Modified by:
 */
@Data
@ToString
public class ExportTask {

    /** 任务id */
    private int jobId;

    /** 任务名称 */
    private String jobName;

    /** 任务分组 */
    private String jobGroup;

    /** 任务状态 0禁用 1启用 2删除*/
    private String jobStatus;

    /** 任务运行时间表达式 */
    private String cronExpression;

    /** 任务执行类 */
    private String beanClass;

    /** 任务执行方法 */
    private String executeMethod;

    /** 任务执行参数 */
    private Object[] executeParam;

    /** 任务创建时间 */
    private String createTime;

    /** 任务更新时间 */
    private String updateTime;

    /** 任务描述 */
    private String jobDesc;
}
