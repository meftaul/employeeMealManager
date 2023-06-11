package com.meftaul.emm.service;

import com.meftaul.emm.entity.Employee;
import com.meftaul.emm.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Page<Employee> getEmployeeList(Pageable page);
    Employee getEmployeeByEmployeeId(String employeeId);
    Employee uodateEmployee(Employee employee);
    void deleteEmployee(Long id);
}
