package com.liftapp.controllers;

import com.liftapp.model.Bean.LU_JOB;
import com.liftapp.services.interfaces.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/job")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<LU_JOB>> getAllJobs(){
        try {
            return ResponseEntity.ok(jobService.getAllJobs());
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("getFree")
    public ResponseEntity<List<LU_JOB>> getFreeJobs(){
        try{
            return ResponseEntity.ok().body(jobService.getAllFreeJobs());
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("getMyAssigned/{driver_username}")
    public ResponseEntity<List<LU_JOB>> getMyAssigned(@PathVariable String driver_username){
        try{
            return ResponseEntity.ok().body(jobService.getMyAssigned(driver_username));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/{id}/{username}")
    public ResponseEntity scheduleJob(@PathVariable Integer id, @PathVariable String username){
        if(jobService.scheduleJob(id, username)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/cancelRide/{job_id}")
    public ResponseEntity cancelRide(@PathVariable Long job_id){
        if(1 == 1){
            jobService.cancelRide(job_id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.internalServerError().build();
        }
    }
}
