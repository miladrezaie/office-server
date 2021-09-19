package com.office.officeserver.modules.v1.api.Job.contoller;

import com.office.officeserver.modules.v1.api.Job.model.Job;
import com.office.officeserver.modules.v1.api.Job.service.Imp.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class JobController {

    @Autowired
    JobServiceImpl jobService;



    @GetMapping("/jobs")
    public List<Job> getAll() {
        return jobService.getList();
    }


    @PostMapping("/jobs")
    public Job saveJob(@RequestBody Job job) {
        return jobService.save(job);
    }


    @GetMapping("/jobs/{id}")
    public ResponseEntity<Optional<Job>> getJob(@PathVariable Long id) {
        return jobService.getJob(id);
    }


    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.delete(id);

    }
}
