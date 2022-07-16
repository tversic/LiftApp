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
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("getFree")
    public ResponseEntity<List<LU_JOB>> getFreeJobs(){
        return ResponseEntity.ok().body(jobService.getAllFreeJobs());
    }

    @PostMapping("/{id}/{username}")
    public ResponseEntity scheduleJob(@PathVariable Integer id, @PathVariable String username){
        if(jobService.scheduleJob(id, username)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.internalServerError().build();
        }
    }
}
