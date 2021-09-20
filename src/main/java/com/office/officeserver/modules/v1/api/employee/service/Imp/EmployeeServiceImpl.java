package com.office.officeserver.modules.v1.api.employee.service.Imp;

import com.office.officeserver.modules.v1.api.employee.model.Employee;
import com.office.officeserver.modules.v1.api.employee.repository.EmployeeRepository;
import com.office.officeserver.modules.v1.api.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

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

    public Employee save(Employee employee, MultipartFile file) {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {

            if (fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                System.out.println("not a valid file");
            }
            employee.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            System.out.println("errrrrorr");
        }

        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
