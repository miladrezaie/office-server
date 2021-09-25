package com.office.officeserver.modules.v1.api.tajhizats.contoller;


import com.office.officeserver.modules.v1.api.tajhizats.model.Tajhizat;
import com.office.officeserver.modules.v1.api.tajhizats.service.Imp.TajhizatServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class TajhizatController {

    private final TajhizatServiceImpl tajhizatService;


    public TajhizatController(TajhizatServiceImpl tajhizatService) {
        this.tajhizatService = tajhizatService;
    }


    @GetMapping("/tajhizats")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Tajhizat> getAll() {
        return tajhizatService.getList();
    }


    @PostMapping("/tajhizats")
    @PreAuthorize("hasRole('ADMIN')")
    public Tajhizat saveTajhiz(@ModelAttribute Tajhizat tajhizat,MultipartFile file) {
        System.out.println("is ok...................................");
        System.out.println("is ok...................................");


        return tajhizatService.save(tajhizat,file);
    }


    @GetMapping("/tajhizats/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Optional<Tajhizat>> getTajhiz(@PathVariable Long id) {
        return tajhizatService.getTajhizat(id);
    }


    @DeleteMapping("/tajhizats/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTajhiz(@PathVariable Long id) {
        tajhizatService.delete(id);
    }
}
