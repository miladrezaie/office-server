package com.office.officeserver.modules.v1.api.employee.contoller;

import com.office.officeserver.modules.v1.api.employee.model.Employee;
import com.office.officeserver.modules.v1.api.employee.service.Imp.EmployeeServiceImpl;
import com.office.officeserver.modules.v1.api.tajhizats.model.Tajhizat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.getList();
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@ModelAttribute Employee employee, MultipartFile file) {
        return employeeService.save(employee,file);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);

    }
}
