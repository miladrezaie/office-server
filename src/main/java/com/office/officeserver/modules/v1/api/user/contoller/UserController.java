package com.office.officeserver.modules.v1.api.user.contoller;

import com.office.officeserver.modules.v1.api.user.model.User;
import com.office.officeserver.modules.v1.api.user.service.Imp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    UserServiceImpl tajhizatService;



    @GetMapping("/tajhizats")
    public List<User> getAll() {
        return tajhizatService.getList();
    }


    @PostMapping("/tajhizats")
    public User saveTajhiz(@RequestBody User tajhizat) {
        return tajhizatService.save(tajhizat);
    }


    @GetMapping("/tajhizats/{id}")
    public ResponseEntity<Optional<User>> getTajhiz(@PathVariable Long id) {
        return tajhizatService.getTajhizat(id);
    }


    @DeleteMapping("/tajhizats/{id}")
    public void deleteTajhiz(@PathVariable Long id) {
        tajhizatService.delete(id);

    }
}
