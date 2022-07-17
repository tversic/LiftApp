package com.liftapp.services.interfaces;

import com.liftapp.model.Bean.LU_JOB;

import java.util.List;

public interface JobService {
    List<LU_JOB> getAllJobs();
    List<LU_JOB> getAllFreeJobs();
    List<LU_JOB> getMyAssigned(String driver_username);
    boolean cancelRide(Long job_id);
    boolean scheduleJob(Integer id, String username);
}
