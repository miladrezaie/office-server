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
    JobServiceImpl tajhizatService;



    @GetMapping("/tajhizats")
    public List<Job> getAll() {
        return tajhizatService.getList();
    }


    @PostMapping("/tajhizats")
    public Job saveTajhiz(@RequestBody Job tajhizat) {
        return tajhizatService.save(tajhizat);
    }


    @GetMapping("/tajhizats/{id}")
    public ResponseEntity<Optional<Job>> getTajhiz(@PathVariable Long id) {
        return tajhizatService.getTajhizat(id);
    }


    @DeleteMapping("/tajhizats/{id}")
    public void deleteTajhiz(@PathVariable Long id) {
        tajhizatService.delete(id);

    }
}
