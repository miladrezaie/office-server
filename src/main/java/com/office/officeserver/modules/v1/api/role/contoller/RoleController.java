package com.office.officeserver.modules.v1.api.role.contoller;

import com.office.officeserver.modules.v1.api.role.model.Role;
import com.office.officeserver.modules.v1.api.role.service.Imp.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class RoleController {

    @Autowired
    RoleServiceImpl tajhizatService;



    @GetMapping("/tajhizats")
    public List<Role> getAll() {
        return tajhizatService.getList();
    }


    @PostMapping("/tajhizats")
    public Role saveTajhiz(@RequestBody Role tajhizat) {
        return tajhizatService.save(tajhizat);
    }


    @GetMapping("/tajhizats/{id}")
    public ResponseEntity<Optional<Role>> getTajhiz(@PathVariable Long id) {
        return tajhizatService.getTajhizat(id);
    }


    @DeleteMapping("/tajhizats/{id}")
    public void deleteTajhiz(@PathVariable Long id) {
        tajhizatService.delete(id);

    }
}
