package com.office.officeserver.modules.v1.api.plan.contoller;

import com.office.officeserver.modules.v1.api.plan.model.Plan;
import com.office.officeserver.modules.v1.api.plan.service.Imp.PlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class PlanController {

    @Autowired
    PlanServiceImpl tajhizatService;



    @GetMapping("/tajhizats")
    public List<Plan> getAll() {
        return tajhizatService.getList();
    }


    @PostMapping("/tajhizats")
    public Plan saveTajhiz(@RequestBody Plan tajhizat) {
        return tajhizatService.save(tajhizat);
    }


    @GetMapping("/tajhizats/{id}")
    public ResponseEntity<Optional<Plan>> getTajhiz(@PathVariable Long id) {
        return tajhizatService.getTajhizat(id);
    }


    @DeleteMapping("/tajhizats/{id}")
    public void deleteTajhiz(@PathVariable Long id) {
        tajhizatService.delete(id);

    }
}
