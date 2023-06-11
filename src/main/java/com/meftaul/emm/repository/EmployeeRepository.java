package com.meftaul.emm.repository;

import com.meftaul.emm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmployeeId(String employeeId);
    Boolean existsByEmployeeId(String employeeId);
}
