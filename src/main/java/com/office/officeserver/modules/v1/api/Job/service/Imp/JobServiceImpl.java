package com.office.officeserver.modules.v1.api.Job.service.Imp;

import com.office.officeserver.modules.v1.api.Job.model.Job;
import com.office.officeserver.modules.v1.api.Job.repository.JobRepository;
import com.office.officeserver.modules.v1.api.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getList() {
        List<Job> jobs = new ArrayList<>();
        List<Job> allJob = jobRepository.findAll();
        for (Job job : allJob) {
            jobs.add(job);
        }
        return jobs;
    }

    public ResponseEntity<Optional<Job>> getJob(Long id) {
        return new ResponseEntity<>(jobRepository.findById(id), HttpStatus.ACCEPTED);
    }

    public Job save(Job t) {
        return jobRepository.save(t);
    }

    public void delete(Long id) {
        jobRepository.deleteById(id);
    }
}
