package com.liftapp.services.interfaces;

import com.liftapp.model.Bean.LU_JOB;
import com.liftapp.model.command.JobCommand;

import java.util.List;

public interface JobService {
    List<LU_JOB> getAllJobs();
    List<LU_JOB> getAllFreeJobs();
    List<LU_JOB> getMyAssigned(String driver_username);
    LU_JOB createJob(String username, JobCommand jobCommand);
    boolean cancelRide(Long job_id);
    boolean scheduleJob(Integer id, String username);
}
