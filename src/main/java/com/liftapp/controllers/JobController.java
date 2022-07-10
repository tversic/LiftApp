package com.liftapp.controllers;

import com.liftapp.model.Bean.LU_JOB;
import com.liftapp.services.interfaces.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("getAll")
    public ResponseEntity<List<LU_JOB>> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobs());
    }
}
