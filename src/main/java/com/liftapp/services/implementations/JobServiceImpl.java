package com.liftapp.services.implementations;

import com.liftapp.model.Bean.LU_JOB;
import com.liftapp.repositories.JPARepos.JPAJobRepository;
import com.liftapp.services.interfaces.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    final JPAJobRepository jobRepository;

    public JobServiceImpl(JPAJobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @Override
    public List<LU_JOB> getAllJobs() {
        return jobRepository.findAll();
    }
}
