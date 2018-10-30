package com.example.quartz.repository;

import com.example.quartz.domain.ScheduleJob;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: Tengfei.Wang
 * @Description;
 * @Date: Created in 下午5:18 29/10/18
 * @Modified by:
 */
public interface ScheduleJobRepository extends MongoRepository<ScheduleJob, String>{

    ScheduleJob getScheduleJobByJobId(Integer jobId);

}
