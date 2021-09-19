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

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.getList();
    }


    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
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
