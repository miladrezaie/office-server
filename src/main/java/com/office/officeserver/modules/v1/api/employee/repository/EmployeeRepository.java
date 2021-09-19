package com.office.officeserver.modules.v1.api.employee.repository;

import com.office.officeserver.modules.v1.api.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
