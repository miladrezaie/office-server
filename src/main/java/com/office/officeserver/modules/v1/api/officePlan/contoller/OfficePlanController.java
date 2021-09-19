package com.office.officeserver.modules.v1.api.officePlan.contoller;

import com.office.officeserver.modules.v1.api.officePlan.model.OfficePlan;
import com.office.officeserver.modules.v1.api.officePlan.service.Imp.OfficePlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class OfficePlanController {

    @Autowired
    OfficePlanServiceImpl tajhizatService;



    @GetMapping("/tajhizats")
    public List<OfficePlan> getAll() {
        return tajhizatService.getList();
    }


    @PostMapping("/tajhizats")
    public OfficePlan saveTajhiz(@RequestBody OfficePlan tajhizat) {
        return tajhizatService.save(tajhizat);
    }


    @GetMapping("/tajhizats/{id}")
    public ResponseEntity<Optional<OfficePlan>> getTajhiz(@PathVariable Long id) {
        return tajhizatService.getTajhizat(id);
    }


    @DeleteMapping("/tajhizats/{id}")
    public void deleteTajhiz(@PathVariable Long id) {
        tajhizatService.delete(id);

    }
}
