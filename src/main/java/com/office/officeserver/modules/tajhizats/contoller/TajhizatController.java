package com.office.officeserver.modules.tajhizats.contoller;

import com.office.officeserver.modules.tajhizats.model.Tajhizat;
import com.office.officeserver.modules.tajhizats.service.Imp.TajhizatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class TajhizatController {

    @Autowired
    TajhizatServiceImpl tajhizatService;



    @GetMapping("/tajhizats")
    public List<Tajhizat> getAll() {
        return tajhizatService.getList();
    }


    @PostMapping("/tajhizats")
    public Tajhizat saveTajhiz(@RequestBody Tajhizat tajhizat) {
        return tajhizatService.save(tajhizat);
    }


    @GetMapping("/tajhizats/{id}")
    public ResponseEntity<Optional<Tajhizat>> getTajhiz(@PathVariable Long id) {
        return tajhizatService.getTajhizat(id);
    }


    @DeleteMapping("/tajhizats/{id}")
    public void deleteTajhiz(@PathVariable Long id) {
        tajhizatService.delete(id);

    }
}
