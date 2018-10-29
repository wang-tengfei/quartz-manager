package com.example.quartz.utils;

import com.example.quartz.config.ExportTask;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午4:20 28/10/18
 * @Modified by:
 */
@Slf4j
public class TaskUtils {

    public static boolean invokeMethod(ExportTask task) {
        try {
            String beanClass = task.getBeanClass();
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
        ExportTask exportTask = new ExportTask();
        exportTask.setJobId(1);
        exportTask.setJobName("test");
        exportTask.setCronExpression("5 * * * * ? *");
        exportTask.setJobGroup("DEFAULT");
        exportTask.setCreateTime("2018/10/26 17:50:05");
        exportTask.setBeanClass("com.example.quartz.job.ExecuteTask");
        exportTask.setExecuteMethod("hello");

        invokeMethod(exportTask);
    }


}
