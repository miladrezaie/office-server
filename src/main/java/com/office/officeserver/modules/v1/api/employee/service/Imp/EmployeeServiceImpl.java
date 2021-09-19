package com.office.officeserver.modules.v1.api.employee.service.Imp;

import com.office.officeserver.modules.v1.api.employee.model.Employee;
import com.office.officeserver.modules.v1.api.employee.repository.EmployeeRepository;
import com.office.officeserver.modules.v1.api.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getList() {
        List<Employee> employees = new ArrayList<>();
        List<Employee> allEmployee = employeeRepository.findAll();
        for (Employee employee : allEmployee) {
            employees.add(employee);
        }
        return employees;
    }


    public ResponseEntity<Optional<Employee>> getEmployee(Long id) {
        return new ResponseEntity<>(employeeRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public Employee save(Employee t) {
        return employeeRepository.save(t);
    }


    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
