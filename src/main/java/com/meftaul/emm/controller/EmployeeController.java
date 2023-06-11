package com.meftaul.emm.controller;

import com.meftaul.emm.dto.EmployeeDto;
import com.meftaul.emm.entity.Employee;
import com.meftaul.emm.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId) {
        return employeeService.getEmployeeByEmployeeId(employeeId);
    }

    @PostMapping
    public ResponseEntity<Void> SaveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        employeeService.saveEmployeeDto(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public Page<Employee> getEmployeeList(@ParameterObject Pageable pageable) {
        return employeeService.getList(pageable);
    }

}
