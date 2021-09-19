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

    @Autowired
    private JobRepository tajhizatRepository;


    public List<Job> getList() {
        List<Job> tajhizats = new ArrayList<>();
        List<Job> allTajhizat = tajhizatRepository.findAll();
        for (Job tajhizat : allTajhizat) {
            tajhizats.add(tajhizat);
        }
        return tajhizats;
    }


    public ResponseEntity<Optional<Job>> getTajhizat(Long id) {
        return new ResponseEntity<>(tajhizatRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public Job save(Job t) {
        return tajhizatRepository.save(t);
    }


    public void delete(Long id) {
        tajhizatRepository.deleteById(id);
    }
}
