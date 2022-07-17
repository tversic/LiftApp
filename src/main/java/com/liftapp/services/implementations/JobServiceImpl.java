package com.liftapp.services.implementations;

import com.liftapp.model.Bean.LU_JOB;
import com.liftapp.model.Bean.User;
import com.liftapp.repositories.JPARepos.JPAJobRepository;
import com.liftapp.repositories.JPARepos.JpaUserRepository;
import com.liftapp.services.interfaces.JobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<LU_JOB> getMyAssigned(String driver_username) {
        User driver = userRepository.findByUsername(driver_username);
        return jobRepository.findAllByDriver(driver);
    }

    @Transactional
    @Override
    public boolean cancelRide(Long job_id) {
        try{
            this.jobRepository.cancelJob(job_id);
        }catch (Exception e){
            return false;
        }return true;
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
