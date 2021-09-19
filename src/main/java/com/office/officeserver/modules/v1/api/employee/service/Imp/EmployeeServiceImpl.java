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

    @Autowired
    private EmployeeRepository tajhizatRepository;


    public List<Employee> getList() {
        List<Employee> tajhizats = new ArrayList<>();
        List<Employee> allTajhizat = tajhizatRepository.findAll();
        for (Employee tajhizat : allTajhizat) {
            tajhizats.add(tajhizat);
        }
        return tajhizats;
    }


    public ResponseEntity<Optional<Employee>> getTajhizat(Long id) {
        return new ResponseEntity<>(tajhizatRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public Employee save(Employee t) {
        return tajhizatRepository.save(t);
    }


    public void delete(Long id) {
        tajhizatRepository.deleteById(id);
    }
}
