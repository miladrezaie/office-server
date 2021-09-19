package com.office.officeserver.modules.v1.api.employee.contoller;

import com.office.officeserver.modules.v1.api.employee.model.Employee;
import com.office.officeserver.modules.v1.api.employee.service.Imp.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl tajhizatService;



    @GetMapping("/tajhizats")
    public List<Employee> getAll() {
        return tajhizatService.getList();
    }


    @PostMapping("/tajhizats")
    public Employee saveTajhiz(@RequestBody Employee tajhizat) {
        return tajhizatService.save(tajhizat);
    }


    @GetMapping("/tajhizats/{id}")
    public ResponseEntity<Optional<Employee>> getTajhiz(@PathVariable Long id) {
        return tajhizatService.getTajhizat(id);
    }


    @DeleteMapping("/tajhizats/{id}")
    public void deleteTajhiz(@PathVariable Long id) {
        tajhizatService.delete(id);

    }
}
