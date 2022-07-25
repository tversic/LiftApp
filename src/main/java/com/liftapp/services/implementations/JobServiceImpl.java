package com.liftapp.services.implementations;

import com.liftapp.model.Bean.LU_JOB;
import com.liftapp.model.Bean.User;
import com.liftapp.model.command.JobCommand;
import com.liftapp.repositories.JPARepos.JPAJobRepository;
import com.liftapp.repositories.JPARepos.JpaUserRepository;
import com.liftapp.services.interfaces.JobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
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

    @Override
    public LU_JOB createJob(String username, JobCommand jobCommand) {
        return jobRepository.save(mapJobCommandToLuJob(jobCommand, username));
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

    private LU_JOB mapJobCommandToLuJob(JobCommand jobCommand, String username){
        LU_JOB job = new LU_JOB();
        job.setTitle(jobCommand.getTitle());
        job.setDescription(jobCommand.getDescription());
        job.setPickupLocation(jobCommand.getPickup_location());
        job.setTarget_location(jobCommand.getTarget_location());
        job.setIssuedDate(jobCommand.getIssuedDate());
        job.setPrice(Double.valueOf(jobCommand.getPrice()));
        job.setDistance(null);
        job.setDateNeeded(Date.valueOf(jobCommand.getDateNeeded()));
        job.setPickupHours(jobCommand.getPickupHours());
        job.setWidth(Integer.valueOf(jobCommand.getWidth()));
        job.setLenght(Integer.valueOf(jobCommand.getLength()));
        job.setWeight(Integer.valueOf(jobCommand.getWeight()));
        job.setIssuer(userRepository.findByUsername(username));
        return job;
    }

}
