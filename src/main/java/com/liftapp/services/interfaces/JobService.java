package com.liftapp.services.interfaces;

import com.liftapp.model.Bean.LU_JOB;

import java.util.List;

public interface JobService {
    List<LU_JOB> getAllJobs();
    List<LU_JOB> getAllFreeJobs();
    boolean scheduleJob(Integer id, String username);
}
