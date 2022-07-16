package com.liftapp.services.implementations;

import com.liftapp.model.Bean.LU_JOB;
import com.liftapp.repositories.JPARepos.JPAJobRepository;
import com.liftapp.repositories.JPARepos.JpaUserRepository;
import com.liftapp.services.interfaces.JobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    final JPAJobRepository jobRepository;
    final JpaUserRepository userRepository;

    public JobServiceImpl(JPAJobRepository jobRepository, JpaUserRepository userRepository){
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<LU_JOB> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public List<LU_JOB> getAllFreeJobs() {
        return jobRepository.findAllByDriverIsNull();
    }

    @Transactional
    @Override
    public boolean scheduleJob(Integer id, String username) {
        try{
            this.jobRepository.assignJob(userRepository.findByUsername(username), Long.valueOf(id));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
