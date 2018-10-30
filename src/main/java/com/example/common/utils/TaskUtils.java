package com.example.common.utils;

import com.example.quartz.domain.ScheduleJob;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午4:20 28/10/18
 * @Modified by:
 */
@Slf4j
public class TaskUtils {

    public static boolean invokeMethod(ScheduleJob task) {
        try {
            String beanClass = task.getExecuteClass();
            Method method = methodIsExist(beanClass, task.getExecuteMethod(), task.getExecuteParam());
            if(method ==null){
                return false;
            }
            log.info("调用方法:" + String.valueOf(method));
            method.invoke(Class.forName(beanClass).newInstance(), task.getExecuteParam());
            return true;

        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            log.error("方法调用异常：", e.getMessage());
            return false;
        }
    }

    public static Method methodIsExist(String beanClass, String beanMethod, Object[] args) {
        try {
            Class<?> clazz = Class.forName(beanClass);
            if(clazz == null){
                return null;
            }

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                Parameter[] parameters = method.getParameters();
                if (!(method.getName().equals(beanMethod) && parameters.length == args.length)) {
                    continue;
                }
                if (parameters.length == 0) {
                    return method;
                }
                //判断方法参数类型是否匹配
                for (int i = 0; i < parameters.length; i++) {
                    if (parameters[i].getType() != args[i].getClass()) {
                        return null;
                    }
                }
                return method;
            }
            return null;
        } catch (ClassNotFoundException e) {
            log.error("方法调用异常：", e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        ScheduleJob exportTask = new ScheduleJob();
        exportTask.setJobId("11");
        exportTask.setJobName("test");
        exportTask.setCronExpression("5 * * * * ? *");
        exportTask.setJobGroup("DEFAULT");
        exportTask.setCreateTime(new Date());
        exportTask.setExecuteClass("com.example.job.ExecuteTask");
        exportTask.setExecuteMethod("hello");
        exportTask.setExecuteParam(new Object[]{});

        System.out.println(invokeMethod(exportTask));
    }


}
